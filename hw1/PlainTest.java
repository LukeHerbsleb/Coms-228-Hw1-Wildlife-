package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

public class PlainTest {

	@Test
	public void test() throws FileNotFoundException {
		Plain p = new Plain("testCases\\public1-3x3.txt");
		assertTrue(p.grid[0][0].who() == State.GRASS);
		assertTrue(p.grid[0][1].who() == State.BADGER);
		assertTrue(p.grid[0][2].who() == State.FOX);
		assertTrue(p.grid[1][0].who() == State.FOX);
		assertTrue(p.grid[1][1].who() == State.FOX);
		assertTrue(p.grid[1][2].who() == State.RABBIT);
		assertTrue(p.grid[2][0].who() == State.FOX);
		assertTrue(p.grid[2][1].who() == State.EMPTY);
		assertTrue(p.grid[2][2].who() == State.GRASS);
	}
	
	@Test
	public void testWidth() {
		Plain p = new Plain(3);
		assertTrue(p.getWidth() == 3);
		
	}
	
	@Test
	public void testWidth2() {
		Plain p = new Plain(9999);
		assertTrue(p.getWidth() == 9999);
		
	}
	
	public void testRandomInit() {
		Plain p = new Plain(3);
		p.randomInit();
		assertTrue(p.grid[0][0].who() != null);
		assertTrue(p.grid[0][1].who() != null);
		assertTrue(p.grid[0][2].who() != null);
		assertTrue(p.grid[1][0].who() != null);
		assertTrue(p.grid[1][1].who() != null);
		assertTrue(p.grid[1][2].who() != null);
		assertTrue(p.grid[2][0].who() != null);
		assertTrue(p.grid[2][1].who() != null);
		assertTrue(p.grid[2][2].who() != null);
	}

}
