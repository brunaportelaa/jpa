package exercicioOneToMany;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String cargo;

    private Date data_admissao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    public Funcionario() {
    }

    public Funcionario(String nome, String cargo,  Departamento departamento) {
        this.nome = nome;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
