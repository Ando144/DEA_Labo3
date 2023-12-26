package DEA_Labo4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

public class AktoreKatalogoa {

    private static AktoreKatalogoa nireListaAktore = null;
    private HashMap <String, Aktorea> map;

    public AktoreKatalogoa() {
        this.map = new HashMap<String, Aktorea>();
    }
    public static AktoreKatalogoa getListaAktore(){
        if(nireListaAktore == null){
            nireListaAktore = new AktoreKatalogoa();
        }
        return nireListaAktore;
    }

    //para buscar el actor en el hashmap
    public Aktorea bilatuAktorea(String pIzenAbizena)
    {
        Aktorea Aktore1 = null;
        if (this.map.containsKey(pIzenAbizena))
        {
            Aktore1 = this.map.get(pIzenAbizena);
        }
        return Aktore1;
    }

    //para añadir un actor al hashmap
    public void gehituAktorea(Aktorea pAktorea)
    {
        if (!this.map.containsKey(pAktorea.getIzenAbizena()))
        {
            this.map.put(pAktorea.getIzenAbizena(), pAktorea);
        }
    }

    //para eliminar un actor del hashmap
    public void ezabatuAktorea(Aktorea pAktorea)
    {
        if (this.map.containsKey(pAktorea.getIzenAbizena()))
        {
            this.map.remove(pAktorea.getIzenAbizena());
        }
    }

    //para devolver las pelikulas de un actor
    public ListaPelikula pelikulakBueltatu(String pIzenAbizena)
    {
        ListaPelikula pelikulak = null;
        if (this.map.containsKey(pIzenAbizena))
        {
            pelikulak = this.map.get(pIzenAbizena).getListaPelikula();
        }
        return pelikulak;
    }

    //pasar los nombres del hasmap a un arraylist
    public ArrayList<String> getIzenaLista()
    {
        
        //un arraylist para los nombres
        ArrayList<String> izenak = new ArrayList<String>();
        //un iterador para los aktores
        Iterator<Aktorea> iteradorea = this.map.values().iterator();
        
        while (iteradorea.hasNext())
        {
            Aktorea aktore = iteradorea.next();
            izenak.add(aktore.getIzenAbizena());
        }
        return izenak;
    }
    //ordenar el array alfabeticamente usando quicksort
    public static void ordenatu(String[] izenak) {
        quickSort(izenak, 0, izenak.length - 1);
    }
    public void inprimatu()
    {
        Iterator<Aktorea> itr = this.map.values().iterator();
        while (itr.hasNext())
        {
            Aktorea akt = itr.next();
            System.out.println(akt.getIzenAbizena());
        }
    }
    
    private static void quickSort(String[] izenak, int eskerra, int eskuma) 
    {
        if (eskerra < eskuma) 
        {
            int zatituIndizearekin = zatiketa(izenak, eskerra, eskuma);
            quickSort(izenak, eskerra, zatituIndizearekin - 1);
            quickSort(izenak, zatituIndizearekin + 1, eskuma);
        }
    }
    
    private static int zatiketa(String[] izenak, int eskerra, int eskuma) {
        String pibote = izenak[eskuma];
        int n = eskerra - 1;
        for (int m = eskerra; m < eskuma; m++) {
            //esto compara m con el pibote y dependiendo de si la m esta adelante enmedio o detras 
            //alfabeticamente da un numero positivo negativo o 0
            if (izenak[m].compareTo(pibote) < 0) {
                n++;
                String temp = izenak[n];
                izenak[n] = izenak[m];
                izenak[m] = temp;
            }
        }
        String temp = izenak[n + 1];
        izenak[n + 1] = izenak[eskuma];
        izenak[eskuma] = temp;
        return n + 1;
    }

    public void AktoreakTxtanSartu(){
    FileWriter fitxategia = null;	
    try {
        fitxategia = new FileWriter("FitxategiaAktoreak.txt");
        Iterator<String> it = AktoreKatalogoa.nireListaAktore.map.keySet().iterator();
        String lerroa = null;
        while (it.hasNext()) {
            lerroa = it.next();

            fitxategia.write(lerroa + " &&& " );
            AktoreKatalogoa.nireListaAktore.map.get(lerroa).getListaPelikula().inprimatu();
            System.out.println("/n");
        }

        fitxategia.close();

    } 
    catch (FileNotFoundException e) {
        System.out.println("Txt-a ez da aurkitu ");
    } catch (IOException e) {
        System.out.println("Errore bat egon da idazketan ");
    }
    }
}
