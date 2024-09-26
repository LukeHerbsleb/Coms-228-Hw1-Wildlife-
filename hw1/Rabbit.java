package edu.iastate.cs228.hw1;

/**
 *  
 * @author Luke Herbsleb
 *
 */

/*
 * A rabbit eats grass and lives no more than three years.
 */
public class Rabbit extends Animal 
{	
	/**
	 * Creates a Rabbit object.
	 * @param p: plain  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Rabbit (Plain p, int r, int c, int a) 
	{
		age = a;
		row = r;
		column = c;
		plain = p;
	}
		
	// Rabbit occupies the square.
	public State who()
	{
		return State.RABBIT; 
	}
	
	/**
	 * A rabbit dies of old age or hunger. It may also be eaten by a badger or a fox.  
	 * @param pNew     plain of the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Plain pNew)
	{
		int[] population = new int[5];
		plain.grid[row][column].census(population);
		if (age >= RABBIT_MAX_AGE) {		//dies of old age
			Empty e = new Empty(pNew, column, row);
			return e;
		} else if (population[GRASS] == 0) {
			Empty e = new Empty(pNew, column, row);
			return e;
		} else if (((population[FOX] + population[BADGER] >= population[RABBIT] + 1) && (population[FOX] >= population[BADGER])) || (population[FOX] > population[BADGER])) {
			Fox f = new Fox(pNew, column, row, 0);
			return f;
		} else if (population[BADGER] > population[RABBIT] + 1) {
			Badger b = new Badger(pNew, row, column, 0);
			return b;
		} else {
			Rabbit R = new Rabbit(pNew, column, row, age + 1);
			return R;
		}
	}
}
