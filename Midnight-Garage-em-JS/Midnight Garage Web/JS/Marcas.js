class Marcas {

    iniciar() {

        document.getElementById("btnHonda").addEventListener("click", () => {
            const honda = new Honda();
            honda.iniciar();
        });

        document.getElementById("btnToyota").addEventListener("click", () => {
            const toyota = new Toyota();
            toyota.iniciar();
        });

        document.getElementById("btnChevrolet").addEventListener("click", () => {
            const chevrolet = new Chevrolet();
            chevrolet.iniciar();
        });

        document.getElementById("btnNissan").addEventListener("click", () => {
            const nissan = new Nissan();
            nissan.iniciar();
        });

        document.getElementById("btnMitsubishi").addEventListener("click", () => {
            const mitsubishi = new Mitsubishi();
            mitsubishi.iniciar();
        });

        document.getElementById("btnVolkswagen").addEventListener("click", () => {
            const volkswagen = new Volkswagen();
            volkswagen.iniciar();
        });

        document.getElementById("btnVoltar").addEventListener("click", () => {
            const loja = new Loja();
            loja.iniciar();
        });

    }

}