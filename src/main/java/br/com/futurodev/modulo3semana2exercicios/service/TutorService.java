package br.com.futurodev.modulo3semana2exercicios.service;
import br.com.futurodev.modulo3semana2exercicios.model.Tutor;
import br.com.futurodev.modulo3semana2exercicios.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TutorService {
    @Autowired
    private TutorRepository tutorRepository;
    public Tutor salvar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }
    public List<Tutor> buscarTutores() {
        return tutorRepository.findAll();
    }
    public void excluir(Integer id) {
        tutorRepository.delete(id);
    }

}
