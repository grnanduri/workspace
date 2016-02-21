package com.testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquareTest {

	@Test
	public void test() {
		JUnitTesting test = new JUnitTesting();
		int output = test.square(5);
		assertEquals(25, output); 
	}
	
}
