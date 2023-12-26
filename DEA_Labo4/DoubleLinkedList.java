package DEA_Labo4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributuak
	Node<T> first;  // azkenengoaren erreferentzia
	protected String deskr;  // deskribapena
	protected int count;
	

	public DoubleLinkedList() {
		first = null;
		deskr = "";
		count = 0;
	}
	
	public void setDeskr(String ize) {
	  deskr = ize;
	}

	public String getDeskr() {
	  return deskr;
	}

	public T removeFirst() {
		Node<T> elem = first;
		if(first.next == null) {
			first = null;
		}
		else {
			first.prev.next = first.next;
			first.next.prev = first.prev;
			first = first.next;
		}
		count--;
		return elem.data;
	}

	public T removeLast() {
		Node<T> elem = first.prev;
		if(first.next == first) {
			first = null;
		}
		else{
			elem.prev.next = first;
			first.prev = elem.prev;
		}
		count--;
		return elem.data;
    }


	public T remove(T elem) {
		if(!contains(elem)) {
			return null;
		}
		else {
			Node<T> unekoa = first;
			boolean aurkitua = false;
			while(!aurkitua){
	
				if(unekoa.data.equals(elem)) {
					aurkitua = true;
					if(unekoa.equals(first)){return removeFirst();}
					else if(unekoa.next.equals(first)){return removeLast();}
					else{
						unekoa.prev.next = unekoa.next;
						unekoa.next.prev = unekoa.prev;
						count--;
						return unekoa.data;
					}
				}
				unekoa=unekoa.next;
			}

		}	
		return null;
	}

	public T first() {
	// listako lehen elementua ematen du
	      if (isEmpty())
	          return null;
	      else return first.data;
	}

	public T last() {
	// listako azken elementua ematen du
	      if (isEmpty())
	          return null;
	      else return first.prev.data;
	}

	public boolean contains(T elem) {
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		      if (isEmpty()){
		          return false;
			  }
			  else{
				Node<T> unekoa = first;
				boolean aurkitua = false;
				if(first.data.equals(elem)) {
					aurkitua = true;
					return aurkitua;
			  }
			  while(!aurkitua){
				  if(unekoa.data.equals(elem)) {
					  aurkitua = true;
				  }
				  unekoa = unekoa.next;
			  }
		      return aurkitua;		// KODEA OSATU ETA KOSTUA KALKULATU
		   }
		}
	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela
		if (contains(elem)) {
			return elem;
		}
		else {
			return null;
		}
	// KODEA OSATU ETA KOSTUA KALKULATU
	}

	public boolean isEmpty() 
	{ return first == null;};
	
	public int size() 
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 
		Node<T> puntero = first;
		boolean flag=false; 

		public boolean hasNext(){
			if(isEmpty()){ return false; }
			else if (puntero.equals(first) && flag) {return false;}
			 else {
				 flag=true;
				 return true;
			 }
		 }
		 public T next(){
			 T emaitza = puntero.data;
			 puntero=puntero.next;
			 return emaitza;} 

		// KODEA OSATU 
	   } // private class
		
		
		public void adabegiakInprimatu() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "DoubleLinkedList " + result + "]";
		}

}
