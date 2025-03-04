package tech.trimed.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import tech.trimed.entity.SemestreEntity;
import tech.trimed.exception.UserNotFoundException;
import tech.trimed.repository.SemestreRepository;


@ApplicationScoped
public class SemestreService {

    private final SemestreRepository semestreRepository;

    public SemestreService(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    public SemestreEntity createSemestre(SemestreEntity semestreEntity) {
        semestreRepository.persist(semestreEntity);
        return semestreEntity;
    }

    public List<SemestreEntity> findAll(Integer page, Integer pageSize) {
        return semestreRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public SemestreEntity findById(Integer id) {
        return (SemestreEntity) semestreRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public SemestreEntity updateSemestre(Integer id, SemestreEntity semestreEntity) {
        var semestre = findById(id);

        semestre.setNumero(semestreEntity.getNumero());

        semestreRepository.persist(semestre);

        return semestre;
    }

    public void deleteById(Integer id) {
        var semestre = findById(id);
        semestreRepository.deleteById(semestre.getIdSemestre());
    }
}
