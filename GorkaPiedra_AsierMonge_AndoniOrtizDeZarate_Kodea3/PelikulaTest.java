import org.junit.Test;
import static org.junit.Assert.*;

public class PelikulaTest {

    @Test
    public void testGetIzenBurua() {
        Pelikula pelikula = new Pelikula("Inception", 2010);
        assertEquals("Inception", pelikula.getIzenBurua());
    }

    @Test
    public void testGetEstrenaldia() {
        Pelikula pelikula = new Pelikula("Inception", 2010);
        assertEquals(2010, pelikula.getEstrenaldia());
    }

    @Test
    public void testGetCasting() {
        Pelikula pelikula = new Pelikula("Inception", 2010);
        pelikula.aktoreaSartu(new Aktorea("Leonardo DiCaprio"));
        pelikula.aktoreaSartu(new Aktorea("Ellen Page"));
        assertEquals(2, pelikula.getCasting().getLuzera());
        //si getcasting funciona bien, deberia dar la msisma luzeera
    }

    @Test
    public void testSetEstrenaldia() {
        Pelikula pelikula = new Pelikula("Inception", 2010);
        pelikula.setEstrenaldia(2011);
        assertEquals(2011, pelikula.getEstrenaldia());
    }

    @Test
    public void testEstreinaldiaAldatu() {
        Pelikula pelikula = new Pelikula("Inception", 2010);
        pelikula.estreinaldiaAldatu(2011);
        assertEquals(2011, pelikula.getEstrenaldia());
    }

    @Test
    public void testAktoreaSartu() {
        Pelikula pelikula = new Pelikula("Inception", 2010);
        pelikula.aktoreaSartu(new Aktorea("Leonardo DiCaprio"));
        pelikula.aktoreaSartu(new Aktorea("Ellen Page"));
        assertEquals(2, pelikula.getCasting().getLuzera());
        //si aktoreasartu funciona bien deberia dar 2 la luzeera
    }
}
