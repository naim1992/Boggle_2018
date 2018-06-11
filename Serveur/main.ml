open Global_functions;;
open Server_manager;;
open Journal;;


(*
   val main : unit -> unit
   *)
  
   let main () =
    
		if Sys.argv.(1) = "-port" 
		&& Sys.argv.(3) = "-tours" 
		(* &&  Sys.argv.(5) = "-grilles" *)
		  then
			let port = int_of_string(Sys.argv.(2)) 
			in
				nb_tour := int_of_string(Sys.argv.(4));
				open_journal ();
				
				(new server_manager port nb_tour)#start()
		else
			print_endline "usage : server -port port -tours nbtour";;
   
    main();;