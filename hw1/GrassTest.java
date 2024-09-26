package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrassTest {

	@Test
	public void EatenByRabbits() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Rabbit f = new Rabbit(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}

		Grass b = new Grass(p, 1, 1);
		p.grid[1][1] = b;

		assertTrue(State.EMPTY == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void BecomeRabbit() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Rabbit f = new Rabbit(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}

		Grass b = new Grass(p, 1, 1);
		p.grid[1][1] = b;
		Grass b2 = new Grass(p, 1, 2);
		p.grid[1][2] = b2;
		Grass b3 = new Grass(p, 2, 1);
		p.grid[2][1] = b3;

		assertTrue(State.RABBIT == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void GrassLivesOn() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Empty f = new Empty(p, i, j);
				p.grid[i][j] = f;
			}
		}

		Grass b = new Grass(p, 1, 1);
		p.grid[1][1] = b;

		assertTrue(State.GRASS == p.grid[1][1].next(p).who());
	}
	

}
