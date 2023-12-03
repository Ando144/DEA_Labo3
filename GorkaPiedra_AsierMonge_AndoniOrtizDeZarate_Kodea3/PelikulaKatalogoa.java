package DEA_Labo3;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.HashMap;
public class PelikulaKatalogoa {


    private static PelikulaKatalogoa nirePelikulaKatalogoa = null;
    private HashMap <String, Pelikula> map;


    private PelikulaKatalogoa() {
        this.map = new HashMap<String, Pelikula>();
    }
    public static PelikulaKatalogoa getListaPelikula(){
		if(nirePelikulaKatalogoa == null){
            nirePelikulaKatalogoa = new PelikulaKatalogoa();
        }
        return nirePelikulaKatalogoa;
	}
    public Iterator<Pelikula> getIteradorea(){
        return this.map.values().iterator();
    }
	public Pelikula bilatuPelikula(String pIzenburua){
		Pelikula pelikula = null;
		if (this.map.containsKey(pIzenburua)){
			pelikula=this.map.get(pIzenburua);
		}
		return pelikula;
    }
    public ListaAktore aktoreakBueltatu(String pIzenburua)
    {
        ListaAktore Aktoreak = null;
        if (this.map.containsKey(pIzenburua))
        {
            Aktoreak = this.map.get(pIzenburua).getCasting();
        }
        return Aktoreak;
    }
    public void gehituPelikula(Pelikula pPelikula){
		if(this.bilatuPelikula(pPelikula.getIzenBurua())==null){
			this.map.put(pPelikula.getIzenBurua(),pPelikula);
		}
	}
    public void pelikularenUrteaAldatu(int pEstrenaldia, String pIzenburua){
        if(bilatuPelikula(pIzenburua)!=null){
            Pelikula pelikula = bilatuPelikula(pIzenburua);
            pelikula.estreinaldiaAldatu(pEstrenaldia);
        }

    }
    public void PelikulakTxtanSartu(){
		FileWriter fitxategia = null;	
		try {
			fitxategia = new FileWriter("FitxategiaPelikulak.txt");
            Iterator<String> it = PelikulaKatalogoa.getListaPelikula().map.keySet().iterator();
            String lerroa = null;
			while (it.hasNext()) {
				lerroa = it.next();

                fitxategia.write(lerroa + " &&& " + "\n");
                this.map.get(lerroa).getCasting().inprimatu();
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