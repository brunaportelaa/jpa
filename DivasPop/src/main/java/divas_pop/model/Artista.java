package divas_pop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "artistas")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private Integer id;

    @NotBlank(message = "O nome do artista não pode estar vazio.")
    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private int idade;

    @Column(name = "pais")
    private String pais;

    @Column(name = "quantidade_albuns")
    private int quantidadeAlbuns;

    @OneToMany (mappedBy = "artista")
    private List<Album> albuns = new ArrayList<>();

    @OneToMany(mappedBy = "artistaFeat")
    private List<Musica> musicasComoFeat = new ArrayList<>();

    public Artista(int id, String nome, int idade, String pais, int quantidadeAlbuns) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.pais = pais;
        this.quantidadeAlbuns = quantidadeAlbuns;
    }

    public Artista(String nome, int idade, String pais, int quantidadeAlbuns) {
        this.nome = nome;
        this.idade = idade;
        this.pais = pais;
        this.quantidadeAlbuns = quantidadeAlbuns;
    }

    public Artista() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getQuantidadeAlbuns() {
        return quantidadeAlbuns;
    }

    public void setQuantidadeAlbuns(int quantidadeAlbuns) {
        this.quantidadeAlbuns = quantidadeAlbuns;
    }

    public Integer getId() {
        return id;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public ArrayList<String> getAlbunsNomes() {
        ArrayList<String> albunsNomes = new ArrayList<String>();
        for (Album album : albuns) {
            albunsNomes.add(album.getNome());
        }
        return albunsNomes;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nId: " + id +
                "\nIdade: " + idade +
                "\nPaís: " + pais +
                "\nQtd de Albuns: " + quantidadeAlbuns +
                "\nAlbuns: " + getAlbunsNomes();
    }
}
