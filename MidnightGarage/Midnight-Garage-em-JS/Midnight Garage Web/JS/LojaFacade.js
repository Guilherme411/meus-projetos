class LojaFacade {

    abrirMenuVendas() {
        const disponiveis = new Disponiveis();
        disponiveis.iniciar();
    }

    anunciarCarro() {
        const anunciar = new Anunciar();
        anunciar.iniciar();
    }

    sair() {
        document.getElementById("conteudo").innerHTML = `
            <h2>Saindo da loja :) !</h2>
        `;
    }

}