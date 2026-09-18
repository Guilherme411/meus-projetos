class Comprador {

    constructor(nome, cpf, dataNascimento, metodoPagamento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.metodoPagamento = metodoPagamento;
    }

    getNome() {
        return this.nome;
    }

    getCpf() {
        return this.cpf;
    }

    getDataNascimento() {
        return this.dataNascimento;
    }

    getMetodoPagamento() {
        return this.metodoPagamento;
    }

}