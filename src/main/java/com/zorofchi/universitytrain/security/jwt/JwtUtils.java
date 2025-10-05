package com.zorofchi.universitytrain.security.jwt;


import com.zorofchi.universitytrain.security.services.UserDetailsImpl;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hibernate.query.sqm.EntityTypeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;


@Component
public class JwtUtils {


    @Value("${javatar.app.jwtSecret}")
    private String jwtSecret;
    @Value("${javatar.app.jwtExpirationMs}")
    private int jwtExpirationMs;


    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userDetails.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key() , SignatureAlgorithm.HS256)
                .compact();

    }
    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authtToken){
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(authtToken);
            return true;
        } catch (EntityTypeException e){
            System.out.println("Jwt token is expired" + e.getMessage());
        } catch (MalformedJwtException e){
            System.out.println("Invalid Jwt token "+ e.getMessage());
        } catch (IllegalArgumentException e){
            System.out.println("Jwt string is Empty "+ e.getMessage());
        }
        return false;
    }

    public String getUsernameFromJwtToken(String authToken){
        return Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(authToken).getBody().getSubject();
    }




}
