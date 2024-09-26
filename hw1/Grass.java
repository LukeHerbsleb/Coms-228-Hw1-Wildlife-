package edu.iastate.cs228.hw1;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/**
 * Grass remains if more than rabbits in the neighborhood; otherwise, it is eaten. 
 *
 */
public class Grass extends Living 
{
	public Grass (Plain p, int r, int c) 
	{
		row = r;
		column = c;
		plain = p;
	}
	
	public State who()
	{
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many rabbits. Rabbits may also multiply fast enough to take over Grass.
	 */
	public Living next(Plain pNew)
	{
		int[] population = new int[5];
		plain.grid[row][column].census(population);
		
		//new plan
		if ((population[RABBIT] >= 3 && population[GRASS] == 0) || (population[RABBIT] >= 6 && population[GRASS] <= 1)) {// cant have 3 crass and more than 9 rabbits
			Empty e = new Empty(pNew, column, row);
			return e;
		} else if (population[RABBIT] >= 3) {
			Rabbit R = new Rabbit(pNew, column, row, 0);
			return R;
		} else {
			Grass G = new Grass(pNew, column, row);
			return G;
		}
		
		//origional code
//		
//		if (population[GRASS] == 0 && population[RABBIT] > 1) {//prevents a divide by 0 error
//			Empty e = new Empty(pNew, column, row);
//			return e;
//		} else if (population[GRASS] == 0 && population[RABBIT] == 0) {		//if there is 0 grass and zero rabbits this causes an error
//			Grass G = new Grass(pNew, column, row);
//			return G;
//		} else if (population[RABBIT] / population[GRASS] >= 3) {
//			Empty e = new Empty(pNew, column, row);
//			return e;
//		} else if (population[RABBIT] >= 3) {
//			Rabbit R = new Rabbit(pNew, column, row, 0);
//			return R;
//		} else {
//			Grass G = new Grass(pNew, column, row);
//			return G;
//		}
	}
}
