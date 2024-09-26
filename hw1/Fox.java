package edu.iastate.cs228.hw1;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/**
 * A fox eats rabbits and competes against a badger. 
 */
public class Fox extends Animal 
{
	/**
	 * Constructor 
	 * @param p: plain
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Fox (Plain p, int r, int c, int a) 
	{
		age = a;
		row = r;
		column = c;
		plain = p;
	}
		
	/**
	 * A fox occupies the square. 	 
	 */
	public State who()
	{
		return State.FOX; 
	}
	
	/**
	 * A fox dies of old age or hunger, or from attack by numerically superior badgers. 
	 * @param pNew     plain of the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Plain pNew)
	{
		int[] population = new int[5];
		plain.grid[row][column].census(population);
		if (age >= FOX_MAX_AGE) {		//dies of old age
			Empty e = new Empty(pNew, column, row);
			return e;
		} else if (population[BADGER] > population[FOX] + 1) {		//if badger outnumber foxes
			Badger b = new Badger(pNew, row, column, 0);
			return b;
		} else if (population[BADGER] + population[FOX] + 1 > population[RABBIT]) {		//if badgers + foxes outnumber rabbits
			Empty e = new Empty(pNew, column, row);
			return e;
		} else {
			Fox f = new Fox(pNew, column, row, age + 1);
			return f;
		}
	}
}
