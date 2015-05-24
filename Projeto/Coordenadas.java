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
    private double latitude; // mudar para double ( Parte inteira graus ,  resto minutos decimais)
    private double longitude;
    
    public Coordenadas() {
        this.latitude= 0;
        this.longitude=0;
    }
    
    public Coordenadas(double latitude, double longitude) {
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
    
    public void setLatitude(double latitude) {
        this.latitude=latitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude=longitude;
    }
    
    /**
     *  Fazer funçao de scan de coordenadas???
     */
    
    /**
    *Calcular a distancia entre 2 coordenadas   
    */
    public double distance(Coordenadas b) {
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
 
    public double ToRadians(double degrees) 
    {
       double radians = degrees * (3.1415926535897932385) / 180;
       return radians;
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
