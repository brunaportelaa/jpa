package exercicio1;

import jakarta.persistence.*;

@Entity
public class Documento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "titulo")
    private String titulo;

    @OneToOne
    @JoinColumn(name = "id_pessoa", unique = true)
    private Pessoa pessoa;

    public Documento() {
    }

    public Documento(String titulo) {
        this.titulo = titulo;
    }


    public Documento(String titulo, Pessoa pessoa) {
        this.titulo = titulo;
        this.pessoa = pessoa;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
