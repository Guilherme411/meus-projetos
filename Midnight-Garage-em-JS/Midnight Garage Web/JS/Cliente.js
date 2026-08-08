class Cliente {

    constructor(nome) {
        this.nome = nome;
    }

    atualizar(carro) {

        const notificacoes = document.getElementById("notificacoes");

        notificacoes.innerHTML += `
            <div class="notificacao">
                <h3>Novo Anúncio</h3>
                <p><strong>${this.nome}</strong> recebeu um novo anúncio!</p>
                <p><strong>Nome:</strong> ${carro.getNome()}</p>
                <p><strong>Cor:</strong> ${carro.getCor()}</p>
                <p><strong>Preço:</strong> ${carro.getPreco()}</p>
            </div>
        `;
    }

}