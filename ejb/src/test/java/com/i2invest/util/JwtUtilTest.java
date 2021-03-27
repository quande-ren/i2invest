package com.i2invest.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JwtUtilTest {

	@Test
	public void testIt() {
		String issuer = "Quande.Ren@gmail.com";
		String token=JwtUtil.generateToken(issuer);
		System.out.println(token);
		
		assertTrue(JwtUtil.isValidToken(token, issuer));
	}

}
