import org.junit.Test;
import static org.junit.Assert.*;

public class AktoreKatalogoaTest {

    @Test
    public void testGehituAktorea() {
        AktoreKatalogoa aktoreKatalogoa = AktoreKatalogoa.getListaAktore();
        Aktorea aktorea = new Aktorea("Angelina Jolie");
        aktoreKatalogoa.gehituAktorea(aktorea);
        assertEquals(aktorea, aktoreKatalogoa.bilatuAktorea("Angelina Jolie"));
    }

    @Test
    public void testEzabatuAktorea() {
        AktoreKatalogoa aktoreKatalogoa = AktoreKatalogoa.getListaAktore();
        Aktorea aktorea = new Aktorea("Brad Pitt");
        aktoreKatalogoa.gehituAktorea(aktorea);
        aktoreKatalogoa.ezabatuAktorea(aktorea);
        assertNull(aktoreKatalogoa.bilatuAktorea("Brad Pitt"));
    }

    @Test
    public void testPelikulakBueltatu() {
        AktoreKatalogoa aktoreKatalogoa = AktoreKatalogoa.getListaAktore();
        Aktorea aktorea = new Aktorea("Tom Hanks");
        Pelikula pelikula1 = new Pelikula("Forrest Gump", 1994);
        Pelikula pelikula2 = new Pelikula("Cast Away", 2000);
        aktorea.gehituPelikula(pelikula1);
        aktorea.gehituPelikula(pelikula2);
        aktoreKatalogoa.gehituAktorea(aktorea);
        ListaPelikula listaPelikula = aktoreKatalogoa.pelikulakBueltatu("Tom Hanks");
        assertTrue(listaPelikula.pelikulaDago(pelikula1));
        assertTrue(listaPelikula.pelikulaDago(pelikula2));
    }

    @Test
    public void testGetIzenaLista() {
        AktoreKatalogoa aktoreKatalogoa = AktoreKatalogoa.getListaAktore();
        Aktorea aktorea1 = new Aktorea("Leonardo DiCaprio");
        Aktorea aktorea2 = new Aktorea("Johnny Depp");
        aktoreKatalogoa.gehituAktorea(aktorea1);
        aktoreKatalogoa.gehituAktorea(aktorea2);
        assertTrue(aktoreKatalogoa.getIzenaLista().contains("Leonardo DiCaprio"));
        assertTrue(aktoreKatalogoa.getIzenaLista().contains("Johnny Depp"));
    }

    @Test
    public void testOrdenatu() {
        String[] izenak = {"Brad Pitt", "Angelina Jolie", "Tom Hanks", "Johnny Depp"};
        AktoreKatalogoa.ordenatu(izenak);
        assertArrayEquals(new String[]{"Angelina Jolie", "Brad Pitt", "Johnny Depp", "Tom Hanks"}, izenak);
    }
}
