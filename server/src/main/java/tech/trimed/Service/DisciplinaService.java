package tech.trimed.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import tech.trimed.entity.DisciplinaEntity;
import tech.trimed.exception.UserNotFoundException;
import tech.trimed.repository.DisciplinaRepository;

@ApplicationScoped
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public DisciplinaEntity createDisciplina(DisciplinaEntity disciplinaEntity) {
        disciplinaRepository.persist(disciplinaEntity);
        return disciplinaEntity;
    }

    public List<DisciplinaEntity> findAll(Integer page, Integer pageSize) {
        return disciplinaRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public DisciplinaEntity findById(Integer id) {
        return (DisciplinaEntity) disciplinaRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public DisciplinaEntity updateDisciplina(Integer id, DisciplinaEntity disciplinaEntity) {
        var disciplina = findById(id);

        disciplina.setNomeDisciplina(disciplinaEntity.getNomeDisciplina());

        disciplinaRepository.persist(disciplina);

        return disciplina;
    }

    public void deleteById(Integer id) {
        var disciplina = findById(id);
        disciplinaRepository.deleteById(disciplina.getIdDisciplina());
    }
}
