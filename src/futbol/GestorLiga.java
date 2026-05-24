package futbol;

import java.util.ArrayList;
import java.util.List;

public class GestorLiga {
    public static final String TacticaOfensiva = "Ofensivo";
    public static final String TacticaTikiTaka = "Tiki-Taka";
    // Variables globales sucias (Ideal para renombrar y encapsular)
    private List<String> listaEquipos = new ArrayList<>(); // Nombres de los equipos
    private List<Integer> listaPuntos = new ArrayList<>(); // Puntos en la clasificación
    private List<Integer> listaGoles = new ArrayList<>(); // Goles a favor
    private List<String> listaTacticas = new ArrayList<>(); // Táctica (Ofensivo, Defensivo, Tiki-Taka)

    public List<String> getListaEquipos() {
        return listaEquipos;
    }

    public List<Integer> getListaPuntos() {
        return listaPuntos;
    }

    public List<Integer> getListaGoles() {
        return listaGoles;
    }

    public List<String> getListaTacticas() {
        return listaTacticas;
    }

    // Método 1: Registrar equipo en la liga (Nombres feos y lógica simple)
    public void registrarEquipo(String n, int pts, int gls, String tac) {
        if (pts < 0) {
            pts = 0; // No puede empezar con puntos negativos
        }
        if (gls < 0) {
            gls = 0;
        }

        listaEquipos.add(n);
        listaPuntos.add(pts);
        listaGoles.add(gls);
        listaTacticas.add(tac);
        System.out.println("Equipo " + n + " inscrito correctamente en la competicion.");
    }

    // Método 2: El método GIGANTE del simulador del partido (Para extraer métodos y variables)
    public String jugarPartido(int idLocal, int idVisitante, boolean esDerbi) {
        String eqLocal = listaEquipos.get(idLocal);
        String eqVisitante = listaEquipos.get(idVisitante);
        int ptsL = listaPuntos.get(idLocal);
        int ptsV = listaPuntos.get(idVisitante);
        int golesL = listaGoles.get(idLocal);
        int golesV = listaGoles.get(idVisitante);
        String tacL = listaTacticas.get(idLocal);
        String tacV = listaTacticas.get(idVisitante);

        System.out.println("--- ¡COMIENZA EL PARTIDAZO ---");
        System.out.println(eqLocal + " VS " + eqVisitante);

        // Lógica de ataque mezclada (Números mágicos 2.5, 1.2 y bonus)
        double ataqueLocal = calcularGoles();
        double ataqueLocal1 = 3.5;
        if (tacL.equals(TacticaOfensiva)) {
            ataqueLocal = ataqueLocal1; // Modificador táctico
        } else if (tacL.equals(TacticaTikiTaka)) {
            ataqueLocal = 2.5;
        }

        if (esDerbi) {
            ataqueLocal = ataqueLocal + 1.5; // Plus de motivación por ser el rival histórico
        }

        // Simulación rápida de goles del local basándonos en su ataque
        int golesMarcadosLocal = (int) (ataqueLocal);
        listaGoles.set(idLocal, golesL + golesMarcadosLocal);

        // Ataque del visitante
        double ataqueVisitante = calcularGoles();
        if (tacV.equals("Ofensivo")) {
            ataqueVisitante = ataqueLocal1;
        } else if (tacV.equals("Tiki-Taka")) {
            ataqueVisitante = 2.5;
        }

        int golesMarcadosVisitante = (int) (ataqueVisitante - 1); // El visitante ataca un poco menos
        if (golesMarcadosVisitante < 0) {
            golesMarcadosVisitante = 0;
        }
        listaGoles.set(idVisitante, golesV + golesMarcadosVisitante);

        // Reparto de puntos final según el resultado del partido
        if (golesMarcadosLocal > golesMarcadosVisitante) {
            listaPuntos.set(idLocal, ptsL + 3); // Victoria local
        } else if (golesMarcadosLocal < golesMarcadosVisitante) {
            listaPuntos.set(idVisitante, ptsV + 3); // Victoria visitante
        } else {
            listaPuntos.set(idLocal, ptsL + 1); // Empate
            listaPuntos.set(idVisitante, ptsV + 1);
        }

        // Retorna el marcador en un formato complejo
        return "Marcador Final -> " + eqLocal + " " + golesMarcadosLocal + " - " + golesMarcadosVisitante + " " + eqVisitante;
    }

    private static double calcularGoles() {
        double ataqueLocal = 2.0;
        return ataqueLocal;
    }

    // Método 3: Entrenar para mejorar goles (Variables basura e Inline)
    public boolean esIntensivo(int idEquipo) {
        String tacticaActual = listaTacticas.get(idEquipo);
        int golesActuales = listaGoles.get(idEquipo);

        if (tacticaActual.equals("Ofensivo")) {
            int bonusGolesEntreno = 5; // Número mágico
            listaGoles.set(idEquipo, golesActuales + bonusGolesEntreno);
        } else {
            int bonusPequeno = 2;
            int tempSumaGoles2 = golesActuales + bonusPequeno;
            listaGoles.set(idEquipo, tempSumaGoles2);
        }
        return false;
    }
}
