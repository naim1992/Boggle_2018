open Global_functions;;
open Tour;;



class session  = 
	object(self)
	initializer 
		self#wait_connexion ()

	val tour_actuel = new tour
	
	method getTour = tour_actuel
	
	method run () =  
		
		while true do
			Mutex.lock mutex_session;
			Condition.wait cond_session mutex_session;	
			print_endline "nouvelle session\n";
			if !session_fini = true then
			begin
				ignore(List.map (fun x ->  output_string x.outchan "SESSION/\n";
    						                								flush x.outchan
    						     ) !clients);
										tour_actuel#setTirage ();
										
    		let message = "TOUR/" ^ (array_to_string tour_actuel#getTirage) ^ "/\n" in
    						ignore (List.map (
    						             fun x -> 
    						                    output_string x.outchan message;
    						                	  flush x.outchan;
    						        ) !clients)
			end;
			session_fini := false;
			Mutex.unlock mutex_session;
			ignore (Thread.create (fun x -> tour_actuel#start_tour 1)());
		done	
		
	method wait_connexion () = ignore (Thread.create (fun x -> self#run x) ())
	
end;;