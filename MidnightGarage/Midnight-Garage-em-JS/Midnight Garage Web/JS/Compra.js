document.getElementById("btnSim").addEventListener("click", () => {
    const inserirDados = new InserirDados();
    inserirDados.iniciar(carro);
});

document.getElementById("btnNao").addEventListener("click", () => {
    const menu = new Disponiveis();
    menu.iniciar();
});