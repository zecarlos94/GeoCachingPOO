import java.util.*;

public class geraMicroCache
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
}