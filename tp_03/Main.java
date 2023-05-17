package Prog_III_2023.tp_03;

import Prog_III_2023.tp_03.Grafos.GrafoDirigido;
import Prog_III_2023.tp_03.Grafos.GrafoNoDirigido;
import Prog_III_2023.tp_03.Servicios.BFS.BFS_Forest;
import Prog_III_2023.tp_03.Servicios.BFS.Ej_07_CaminoMasCorto;
import Prog_III_2023.tp_03.Servicios.DFS.Ej_06_CaminoAlternativo_EvitandoVertice;
import Prog_III_2023.tp_03.Servicios.DFS.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();

//        grafo.agregarArco(3, 10, null);
//        grafo.agregarArco(3, 8, null);
//        grafo.agregarArco(5, 11, null);
//        grafo.agregarArco(7, 8, null);
//        grafo.agregarArco(7, 11, null);
//        grafo.agregarArco(8, 9, null);
//        grafo.agregarArco(11, 9, null);
//        grafo.agregarArco(11, 10, null);
//        grafo.agregarArco(11, 2, null);

        /*-- Test de aciclicidad --*/
//        grafo.agregarArco(3, 10, null);
//        grafo.agregarArco(3, 8, null);
//        grafo.agregarArco(5, 11, null);
//        grafo.agregarArco(7, 11, null);
//        grafo.agregarArco(11, 9, null);
//        grafo.agregarArco(11, 10, null);
//        grafo.agregarArco(11, 2, null);
//        grafo.agregarArco(8, 7, null);
//        grafo.agregarArco(9, 8, null);
//
//        grafo.agregarArco(7, 5, null);
//        grafo.agregarArco(5, 8, null);

        /*--------- Grafo no dirigido --------------------*/
        GrafoNoDirigido<Integer> grafond = new GrafoNoDirigido();
        grafond.agregarArco(3, 10, null);
        grafond.agregarArco(3, 8, null);
        grafond.agregarArco(5, 11, null);
        grafond.agregarArco(7, 11, null);
        grafond.agregarArco(11, 9, null);
        grafond.agregarArco(11, 10, null);
        grafond.agregarArco(11, 2, null);
        grafond.agregarArco(8, 7, null);
        grafond.agregarArco(9, 8, null);

        grafond.agregarArco(7, 5, null);
        grafond.agregarArco(5, 8, null);


        /*------------------------ Ej_03 DFS -------------------------------------------------------------------------*/
        DFS_Forest dfs = new DFS_Forest(grafo);
        List<Integer> dfs_forest = dfs.dfsForest();
        System.out.println("\nDFS Forest: " + dfs_forest);


        /*------------------------ Ej_02 BFS -------------------------------------------------------------------------*/
        BFS_Forest bfs = new BFS_Forest(grafo);
        List<Integer> bfs_forest = bfs.bfsForest();
        System.out.println("\nBFS Forest: " + bfs_forest);


        /*------------------------ Ej_03 Test de aciclicidad ---------------------------------------------------------*/
        Ej_03_TestDeAciclicidad tda = new Ej_03_TestDeAciclicidad();
        Boolean esAciclico = tda.esAciclico(grafo);
        System.out.println(esAciclico? "\nEs acíclico" : "\nEs cíclico (tiene al menos un ciclo)");


        /*-------------------- TPE Caminos con límite de arcos no repetidos ------------------------------------------*/
        int arcos = 6;
        Caminos caminosSearch = new Caminos(grafo, 7, 8, arcos);
        List<List<Integer>> caminos = caminosSearch.caminos();
        String string = "\nCaminos con un máximo de " + arcos + " arcos:";
        if (caminos.size() == 0) System.out.println(string + caminos.toString());
        else  {
            for (List<Integer> c: caminos) string += " " + c.toString();
            System.out.println(string);
        }


        /*------------------------- Ej_04 Camino simple de mayor longitud --------------------------------------------*/
        Ej_04_CaminoSimpleDeMayorLongitud csml = new Ej_04_CaminoSimpleDeMayorLongitud(grafo, 7, 8);
        List<Integer> camino = csml.buscar();
        System.out.println("\nCamino simple de mayor longitud: " + camino);


        /*------------------------- Ej_05 Vértices con camino a V ----------------------------------------------------*/
        Integer destino = 8;
        Ej_05_VerticesConCaminoAV cr = new Ej_05_VerticesConCaminoAV(grafo, destino);
        List<Integer> vertices = cr.buscar();
        System.out.println("\nVértices con camino a " + destino + ": " + vertices.toString());


        /*------------------------- Ej_06 Conexión entre vértices sin pasar por i ------------------------------------*/
        Ej_06_CaminoAlternativo_EvitandoVertice cxn = new Ej_06_CaminoAlternativo_EvitandoVertice(grafo, 3, 9, 11);
        List<Integer> cxn_result = cxn.search();
        if (cxn_result.isEmpty()) System.out.println("\nNo hay conexion posible");
        else System.out.println("\nLa conexión más corta es: " + cxn_result.toString());


        /*------------------------- Ej_07 Camino más corto entre dos vértices ----------------------------------------*/
        Ej_07_CaminoMasCorto cmc = new Ej_07_CaminoMasCorto(grafond, 3, 2);
        List<Integer> cmc_result = cmc.get();
        if (cmc_result.isEmpty()) System.out.println("\nNo existe camino");
        else System.out.println("\nCamino más corto: " + cmc_result.toString());


        /*------------------------- Ej_08 Camino entre dos vértices sin pasar por rotulados de x modo-----------------*/
    }
}