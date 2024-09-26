package edu.iastate.cs228.hw1;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/**
 * A badger eats a rabbit and competes against a fox. 
 */
public class Badger extends Animal
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Badger (Plain p, int r, int c, int a) 
	{
		age = a;
		row = r;
		column = c;
		plain = p;
	}
	
	/**
	 * A badger occupies the square. 	 
	 */
	public State who()
	{
		return State.BADGER; 
	}
	
	/**
	 * A badger dies of old age or hunger, or from isolation and attack by a group of foxes. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		int[] population = new int[5];
		plain.grid[row][column].census(population);
		if (age >= BADGER_MAX_AGE) {
			Empty e = new Empty(pNew, column, row);
			return e;
		} else if (population[FOX] >= 2 && population[BADGER] == 0) {	//more than one fox 
			Fox f = new Fox(pNew, column, row, 0);
			return f;
		} else if ((population[FOX] + population[BADGER] + 1) > population[RABBIT]) {	//more badger + foxes than rabbits
			Empty e = new Empty(pNew, column, row);
			return e;
		} else {
			Badger b = new Badger(pNew, row, column, age + 1);
			return b;
		}
	}
}
