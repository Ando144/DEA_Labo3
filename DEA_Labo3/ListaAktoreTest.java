import org.junit.Test;
import static org.junit.Assert.*;
import DEA_Labo3;
public class ListaAktoreTest {

    @Test
    public void testGehituAktorea() {
        ListaAktore lista = ListaAktore.getListaAktore();
        Aktorea aktorea = new Aktorea("Doe");
        lista.gehituAktorea(aktorea);
        assertTrue(lista.badagoAktorea("Doe"));
    }

    @Test
    public void testBadagoAktorea() {
        ListaAktore lista = ListaAktore.getListaAktore();
        Aktorea aktorea = new Aktorea("Doe");
        lista.gehituAktorea(aktorea);
        assertTrue(lista.badagoAktorea("Doe"));
        assertFalse(lista.badagoAktorea("Smith"));
    }

    @Test
    public void testInprimatu() {
        ListaAktore lista = ListaAktore.getListaAktore();
        Aktorea aktorea1 = new Aktorea("Doe");
        Aktorea aktorea2 = new Aktorea("Doe2");
        lista.gehituAktorea(aktorea1);
        lista.gehituAktorea(aktorea2);
        lista.inprimatu();
        
    }
}
