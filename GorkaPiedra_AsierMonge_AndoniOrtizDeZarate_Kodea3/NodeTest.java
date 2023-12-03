import org.junit.Test;
import static org.junit.Assert.*;
package DEA_Labo2;


public class NodeTest {

    @Test
    public void testNodeCreation() {
        Node<Integer> node = new Node<>(42);
        assertEquals(42, (int) node.data);
        assertNull(node.next);
        assertNull(node.prev);
    }

    // Add more tests here as needed

}
    
}
