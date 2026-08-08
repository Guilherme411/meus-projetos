class CentralAnuncios {

    constructor() {
        this.observadores = [];

        this.adicionarObservador(new Cliente("João"));
        this.adicionarObservador(new Cliente("Maria"));
        this.adicionarObservador(new Cliente("Carlos"));
    }

    adicionarObservador(observador) {
        this.observadores.push(observador);
    }

    removerObservador(observador) {
        this.observadores = this.observadores.filter(
            obs => obs !== observador
        );
    }

    notificarObservadores(carro) {
        this.observadores.forEach(observador => {
            observador.atualizar(carro);
        });
    }

}