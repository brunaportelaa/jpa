package divas_pop.controller;

import divas_pop.model.Artista;
import divas_pop.service.ArtistaService;
import divas_pop.view.ArtistaView;
import divas_pop.view.Leitor;

import java.util.List;

public class ArtistaController {

    private final ArtistaService service;
    private final ArtistaView view;

    public ArtistaController(ArtistaService service, ArtistaView view) {
        this.service = service;
        this.view = view;
    }

    public void iniciar() {
        boolean continuar = true;
        while (continuar) {
            int opcao = view.menu();
            switch (opcao) {
                case 1 -> adicionar();
                case 2 -> listarTodos();
                case 3 -> buscar();
                case 4 -> deletar();
                case 0 -> {
                    continuar = false;
                    view.exibirMensagem("Encerrando...");
                }
                default -> view.exibirMensagem("Opção inválida");
            }
        }
    }

    public void adicionar() {
        Artista artista = view.ler();
        service.salvar(artista);
        view.exibirMensagem("Artista adicionado com sucesso!");
    }

    private void listarTodos() {
        List<Artista> artistas = service.listarTodos();
        view.exibirLista(artistas);
    }

    private void buscar() {
        int id = Leitor.lerInt("Informe o ID que deseja buscar");
        Artista artista = service.buscarPorId(id);
        view.exibir(artista);
    }

    private void deletar() {
        int id = Leitor.lerInt("Informe o ID que deseja buscar");
        service.deletar(id);
        view.exibirMensagem("Artista deletado com sucesso");
    }
}
