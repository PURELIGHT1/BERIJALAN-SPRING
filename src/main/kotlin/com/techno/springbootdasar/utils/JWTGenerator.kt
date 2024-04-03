package com.techno.springbootdasar.utils

import com.techno.springbootdasar.domain.dto.request.ReqEncodeJWTDto
import com.techno.springbootdasar.domain.dto.response.ResLoginJWTDto
import com.techno.springbootdasar.exception.DataNotFoundException
import com.techno.springbootdasar.exception.TokenNotFound
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtBuilder
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.web.bind.annotation.RequestHeader
import java.util.Date
import javax.crypto.spec.SecretKeySpec


class JWTGenerator {
    companion object{
        private const val SECRET_KEY = "YOUR_SECRET_KEY_THAT_HAS_256_LONG"
        private val istance: JWTGenerator = JWTGenerator()
    }

    fun createJWT(req: ReqEncodeJWTDto): String {
        val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
        val nowMills: Long = System.currentTimeMillis()
        val now = Date(nowMills)

        val apiKeySecretBytes = SECRET_KEY.toByteArray()
        val singinKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.jcaName)

        val builder: JwtBuilder = Jwts.builder().setSubject(req.id)
            .claim("id", req.id)
            .claim("role", req.role)
            .claim("email", req.email)
            .claim("password", req.password)
            .setIssuer("technocenter")
            .setAudience("technocenter")
            .signWith(singinKey, signatureAlgorithm)

        val expMills = nowMills + 3600000L
        val exp = Date(expMills)
        builder.setExpiration(exp)

        return builder.compact()
    }

    fun createLoginJWT(req: ResLoginJWTDto): String {
        val signatureAlgorithm: SignatureAlgorithm = SignatureAlgorithm.HS256
        val nowMills: Long = System.currentTimeMillis()
        val now = Date(nowMills)

        val apiKeySecretBytes = SECRET_KEY.toByteArray()
        val singinKey = SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.jcaName)

        val builder: JwtBuilder = Jwts.builder().setSubject(req.id.toString())
            .claim("id", req.id)
            .claim("name", req.name)
            .claim("username", req.username)
            .claim("email", req.email)
            .setIssuer("technocenter")
            .setAudience("technocenter")
            .signWith(singinKey, signatureAlgorithm)

        val expMills = nowMills + 3600000L
        val exp = Date(expMills)
        builder.setExpiration(exp)

        return builder.compact()
    }

    fun decodeJWT(jwt: String): Claims {
        try {
            val claims: Claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.toByteArray())
                .build()
                .parseClaimsJws(jwt).body
            return claims
        }
        catch (e: JwtException) {
            e.printStackTrace()
            throw DataNotFoundException("Invalid Token")
        }
    }

    fun decodeLoginJWT(
        @RequestHeader("token") token: String,
    ): Claims {
        try {
            val claims: Claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY.toByteArray())
                .build()
                .parseClaimsJws(token).body
            return claims
        }
        catch (e: JwtException) {
            e.printStackTrace()
            throw DataNotFoundException("Invalid Token")
        }
    }
}