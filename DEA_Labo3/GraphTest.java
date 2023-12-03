
}package DEA_Labo3;

import org.junit.Test;
import static org.junit;

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
}