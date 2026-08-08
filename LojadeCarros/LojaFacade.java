package LojadeCarros;

public class LojaFacade {

    public void abrirMenuVendas() {
        Disponiveis disponiveis = new Disponiveis();
        disponiveis.iniciar();
    }

    public void anunciarCarro() {
        Anunciar anunciar = new Anunciar();
        anunciar.iniciar();
    }

    public void sair() {
        System.out.println("Saindo da loja :) !");
    }

}