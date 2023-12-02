package DEA_Labo3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Iterator;


public class Graph {
	
    HashMap<String, Integer> th;
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
		boolean aux=erlazionatuta(a1,a2);
		boolean atera=false;
		Queue<String> aztGabe = new LinkedList<String>();
		HashSet<String> aztertuak = new HashSet<String>();
		
    Stack<String> nondik = new Stack<String>();//pila honen helburua, grafoaren elementu bakoitza nondik etorri den jakitea da
		Stack<String> adabegia = new Stack<String>();//pila honetan, grafoaren elementu guztiak sartuko ditugu
		
    aztGabe.add(a1);
		aztertuak.add(a1);
		adabegia.add(a1);
		//lehenengo elementua sartuko dugu, geroago aterako balitz, berriro ez sartzeko
		
    ArrayList<String> emaitza=new ArrayList<String>();
		if(aux){//bi aktoreak konektatuta badaude sartuko da
			while(!aztGabe.isEmpty() && !atera){ 
				String lag= aztGabe.remove();
				if(lag.equals(a2)){
					atera=true; 
				}else{
					ArrayList<String> array = g.get(lag);
					Iterator<String> itr = array.iterator();
					while(itr.hasNext()){
						String izena = itr.next();
						if(!aztertuak.contains(izena)){
							aztGabe.add(izena);
							aztertuak.add(izena);
							nondik.add(lag);//hemen, lehen esan den bezala, beste datu egituretan sartzen ari garen elementuaren
							//gurasoak sartuko ditugu
							adabegia.add(izena);
							//aurreko metodoan egin den bezala, datu egitura guztietan sartuko da, berriro ere ateratzen bada
							//elementu berdina, ez sartzeko
						}
					}
				}
			}//ARRAYLIST-A BETETZEN HASI
			String aurrekoa=a2;//Lehenengo elementua sartuko dugu pilan
			Stack<String> emaitza2 = new Stack<String>();
			emaitza2.push(a2);
			while(!adabegia.isEmpty() && !aurrekoa.equals(a1)){
				while(!adabegia.peek().equals(aurrekoa) && !nondik.isEmpty()){
					//while honetan, aurrekoa atributuan daukagun balioa aurkitu beharko dugu adabegia pilan, eta hau egiten dugun
					//bitartean, nondik pilan elementuak ateratzen joango gara.
					//Elementua aurkitzean, nondik pilan dagoen azken String-a, elementuaren gurasoa izango da, eta hau pilan
					//sartuko dugu. Nondik, hutsa denean, azken-aurreko elementura iritsi gara(azken elementua metodoaren parametroko
					//string bat da)
					nondik.pop();
					adabegia.pop();
				}
				aurrekoa = nondik.pop();
				emaitza2.push(aurrekoa);
				adabegia.pop();
			}
			//momentu honetan, bi aktoreen arteko erlazioaren bidea pilan dago, eta orain arrayListera pasako dugu
			while(!emaitza2.isEmpty()){
				emaitza.add(emaitza2.pop());
			}
			
		}
		else{
			System.out.println("Aktoreak ez daude konektatuta");
		}
		return emaitza;
	}
}