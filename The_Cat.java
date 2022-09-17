/* Ismail Cem Tüzün, 041902011, 09.01.2021

*This code visually prints the information taken from the file it reads.
*The file is first verified to collect the suppression data.
*After the file is verified, the data in the file is read line by line.
*The data separated by the split method is processed in a while loop and printed on the screen.
*The visual we come across is the map / world where our imaginary cat will move.
*The aim of our cat is to eat the food (pink squares) on the map.
*To eat these squares, it interprets the surrounding boxes (up-down-right-left box).
*it moves towards the empty ones among them.
*But if there is both an empty box and a food, the priority is the box, which is the food, and the cat turns to the box with food.
*The traces left by the cat during its movement are deleted and refreshed with the draw command in the class method.
*For the movement mechanism of the cat, separate if states are written for each of the 4 conditions (up-down-right-left) in an infinite while loop.
*Thanks to these conditions, it assigns the coordinates that it can move to an ArrayList defined in the loop.
*Thanks to this choice mechanism, the cat randomly chooses one of the boxes.
*A boolean type constant has been assigned to avoid confusion between empty boxes and lunch boxes

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.Color;
import java.lang.*;

public class The_Cat{

	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		// TODO Auto-generated method stub
		// file name

		String filename = "word.txt";

		File file = new File(filename);

		// if there is no file
		if (!file.exists()) {
			System.out.println("File is not found!");
			// exit from the program
			System.exit(1);
		}
		Scanner inputFile = new Scanner(file);//we declare a scanner in order to accept the file as input

		int canvas_width = 600; // specify canvas width 
		int canvas_height = 600; // specify canvas height 
		StdDraw.setCanvasSize(canvas_width, canvas_height);
		StdDraw.setXscale(0.5,40.5); // x axis scale is in the range [0,1]
		StdDraw.setYscale(0.5,40.5); // y axis scale is in the range [0,1]
		StdDraw.enableDoubleBuffering();

		double square_thickness = 0.5;//thicknesses of squares
		int y = 40 ;//beginning to read the file on y=40 axis

		int[][]world=new int [40][40];//world for storing types 0,1,2,3

		int j = 39;//numbers of columns
		while (inputFile.hasNextLine()) {//if there is another line , continue

			String line = inputFile.nextLine();//convert line to string
			String[] parts = line.split(";");//split all the elements in the line by ";"
			int x = 1 ;
			
			for (int i = 0; i < world.length; i++) {

				if(Integer.parseInt(parts[i])== 0) {
					StdDraw.setPenColor(StdDraw.BLACK); // set color for the square
					StdDraw.square(x, y, square_thickness);//Set coordinates and thickness
					world[j][i]=(Integer.parseInt(parts[i]));//store the type 0 in the world

					x ++ ;
				}
				else if(Integer.parseInt(parts[i])== 1) {
					StdDraw.setPenColor(StdDraw.GRAY); // set color for the square
					StdDraw.filledSquare(x, y, square_thickness);//Set coordinates and thickness
					StdDraw.setPenColor(StdDraw.BLACK); // set color for the outer square
					StdDraw.square(x, y, 0.501);//Set coordinates and thickness

					world[j][i]=(Integer.parseInt(parts[i]));//store the type 1 in the world

					x ++ ;
				}
				else if(Integer.parseInt(parts[i])== 2) {
					StdDraw.setPenColor(StdDraw.BLUE); // set color for the square
					StdDraw.filledSquare(x, y, square_thickness);//Set coordinates and thickness
					StdDraw.setPenColor(StdDraw.BLACK);  // set color for the outer square
					StdDraw.square(x, y, 0.501);//Set coordinates and thickness

					world[j][i]=(Integer.parseInt(parts[i]));//store the type 2 in the world

					x ++ ;
				}
				else if (Integer.parseInt(parts[i])== 3) {
					StdDraw.setPenColor(StdDraw.PINK); // set color for the square
					StdDraw.filledSquare(x, y, 0.44);//Set coordinates and thickness

					world[j][i]=(Integer.parseInt(parts[i]));//store the type 3 in the world
					x ++ ;
				}
			}
			j--;
			y--;
		}
		int x1=11;//Starting point of the cat on the map as x coordinate
		int y1= 11;//Starting point of the cat on the map as y coordinate
		int count = 0 ;//constant for counting the iterations

		while(true){//infinite loop

			ArrayList<Integer>temp_coordinates=new ArrayList<>();//temporary ArrayList for assigning the coordinates
			boolean check = false;//boolean for preventing to add more coordinates to temp arraylist

			//above empty box
			if(world[y1][x1-1]==0 || world[y1][x1-1]==3 ){//conditional
				if(world[y1][x1-1]==3) {//if the box above is "food"
					x1=x1;//declare x1
					y1++;//declare y1
					Cat kitten = new Cat(x1,y1,StdDraw.ORANGE);// create an object called kitten in Cat class

					kitten.draw();//draw the cat
				}
				else {
					temp_coordinates.add(x1);//temporary coordinates added to the ArrayList
					temp_coordinates.add(y1+1);//temporary coordinates added to the ArrayList
					check = true;
				}
			} 
			//below empty box
			if(world[y1-2][x1-1]==0 || world[y1-2][x1-1]==3) {
				if(world[y1-2][x1-1]==3) {//if the box below is "food"
					x1=x1;//declare x1
					y1--;//declare y1
					Cat kitten = new Cat(x1,y1,StdDraw.ORANGE);// create an object called kitten in Cat class

					kitten.draw();//draw the cat
				}else {
					temp_coordinates.add(x1);//temporary coordinates added to the ArrayList
					temp_coordinates.add(y1-1);//temporary coordinates added to the ArrayList
					check = true;
				}
			}
			//right empty box
			if(world[y1-1][x1]==0 || world[y1-1][x1]==3) {//conditional
				if(world[y1-1][x1]==3) {//if the box on the right is "food"
					x1++;//declare x1
					y1=y1;//declare y1
					Cat kitten = new Cat(x1,y1,StdDraw.ORANGE);// create an object called kitten in Cat class

					kitten.draw();//draw the cat
				}else {
					temp_coordinates.add(x1+1);//temporary coordinates added to the ArrayList
					temp_coordinates.add(y1);//temporary coordinates added to the ArrayList
					check = true;
				}
			}
			//left empty box
			if(world[y1-1][x1-2]==0 || world[y1-1][x1-2]==3) {//conditional
				if(world[y1-1][x1-2]==3) {//if the box on the left is "food"
					x1--;//declare x1
					y1=y1;//declare y1
					Cat kitten = new Cat(x1,y1,StdDraw.ORANGE);// create an object called kitten in Cat class

					kitten.draw();//draw the cat
				}else {
					temp_coordinates.add(x1-1);//temporary coordinates added to the ArrayList
					temp_coordinates.add(y1);//temporary coordinates added to the ArrayList
					check = true;
				}	
			}
			//Next box which cat moves into it will be chosen randomly
			Random random = new Random();
			int x = random.nextInt(temp_coordinates.size());//random value 
			
			if(x%2==0 && check) {//conditional 
				x1=temp_coordinates.get(x);//declare x1
				y1=temp_coordinates.get(x+1);//declare y1

				Cat kitten = new Cat(x1,y1,StdDraw.ORANGE);// create an object called kitten in Cat class
				kitten.draw();//draw the cat
			}
			count++;//add 1 to number of iterations
			System.out.println("number of iterations :"+count);//print the number of iterations
		}
	}
}

