package divas_pop.service;

import divas_pop.dao.ArtistaDAOImpl;
import divas_pop.exception.ArtistaNaoEncontrado;
import divas_pop.model.Artista;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ArtistaService implements GenericService<Artista> {

    private ArtistaDAOImpl artistaDAO;

    public ArtistaService(EntityManager em) {
        this.artistaDAO = new ArtistaDAOImpl(em);
    }

    @Override
    public void salvar(Artista artista) {
        if (artista.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome do artista não pode estar vazio");
        }
        artistaDAO.salvar(artista);
    }

    @Override
    public Artista buscarPorId(Integer id) {
        Artista artista = artistaDAO.buscarPorId(id);
        if (artista == null) {
            throw new ArtistaNaoEncontrado(id);
        }
        return artista;
    }

    @Override
    public List<Artista> listarTodos() {
        return artistaDAO.listarTodos();
    }

    @Override
    public void deletar(Integer id) {
        Artista artista = artistaDAO.buscarPorId(id);
        if (artista == null) {
            throw new ArtistaNaoEncontrado(id);
        }
        artistaDAO.deletar(id);
    }
}
