package DEA_Labo4;

import java.util.ArrayList;
import java.util.Iterator;

import DEA_Labo4.UnorderedDoubleLinkedList;

public class ListaAktore {
    private UnorderedDoubleLinkedList<Aktorea> lista;


    public ListaAktore()
    {
        this.lista = new UnorderedDoubleLinkedList<Aktorea>();
    } 
    public Iterator<Aktorea> getNireIteradorea() {
        return this.lista.iterator();
    
    }

    public int getLuzera()
    {
        return this.lista.size();
    }
    public void ezabatuAktorea(Aktorea pAktorea)
    {
        this.lista.remove(pAktorea);
    }
    public void gehituAktorea(Aktorea pAktorea)
    {
        if (!this.lista.contains(pAktorea))
        {
            this.lista.addToRear(pAktorea);
        }
    }
    public boolean badagoAktorea(String pizenAbizena){
        boolean badago = false;
		Aktorea aktorea = null;
		Iterator<Aktorea> itr = this.getNireIteradorea();
		while(itr.hasNext() && !badago){
			aktorea = itr.next();
			if(aktorea.getIzenAbizena().equals(pizenAbizena)){
				badago = true;
			}
		}
		return badago;
    }
    public boolean AktoreaBadago(Aktorea pAktorea)
    {
        return this.lista.contains(pAktorea);
    }
    public void reseat()
    {
        this.lista.first=null;
        //this.lista.count=0;
    }
    public void inprimatu()
    {
        Iterator<Aktorea> itr = this.getNireIteradorea();
        while (itr.hasNext())
        {
            Aktorea akt = itr.next();
            System.out.println(akt.getIzenAbizena());
        }
    }
}