import java.util.*;

public class geraMultiCache
{

 public static Coordenadas geraCoordenadas() {
 	return new Coordenadas(geraLatitude(),geraLongitude());
 }

 public static Double geraLatitude() {
    Random rn = new Random();
    double latitude = rn.nextDouble();
    return latitude;
  }

  public static Double geraLongitude() {
    Random rn = new Random();
    double longitude = rn.nextDouble();
    return longitude;
  }

  public ArrayList<Coordenadas> criaCheckpoints(Coordenadas cd){
        Random rn = new Random();
        int quantos,i;
        quantos=rn.nextInt(3)+1;
        ArrayList<Coordenadas> checkps = new ArrayList<Coordenadas>(quantos);
        double latitude_aux= cd.getLatitude() ;
        double longitude_aux= cd.getLongitude() ;
        double factor=0.0001; // aprox 11 metros
        for(i=0;i<quantos;i++){
            latitude_aux+= factor;
            longitude_aux+= factor;
            Coordenadas cp = new Coordenadas(latitude_aux,longitude_aux);
            checkps.add(cp);
        }
        return checkps;
    }  

}