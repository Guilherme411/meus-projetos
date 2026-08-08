class FabricaCarros {

    static criarCarro(marca, nome, cor, preco) {

        switch (marca.toLowerCase()) {

            case "honda":
                return new Carro("Honda " + nome, cor, preco);

            case "toyota":
                return new Carro("Toyota " + nome, cor, preco);

            case "fiat":
                return new Carro("Fiat " + nome, cor, preco);

            case "chevrolet":
                return new Carro("Chevrolet " + nome, cor, preco);

            case "mitsubishi":
                return new Carro("Mitsubishi " + nome, cor, preco);

            case "nissan":
                return new Carro("Nissan " + nome, cor, preco);

            case "volkswagen":
                return new Carro("Volkswagen " + nome, cor, preco);

            default:
                return new Carro(nome, cor, preco);
        }
    }

}