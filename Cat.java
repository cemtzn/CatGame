/*Ýsmail Cem Tüzün , 04102011 , 09.01.2021

*Class called Cat was created
*The class has cat objects
*Data fields and constructor provide required information and implemantion for objects
*draw method , draws the cat objects on the screen

*/
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Cat {// Class
	//data fields
	private int x;//x coordinate of the cat
	private int y;//y coordinate of the cat
	private Color color= StdDraw.BOOK_RED;//color of the cat
	private int foodCount;//number of foods eaten by the cat

	Cat(int x , int y , Color color){//constructor for the cat

		this.x=x ;//x coordinate of the cat
		this.y=y;//x coordinate of the cat
		this.color=color;//color of the cat
	}

	public void draw() {//method for drawing the cat on the map

		double radius=0.4;//cat's radius
		double square_thickness = 0.44;//square thickness
		int pause_duration=5;//milliseconds

		// draw the cat on the screen
		StdDraw.setPenColor(color); // color of the cat
		StdDraw.filledCircle(x, y, radius);//coordinates and radius of the cat

		StdDraw.show();//show
		StdDraw.pause(pause_duration);//Pause

		StdDraw.setPenColor(StdDraw.WHITE); // color of the boxes to erase the traces of the cat
		StdDraw.filledSquare(x, y, square_thickness);//Set coordinates and thickness

	}
}



