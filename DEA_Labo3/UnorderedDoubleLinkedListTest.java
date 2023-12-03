import static org.junit.Assert.assertEquals;
import org.junit.Test;
public class UnorderedDoubleLinkedListTest {

    @Test
    public void testAddToFront() {
        UnorderedDoubleLinkedList<Integer> list = new UnorderedDoubleLinkedList<>();
        list.addToFront(1);
        list.addToFront(2);
        list.addToFront(3);
        assertEquals("3, 2, 1", list.toString());
    }
    @Test
    public void testAddToRear() {
        UnorderedDoubleLinkedList<Integer> list = new UnorderedDoubleLinkedList<>();
        list.addToRear(1);
        list.addToRear(2);
        list.addToRear(3);
        assertEquals("1, 2, 3", list.toString());
    }
    @Test
    public void testAddAfter() {
        UnorderedDoubleLinkedList<Integer> list = new UnorderedDoubleLinkedList<>();
        list.addToRear(1);
        list.addToRear(2);
        list.addToRear(3);
        list.addAfter(4, 2);
        assertEquals("1, 2, 4, 3", list.toString());
    }

}


