package br.com.exercicios.ilab.ecommerce.mysql.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.exercicios.ilab.ecommerce.mysql.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TokenUtil {
	private static final int SEGUNDOS = 1000;
	private static final int MINUTOS = 60 * SEGUNDOS;
	private static final int HORAS = 60 * MINUTOS;
	private static final int DIAS = 24 * HORAS;

	private static final String HEADER = "Authorization";
	private static final String PREFIX = "Bearer ";
	private static final long EXPIRATION = 2 * MINUTOS;

	public static final String SECRET_KEY = "12345678901234567890123456789012";
	public static final String EMISSOR = "A";

	public static String createToken(Usuario usuario) {
		Key secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

		String token = Jwts.builder().setSubject(usuario.getUsername()).setIssuer(EMISSOR)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
				.signWith(secretKey, SignatureAlgorithm.HS256).compact();

		return PREFIX + token;
	}

	private static boolean isExpirationValid(Date expiration) {
		return expiration.after(new Date(System.currentTimeMillis()));
	}

	private static boolean isEmissorValid(String emissor) {
		return emissor.equals(EMISSOR);
	}

	private static boolean isSubjectValid(String username) {
		return username != null && username.length() > 0;
	}

	public static Authentication validate(HttpServletRequest request) {

		String token = request.getHeader(HEADER);
		token = token.replace(PREFIX, "");

		Jws<Claims> jwsClaims = Jwts.parserBuilder().setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token);

		String username = jwsClaims.getBody().getSubject();
		String issuer = jwsClaims.getBody().getIssuer();
		Date expira = jwsClaims.getBody().getExpiration();

		if (isSubjectValid(username) && isEmissorValid(issuer) && isExpirationValid(expira)) {
			return new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
		}

		return null;

	}
}
