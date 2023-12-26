
package DEA_Labo4;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphTest {
    @Test
    public void testGrafoaSortu() {
        Graph grafoa = new Graph();
        assertNotNull(grafoa);
    }
    
    @Test
    public void testGrafoaSortu_PelikulaKatalogoaEzHutsik() {
        PelikulaKatalogoa lista = new PelikulaKatalogoa();
        lista.gehituPelikula(new Pelikula("Peli1"));
        lista.gehituPelikula(new Pelikula("Peli2"));
        
        Graph grafoa = new Graph();
        grafoa.grafoaSortu(lista);
        
        assertNotNull(grafoa);
    }
    
    @Test
    public void testGrafoaSortu_ThHashMapEzHutzik() {
        PelikulaKatalogoa lista = new PelikulaKatalogoa();
        lista.gehituPelikula(new Pelikula("Peli1"));
        lista.gehituPelikula(new Pelikula("Peli2"));
        
        Graph grafoa = new Graph();
        grafoa.grafoaSortu(lista);
        
        assertFalse(grafoa.getTh().isEmpty());
    }
    
    @Test
    public void testGrafoaSortu_KeysArrayEzHutsik() {
        PelikulaKatalogoa lista = new PelikulaKatalogoa();
        lista.gehituPelikula(new Pelikula("Peli1"));
        lista.gehituPelikula(new Pelikula("Peli2"));
        
        Graph grafoa = new Graph();
        grafoa.grafoaSortu(lista);
        
        assertNotNull(grafoa.getKeys());
        assertTrue(grafoa.getKeys().length > 0);
    }
    
    @Test
    public void testGrafoaSortu_AdjListezhutsik() {
        PelikulaKatalogoa lista = new PelikulaKatalogoa();
        lista.gehituPelikula(new Pelikula("Peli1"));
        lista.gehituPelikula(new Pelikula("Peli2"));
        
        Graph grafoa = new Graph();
        grafoa.grafoaSortu(lista);
        
        assertNotNull(grafoa.getAdjList());
        assertTrue(grafoa.getAdjList().length > 0);
    }

    @Test
    public void testErlazionatuta_KasuPositiboa() {
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        grafoa.getAdjList()[0].add(1);
        grafoa.getAdjList()[1].add(2);
        
        boolean result = grafoa.erlazionatuta("A1", "A3");
        
        assertTrue(result);
    }
    
    @Test
    public void testErlazionatuta_kasunegatiboa() {
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        grafoa.getAdjList()[0].add(1);
        grafoa.getAdjList()[1].add(2);
        
        boolean result = grafoa.erlazionatuta("A1", "A2");
        
        assertFalse(result);
    }
    
    @Test
    public void testErlazionatuta_NodoInbalidoa() {
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        grafoa.getAdjList()[0].add(1);
        grafoa.getAdjList()[1].add(2);
        
        boolean result = grafoa.erlazionatuta("A1", "A4");
        
        assertFalse(result);
    }
    
    @Test
    public void testErlazionatutaEXTRA_CaminoEntreActores() {
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        grafoa.getAdjList()[0].add(1);
        grafoa.getAdjList()[1].add(2);
        
        ArrayList<String> result = grafoa.erlazionatutaEXTRA("A1", "A3");
        
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("A2", result.get(0));
        assertEquals("A3", result.get(1));
    }

    @Test
    public void testErlazionatutaEXTRA_CaminoEntreActores_NoExiste() {
       
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        grafoa.getAdjList()[0].add(1);
        grafoa.getAdjList()[1].add(2);
        
        ArrayList<String> result = grafoa.erlazionatutaEXTRA("A1", "A2");
        
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testErlazionatutaEXTRA_NodoInbalidoa() {
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        grafoa.getAdjList()[0].add(1);
        grafoa.getAdjList()[1].add(2);
        
        ArrayList<String> result = grafoa.erlazionatutaEXTRA("A1", "A4");
        
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
    
    @Test
    public void testPageRankHasieratu() {
        //Page ranka hasieratzen duen metodoa probatzeko testa da
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        
        grafoa.PageRankHasieratu();
        
        HashMap<String, Double> aurrekoPageRank = grafoa.getAurrekoPageRank();
        HashMap<String, Double> oraingoPageRank = grafoa.getOraingoPageRank();
        
        assertNotNull(aurrekoPageRank);
        assertNotNull(oraingoPageRank);
        assertEquals(0.0, aurrekoPageRank.get("A1"), 0.0001);
        assertEquals(0.0, aurrekoPageRank.get("A2"), 0.0001);
        assertEquals(0.0, aurrekoPageRank.get("A3"), 0.0001);
        assertEquals(0.0, oraingoPageRank.get("A1"), 0.0001);
        assertEquals(0.0, oraingoPageRank.get("A2"), 0.0001);
        assertEquals(0.0, oraingoPageRank.get("A3"), 0.0001);
    }
    
    @Test
    public void testPageRank() {
        //Test hau PageRank metodoa erabiltzen duen proba da
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        grafoa.getAdjList()[0].add(1);
        grafoa.getAdjList()[1].add(2);
        
        grafoa.PageRankHasieratu();
        HashMap<String, Double> pageRank = grafoa.PageRank();
        
        assertNotNull(pageRank);
        assertEquals(0.0, pageRank.get("A1"), 0.0001);
        assertEquals(0.0, pageRank.get("A2"), 0.0001);
        assertEquals(0.0, pageRank.get("A3"), 0.0001);
    }
    
    @Test
    public void testPrintenOrden() {
        //Test hau inprimatzea testatzeko balio du
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        
        ArrayList<Bikote> emaitza = new ArrayList<Bikote>();
        emaitza.add(new Bikote("A1", 0.5));
        emaitza.add(new Bikote("A2", 0.3));
        emaitza.add(new Bikote("A3", 0.2));
        
        grafoa.PrintenOrden(emaitza, "A1");
        
        // Add assertions here
    }
    
    @Test
    public void testBuscador() {
        //Test hau buscador metodoa erabiltzen duen proba
        Graph grafoa = new Graph();
        grafoa.getTh().put("A1", 0);
        grafoa.getTh().put("A2", 1);
        grafoa.getTh().put("A3", 2);
        grafoa.getKeys()[0] = "A1";
        grafoa.getKeys()[1] = "A2";
        grafoa.getKeys()[2] = "A3";
        grafoa.getOraingoPageRank().put("A1", 0.5);
        grafoa.getOraingoPageRank().put("A2", 0.3);
        grafoa.getOraingoPageRank().put("A3", 0.2);
        
        ArrayList<Bikote> result = grafoa.buscador("A");
        
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("A1", result.get(0).getBikotekide());
        assertEquals(0.5, result.get(0).getPageRank(), 0.0001);
        assertEquals("A2", result.get(1).getBikotekide());
        assertEquals(0.3, result.get(1).getPageRank(), 0.0001);
        assertEquals("A3", result.get(2).getBikotekide());
        assertEquals(0.2, result.get(2).getPageRank(), 0.0001);
    }
}