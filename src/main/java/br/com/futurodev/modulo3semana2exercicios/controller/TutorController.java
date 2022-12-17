package br.com.futurodev.modulo3semana2exercicios.controller;

import br.com.futurodev.modulo3semana2exercicios.model.Tutor;
import br.com.futurodev.modulo3semana2exercicios.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
    @RestController
    @RequestMapping(value = "/tutores")
public class TutorController {
    @Autowired
    private TutorService tutorService;
    @GetMapping
    public List<Tutor> get() {
        return tutorService.buscarTutores();
    }
    @PostMapping
    public Tutor post(@RequestBody Tutor tutor) {
        return tutorService.salvar(tutor);
    }
    @PutMapping
    public Tutor put(@RequestBody Tutor tutor) {
        return tutorService.salvar(tutor);
    }
    @DeleteMapping
    public boolean delete(@RequestBody Tutor tutor) {
        tutorService.excluir(tutor.getId());
        return true;
    }

}
