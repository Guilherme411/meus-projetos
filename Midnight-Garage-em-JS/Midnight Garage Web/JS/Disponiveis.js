class Disponiveis {

    iniciar() {

        document.getElementById("conteudo").innerHTML = `

            <h2>Marcas Disponíveis</h2>

            <button onclick="new Honda().iniciar()">
                Honda
            </button>

            <button onclick="new Toyota().iniciar()">
                Toyota
            </button>

            <button onclick="new Chevrolet().iniciar()">
                Chevrolet
            </button>

            <button onclick="new Nissan().iniciar()">
                Nissan
            </button>

            <button onclick="new Mitsubishi().iniciar()">
                Mitsubishi
            </button>

            <button onclick="new Volkswagen().iniciar()">
                Volkswagen
            </button>

            <button onclick="loja.iniciar()">
                Voltar
            </button>

        `;
    }

}