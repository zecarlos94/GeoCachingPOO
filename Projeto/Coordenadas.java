import java.lang.Math.*;

public class Coordenadas
{
    /**
     *  Variável de classe para calcular distancia entre 2 pontos
     */
    double earthRadius = 3958.75;
    
    /**
     * Variáveis de Instância
     */
    private double latitude; /* mudar para double ( Parte inteira graus ,  resto minutos decimais)*/
    private double longitude;
    /*throws NumberFormatException*/
    
    public Coordenadas() {
        this.latitude= 0;
        this.longitude=0;
    }
    
    public Coordenadas(double latitude, double longitude) throws NumberFormatException {
        this.latitude= latitude;
        this.longitude= longitude;
    }
    
    public Coordenadas(Coordenadas c) {
        this.latitude=c.getLatitude();
        this.longitude=c.getLongitude();
    }
    
    /**
     * Getters e Setters
     */
    public double getLatitude() {
        return this.latitude;
    }
    
    public double getLongitude() {
        return this.longitude;
    }
    
    public void setLatitude(double latitude) throws NumberFormatException {
        this.latitude=latitude;
    }
    
    public void setLongitude(double longitude) throws NumberFormatException {
        this.longitude=longitude;
    }
    
    /**
     *  Fazer funçao de scan de coordenadas???
     */
    
    /**
    *Calcular a distancia entre 2 coordenadas   
    */
    public double distance(Coordenadas b) throws NumberFormatException {
      double lat2 = b.getLatitude();
      double lng2 = b.getLongitude();
             
      double dLat = ToRadians(lat2-this.latitude);
      double dLng = ToRadians(lng2-this.longitude);
      double a = Math.sin(dLat/2) * Math.sin(dLat/2) + 
             Math.cos(ToRadians(this.latitude)) * Math.cos(ToRadians(lat2)) * 
             Math.sin(dLng/2) * Math.sin(dLng/2);
      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
      double dist = earthRadius * c;
      double meterConversion = 1609.00;
      return dist * meterConversion;
    }
 
    public double ToRadians(double degrees) throws NumberFormatException {
       double radians = degrees * (3.1415926535897932385) / 180;
       return radians;
    }

    /*
     * Calcula o bearing entre 2 Coordenadas
     * 
     */
    public double bearing(double lat1, double lon1, double lat2, double lon2) throws NumberFormatException {
        double longitude1 = lon1;
        double longitude2 = lon2;
        double latitude1 = Math.toRadians(lat1);
        double latitude2 = Math.toRadians(lat2);
        double longDiff= Math.toRadians(longitude2-longitude1);
        double y= Math.sin(longDiff)*Math.cos(latitude2);
        double x=Math.cos(latitude1)*Math.sin(latitude2)-Math.sin(latitude1)*Math.cos(latitude2)*Math.cos(longDiff);
        return (Math.toDegrees(Math.atan2(y, x))+360)%360;
    }
    
    /*
     * Calcula as Coordenadas de Destino
    */
    public Coordenadas getDestination(double distance, double bearing) throws NumberFormatException {
		double d = distance / earthRadius;
		double lat1 = Math.toRadians(this.latitude);
		double lon1 = Math.toRadians(this.longitude);
		double lat = Math.asin((Math.sin(lat1) * Math.cos(d))
				+ (Math.cos(lat1) * Math.sin(d) * Math.cos(Math
						.toRadians(bearing))));

		double lon = lon1
				+ Math.atan2(Math.sin(Math.toRadians(bearing)) * Math.sin(d)
						* Math.cos(lat1),
						Math.cos(d) - Math.sin(lat1) * Math.sin(lat));
		return new Coordenadas(Math.toDegrees(lat),Math.toDegrees(lon));
	}
    
    /**
     * Métodos auxiliares
     */
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Coordenadas c = (Coordenadas) obj;
      return(this.latitude == c.getLatitude() && this.longitude == c.getLongitude());
    }
   
    public String toString(){
     return new String("Latitude: " +this.latitude+ ", Longitude: " +this.longitude);
    }
     
    public Coordenadas clone(){
      return new Coordenadas(this);
    }
    
    public int hashCode() {
       return this.toString().hashCode();
   }
}
