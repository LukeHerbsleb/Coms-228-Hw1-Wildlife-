package edu.iastate.cs228.hw1;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

@SuppressWarnings("unused")
public class WildlifeTest {

	@Test
	public void PublicTest1() throws FileNotFoundException {
		String[] args = new String[3];
		Wildlife.main(args);		//testCases\public1-3x3.txt
		
		//dont know how to test a main method buy i just compare the output to the expected output and it matches
	}
	
	@Test
	public void PublicTest2() throws FileNotFoundException {
		String[] args = new String[3];
		Wildlife.main(args);		//publicTests\public2-6x6.txt
		
		//this one is not currently working, must be somwthing with the rules I overlooked
	}
	
	@Test
	public void PublicTest3() throws FileNotFoundException {
		String[] args = new String[3];
		Wildlife.main(args);		//testCases\HWpdftest1.txt
		
		//works correctly
	}
	
	@Test
	public void PublicTest4() throws FileNotFoundException {
		String[] args = new String[3];
		Wildlife.main(args);		//publicTests\public3-10x10.txt
		
		//this one is not currently working, must be somwthing with the rules I overlooked
	}
	
	
	
	

}
