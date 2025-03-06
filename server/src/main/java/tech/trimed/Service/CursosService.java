package tech.trimed.service;

import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import tech.trimed.entity.CursoEntity;
import tech.trimed.exception.UserNotFoundException;
import tech.trimed.repository.CursosRepository;

@ApplicationScoped
public class CursosService {

    private final CursosRepository cursosRepository;

    public CursosService(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

    public CursoEntity createCurso(CursoEntity cursoEntity) {
        cursosRepository.persist(cursoEntity);
        return cursoEntity;
    }

    public List<CursoEntity> findAll(Integer page, Integer pageSize) {
        return cursosRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public CursoEntity findById(Integer id) {
        return (CursoEntity) cursosRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public CursoEntity updateCurso(Integer id, CursoEntity cursoEntity) {
        var curso = findById(id);

        curso.setNomeCurso(cursoEntity.getNomeCurso());

        cursosRepository.persist(curso);

        return curso;
    }

    public void deleteById(Integer id) {
        var curso = findById(id);
        cursosRepository.deleteById(curso.getIdCurso());
    }
}
