package divas_pop.exception;

public class ArtistaNaoEncontrado extends RuntimeException {
    public ArtistaNaoEncontrado(Integer id) {
        super("Artista com o ID " + id + " não foi encontrado");
    }
}
