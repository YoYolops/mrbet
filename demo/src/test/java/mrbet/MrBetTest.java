package mrbet;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import mrbet.models.*;

/**
 * Unit test for simple App.
 */
class MrBetTest {
    MrBet driver;

    @BeforeEach
    public void setUp() {
        driver = new MrBet();

        driver.cadastrarTime("250_PB", "Nacional de Patos", "Canário");
        driver.cadastrarTime("252_PB", "Sport Lagoa Seca", "Carneiro");
        driver.cadastrarTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
        driver.cadastrarTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
    }

    @AfterEach
    public void tearDown() {
        driver = null;
    }


    @Test
    void testCadastrarCampeonatoComSucesso() {
        driver.criarCampeonato("Brasileirão série A 2023", 10);
        Campeonato campeonatoRegistrado = driver.getCampeonato("Brasileirão série A 2023");

        assertEquals("Brasileirão série A 2023", campeonatoRegistrado.getNome());
    }

    @Test
    void testCadastrarCampeonatoJaExistente() {
        driver.criarCampeonato("Brasileirão série A 2023", 10);
        assertThrows(IllegalArgumentException.class, () -> driver.criarCampeonato("Brasileirão série A 2023", 10));
    }

    @Test
    void testIncluirTimesEmCampeonatoComSucesso() {
        driver.criarCampeonato("Brasileirão série A 2023", 10);
        driver.incluirTimeEmCampeonato("i", "250_PB", "Brasileirão série A 2023");

        Campeonato campeonatoCriado = driver.getCampeonato("Brasileirão série A 2023");
        assertEquals(1, campeonatoCriado.getQuantidadeParticipantes());
        
        Time timeCadastrado = campeonatoCriado.getTime("250_PB");
        assertEquals("250_PB", timeCadastrado.getId());
    }

    @Test
    void testIncluirTimeInexistenteEmCampeonato() {
        driver.criarCampeonato("Brasileirão série A 2023", 10);
        assertThrows(IllegalArgumentException.class, () -> driver.incluirTimeEmCampeonato("i", "005_PB", "Brasileirão série A 2023"));
    }

    @Test
    void testIncluirTimeEmCampeonatoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> driver.incluirTimeEmCampeonato("i", "250_PB", "Brasileirão série D 2023"));
    }

    @Test
    void testIncluirTimesAcimaDoLimiteDoCampeonato() {
        driver.criarCampeonato("Brasileirão série A 2023", 1);
        driver.incluirTimeEmCampeonato("i", "250_PB", "Brasileirão série A 2023");
        assertThrows(IllegalArgumentException.class, () -> driver.incluirTimeEmCampeonato("i", "252_PB", "Brasileirão série A 2023"));
    }
}
