package tech.trimed.Service;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import tech.trimed.entity.UsuarioEntity;
import tech.trimed.exception.UserNotFoundException;
import tech.trimed.repository.UserRepository;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UsuarioEntity createUser(UsuarioEntity userEntity) {
        userRepository.persist(userEntity);
        return userEntity;
    }

    public List<UsuarioEntity> findAll(Integer page, Integer pageSize) {
        return userRepository.findAll()
                .page(page, pageSize)
                .list();
    }

    public UsuarioEntity findById(UUID id) {
        return (UsuarioEntity) userRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public UsuarioEntity updateUser(UUID id, UsuarioEntity usuarioEntity) {
        var user = findById(id);

        user.setLogin(usuarioEntity.getLogin());

        userRepository.persist(user);

        return user;
    }

    public void deleteById(UUID id) {
        var user = findById(id);
        userRepository.deleteById(user.getId_login());
    }
}
