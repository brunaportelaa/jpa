package divas_pop.view;

import divas_pop.model.Artista;

import java.util.List;

public class ArtistaView implements GenericView<Artista>{

    @Override
    public int menu() {
        System.out.println("\n===== MENU ARTISTAS =====");
        System.out.println("1. Adicionar artista");
        System.out.println("2. Listar artistas");
        System.out.println("3. Buscar artista por ID");
        System.out.println("4. Deletar artista");
        System.out.println("0. Sair");
        return Leitor.lerInt("Selecione uma opção: ", 0, 4);
    }

    @Override
    public Artista ler() {
        String nome = Leitor.lerString("Nome: ");
        int idade = Leitor.lerInt("Idade: ");
        String pais = Leitor.lerString("País");
        int qtdAlbuns  = Leitor.lerInt("Quantidade de albuns: ");
        return new Artista(nome, idade, pais, qtdAlbuns);
    }

    @Override
    public void exibir(Artista artista) {
        System.out.println(artista);
    }

    @Override
    public void exibirLista(List<Artista> listaArtistas) {
        for(Artista artista : listaArtistas){
            System.out.println(artista);
            System.out.println();
        }
    }

    @Override
    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    @Override
    public void exibirErro(String err) {
        System.out.println(err);
    }
}
