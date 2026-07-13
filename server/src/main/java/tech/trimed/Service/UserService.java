package tech.trimed.service;

import java.util.List;

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

    public UsuarioEntity findById(Integer id) {
        return (UsuarioEntity) userRepository.findByIdOptional(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public UsuarioEntity updateUser(Integer id, UsuarioEntity usuarioEntity) {
        var user = findById(id);

        user.setLogin(usuarioEntity.getLogin());

        userRepository.persist(user);

        return user;
    }

    public void deleteById(Integer id) {
        var user = findById(id);
        userRepository.deleteById(user.getIdLogin());
    }
}
