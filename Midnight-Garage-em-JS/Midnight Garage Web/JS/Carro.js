class Carro {
    constructor(nome, cor, preco) {
        this.nome = nome;
        this.cor = cor;
        this.preco = preco;
    }

    getNome() {
        return this.nome;
    }

    getCor() {
        return this.cor;
    }

    getPreco() {
        return this.preco;
    }

    exibirDescricao() {
        return `
            <div class="card-carro">
                <h3>Veículo</h3>
                <p><strong>Nome:</strong> ${this.nome}</p>
                <p><strong>Cor:</strong> ${this.cor}</p>
                <p><strong>Preço:</strong> ${this.preco}</p>
            </div>
        `;
    }
}