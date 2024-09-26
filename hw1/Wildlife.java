package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/**
 * 
 * The Wildlife class performs a simulation of a grid plain with squares
 * inhabited by badgers, foxes, rabbits, grass, or none.
 *
 */
public class Wildlife {
	/**
	 * Update the new plain from the old plain in one cycle.
	 * 
	 * @param pOld old plain
	 * @param pNew new plain
	 */
	public static void updatePlain(Plain pOld, Plain pNew) {
		//
		// For every life form (i.e., a Living object) in the grid pOld, generate
		// a Living object in the grid pNew at the corresponding location such that
		// the former life form changes into the latter life form.
		//
		// Employ the method next() of the Living class.

		// do the real update
		for (int i = 0; i < pOld.getWidth(); i++) {
			for (int j = 0; j < pOld.getWidth(); j++) {
				pNew.grid[i][j] = pOld.grid[i][j].next(pOld);
			}
		}
	}

	private static Plain deepCopy(Plain pOld) {
		Plain pNew = new Plain(pOld.getWidth());
		for (int i = 0; i < pNew.getWidth(); i++) {
			for (int j = 0; j < pNew.getWidth(); j++) {
				State who = pOld.grid[i][j].who();

				// one constructor for each type
				if (who.equals(State.BADGER)) {
					Badger L = (Badger) pOld.grid[i][j];
					Badger A = new Badger(pNew, i, j, L.myAge());
					pNew.grid[i][j] = A;
				} else if (who.equals(State.FOX)) {
					Fox L = (Fox) pOld.grid[i][j];
					Fox A = new Fox(pNew, i, j, L.myAge());
					pNew.grid[i][j] = A;
				} else if (who.equals(State.RABBIT)) {
					Rabbit L = (Rabbit) pOld.grid[i][j];
					Rabbit A = new Rabbit(pNew, i, j, L.myAge());
					pNew.grid[i][j] = A;
				} else if (who.equals(State.EMPTY)) {
					Empty A = new Empty(pNew, i, j);
					pNew.grid[i][j] = A;
				} else if (who.equals(State.GRASS)) {
					Grass A = new Grass(pNew, i, j);
					pNew.grid[i][j] = A;
				} else {
					pNew.grid[i][j] = null;
					System.out.println("attempted to copy an object that doesnt exist");
				}
			}
		}
		return pNew;
	}

	/**
	 * Repeatedly generates plains either randomly or from reading files. Over each
	 * plain, carries out an input number of cycles of evolution.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//
		// Generate wildlife simulations repeatedly like shown in the
		// sample run in the project description.
		//
		// 1. Enter 1 to generate a random plain, 2 to read a plain from an input
		// file, and 3 to end the simulation. (An input file always ends with
		// the suffix .txt.)
		//
		// 2. Print out standard messages as given in the project description.
		//
		// 3. For convenience, you may define two plains pOld and pNew as below.
		// In an pOld numbered cycle (starting at zero), generate the plain
		// pNew from the plain pOld; in an pNew numbered cycle, generate pOld
		// from pNew.

//		Plain even;   				 // the plain after an even number of cycles 
//		Plain odd;                   // the plain after an odd number of cycles

		// 4. Print out initial and final plains only. No intermediate plains should
		// appear in the standard output. (When debugging your program, you can
		// print intermediate plains.)
		//
		// 5. You may save some randomly generated plains as your own test cases.
		//
		// 6. It is not necessary to handle file input & output exceptions for this
		// project. Assume data in an input file to be correctly formated.

		System.out.println("Simulation of Wildlife of the Plain");
		System.out.println("keys: 1 (random plain)  2 (file input)  3 (exit)");
		System.out.println("");
		Scanner scnr = new Scanner(System.in);
		System.out.print("Trial 1: ");
		int key = scnr.nextInt();
		int numTrials = 1;

		while (key != 3) {
			numTrials++;
			if (key == 1) {
				System.out.println("Random plain");
				// do stuff
				System.out.print("Enter grid width: ");
				int width = scnr.nextInt();

				System.out.print("Enter the number of cycles: ");
				int numCycles = scnr.nextInt();

				System.out.println("");
				System.out.println("Initial plain:");
				System.out.println();

				// random plain
				Plain pNew = new Plain(width);
				pNew.randomInit();
				System.out.println(pNew.toString());

				// do updates
				Plain pOld = new Plain(width);

				for (int i = 0; i < numCycles; i++) {

					if (i % 2 == 0) { // odd
						pOld = deepCopy(pNew);
						updatePlain(pOld, pNew);
						//System.out.println(pNew.toString());
						if (i == numCycles - 1) {
							System.out.println(pNew.toString());
						}
					} else { // even
						pOld = deepCopy(pNew);
						updatePlain(pOld, pNew);
						//System.out.println(pNew.toString());
						if (i == numCycles - 1) {
							System.out.println(pNew.toString());
						}
					}
					if (i == numCycles - 2) {
						System.out.println("Final plain: ");
						
					}
				}
			} else if (key == 2) {
				// read a plain from an input file
				System.out.println("Plain input from a file");
				System.out.print("File name: ");		//this is the current file im using testCases\public1-3x3.txt
														//second test    publicTests\public2-6x6.txt
														// first test from pdf    testCases\HWpdftest1.txt (fixed)
														// third test from public     publicTests\public3-10x10.txt
				String fileName = scnr.next();
				System.out.print("Enter the number of cycles: ");
				int numCycles = scnr.nextInt();

				// repetitive code here

				System.out.println("");
				System.out.println("Initial plain:");
				System.out.println();

				// random plain
				Plain pNew = new Plain(fileName);
				System.out.println(pNew.toString());

				// do updates
				Plain pOld = new Plain(fileName);

				for (int i = 0; i < numCycles; i++) {

					if (i % 2 == 0) { // odd
						pOld = deepCopy(pNew);
						updatePlain(pOld, pNew);
						//System.out.println(pNew.toString());
						if (i == numCycles - 1) {
							System.out.println(pNew.toString());
						}
					} else { // even
						pOld = deepCopy(pNew);
						updatePlain(pOld, pNew);
						//System.out.println(pNew.toString());
						if (i == numCycles - 1) {
							System.out.println(pNew.toString());
						}
					}
					if (i == numCycles - 2) {
						System.out.println("Final plain: ");
					}
				}

			}
			
			System.out.print("Trial " + numTrials + ": ");
			key = scnr.nextInt();
		}
		//if key == 3 close scanner and end loop
		scnr.close();
		
	}
}
