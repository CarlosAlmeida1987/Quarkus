package tech.trimed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aluno")
public class AlunoEntity {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Integer idAluno;

    @Column(name = "nome")
    private String nome;

    @Column(name = "matricula")
    private String matricula;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private CursoEntity curso;

    @Column(name = "email")
    private String email;
    
    // Getters and Setters
    public Integer getIdAluno() {
        return idAluno;
    }
    
    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getMatricula() {
        return matricula;
    }
    
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public CursoEntity getCurso() {
        return curso;
    }
    
    public void setCurso(CursoEntity curso) {
        this.curso = curso;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }


}
