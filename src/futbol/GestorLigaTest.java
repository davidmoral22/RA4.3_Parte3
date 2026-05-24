package futbol;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorLigaTest {

    @Test
    public void testSimulacionPartido() {
        GestorLiga liga = new GestorLiga();

        // Registramos dos equipos usando el nuevo nombre del método
        liga.registrarEquipo("Real Madrid", 0, 0, GestorLiga.TacticaOfensiva);
        liga.registrarEquipo("Barcelona", 0, 0, GestorLiga.TacticaTikiTaka);

        // Comprobamos usando los nuevos métodos Getter que generaste
        assertEquals("Real Madrid", liga.getListaEquipos().get(0));
        assertEquals("Barcelona", liga.getListaEquipos().get(1));

        // Jugamos el partido (revisa si tu método jugarPartido pide los mismos parámetros)
        String resultado = liga.jugarPartido(0, 1, false);

        // Validamos los puntos usando los Getters
        assertEquals(3, liga.getListaPuntos().get(0));
        assertEquals(0, liga.getListaPuntos().get(1));
    }
}