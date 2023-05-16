package es.unican.hapisecurity.REST_TFGMarioIngelmoDiana.security;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class GestionTokens {

	private static final String SECRET_KEY = "A56BYHGWDSG2391DKZFREGER34T9GRG349T5G83BETR3Y5GE";
	private static Key keyGenerada;

	private static final String NOMBRE = "mario";
	private static final String CONTRA = "ContraRESTTFG";

	public String generaToken(String nombre, String contra) {
		String token = null;
		if (nombre.equals(NOMBRE) && contra.equals(CONTRA)) {
			Key signingKey = new SecretKeySpec(DatatypeConverter.parseBase64Binary(SECRET_KEY),
					SignatureAlgorithm.HS256.getJcaName());
			keyGenerada = signingKey;
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MINUTE, 15);
			Date date = cal.getTime();
			JwtBuilder builder = Jwts.builder().setSubject(NOMBRE).setExpiration(date).signWith(signingKey,
					SignatureAlgorithm.HS256);

			token = builder.compact();
		}
		return token;
	}

	public boolean validaToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(keyGenerada).build().parseClaimsJws(token);
			return true;
		} catch (JwtException e) {
			System.out.println("El token está mal");
		}
		return false;
	}

}
