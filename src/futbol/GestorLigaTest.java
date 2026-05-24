package futbol;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorLigaTest {

    @Test
    public void testSimulacionPartido() {
        GestorLiga liga = new GestorLiga();

        // Registramos dos equipos clásicos
        liga.regEq("Real Madrid", 0, 0, "Ofensivo");
        liga.regEq("Barcelona", 0, 0, "Tiki-Taka");

        // Comprobamos que se guardan bien en las listas
        assertEquals("Real Madrid", liga.e.get(0));
        assertEquals("Barcelona", liga.e.get(1));

        // Jugamos un partido normal (No es derbi para mantener la matemática fija)
        // Madrid (Ofensivo = 3.5 ataque -> 3 goles). Barça (Tiki-Taka = 2.5 - 1 = 1.5 ataque -> 1 gol).
        // Gana el Madrid 3 - 1. Debería sumar 3 puntos.
        String resultado = liga.jugarPartido(0, 1, false);

        // Validamos que el Real Madrid (id 0) ahora tiene 3 puntos en la clasificación
        assertEquals(3, liga.p.get(0));
        // Validamos que el Barcelona (id 1) se queda con 0 puntos
        assertEquals(0, liga.p.get(1));
    }
}
