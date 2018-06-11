open Global_functions;;
open Journal;;


let matrice = Array.make_matrix 4 4 "";;
let num_tour = ref 1;;



(*lancer les des *)
let des () = 
  let list_des = read_file "des.dat" and index = ref 1
	and tab_string = ref "" in
  for i = 0 to (Array.length matrice) - 1 do
    for j = 0 to (Array.length matrice.(i)) - 1 do
        let rand = Random.int 6 and
            case = List.nth list_des !index 
            in 
              matrice.(i).(j) <- (String.make 1 case.[rand]);
              index := !index + 1   
      done
  done;;


class tour = 
	object(self)
	initializer 
		self#setTirage ()
		
	
	(* method debut_tour = *) 
	
	val mutable tirage = matrice
	val mutable words_found = [""]


	method getDictionnaire = read_file "dictionnaire.dat"
  (*tirage : matrice 4*4 *)
  method getTirage = matrice
	method setTirage () = 
												des ();
												tirage <- matrice
												
	
	method bilan () =
		ignore (
			List.map (fun x -> 
				 let mots = ref "" and scores = ref ((string_of_int !num_tour) ^ "*") in
					ignore(List.map (fun y -> mots := !mots ^ y.user ^ ":" ^  !(y.motsproposes) ^ ";";
					                  scores := !scores ^ y.user ^  "*" ^ (string_of_int !(y.score) ^ "*")) !(clients));
						
					let message = "BILANMOTS/" ^ !mots ^ "/" ^ !scores ^ "/\n" in							
						output_string x.outchan message;
            flush x.outchan					
				) !(clients)
				) 	
	
	method fin_tour () =  Thread.create (fun x -> self#expiration ())() 
	method getNumTour () = !num_tour
	
	(* experation de tour *)
	method expiration ()= 
		Thread.delay 30.0;
		print_endline ("fin de temps repartie pour le tour " ^ string_of_int !num_tour);
		let message =  "RFIN/\n" in
		let t = ref ["\n<tour>\n<num_tour>" ^ string_of_int !num_tour ^ "</num_tour>\n"] in	
          ignore (List.map (
                      fun x -> 
                                output_string x.outchan message;
                								flush x.outchan;
																t := !t@["<client>\n"^ 
																									"<name>\n" ^ x.user ^ "</name>\n" ^
																									"<score>\n" ^ string_of_int !(x.score) ^ "</score>\n" ^
																									"</client>\n"];		
                    ) !clients);
										t := !t@["</tour>\n"];
										
										
										
										let j = ref  (List.rev (List.tl (List.tl (List.rev (read_file "journal.xml")))))
										in
										
										j := !j@(!t)@["</session>\n"]@["</journal>\n"];
										
										write_list_to_file !j;
										
										self#bilan ();
										
										num_tour := !num_tour + 1; 
										ignore (Thread.create (fun x -> self#start_tour !num_tour)());
		Thread.exit ()	
	
	method start_tour num = 
		if !num_tour < !nb_tour then 
			begin
				
				print_endline ("debut de tour " ^ string_of_int num);

				if (!num_tour > 1) then
					begin
    				self#setTirage ();
    				let message = "TOUR/" ^ (array_to_string self#getTirage) ^ "/\n" in
    								ignore (List.map (
    						                      fun x -> 
    						                                output_string x.outchan message;
    						                								flush x.outchan;
    						                    ) !clients)
					end;							
				ignore(self#fin_tour ());
				
			end
			else
				(
					self#end_session ();
					if (List.length !clients > 0) then
						begin
							Mutex.lock mutex_session;
							session_fini := true;
							num_tour := 1;
							Condition.signal cond_session;
							
							Mutex.unlock mutex_session
						end
				)
	(*fin d'une session *)
   method end_session () = 
            let message =  "VAINQUEUR/" ^ (scores clients) ^ "\n" in
						ignore(List.map (fun x ->  output_string x.outchan message;
    						                								flush x.outchan
    						     ) !clients)
            
						
	method getWords = words_found
	
	method add_word word = 
		Mutex.lock mutex_add_word;
		words_found <- words_found@[word];
		Mutex.unlock mutex_add_word	

end;;