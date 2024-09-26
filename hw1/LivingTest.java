package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class LivingTest {

	@Test
	public void testCensus1() throws FileNotFoundException {		//i've been told to not inclode the animal in the middle of census
																	//every time calculations are done in next() this is accounted for
		Plain p = new Plain("publicTests\\public3-10x10.txt");
		int[] population = new int[5];
		p.grid[1][1].census(population);
		assertTrue(population[0] == 3);
		assertTrue(population[1] == 1);
		assertTrue(population[2] == 0);
		assertTrue(population[3] == 4);
		assertTrue(population[4] == 0);
	}
	
	@Test
	public void testCensus2() throws FileNotFoundException {
		Plain p = new Plain("publicTests\\public3-10x10.txt");
		int[] population = new int[5];
		p.grid[0][0].census(population);
		assertTrue(population[0] == 0);
		assertTrue(population[1] == 2);
		assertTrue(population[2] == 0);
		assertTrue(population[3] == 1);
		assertTrue(population[4] == 0);
	}
	
	
	

}
