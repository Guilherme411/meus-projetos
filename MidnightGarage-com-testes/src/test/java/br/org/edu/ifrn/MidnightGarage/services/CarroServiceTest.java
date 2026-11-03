package br.org.edu.ifrn.MidnightGarage.services;

import br.org.edu.ifrn.MidnightGarage.exception.RecursoNaoEncontradoException;
import br.org.edu.ifrn.MidnightGarage.model.Carro;
import br.org.edu.ifrn.MidnightGarage.model.Marca;
import br.org.edu.ifrn.MidnightGarage.repository.CarroRepository;
import br.org.edu.ifrn.MidnightGarage.repository.MarcaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarroServiceTest {

    @Mock
    private CarroRepository carros;

    @Mock
    private MarcaRepository marcas;

    @Mock
    private LogService logs;

    @InjectMocks
    private CarroService carroService;

    private Marca marca;
    private Carro carro;

    @BeforeEach
    void configurar() {
        marca = new Marca(1L, "Toyota");
        carro = new Carro(1L, "Toyota", "Corolla", "Preto", 120000.00, 2022, true);
    }

    @Test
    void deveListarCarros() {
        when(carros.listar()).thenReturn(List.of(carro));

        List<Carro> resultado = carroService.listar();

        assertEquals(1, resultado.size());
        assertEquals("Corolla", resultado.get(0).getModelo());
        verify(carros).listar();
    }

    @Test
    void deveListarSomenteSeminovos() {
        Carro novo = new Carro(2L, "Toyota", "Yaris", "Branco", 95000.00, 2025, false);
        when(carros.listar()).thenReturn(List.of(carro, novo));

        List<Carro> resultado = carroService.listarSeminovos();

        assertEquals(1, resultado.size());
        assertTrue(resultado.get(0).isSeminovo());
        assertEquals("Corolla", resultado.get(0).getModelo());
    }

    @Test
    void deveBuscarCarroPorId() {
        when(carros.buscar(1L)).thenReturn(Optional.of(carro));

        Carro resultado = carroService.buscar(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Corolla", resultado.getModelo());
    }

    @Test
    void deveLancarErroQuandoCarroNaoExiste() {
        when(carros.buscar(99L)).thenReturn(Optional.empty());

        assertThrows(RecursoNaoEncontradoException.class,
                () -> carroService.buscar(99L));
    }

    @Test
    void deveCadastrarCarroComMarcaExistente() {
        when(marcas.listar()).thenReturn(List.of(marca));
        when(carros.salvar(any(Carro.class))).thenAnswer(invocacao -> {
            Carro recebido = invocacao.getArgument(0);
            recebido.setId(10L); // Simula o identificador gerado pelo repository.
            return recebido;
        });
        carro.setId(50L); // O service deve limpar o identificador antes de salvar.
        carro.setMarca("toyota");

        Carro resultado = carroService.cadastrar(carro);

        assertNotNull(resultado);
        assertEquals(10L, resultado.getId());
        assertEquals("Toyota", resultado.getMarca());
        verify(carros).salvar(carro);
        verify(logs).registrar(eq("CADASTRO_CARRO"), contains("Toyota Corolla"));
    }

    @Test
    void naoDeveCadastrarCarroComMarcaInexistente() {
        when(marcas.listar()).thenReturn(List.of(marca));
        carro.setMarca("Honda");

        assertThrows(IllegalArgumentException.class,
                () -> carroService.cadastrar(carro));
        verify(carros, never()).salvar(any(Carro.class));
        verify(logs, never()).registrar(anyString(), anyString());
    }

    @Test
    void naoDeveCadastrarCarroSemModelo() {
        carro.setModelo("   ");

        assertThrows(IllegalArgumentException.class,
                () -> carroService.cadastrar(carro));
        verify(carros, never()).salvar(any(Carro.class));
    }

    @Test
    void naoDeveCadastrarCarroComPrecoNegativo() {
        carro.setPreco(-1.0);

        assertThrows(IllegalArgumentException.class,
                () -> carroService.cadastrar(carro));
        verify(carros, never()).salvar(any(Carro.class));
    }

    @Test
    void deveExcluirCarroExistente() {
        when(carros.buscar(1L)).thenReturn(Optional.of(carro));

        assertDoesNotThrow(() -> carroService.excluir(1L));

        verify(carros).excluir(1L);
        verify(logs).registrar(eq("EXCLUSAO_CARRO"), contains("Toyota Corolla"));
    }
}
