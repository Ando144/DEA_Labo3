import org.junit.Test;
import static org.junit.Assert.*;

public class ListaPelikulaTest {

    @Test
    public void testGehituEtaEzabatuPelikula() {
        ListaPelikula lista = new ListaPelikula();
        Pelikula peli1 = new Pelikula("The Godfather", 1972);
        Pelikula peli2 = new Pelikula("The Shawshank Redemption", 1994);
        Pelikula peli3 = new Pelikula("The Dark Knight", 2008);

        lista.gehituPelikula(peli1);
        lista.gehituPelikula(peli2);
        lista.gehituPelikula(peli3);

        assertEquals(3, lista.getTamaina());

        lista.ezabatuPelikula(peli2);

        assertEquals(2, lista.getTamaina());
        assertTrue(lista.pelikulaDago(peli1));
        assertFalse(lista.pelikulaDago(peli2));
        assertTrue(lista.pelikulaDago(peli3));
    }

    @Test
    public void testBadagoPelikula() {
        ListaPelikula lista = new ListaPelikula();
        Pelikula peli1 = new Pelikula("The Godfather", 1972);
        Pelikula peli2 = new Pelikula("The Shawshank Redemption", 1994);

        lista.gehituPelikula(peli1);

        assertTrue(lista.badagoPelikula("The Godfather"));
        assertFalse(lista.badagoPelikula("The Shawshank Redemption"));

        lista.gehituPelikula(peli2);

        assertTrue(lista.badagoPelikula("The Shawshank Redemption"));
    }
}
