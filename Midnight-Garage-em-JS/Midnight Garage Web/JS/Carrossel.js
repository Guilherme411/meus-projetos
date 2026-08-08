const slides = document.querySelectorAll(".slide");
const indicadores = document.querySelectorAll(".indicador");

let slideAtual = 0;
let intervaloCarrossel;

function exibirSlide(indice) {

    slides.forEach((slide) => {
        slide.classList.remove("ativo");
    });

    indicadores.forEach((indicador) => {
        indicador.classList.remove("ativo");
    });

    slides[indice].classList.add("ativo");
    indicadores[indice].classList.add("ativo");

}


function mostrarSlide(indice) {

    slideAtual = indice;

    exibirSlide(slideAtual);

    reiniciarCarrossel();

}


function mudarSlide(direcao) {

    slideAtual += direcao;

    if (slideAtual >= slides.length) {
        slideAtual = 0;
    }

    if (slideAtual < 0) {
        slideAtual = slides.length - 1;
    }

    exibirSlide(slideAtual);

    reiniciarCarrossel();

}


function iniciarCarrossel() {

    intervaloCarrossel = setInterval(() => {

        slideAtual++;

        if (slideAtual >= slides.length) {
            slideAtual = 0;
        }

        exibirSlide(slideAtual);

    }, 5000);

}


function reiniciarCarrossel() {

    clearInterval(intervaloCarrossel);

    iniciarCarrossel();

}


iniciarCarrossel();