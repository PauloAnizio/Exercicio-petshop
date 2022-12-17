package br.com.futurodev.modulo3semana2exercicios.repository;
import br.com.futurodev.modulo3semana2exercicios.model.Tutor;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
 @Repository
public class TutorRepository {
    private static int indice = 1;
    private static List<Tutor> tutores = new ArrayList<>();
    private int gerarId() {
        return indice++;
    }
    public Tutor save(Tutor tutor) {
        if (tutor.getId() == null) {
            tutor.setId(gerarId());
        } else {
            delete(tutor.getId());
        }
        tutores.add(tutor);
        return tutor;
    }
    public Tutor findById(Integer id) {
        if (id == null)
            return null;
        for (Tutor tutor : tutores) {
            if (id.equals(tutor.getId())) {
                return tutor;
            }
        }
        return null;
    }
    public List<Tutor> findAll() {
        return tutores;
    }
    public void delete(Integer id) {
        try {
            Tutor tutorOld = findById(id);
            tutores.remove(tutorOld);
        } catch (Exception ignorado) {
        }
    }

}
