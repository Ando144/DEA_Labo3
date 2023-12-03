import org.junit.*;
import static org.junit.Assert.*;
 

public class AktoreaTest {
    @Test
    public void testGetIzenAbizena() {
        Aktorea aktorea = new Aktorea("Angelina Jolie");
        assertEquals("Angelina Jolie", aktorea.getIzenAbizena());
    }

    @Test
    public void testGehituPelikula() {
        Aktorea aktorea = new Aktorea("Tom Hanks");
        Pelikula pelikula1 = new Pelikula("Forrest Gump", 1994);
        Pelikula pelikula2 = new Pelikula("Cast Away", 2000);
        aktorea.gehituPelikula(pelikula1);
        aktorea.gehituPelikula(pelikula2);
        assertEquals(2, aktorea.getListaPelikula().getTamaina());
    }

    @Test
    public void testPelikulaSartu() {
        Aktorea aktorea = new Aktorea("Leonardo DiCaprio");
        Pelikula pelikula1 = new Pelikula("Titanic", 1997);
        Pelikula pelikula2 = new Pelikula("The Revenant", 2015);
        aktorea.gehituPelikula(pelikula1);
        aktorea.gehituPelikula(pelikula2);
        assertEquals(2, aktorea.getListaPelikula().getTamaina());
    }
}
