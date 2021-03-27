package com.i2invest.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtUtil {
	private static final String HMAC256_SECRET = "secret12114sjgjkldfgnxc ln89hfdgvkjnbxcvznvzkhdsvfbgvbXDMH";
	public static String generateToken(String email) {
		Algorithm algorithm = Algorithm.HMAC256(HMAC256_SECRET);
		 String token = JWT.create()
		        .withIssuer(email.toLowerCase())
		        .sign(algorithm);
		 return token;
	}
	public static boolean isValidToken(String token, String email) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(HMAC256_SECRET);
		    JWTVerifier verifier = JWT.require(algorithm)
		        .withIssuer(email.toLowerCase())
		        .build(); 
		    DecodedJWT jwt = verifier.verify(token);
		    System.out.println(jwt.getAlgorithm()+" "+jwt.getContentType()+" "+jwt.getHeader()+" "+jwt.getIssuer());
		    return true;
		}catch (JWTVerificationException  e) {
			return false;
		}
	}
}
