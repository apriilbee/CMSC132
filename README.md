# CMSC132
Machine Problems for our Computer Architecture class

MP1 - URM Tracer
Functions:
C - Copy value in index param1 to index param2
J - Jump to instruction in line param3 if param1 and param2 are equal
S - Add 1 to value in index param1
Z - Set value in param1 equal to 0
execute - where lines of instructions in input file are executed
initialize - initialize the URM
inputToArrayList - adds input in input file to the URM
write - writes output to new file

MP2 - River Crossing Problem
Functions:
CrossRiver -  where man and one of his possessions (R,L,C) are brought to the other end of the river
              returns true if move has been successfully carried out
checkStatus - checks status of both islands if constraints are met (i.e. Lion and Rabbit left alone in one end of the river)
execute - contains the main loop, processes the string inputs
initialize - initialize variables every after a string input is processed
initializeMoves - adds the sequence of moves into a queue
