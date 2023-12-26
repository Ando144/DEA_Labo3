package DEA_Labo4;

public class Aktorea {
private String izenAbizena;
private ListaPelikula pelikulak;
    public Aktorea(String pIzenAbizena) {
        this.izenAbizena=pIzenAbizena;
        this.pelikulak = new ListaPelikula();
    }
    public String getIzenAbizena() {
        return this.izenAbizena;
    }
    public ListaPelikula getListaPelikula() {
        return this.pelikulak;
    } 
    public void gehituPelikula(Pelikula pPelikula) {//Hemn pelikula bat gehitzen diogu aktore bati
        this.pelikulak.gehituPelikula(pPelikula);
    }
 
}
