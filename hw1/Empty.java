package edu.iastate.cs228.hw1;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	public Empty (Plain p, int r, int c) 
	{
		row = r;
		column = c;
		plain = p;
	}
	
	public State who()
	{ 
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Badger, Fox, Rabbit, or Grass, or remain empty. 
	 * @param pNew     plain of the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Plain pNew)
	{
		int[] population = new int[5];
		plain.grid[row][column].census(population);
		if (population[RABBIT] > 1) {
			Rabbit R = new Rabbit(pNew, column, row, 0);
			return R;
		} else if (population[FOX] > 1) {
			Fox f = new Fox(pNew, column, row, 0);
			return f;
		} else if (population[BADGER] > 1) {
			Badger b = new Badger(pNew, row, column, 0);
			return b;
		} else if (population[GRASS] >= 1) {
			Grass G = new Grass(pNew, column, row);
			return G;
		} else {
			Empty e = new Empty(pNew, column, row);
			return e;
		}
	}
}
