class InserirDados {

    iniciar(carro) {

        const nome = document.getElementById("nome").value;
        const cpf = document.getElementById("cpf").value;
        const dataNascimento = document.getElementById("dataNascimento").value;
        const metodoPagamento = document.getElementById("metodoPagamento").value;

        const comprador = new Comprador(
            nome,
            cpf,
            dataNascimento,
            metodoPagamento
        );

        document.getElementById("conteudo").innerHTML = `
            <h2>Validação feita com sucesso!</h2>
            <p>Compra concluída.</p>

            <h3>Ficha do Comprador</h3>
            <p><strong>Nome:</strong> ${comprador.getNome()}</p>
            <p><strong>CPF:</strong> ${comprador.getCpf()}</p>
            <p><strong>Data de Nascimento:</strong> ${comprador.getDataNascimento()}</p>
            <p><strong>Método de Pagamento:</strong> ${comprador.getMetodoPagamento()}</p>

            <h3>Veículo</h3>
            <p><strong>Nome:</strong> ${carro.getNome()}</p>
            <p><strong>Cor:</strong> ${carro.getCor()}</p>
            <p><strong>Preço:</strong> ${carro.getPreco()}</p>

            <button id="btnVoltar">Voltar ao Menu</button>
            <button id="btnSair">Sair</button>
        `;

        document.getElementById("btnVoltar").addEventListener("click", () => {
            const loja = new Loja();
            loja.iniciar();
        });

        document.getElementById("btnSair").addEventListener("click", () => {
            document.getElementById("conteudo").innerHTML = `
                <h2>Obrigado pela preferência!</h2>
            `;
        });

    }

}