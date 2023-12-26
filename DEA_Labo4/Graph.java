package DEA_Labo4;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Graph {
	
    HashMap<String,Double> aurrekoPageRank = new HashMap<String,Double>();
	HashMap<String,Double> oraingoPageRank = new HashMap<String,Double>();
	HashMap<String, Integer> th;

    double aux1 = 0.85;
	double aux2 = 1/((double)th.size());
	double Num = 0.0001;
	double ada=0.0;
	double dife=0.0;


    String[] keys;
    ArrayList<Integer>[] adjList;
  
  public void grafoaSortu(PelikulaKatalogoa lista){
        // Post: pelikulen zerrendatik grafoa sortu
        //       Nodoak aktore izenak dira
        Pelikula peli =null;
        Aktorea aktor=null;
        Iterator<Pelikula> itr = lista.getIteradorea();
        // 1. pausua:  “th” bete
        //para llenarlo vamos a iterar entre las peliculas y si el actor no esta en el hashmap lo añadimos
        //si esta ya en el hashmap no hacemos nada
        while(itr.hasNext()){
            peli = itr.next();
            Iterator<Aktorea> itr2 = peli.getCasting().getNireIteradorea();
            while(itr2.hasNext()){
                aktor = itr2.next();
                if(!th.containsKey(aktor.getIzenAbizena())){
                    th.put(aktor.getIzenAbizena(), th.size());//añadimos el actor al hashmap y le damos un numero que corresponde a el ultimo numero que se ha añadido
                }
            }
        }
        // KODEA INPLEMENTATU

        // 2. pausua: “keys” bete
      keys = new String[th.size()];
      for (String k: th.keySet()) keys[th.get(k)] = k;


       // 3. pausua: “adjList” bete
       //para llenar el adjList vamos a iterar entre las peliculas y en cada pelicula vamos a iterar entre los actores
       //y vamos a añadir a la lista de adyacencia de cada actor los actores que aparecen en la pelicula
       //KODEA INPLEMENTATU
        adjList = new ArrayList[th.size()];
        for (int i = 0; i < adjList.length; i++) adjList[i] = new ArrayList<Integer>();
        
        itr = lista.getIteradorea();
        while(itr.hasNext()){
            peli = itr.next();
            Iterator<Aktorea> itr2 = peli.getCasting().getNireIteradorea();
            while(itr2.hasNext()){
                aktor = itr2.next();
                int pos1 = th.get(aktor.getIzenAbizena());//posicion del actor del que estamos rellenando info en el hashmap
                Iterator<Aktorea> itr3 = peli.getCasting().getNireIteradorea();
                while(itr3.hasNext()){
                    aktor = itr3.next();
                    int pos2 = th.get(aktor.getIzenAbizena());//posicion del actor que estamos añadiendo a la lista de pos1
                    if(pos1!=pos2){//si no es el mismo actor añadirlo a la lista de adyacencia
                        adjList[pos1].add(pos2);
                    }
                }
            }
        }
         
  }
  
  public void print(){
     for (int i = 0; i < adjList.length; i++){
      System.out.print("Element: " + i + " " + keys[i] + " --> ");
      for (int k: adjList[i])  System.out.print(keys[k] + " ### ");
      
      System.out.println();
     }
  }
  
  public boolean erlazionatuta(String a1, String a2){
      Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
      
      int pos1 = th.get(a1);
      int pos2 = th.get(a2);
      boolean aurkitua = false;
       // KODEA INPLEMENTATU    
      aztertuGabeak.add(pos1);
      HashSet<String> aztertuak = new HashSet<String>();
      while(!aztertuGabeak.isEmpty() && !aurkitua){
          int pos = aztertuGabeak.remove();
          if(pos==pos2){
              aurkitua=true;
          }
          else{
              Iterator<Integer> itr = adjList[pos].iterator();
              while(itr.hasNext()){
                  int pos3 = itr.next();
                  if(!aztertuak.contains(keys[pos3])){
                      aztertuGabeak.add(pos3);
                      aztertuak.add(keys[pos3]);
                  }
              }
          }
      }
      
      return aurkitua;

  }

  public ArrayList<String> erlazionatutaEXTRA(String a1, String a2){
		ArrayList<String> emaitza = new ArrayList<String>();
    //este metodo es igual que el anterior pero en vez de devolver un boolean devuelve un arraylist con los actores que estan en el camino
    //entre los dos actores que se pasan como parametro
    Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
    
    int pos1 = th.get(a1);
    int pos2 = th.get(a2);
    boolean aurkitua = false;
      // KODEA INPLEMENTATU    
    aztertuGabeak.add(pos1);//añadimos el primer actor a la cola 
    HashSet<String> aztertuak = new HashSet<String>();
    while(!aztertuGabeak.isEmpty() && !aurkitua){
      int pos = aztertuGabeak.remove();
      if(pos==pos2){
          aurkitua=true;
      }
      else{
          Iterator<Integer> itr = adjList[pos].iterator();
          while(itr.hasNext()){
              int pos3 = itr.next();
              if(!aztertuak.contains(keys[pos3])){//comprueba si el actor ya ha sido añadido a la lista 
                  aztertuGabeak.add(pos3);
                  aztertuak.add(keys[pos3]);
              }
          }
      }
    }
    if(aurkitua){
        Stack<String> pila = new Stack<String>();
        pila.push(a2);
        int pos = pos2;
        while(pos!=pos1){
            Iterator<Integer> itr = adjList[pos].iterator();
            while(itr.hasNext()){
                int pos3 = itr.next();
                if(aztertuak.contains(keys[pos3])){
                    pila.push(keys[pos3]);
                    pos=pos3;
                }
            }
        }
        while(!pila.isEmpty()){
            emaitza.add(pila.pop());
        }
    }
    return emaitza;
  }
  	public void PageRankHasieratu(){
		Double n = 1.0/((double)th.size());
		Double balioa=n;
		String elementua = "";
		Iterator<String> itr= th.keySet().iterator();
		while(itr.hasNext()){
			elementua = itr.next();
			aurrekoPageRank.put(elementua, balioa);
			oraingoPageRank.put(elementua, 0.0);
		}
        
	}
    public HashMap<String,Double> PageRank(){
    // Post: PageRank kalkulatzen du
    //       PageRank-a “oraingoPageRank”-en gordeko da
    //       PageRank-a bueltatuko du
    // KODEA INPLEMENTATU
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(340);
        double Dif=9.9;
        while(Dif>Num){
            Dif=0.0;
            
            Iterator<String> itr = th.keySet().iterator();
            
            while(itr.hasNext()){
                String elem= itr.next();
                int Luzera = adjList[th.get(elem)].size();
                for(int i=0;i<Luzera ; i++){
                    String listakoElem = keys[adjList[th.get(elem)].get(i)];
                    Double listakoElemLuzera = (double)adjList[th.get(listakoElem)].size();
                    Double listakoElemPR = aurrekoPageRank.get(listakoElem);
                    Double elemPR = oraingoPageRank.get(elem);
                    oraingoPageRank.put(elem,elemPR+(listakoElemPR/listakoElemLuzera));
                    oraingoPageRank.get(elem);
                }
            }
            
            Iterator<String> itrMap = oraingoPageRank.keySet().iterator();	
            
            while (itrMap.hasNext()) {
                String Elementua = itrMap.next();
                double x=oraingoPageRank.get(Elementua);
                double z= ((1-aux1)/(1/((double)th.size()))) + (aux1*x);
                oraingoPageRank.put(Elementua, z);
            
                double y=aurrekoPageRank.get(Elementua);
        
                double auxDif=Math.abs(z-y);
                Dif=Dif+auxDif;
            }
            aurrekoPageRank=oraingoPageRank;
            
        }
        return oraingoPageRank;
    }
    public void PageRankInprimatu(){
        // Post: PageRank-ak inprimatzen ditu
        // KODEA INPLEMENTATU
        Iterator<String> itr = th.keySet().iterator();
        while(itr.hasNext()){
            String elem= itr.next();
            System.out.println(elem + " " + oraingoPageRank.get(elem));
        }
    }
    public void PrintenOrden(ArrayList<Bikote> emaitza,String Aktorea){
    //Post: Aktorearekin erlazionatutako PageRank lista ordenatuta entregatzen du
    //KODEA INPLEMENTATU
        System.out.println("PageRank lista ordenatuta:");
        System.out.println("Aktorea: " + Aktorea);
        for(int i=0;i<emaitza.size();i++){
            System.out.println(emaitza.get(i).bikotekide + " " + emaitza.get(i).pageRank);
        }
        
    }
    public ArrayList<Bikote> buscador(String gakoHitz){
        // Post: “gakoHitz” hitza duten aktoreen zerrenda bueltatzen du
        //       Zerrenda Bikote klaseko objektuak dira, eta ordenatuta daude
        //       Bikote klaseko compareTo metodoa erabiliz ordenatzen dira
        // KODEA INPLEMENTATU
        ArrayList<Bikote> emaitza = new ArrayList<Bikote>();
        Iterator<String> itr = th.keySet().iterator();
        while(itr.hasNext()){
            String elem= itr.next();
            if(elem.contains(gakoHitz)){
                emaitza.add(new Bikote(elem,oraingoPageRank.get(elem)));
            }
        }
        return emaitza;
    }

}