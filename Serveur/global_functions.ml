type infos = {user : string; socket : Unix.file_descr; motsproposes: string ref;  score : int ref; outchan : out_channel };;

let mutex_session = Mutex.create ();;
let mutex_clients = Mutex.create ();;
let mutex_add_word = Mutex.create ();;
let cond_session = Condition.create ();;

let (clients : infos list ref) = ref [];;
let nb_tour = ref 0;;
let session_fini = ref false;;
let timer = ref 120;;


(*lire le dictionnaire dans une liste*)
let read_file filename = 
    let lines = ref [""] in
    let chan = open_in filename in
    try
      while true; do
        lines := input_line chan :: !lines
      done;
      !lines
    with End_of_file ->
      close_in chan;
      List.rev !lines;;

(*transformer la matrice en  string pour l'envoyer*)
let array_to_string tab = 
  let tab_string = ref "" in 
   for i = 0 to ((Array.length tab) -1)  do
    for j = 0 to ((Array.length tab.(i)) -1)  do
    tab_string := !tab_string ^ tab.(i).(j);
    done
   done;
   !tab_string;;

(*scores*)
let scores (clients : infos list ref) = 
	let scr = ref "" in
	 		ignore(List.map (fun x -> scr := !scr ^ x.user ^  "*" ^ (string_of_int !(x.score) ^ "*")) !clients);
			!scr;;


