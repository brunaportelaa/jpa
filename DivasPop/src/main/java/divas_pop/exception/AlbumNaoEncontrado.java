package divas_pop.exception;

public class AlbumNaoEncontrado extends RuntimeException {
    public AlbumNaoEncontrado(Integer id) {
        super("Álbum com o ID " + id + " não foi encontrado");
    }
}
