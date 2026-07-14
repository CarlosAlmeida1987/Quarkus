package tech.trimed.service;

import java.util.List;
import java.util.stream.Collectors;
import jakarta.enterprise.context.ApplicationScoped;
import tech.trimed.dto.CursoRequestDTO;
import tech.trimed.dto.CursoResponseDTO;
import tech.trimed.entity.CursoEntity;
import tech.trimed.exception.UserNotFoundException;
import tech.trimed.repository.CursosRepository;

@ApplicationScoped
public class CursosService {

    private final CursosRepository cursosRepository;

    public CursosService(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

    private CursoResponseDTO toResponseDTO(CursoEntity entity) {
        CursoResponseDTO dto = new CursoResponseDTO();
        dto.setIdCurso(entity.getIdCurso());
        dto.setNomeCurso(entity.getNomeCurso());
        dto.setDuracao(entity.getDuracao());
        dto.setDia(entity.getDia());
        dto.setHora(entity.getHora());
        return dto;
    }

    private CursoEntity toEntity(CursoRequestDTO dto) {
        CursoEntity entity = new CursoEntity();
        entity.setNomeCurso(dto.getNomeCurso());
        entity.setDuracao(dto.getDuracao());
        entity.setDia(dto.getDia());
        entity.setHora(dto.getHora());
        return entity;
    }

    public CursoResponseDTO createCurso(CursoRequestDTO dto) {
        CursoEntity entity = toEntity(dto);
        cursosRepository.persist(entity);
        return toResponseDTO(entity);
    }

    public List<CursoResponseDTO> findAll(Integer page, Integer pageSize) {
        return cursosRepository.findAll()
                .page(page, pageSize)
                .list()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CursoResponseDTO findById(Integer id) {
        CursoEntity entity = (CursoEntity) cursosRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
        return toResponseDTO(entity);
    }

    public CursoResponseDTO updateCurso(Integer id, CursoRequestDTO dto) {
        CursoEntity curso = (CursoEntity) cursosRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);

        curso.setNomeCurso(dto.getNomeCurso());
        curso.setDuracao(dto.getDuracao());
        curso.setDia(dto.getDia());
        curso.setHora(dto.getHora());

        cursosRepository.persist(curso);

        return toResponseDTO(curso);
    }

    public void deleteById(Integer id) {
        var curso = (CursoEntity) cursosRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
        cursosRepository.deleteById(curso.getIdCurso());
    }
}
