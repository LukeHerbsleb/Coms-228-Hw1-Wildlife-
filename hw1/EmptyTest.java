package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmptyTest {

	@Test
	public void BecomeRabbit() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Rabbit f = new Rabbit(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		
		Empty b = new Empty(p, 1, 1);
		p.grid[1][1] = b;
		
		
		assertTrue(State.RABBIT == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void BecomeFox() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Fox f = new Fox(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		
		Empty b = new Empty(p, 1, 1);
		p.grid[1][1] = b;
		
		
		assertTrue(State.FOX == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void BecomeBadger() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Badger f = new Badger(p, i, j, 0);
				p.grid[i][j] = f;
			}
		}
		
		Empty b = new Empty(p, 1, 1);
		p.grid[1][1] = b;
		
		
		assertTrue(State.BADGER == p.grid[1][1].next(p).who());
	}
	
	
	@Test
	public void BecomeGrass() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Grass f = new Grass(p, i, j);
				p.grid[i][j] = f;
			}
		}
		
		Empty b = new Empty(p, 1, 1);
		p.grid[1][1] = b;
		
		
		assertTrue(State.GRASS == p.grid[1][1].next(p).who());
	}
	
	@Test
	public void BecomeGrassFrom1Grass() {
		Plain p = new Plain(3);
		for (int i = 0; i < p.getWidth(); i++) {
			for (int j = 0; j < p.getWidth(); j++) {
				Empty f = new Empty(p, i, j);
				p.grid[i][j] = f;
			}
		}
		Grass G = new Grass(p, 1, 2);
		p.grid[1][2] = G;
		
		
		Empty b = new Empty(p, 1, 1);
		p.grid[1][1] = b;
		
		
		assertTrue(State.GRASS == p.grid[1][1].next(p).who());
	}
	
	

}
