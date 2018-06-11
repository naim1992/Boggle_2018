#export OCAMLPARAM="safe-string=0,_"

SOURCES = global_functions.ml journal.ml tour.ml session.ml connexion.ml connexion_manager.ml  server.ml server_manager.ml main.ml

EXEC = a.out

CAMLC = ocamlc -g
#CAMLC = ~/Bureau/bin/ocamlc -g
CAMLDEP = ocamldep

LIBS = $(WITHUNIX) $(WITHTHREADS) 

CUSTOM=-custom

THREADS=-thread

WITHUNIX =unix.cma -cclib -lunix

WITHSTR =str.cma -cclib -lstr

WITHTHREADS =threads.cma -cclib -lthreads

all: $(EXEC)

OBJS = $(SOURCES:.ml=.cmo)


$(EXEC): $(OBJS)
	$(CAMLC) $(THREADS) $(CUSTOM) -o $(EXEC) $(LIBS) $(OBJS) 

.SUFFIXES:
.SUFFIXES: .ml .cmo .cmi

.ml.cmo:
	$(CAMLC) $(THREADS) $(CUSTOM) -c $< $(LIBS)

clean:
	rm -f *.cm[iox] *~ .*~ #*#
	rm -f $(EXEC)
	rm -f $(EXEC).opt

lance:
	./a.out -port 2018 -tours 5

