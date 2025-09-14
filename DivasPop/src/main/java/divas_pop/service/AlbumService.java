package divas_pop.service;

import divas_pop.model.Album;
import divas_pop.model.Artista;

import java.util.List;

public class AlbumService implements GenericService<Album> {

    @Override
    public void salvar(Album album) {

    }

    @Override
    public Album buscarPorId(Integer id) {
        return null;
    }

    @Override
    public List<Album> listarTodos() {
        return List.of();
    }

    @Override
    public void deletar(Integer id) {

    }


}
