package divas_pop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "albuns")
public class Album {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "id_album")
    private Integer id;

    @NotNull(message = "O campo Artista não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_artista")
    private Artista artista;

    @NotBlank(message = "O nome do álbum não pode estar vazio.")
    @Column(name = "nome_album")
    private String nome;

    @Column(name = "numero_album")
    private int ordemLancamento;

    @Column(name = "ano_lancamento")
    private int ano;

    @Column(name = "numero_faixas")
    private int qtdFaixas;

    @OneToMany(mappedBy = "album")
    private List<Musica> musicas = new ArrayList<>();

    public Album() {
    }

    public Album(Artista artista, String nome, int ordemLancamento, int ano, int qtdFaixas) {
        this.artista = artista;
        this.nome = nome;
        this.ordemLancamento = ordemLancamento;
        this.ano = ano;
        this.qtdFaixas = qtdFaixas;
    }

    public Integer getId() {
        return this.id;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOrdemLancamento() {
        return ordemLancamento;
    }

    public void setOrdemLancamento(int ordemLancamento) {
        this.ordemLancamento = ordemLancamento;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQtdFaixas() {
        return qtdFaixas;
    }

    public void setQtdFaixas(int qtdFaixas) {
        this.qtdFaixas = qtdFaixas;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }
}
