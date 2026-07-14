package tech.trimed.service;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.enterprise.context.ApplicationScoped;
import tech.trimed.dto.UsuarioRequestDTO;
import tech.trimed.dto.UsuarioResponseDTO;
import tech.trimed.entity.UsuarioEntity;
import tech.trimed.exception.UserNotFoundException;
import tech.trimed.repository.UserRepository;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private UsuarioResponseDTO toResponseDTO(UsuarioEntity entity) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setIdLogin(entity.getIdLogin());
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setLogin(entity.getLogin());
        dto.setTipoUsuario(entity.getTipoUsuario());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setUltimoAcesso(entity.getUltimoAcesso());
        dto.setStatus(entity.getStatus());
        return dto;
    }

    private UsuarioEntity toEntity(UsuarioRequestDTO dto) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setIdUsuario(dto.getIdUsuario());
        entity.setLogin(dto.getLogin());
        entity.setSenha(dto.getSenha());
        entity.setTipoUsuario(dto.getTipoUsuario());
        return entity;
    }

    public UsuarioResponseDTO createUser(UsuarioRequestDTO dto) {
        UsuarioEntity entity = toEntity(dto);
        userRepository.persist(entity);
        return toResponseDTO(entity);
    }

    public List<UsuarioResponseDTO> findAll(Integer page, Integer pageSize) {
        return userRepository.findAll()
                .page(page, pageSize)
                .list()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    public UsuarioResponseDTO findById(Integer id) {
        UsuarioEntity entity = (UsuarioEntity) userRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
        return toResponseDTO(entity);
    }

    public UsuarioResponseDTO updateUser(Integer id, UsuarioRequestDTO dto) {
        UsuarioEntity user = (UsuarioEntity) userRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);

        user.setLogin(dto.getLogin());
        if (dto.getSenha() != null) {
            user.setSenha(dto.getSenha());
        }
        if (dto.getTipoUsuario() != null) {
            user.setTipoUsuario(dto.getTipoUsuario());
        }
        if (dto.getIdUsuario() != null) {
            user.setIdUsuario(dto.getIdUsuario());
        }

        userRepository.persist(user);

        return toResponseDTO(user);
    }

    public void deleteById(Integer id) {
        var user = (UsuarioEntity) userRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
        userRepository.deleteById(user.getIdLogin());
    }
}
