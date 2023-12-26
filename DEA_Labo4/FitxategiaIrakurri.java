package DEA_Labo4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FitxategiaIrakurri {
    public static void main(String[] args) {
    int urtea = 1970;
    // Especifica la ruta del archivo que deseas cargar
    while (urtea < 2023){
        String rutaArchivo = "C:\\Users\\andon\\Desktop\\Universidad\\DEA\\DEA_Labo3\\DEA_Labo3\\Pelikulak\\actors_and_films_" + urtea + ".txt";

        try {
            // Crea un objeto Scanner para leer el archivo
            Scanner entrada = new Scanner(new FileReader(rutaArchivo));
        
            // Lee el archivo línea por línea
            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                //separar la linea en 4 partes separadas por "###"
                String[] partes = linea.split("###");
                String akt = partes[1];
                String peli = partes[3];
                Aktorea aktoreBerria = new Aktorea(akt);
                Pelikula peliBerria = new Pelikula(peli, urtea);
                //ver si el actor esta en AktoreKatalogoa
                if (AktoreKatalogoa.getListaAktore().bilatuAktorea(akt) == null)
                {
                    //si no esta, crear un nuevo actor y añadirlo a AktoreKatalogoa
                    //Aktorea aktoreBerria = new Aktorea(akt);
                    AktoreKatalogoa.getListaAktore().gehituAktorea(aktoreBerria);
                }
                //ver si la pelicula esta en PelikulaKatalogoa
                if (PelikulaKatalogoa.getListaPelikula().bilatuPelikula(peli) == null)
                {
                    //si no esta, crear una nueva pelicula y añadirla a PelikulaKatalogoa
                    //aqui hay que crear nueva pelikula con su año de estreno y su nombre
                    //el año lo para crear la pelikula lo sacamos del indice que vamos a crear hasta llegar hasta 2023
                    //Pelikula peliBerria = new Pelikula(peli, urtea);
                    PelikulaKatalogoa.getListaPelikula().gehituPelikula(peliBerria);
                }
                //habria que ir tambien metiendo los aktores en las pelikulas y las pelikulas en los aktores y de esa manera llenariamos los hashmaps
                if((AktoreKatalogoa.getListaAktore().bilatuAktorea(akt) != null)&&(PelikulaKatalogoa.getListaPelikula().bilatuPelikula(peli) != null)){
                aktoreBerria.gehituPelikula(peliBerria);
                peliBerria.aktoreaSartu(aktoreBerria);
                }
            }
            urtea++;
            
            // Cierra el Scanner después de la lectura
            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    System.out.println("acabó");
}

}
