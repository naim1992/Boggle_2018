open Global_functions;;

let string_of_month = function
  0 -> "janvier"
| 1 -> "f�vrier"
| 2 -> "mars"
| 3 -> "avril"
| 4 -> "mai"
| 5 -> "juin"
| 6 -> "juillet"
| 7 -> "ao�t"
| 8 -> "septembre"
| 9 -> "octobre"
| 10 -> "novembre"
| 11 -> "d�cembre"
| _ -> assert false (* on ne doit pas avoir une autre valeur *)
;;

let date_string_of_tm tm =
  let d = ((string_of_int tm.Unix.tm_mday) ^ " " ^ (string_of_month tm.Unix.tm_mon) ^ 
    " " ^ (string_of_int (1900 + tm.Unix.tm_year))) in
		d;;

let rec write_to_file oc = function
	| [] -> ()
	| e::tl -> output_string oc e; flush oc; write_to_file oc tl
	;;
 
let write_list_to_file l = 
	let jrnl =  open_out "../WebSite/journal.xml" in
		write_to_file jrnl l;
		close_out jrnl;;


let open_journal () = 	
	let j = ref (read_file "../WebSite/journal.xml") and date = Unix.gmtime(Unix.time ()) in
		 let session = ["<session><date>" ^ date_string_of_tm date]@["</date>\n"]@["</session>\n"] in
      	j := ["<journal>"]@["\n"]@session@["</journal>"];
		write_list_to_file !j;;
