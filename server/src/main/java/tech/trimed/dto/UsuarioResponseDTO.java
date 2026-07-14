package tech.trimed.dto;

import java.time.LocalDateTime;
import tech.trimed.enums.StatusLogin;
import tech.trimed.enums.TipoUsuario;

public class UsuarioResponseDTO {
    private Integer idLogin;
    private Integer idUsuario;
    private String login;
    private TipoUsuario tipoUsuario;
    private LocalDateTime dataCriacao;
    private LocalDateTime ultimoAcesso;
    private StatusLogin status;

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public StatusLogin getStatus() {
        return status;
    }

    public void setStatus(StatusLogin status) {
        this.status = status;
    }
}
