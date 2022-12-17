package br.com.futurodev.modulo3semana2exercicios.security.dto;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class TokenDto { private String token;
    private String tipo;
}
