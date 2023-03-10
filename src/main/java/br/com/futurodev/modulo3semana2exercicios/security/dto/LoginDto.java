package br.com.futurodev.modulo3semana2exercicios.security.dto;
import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
@Data
public class LoginDto {
    private String login;
    private String senha;
    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(this.login, this.senha);
    }

}
