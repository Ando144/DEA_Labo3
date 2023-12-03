import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
package DEA_Labo2;




public class DoubleLinkedListTest {

    private DoubleLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new DoubleLinkedList<>();
    }

    @Test
    public void testAddFirst() {
        list.addFirst(1);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(1), list.first());
        assertEquals(Integer.valueOf(1), list.last());
    }

    @Test
    public void testAddLast() {
        list.addLast(1);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(1), list.first());
        assertEquals(Integer.valueOf(1), list.last());
    }

    @Test
    public void testRemoveFirst() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(Integer.valueOf(2), list.removeFirst());
        assertEquals(Integer.valueOf(1), list.first());
        assertEquals(Integer.valueOf(1), list.last());
    }

    @Test
    public void testRemoveLast() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(Integer.valueOf(1), list.removeLast());
        assertEquals(Integer.valueOf(2), list.first());
        assertEquals(Integer.valueOf(2), list.last());
    }

    @Test
    public void testRemove() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        assertTrue(list.remove(Integer.valueOf(2)));
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(3), list.first());
        assertEquals(Integer.valueOf(1), list.last());
    }

    @Test
    public void testContains() {
        list.addFirst(1);
        list.addFirst(2);
        assertTrue(list.contains(Integer.valueOf(1)));
        assertFalse(list.contains(Integer.valueOf(3)));
    }

    @Test
    public void testFind() {
        list.addFirst(1);
        list.addFirst(2);
        assertEquals(Integer.valueOf(1), list.find(Integer.valueOf(1)));
        assertNull(list.find(Integer.valueOf(3)));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, list.size());
        list.addFirst(1);
        assertEquals(1, list.size());
    }

}

