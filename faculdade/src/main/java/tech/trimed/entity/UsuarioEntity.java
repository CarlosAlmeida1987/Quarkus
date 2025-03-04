package tech.trimed.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import tech.trimed.enums.StatusLogin;
import tech.trimed.enums.TipoUsuario;

public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_login;

    private Integer id_usuario;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    private String login;

    private String senha;

    private LocalDateTime data_criacao;

    private LocalDateTime ultimo_acesso;

    @Enumerated(EnumType.STRING)
    private StatusLogin status;

    public UsuarioEntity() {}

    public UsuarioEntity(Integer id_usuario, TipoUsuario tipoUsuario, String login, String senha) {
        this.id_usuario = id_usuario;
        this.tipoUsuario = tipoUsuario;
        this.login = login;
        this.senha = senha;
        this.data_criacao = LocalDateTime.now();
        this.status = StatusLogin.ATIVO;
    }
    
    // Getters and Setters
    public UUID getId_login() {
        return id_login;
    }
    
    public void setId_login(UUID id_login) {
        this.id_login = id_login;
    }
    
    public Integer getId_usuario() {
        return id_usuario;
    }
    
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
    
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public LocalDateTime getData_criacao() {
        return data_criacao;
    }
    
    public void setData_criacao(LocalDateTime data_criacao) {
        this.data_criacao = data_criacao;
    }
    
    public LocalDateTime getUltimo_acesso() {
        return ultimo_acesso;
    }
    
    public void setUltimo_acesso(LocalDateTime ultimo_acesso) {
        this.ultimo_acesso = ultimo_acesso;
    }
    
    public StatusLogin getStatus() {
        return status;
    }
    
    public void setStatus(StatusLogin status) {
        this.status = status;
    }

}
