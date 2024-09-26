package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class BadgerTest {

	@Test
	public void testVariables() {
		Badger b = new Badger(null, 2, 3, 4);
		assertEquals(2, b.row);
		assertEquals(3, b.column);
		assertEquals(4, b.age);
	}
	
	@Test
	public void testNextOldAge() {
		Plain p = new Plain(3);
		p.randomInit();
		
		Badger b = new Badger(p, 1, 1, 4);
		p.grid[1][1] = b;
		assertTrue(State.EMPTY == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void testFoxEatBadger() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Fox f = new Fox(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		
		Badger b = new Badger(p, 1, 1, 2);
		p.grid[1][1] = b;
		
		
		assertTrue(State.FOX == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void testBadgerStarvation() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Fox f = new Fox(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		Badger b0 = new Badger(p, 0, 1, 2);
		p.grid[0][1] = b0;
		
		Badger b = new Badger(p, 1, 1, 2);
		p.grid[1][1] = b;
		
		Rabbit R = new Rabbit(p, 2, 2, 0);
		p.grid[2][2] = R;
		assertTrue(State.EMPTY == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void testBaderAge() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Rabbit f = new Rabbit(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		
		Badger b = new Badger(p, 1, 1, 0);
		p.grid[1][1] = b;
		assertTrue(State.BADGER == p.grid[1][1].next(p).who());
	}
	
	
	

}
