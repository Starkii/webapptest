package com.proquest.interview.phonebook;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NameTest {

	@Test(expected=NullPointerException.class)
	public void testName1() {
		new Name(null,null);
	}

	@Test(expected=NullPointerException.class)
	public void testName2() {
		new Name("abc",null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testName3() {
		new Name(null,"abc");
	}
	
	@Test
	public void testName() {
		Name name = new Name("Jens", "Wessling");
		assertEquals(name.getFirst() ,"Jens");
		assertEquals(name.getLast() ,"Wessling");
		assertEquals(name.getName() ,"Jens Wessling");
	}
}
