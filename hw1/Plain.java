package edu.iastate.cs228.hw1;

/**
 *  
 * @author Luke Herbsleb
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random; 

/**
 * 
 * The plain is represented as a square grid of size width x width. 
 *
 */
public class Plain 
{
	private int width; // grid size: width X width 
	
	public Living[][] grid; 
	
	/**
	 *  Default constructor reads from a file 
	 */
	public Plain(String inputFileName) throws FileNotFoundException
	{		
        // TODO 
		// 
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid plain in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done. 
		File f = new File(inputFileName);
		Scanner scnr = new Scanner(f);
		int width = 0;
//		inputFileName.trim();		//to make sure that the file doesn thave any messed up spacing
		while (scnr.hasNextLine()) {
			width += 1;
			scnr.nextLine();
		}
		this.width = width;
		grid = new Living[width][width];
		scnr.close();//must reset scanner because its currently at the end of the line
		File f2 = new File(inputFileName);
		Scanner scnr2 = new Scanner(f2);
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				String str = scnr2.next();
				grid[i][j] = createLivingFromString(str, i, j);
			}
			scnr2.nextLine();
		}
		scnr2.close();
	}
	
	/**
	 * a helper method that creates the correct animal from the strings in a txt file.
	 * @param str
	 * @return Living
	 */
	private Living createLivingFromString(String str, int row, int col) {
		char type = str.charAt(0);
		if (type == 'B') {
			char number = str.charAt(1);
			int age = Character.getNumericValue(number);
			return new Badger(this, row, col, age);
		} else if (type == 'F') {
			char number = str.charAt(1);
			int age = Character.getNumericValue(number);
			return new Fox(this, row, col, age);
		} else if (type == 'R') {
			char number = str.charAt(1);
			int age = Character.getNumericValue(number);
			return new Rabbit(this, row, col, age);
		} else if (type == 'G') {
			return new Grass(this, row, col);
		} else if (type == 'E') {
			return new Empty(this, row, col);
		} else {
			System.out.println("attempted to create a creature that does not exist!");
			return null;
		}
	}
	
	/**
	 * Constructor that builds a w x w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Plain(int w)
	{
		width = w;
		grid = new Living[w][w];
	}
	
	
	public int getWidth()
	{  
		return width;
	}
	
	/**
	 * Initialize the plain by randomly assigning to every square of the grid  
	 * one of BADGER, FOX, RABBIT, GRASS, or EMPTY.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		Random generator = new Random(); 
		int type;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				type = generator.nextInt(5);
				
				//for every type in state, create a random object for that point.
				//Plain neighborhood = new Plain(3);	//find a smart way to assign the correct neighnors to each animal in the array after the arryay is created (after this for loop, create another for loop?)
				if (type == 0) {
					grid[i][j] = new Badger(this, i, j, 0);
				} else if (type == 1) {
					grid[i][j] = new Fox(this, i, j, 0);
				} else if (type == 2) {
					grid[i][j] = new Rabbit(this, i, j, 0);
				} else if (type == 3) {
					grid[i][j] = new Grass(this, i, j);
				} else if (type == 4) {
					grid[i][j] = new Empty(this, i, j);
				} else {
					System.out.println("random is not working here");
				}
			}
		}
	}
	
	
	/**
	 * Output the plain grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		String s = "";
		String info = "";
		int currentAge;
		//int who;	//0=Badger, 1=Fox, 2=Rabbit, 3=Grass, 4=Empty.
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < width; j++) {
				if (State.BADGER.equals(grid[i][j].who())) {
					currentAge = ((Animal) grid[i][j]).myAge();
					info = ("B" +  currentAge + " "); 
				} else if (State.FOX.equals(grid[i][j].who())) {
					currentAge = ((Animal) grid[i][j]).myAge();
					info = ("F" +  currentAge + " ");
				} else if (State.RABBIT.equals(grid[i][j].who())) {
					currentAge = ((Animal) grid[i][j]).myAge();
					info = ("R" +  currentAge + " ");
				} else if (State.GRASS.equals(grid[i][j].who())) {
					info = ("G" +  " " + " ");
				} else if (State.EMPTY.equals(grid[i][j].who())) {
					info = ("E" +  " " + " ");
				}
				
				s += info;
			}
			//adds a new line to the end of the first line
			s += "\n";
		}
		return s; 
	}
	

	/**
	 * Write the plain grid to an output file.  Also useful for saving a randomly 
	 * generated plain for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		// TODO 
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    B, E, F, G, R. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 
		try {
			FileWriter f = new FileWriter(outputFileName);
			f.write(this.toString());
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}			
}
