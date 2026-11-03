package MidnightGarage;

import java.util.ArrayList;

public class CentralAnuncios {

    private ArrayList<Observador> observadores = new ArrayList<>();

    public CentralAnuncios() {
        adicionarObservador(new Cliente("João"));
        adicionarObservador(new Cliente("Maria"));
        adicionarObservador(new Cliente("Carlos"));
    }

    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(Carro carro) {
        for (Observador observador : observadores) {
            observador.atualizar(carro);
        }
    }
}