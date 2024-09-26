package edu.iastate.cs228.hw1;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

class RabbitTest {

	@Test
	void testDiesOfOldAge() {
		Plain p = new Plain(3);
		p.randomInit();
		
		Rabbit b = new Rabbit(p, 1, 1, 6);
		p.grid[1][1] = b;
		assertTrue(State.EMPTY == p.grid[1][1].next(p).who());
	}
	
	@Test
	void testDiesOfStarvation() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Empty f = new Empty(p, i, j);
				p.grid[i][j] = f;
			}
		}
		
		Rabbit b = new Rabbit(p, 1, 1, 0);
		p.grid[1][1] = b;
		assertTrue(State.EMPTY == p.grid[1][1].next(p).who());
	}
	
	@Test
	void testRabbitGetsEaten() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Fox f = new Fox(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		Grass g = new Grass(p, 1, 1);
		p.grid[1][2] = g;
		Rabbit b = new Rabbit(p, 1, 1, 0);
		p.grid[1][1] = b;
		assertTrue(State.FOX == p.grid[1][1].next(p).who());
	}
	
	@Test
	void testRabbitGetsEatenByBadger() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Badger f = new Badger(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		Grass g = new Grass(p, 1, 1);
		p.grid[1][2] = g;
		Rabbit b = new Rabbit(p, 1, 1, 0);
		p.grid[1][1] = b;
		assertTrue(State.BADGER == p.grid[1][1].next(p).who());
	}
	
	@Test
	void testRabbitLivesOn() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Grass f = new Grass(p, i, j);
				p.grid[i][j] = f;
			}
		}
		Rabbit b = new Rabbit(p, 1, 1, 0);
		p.grid[1][1] = b;
		assertTrue(State.RABBIT == p.grid[1][1].next(p).who());
	}

}
