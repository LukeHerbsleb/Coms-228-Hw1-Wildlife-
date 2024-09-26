package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class FoxTest {

	@Test
	public void FoxDiesOfOldAge() {
		Plain p = new Plain(3);
		p.randomInit();
		
		Fox b = new Fox(p, 1, 1, 6);
		p.grid[1][1] = b;
		assertTrue(State.EMPTY == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void TestFoxBecomeBadger() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Badger f = new Badger(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		
		
		Fox b = new Fox(p, 1, 1, 2);
		p.grid[1][1] = b;
		
		assertTrue(State.BADGER == p.grid[1][1].next(p).who());
		
	}
	
	@Test
	public void testFoxStarvation() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Fox f = new Fox(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		Badger b0 = new Badger(p, 0, 1, 2);
		p.grid[0][1] = b0;
		
		Fox b = new Fox(p, 1, 1, 2);
		p.grid[1][1] = b;
		
		Rabbit R = new Rabbit(p, 2, 2, 0);
		p.grid[2][2] = R;
		assertTrue(State.EMPTY == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void testFoxLivesOn() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Rabbit f = new Rabbit(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		
		Fox b = new Fox(p, 1, 1, 2);
		p.grid[1][1] = b;
		
		assertTrue(State.FOX == p.grid[1][1].next(p).who());
	}

}
