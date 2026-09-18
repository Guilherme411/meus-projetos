class Mitsubishi {

    iniciar() {

        document.getElementById("btnLancer").addEventListener("click", () => {

            const lancer = FabricaCarros.criarCarro(
                "Mitsubishi",
                "Lancer",
                "Prata",
                "R$ 95.000"
            );

            lancer.exibirDescricao();

            const compra1 = new Compra(lancer);
            compra1.iniciar();

        });

        document.getElementById("btnLancerEvolutionX").addEventListener("click", () => {

            const evolution = FabricaCarros.criarCarro(
                "Mitsubishi",
                "Lancer Evolution X",
                "Branco",
                "R$ 420.000"
            );

            evolution.exibirDescricao();

            const compra2 = new Compra(evolution);
            compra2.iniciar();

        });

        document.getElementById("btnEclipseCross").addEventListener("click", () => {

            const eclipse = FabricaCarros.criarCarro(
                "Mitsubishi",
                "Eclipse Cross",
                "Cinza",
                "R$ 230.000"
            );

            eclipse.exibirDescricao();

            const compra3 = new Compra(eclipse);
            compra3.iniciar();

        });

        document.getElementById("btnPajeroSport").addEventListener("click", () => {

            const pajeroSport = FabricaCarros.criarCarro(
                "Mitsubishi",
                "Pajero Sport",
                "Preto",
                "R$ 395.000"
            );

            pajeroSport.exibirDescricao();

            const compra4 = new Compra(pajeroSport);
            compra4.iniciar();

        });

        document.getElementById("btnTriton").addEventListener("click", () => {

            const triton = FabricaCarros.criarCarro(
                "Mitsubishi",
                "Triton",
                "Branco",
                "R$ 310.000"
            );

            triton.exibirDescricao();

            const compra5 = new Compra(triton);
            compra5.iniciar();

        });

        document.getElementById("btnASX").addEventListener("click", () => {

            const asx = FabricaCarros.criarCarro(
                "Mitsubishi",
                "ASX",
                "Vermelho",
                "R$ 155.000"
            );

            asx.exibirDescricao();

            const compra6 = new Compra(asx);
            compra6.iniciar();

        });

        document.getElementById("btnOutlander").addEventListener("click", () => {

            const outlander = FabricaCarros.criarCarro(
                "Mitsubishi",
                "Outlander",
                "Azul",
                "R$ 250.000"
            );

            outlander.exibirDescricao();

            const compra7 = new Compra(outlander);
            compra7.iniciar();

        });

        document.getElementById("btnPajeroFull").addEventListener("click", () => {

            const pajeroFull = FabricaCarros.criarCarro(
                "Mitsubishi",
                "Pajero Full",
                "Cinza",
                "R$ 320.000"
            );

            pajeroFull.exibirDescricao();

            const compra8 = new Compra(pajeroFull);
            compra8.iniciar();

        });

        document.getElementById("btnAirtrek").addEventListener("click", () => {

            const airtrek = FabricaCarros.criarCarro(
                "Mitsubishi",
                "Airtrek",
                "Prata",
                "R$ 220.000"
            );

            airtrek.exibirDescricao();

            const compra9 = new Compra(airtrek);
            compra9.iniciar();

        });

        document.getElementById("btnEclipseGSX").addEventListener("click", () => {

            const eclipseGSX = FabricaCarros.criarCarro(
                "Mitsubishi",
                "Eclipse GSX",
                "Preto",
                "R$ 260.000"
            );

            eclipseGSX.exibirDescricao();

            const compra10 = new Compra(eclipseGSX);
            compra10.iniciar();

        });

        document.getElementById("btn3000GT").addEventListener("click", () => {

            const gt3000 = FabricaCarros.criarCarro(
                "Mitsubishi",
                "3000GT",
                "Vermelho",
                "R$ 380.000"
            );

            gt3000.exibirDescricao();

            const compra11 = new Compra(gt3000);
            compra11.iniciar();

        });

        document.getElementById("btnVoltar").addEventListener("click", () => {

            const menu = new Disponiveis();
            menu.iniciar();

        });

    }

}