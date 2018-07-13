package com.saida.spring.rest.repository;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTestCase {

	private User user;

	@Before
	public void setUp() {
		user = User.user().firstName("JUNIT-FST-NAM").lastName("JUNIT-LST-NAM").contactNo("85858585")
				.email("JUNIT@GAMIL.COM").build();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUserBuilderEmpty() {
		user = User.user().build();
	}

	@Test
	public void testUserBuilder() {
		assertNotNull(user);
		assertEquals(user.getContactNo(), "85858585");
	}

	@Test
	public void testEquals() {
		assertTrue(user.getFirstName().equals(User.user().firstName("JUNIT-FST-NAM").build().getFirstName()));
		assertFalse(user.getFirstName().equals(User.user().firstName("JUNIT-FST-NAM-1").build().getFirstName()));

	}

}
