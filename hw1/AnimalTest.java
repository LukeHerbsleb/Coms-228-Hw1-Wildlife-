package edu.iastate.cs228.hw1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnimalTest {

	@Test
	void TestGetFoxAge() {
		Animal a = new Fox(null, 0, 0, 1);
		assertEquals(1, a.myAge());
	}
	
	@Test
	void TestGetBadgerAge() {
		Animal a = new Badger(null, 0, 0, 6);
		assertEquals(6, a.myAge());
	}
	
	@Test
	void TestGetRabbitAge() {
		Animal a = new Fox(null, 0, 0, 7);	//rabbit will die next cycle but currently has age 7
		assertEquals(7, a.myAge());
	}
	

}
