class Loja {

    iniciar() {

        document.getElementById("btnVendas")
            .addEventListener("click", () => {

                const facade = new LojaFacade();
                facade.abrirMenuVendas();

            });

        document.getElementById("btnAnunciar")
            .addEventListener("click", () => {

                const facade = new LojaFacade();
                facade.anunciarCarro();

            });

        document.getElementById("btnSair")
            .addEventListener("click", () => {

                const facade = new LojaFacade();
                facade.sair();

            });

    }

}

const loja = new Loja();
loja.iniciar();