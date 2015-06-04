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

  public static ArrayList<Coordenadas> criaCheckpoints(){
        Random rn = new Random();
        int quantos,i;
        quantos=rn.nextInt(3);
        Coordenadas cd=geraCoordenadas();
        ArrayList<Coordenadas> checkps = new ArrayList<Coordenadas>(quantos);
        double latitude_aux=0;
        double longitude_aux=0;
        double factor=0.0001;
        for(i=0;i<quantos;i++){
            latitude_aux = cd.getLatitude() + factor;
            longitude_aux = cd.getLongitude() + factor;
            cd.setLatitude(latitude_aux);
            cd.setLongitude(longitude_aux);
            checkps.add(cd.clone());
        }
        return checkps;
    }  

}