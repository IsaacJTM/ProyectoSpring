package com.proyecto.listaPendientes.infrastructure.adapter;

import com.proyecto.listaPendientes.domain.port.out.JWTServiceOut;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTServiceAdapter implements JWTServiceOut {
    @Override
    public String generarTokenOut(UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 5*3600))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public boolean validarTokenOut(String token, UserDetails userDetails) {
        final String username = extractUserNameOut(token);
        return (username.equals(userDetails.getUsername()) && isTokenExpired(token));
    }

    @Override
    public String extractUserNameOut(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    //Métodos de apoyo
    //Generar token
    private Key getSignKey(){
        byte[] key = Decoders.BASE64.decode("1a2b3c4d5e6f789abcdef0123456789abcdef0123456789abcdef0123456789AFSDEFSse3158341");
        return Keys.hmacShaKeyFor(key);
    }

    private <T> T extractClaims(String token, Function<Claims, T> claimsFunction){
        final Claims claims = extractAllClaims(token);
        return claimsFunction.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }
    private boolean isTokenExpired(String token){
        return (new Date().before(extractClaims(token, Claims::getExpiration)));
    }
}
