package br.com.futurodev.modulo3semana2exercicios.security;
import br.com.futurodev.modulo3semana2exercicios.model.Usuario;
import br.com.futurodev.modulo3semana2exercicios.security.dto.TokenDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.util.Date;
@Service
public class TokenService {
    @Value("${app.jwt.expiration}")
    private String jwtExpiration;
    @Value("${app.jwt.secret}")
    private String jwtSecret;
    public TokenDto gerarToken(Authentication auth) {
        Usuario usuarioLogado = (Usuario) auth.getPrincipal();
        Date inicioToken = new Date();
        Date terminoToken = new Date(inicioToken.getTime() + Long.parseLong(jwtExpiration));

        String jwt = Jwts.builder()
                .setIssuer("FuturoDev-Security")
                .setSubject(usuarioLogado.getId().toString())
                .setIssuedAt(inicioToken)
                .setExpiration(terminoToken)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
        return TokenDto.builder()
                .token(jwt)
                .tipo("Bearer")
                .build();
    }
    public boolean isTokenValido(String token) {
        try { Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {return false;
        }
    }
    public Integer getUsuarioId(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return Integer.parseInt(claims.getSubject());
    }
}
