import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PelikulaKatalogoaTest {

    private PelikulaKatalogoa pelikulaKatalogoa;

    @Before
    public void setUp() {
        pelikulaKatalogoa = PelikulaKatalogoa.getListaPelikula();
    }

    @Test
    public void testGehituPelikula() {
        Pelikula pelikula = new Pelikula("Inception", 2010);
        pelikulaKatalogoa.gehituPelikula(pelikula);
        assertEquals(pelikula, pelikulaKatalogoa.bilatuPelikula("Inception"));
    }

    @Test
    public void testBilatuPelikula() {
        Pelikula pelikula = new Pelikula("The Dark Knight", 2008);
        pelikulaKatalogoa.gehituPelikula(pelikula);
        assertEquals(pelikula, pelikulaKatalogoa.bilatuPelikula("The Dark Knight"));
    }

    @Test
    public void testBilatuPelikulaNotFound() {
        assertNull(pelikulaKatalogoa.bilatuPelikula("Non-existent movie"));
    }

    @Test
    public void testAktoreakBueltatu() {
        Pelikula pelikula = new Pelikula("The Godfather", 1972);
        Aktorea aktorea1 = new Aktorea("Marlon Brando");
        Aktorea aktorea2 = new Aktorea("Al Pacino");
        pelikula.aktoreaSartu(aktorea1);
        pelikula.aktoreaSartu(aktorea2);
        pelikulaKatalogoa.gehituPelikula(pelikula);
        ListaAktore listaAktore = pelikulaKatalogoa.aktoreakBueltatu("The Godfather");
        assertEquals(listaAktore.getLuzera(), 2);
        assertEquals(listaAktore.badagoAktorea("Marlon Brando"), true );
        assertEquals(listaAktore.badagoAktorea("Al Pacino"), true);
    }

    @Test
    public void testPelikularenUrteaAldatu() {
        Pelikula pelikula = new Pelikula("The Shawshank Redemption", 1994);
        pelikulaKatalogoa.gehituPelikula(pelikula);
        pelikulaKatalogoa.pelikularenUrteaAldatu(1995, "The Shawshank Redemption");
        assertEquals(1995, pelikula.getEstrenaldia());
    }

    @Test
    public void testPelikulakTxtanSartu() {
        Pelikula pelikula1 = new Pelikula("Pulp Fiction", 1994);
        Pelikula pelikula2 = new Pelikula("The Matrix", 1999);
        pelikulaKatalogoa.gehituPelikula(pelikula1);
        pelikulaKatalogoa.gehituPelikula(pelikula2);
        pelikulaKatalogoa.PelikulakTxtanSartu();
        assertNotNull(pelikulaKatalogoa.bilatuPelikula("Pulp Fiction"));
        assertNotNull(pelikulaKatalogoa.bilatuPelikula("The Matrix"));
    }
}
