package com.BackendEcomerce.security;


import com.BackendEcomerce.model.Cliente;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import static javax.crypto.Cipher.SECRET_KEY;
import org.springframework.http.HttpStatus;

@Component
public class JwtTokenProvider {

    @Value("${eCommerce.app.secret}")
    private String APP_SECRET;

    @Value("${eCommerce.expires.in}")
    private long EXPIRES_IN;

//    public String generateJwtToken(Authentication auth) {
//        JwtUserDetails userDetails = (JwtUserDetails) auth.getPrincipal();
//        Date expireDate = new Date(new Date().getTime() + EXPIRES_IN);
//        return Jwts.builder().setSubject(Integer.toString(userDetails.getId()))
//                .setIssuedAt(new Date()).setExpiration(expireDate)
//                .signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();
//    }

    int getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        return Integer.parseInt(claims.getSubject());
    }
/*
    public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
      return true;
    } catch (SignatureException e) {
   //   throw new CustomException("Expired or invalid JWT token", HttpStatus.INTERNAL_SERVER_ERROR);
            return false;
    }
  }
    */
    boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
            return !isTokenExpired(token);
        }catch (SignatureException e) {
            return false;
        }catch (MalformedJwtException e) {
            return false;
        }catch (ExpiredJwtException e) {
            return false;
        }catch (UnsupportedJwtException e) {
            return false;
        }catch (IllegalArgumentException e) {
            return false;
        }
    }
    

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }
    
//    public String generateJwtToken2(Authentication auth) {
//        JwtUserDetails userDetails = (JwtUserDetails) auth.getPrincipal();
//        Date expireDate = new Date(new Date().getTime() + EXPIRES_IN);
//        return Jwts.builder().setSubject(Integer.toString(userDetails.getId()))
//                .claim("roles", user.getRoles().toString())
//                .setIssuedAt(new Date())
//                .setExpiration(expireDate)
//                .signWith(SignatureAlgorithm.HS512, APP_SECRET).compact();
//    }
    
    public String generateAccessToken(Cliente user) {
        Date expireDate = new Date(new Date().getTime() + EXPIRES_IN);
     
    return Jwts.builder()
            .setSubject(String.format("%s,%s", user.getId_cliente(),user.getPassword()))
            .setIssuer("CodeJava")
            .claim("roles", user.getRoles().toString())
            .setIssuedAt(new Date())
            .setExpiration(expireDate)
            .signWith(SignatureAlgorithm.HS512, APP_SECRET)
            .compact();
}

}

