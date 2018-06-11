open Server;;
open Connexion_manager;;
open Journal;;
open Tour;;
open Session;;

class server_manager port n =
   object(self)
    inherit server port n
		
	 val session_actuel = new session	
	(* val mutable tour_actuel = new tour users n *)  
	 
   method treat s sa =
	 ignore( (new connexion_maj s sa true session_actuel#getTour )#start())
   end;;