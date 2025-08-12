package divas_pop.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "musicas")
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O campo Album não pode ser nulo.")
    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;

    @Column(name = "numero_musica")
    private int numero;

    @NotBlank(message = "O nome da música não pode estar vazio.")
    @Column(name = "nome_musica")
    private String nome;

    @Column(name = "featuring")
    private String nomeArtistaFeat;

    @ManyToOne
    @JoinColumn(name = "feat_artista_id")
    private Artista artistaFeat;

    public Musica() {
    }

    public Musica(Album album, int numero, String nome, String nomeArtistaFeat, Artista artistaFeat) {
        this.album = album;
        this.numero = numero;
        this.nome = nome;
        this.nomeArtistaFeat = nomeArtistaFeat;
        this.artistaFeat = artistaFeat;
    }

    public Musica(Album album, int numero, String nome) {
        this.album = album;
        this.numero = numero;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeArtistaFeat() {
        return nomeArtistaFeat;
    }

    public void setNomeArtistaFeat(String nomeArtistaFeat) {
        this.nomeArtistaFeat = nomeArtistaFeat;
    }

    public Artista getArtistaFeat() {
        return artistaFeat;
    }

    public void setIdArtistaFeat(Artista artistaFeat) {
        this.artistaFeat = artistaFeat;
    }
}
