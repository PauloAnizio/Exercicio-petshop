package br.com.futurodev.modulo3semana2exercicios.controller;
import br.com.futurodev.modulo3semana2exercicios.security.dto.LoginDto;
import br.com.futurodev.modulo3semana2exercicios.security.dto.TokenDto;
import br.com.futurodev.modulo3semana2exercicios.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "loguin")
public class LoginController {
    @Autowired private LoginService loginService;
    @PostMapping
    public TokenDto post(@RequestBody LoginDto login) {
        return loginService.gerarToken(login);
    }
}
