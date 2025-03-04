package tech.trimed.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_curso")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;

    @Column(name = "nome_curso")
    private String nomeCurso;

    @Column(name = "duracao")
    private int duracao;

    @Column(name = "dia")
    private String dia;

    @Column(name = "hora")
    private String hora;

    // Getters and Setters
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer id_curso) {
        this.idCurso = id_curso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nome_curso) {
        this.nomeCurso = nome_curso;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

}
