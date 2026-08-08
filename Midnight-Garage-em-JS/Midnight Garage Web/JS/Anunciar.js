class Anunciar {

    iniciar() {

        const formulario = document.getElementById("formCarro");

        formulario.addEventListener("submit", (e) => {

            e.preventDefault();

            const nome = document.getElementById("nome").value;
            const cor = document.getElementById("cor").value;
            const preco = document.getElementById("preco").value;

            const carro = new Carro(nome, cor, preco);

            document.getElementById("resultado").innerHTML = `
                <h3>Cadastro feito com sucesso!</h3>

                <p><strong>Nome:</strong> ${carro.nome}</p>
                <p><strong>Cor:</strong> ${carro.cor}</p>
                <p><strong>Preço:</strong> ${carro.preco}</p>
            `;

            const central = new CentralAnuncios();
            central.notificarObservadores(carro);

        });

    }

}

const anunciar = new Anunciar();
anunciar.iniciar();