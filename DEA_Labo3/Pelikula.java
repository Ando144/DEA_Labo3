package DEA_Labo3;

public class Pelikula
{
    private String IzenBurua;
    private int Estreinaldia;
    //preguntar si esto es ListaAktore(como yo he cambiado) o AktoreKatalogoa
    private ListaAktore casting;

    public Pelikula (String pIzenBurua, int pEstrenaldia){
        this.IzenBurua=pIzenBurua;
        this.Estreinaldia=pEstrenaldia;
        this.casting= new ListaAktore();
    }
    public void aktoreaSartu(Aktorea pAktorea){
        this.casting.gehituAktorea(pAktorea);
    }
    
    public void aktoreaEzabatu(Aktorea pAktorea){
        this.casting.ezabatuAktorea(pAktorea);
    }
    public String getIzenBurua(){
        return this.IzenBurua;
    }

    public int getEstrenaldia(){
        return this.Estreinaldia;
    }
    public boolean badagoAktorea(Aktorea pAktorea){
        return this.casting.AktoreaBadago(pAktorea);
    }

    public ListaAktore getCasting(){
        return this.casting;
    }

    public void setEstrenaldia(int pEstrenaldia){
        this.Estreinaldia=pEstrenaldia;
    }
    //cambiar el estreinaldia
    public void estreinaldiaAldatu(int pEstrenaldia){
        this.Estreinaldia=pEstrenaldia;
    }
    //lo que falta: sumar un aktor a la lista y se haria en listaktorea
}