package exercicio1;

import jakarta.persistence.*;

@Entity
public class Pessoa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @OneToOne(mappedBy = "pessoa")
    private Documento documento;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa(String nome, Documento documento) {
        this.nome = nome;
        this.documento = documento;
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

    public Documento getDocumento() {
        return documento;
    }

}
