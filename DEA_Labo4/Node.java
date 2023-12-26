package DEA_Labo4;

	public class Node<T> {
		T data; 			// dato del nodo
		Node<T> next; 	// puntero al siguiente nodo de la lista
		Node<T> prev; 	// puntero al anterior nodo de la lista
		// -------------------------------------------------------------

		public Node(T dd) 		// constructor
		{
			data = dd;
			next = null;
			prev = null;
		}
	}


