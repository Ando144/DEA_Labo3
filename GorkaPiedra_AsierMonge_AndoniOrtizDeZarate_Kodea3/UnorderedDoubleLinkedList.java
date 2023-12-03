package DEA_Labo3;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// hasieran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node <T> berria = new Node<T>(elem);
		Node <T> last;
		if(this.first==null)
		{
			first=berria;
		}
		last = first.prev;
		berria.next = first;
		berria.prev = last;
		first.prev = berria;
		last.next = berria;
		first = berria;
	}

	public void addToRear(T elem) {
	// bukaeran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
			Node <T> berria = new Node<T>(elem);
			Node <T> last;
		if(this.first==null)
		{
			first=berria;
		}
		else
		{

			last=first.prev;
			berria.next = first;
			berria.prev = last;
			first.prev = berria;
			last.next = berria;
		}
		
	}
	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		Node <T> berria = new Node<T>(elem);
		Node <T> aux;
		Node <T> unekoa=first;

		if (isEmpty()) {
			System.out.println("Lista hutsa da");
			first=berria;
			berria.next=berria;
			berria.prev=berria;
		}
		else {
			if (!contains(target))
			{
				System.out.println("Ez dago elementu hori listan");
			}
			else {
				boolean aurk = false;
				while(!aurk){
					if(unekoa.data.equals(target)){
						aurk = true;
					}else{
						unekoa = unekoa.next;
					}
				}
				aux = unekoa.next;
				unekoa.next=berria;
				aux.prev=berria;
				berria.prev=unekoa;
				berria.next=aux;
				
			}
		}
	}

}
