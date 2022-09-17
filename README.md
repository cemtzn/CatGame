# CatGame
*An OOP an Stdlib based game as a school project*

*Description of the project*

This project is based on OOP. Since the project is image-based, the stdlib library must be loaded into the project for it to work. 
The mapping of the maze in the project is a square pattern formed by combining the numbers 0-1-2-3. The numbers 0 represent the walking area, the area 1 the map walls, the area 2 the water sources, and the number 3 the foods in the areas. 
The cat that wants to find food scans the 4 squares around it. If there is food in the area it is combing, it will head towards the food, otherwise, it should move towards the directions where there is no wall or water. 
The cat eats all the food without hitting the walls or touching the water. 
The program ends when he has eaten all the foods. The number of each move made by the cat is stored and printed out until the end of the program.

*How does the code works* 

This code visually prints the information taken from the file it reads.
The file is first verified to collect the suppression data.
After the file is verified, the data in the file is read line by line.
The data separated by the split method is processed in a while loop and printed on the screen.
The visual we come across is the map / world where our imaginary cat will move.
The aim of our cat is to eat the food (pink squares) on the map.
To eat these squares, it interprets the surrounding boxes (up-down-right-left box).
it moves towards the empty ones among them.
But if there is both an empty box and a food, the priority is the box, which is the food, and the cat turns to the box with food.
The traces left by the cat during its movement are deleted and refreshed with the draw command in the class method.
For the movement mechanism of the cat, separate if states are written for each of the 4 conditions (up-down-right-left) in an infinite while loop.
Thanks to these conditions, it assigns the coordinates that it can move to an ArrayList defined in the loop.
Thanks to this choice mechanism, the cat randomly chooses one of the boxes.
A boolean type constant has been assigned to avoid confusion between empty boxes and lunch boxes

*Note*

*Make sure that Stdlib is configured to the IDE.In this project, Eclipse IDE was used to fulfill the task
