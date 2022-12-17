package br.com.futurodev.modulo3semana2exercicios.repository;
import br.com.futurodev.modulo3semana2exercicios.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class PetRepository {
@Autowired
    private TutorRepository tutorRepository;
    private static int indice = 1;
    private static List<Pet> pets = new ArrayList<>();
    private int gerarId() {
        return indice++;
    }
    public Pet save(Pet pet) {
        if (pet.getId() == null) { // Criação
            pet.setId(gerarId());
        } else { // Edição
            delete(pet.getId());
        }
        try {
            if (pet.getTutor().getId() != null) {
                pet.setTutor(tutorRepository.findById(pet.getTutor().getId()));
            }
        } catch (Exception ignorar) {
        }
        pets.add(pet);
        return pet;
    }
        public Pet findById(Integer id) {
        if (id == null)
            return null;
        for (Pet pet : pets) {
            if (id.equals(pet.getId())) {
                return pet;
            }
        }
        return null;
    }
    public List<Pet> findAll() {
        return pets;
    }
     public void delete(Integer id) {
        try {
            Pet petOld = findById(id);
            pets.remove(petOld);
        } catch (Exception ignorado) {
        }
    }

}
