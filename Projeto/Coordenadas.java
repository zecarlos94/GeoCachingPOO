import java.lang.Math.*;

public class Coordenadas
{
    /**
     * Variáveis de Instância
     */
    private Coordenada latitude; // mudar para double ( Parte inteira graus ,  resto minutos decimais)
    private Coordenada longitude;
    
    public Coordenadas() {
        this.latitude= new Coordenada();
        this.longitude=new Coordenada();
    }
    
    public Coordenadas(Coordenada latitude, Coordenada longitude) {
        this.latitude= new Coordenada(latitude);
        this.longitude= new Coordenada(longitude);
    }
    
    public Coordenadas(Coordenadas c) {
        this.latitude=c.getLatitude();
        this.longitude=c.getLongitude();
    }
    
    /**
     * Getters e Setters
     */
    public Coordenada getLatitude() {
        return this.latitude;
    }
    
    public Coordenada getLongitude() {
        return this.longitude;
    }
    
    public void setLatitude(Coordenada latitude) {
        this.latitude=latitude;
    }
    
    public void setLongitude(Coordenada longitude) {
        this.longitude=longitude;
    }
    
    /**
     *  Fazer funçao de scan de coordenadas???
     */
    
    /**
    *Calcular a distancia entre 2 coordenadas   
    */
    public void CoorDistance(Coordenada a,Coordenada b) {
        int distance;
        
    }
 
    public double ToRadians(double degrees) 
    {
       double radians = degrees * (3.1415926535897932385) / 180;
       return radians;
    }

    public double DirectDistance(double lat1, double lng1, double lat2, double lng2) 
    {
      double earthRadius = 3958.75;
      double dLat = ToRadians(lat2-lat1);
      double dLng = ToRadians(lng2-lng1);
      double a = Math.sin(dLat/2) * Math.sin(dLat/2) + 
             Math.cos(ToRadians(lat1)) * Math.cos(ToRadians(lat2)) * 
             Math.sin(dLng/2) * Math.sin(dLng/2);
      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
      double dist = earthRadius * c;
      double meterConversion = 1609.00;
      return dist * meterConversion;
    }
    
    /**
     * Métodos auxiliares
     */
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Coordenadas c = (Coordenadas) obj;
      return(this.latitude.equals(c.getLatitude()) && this.longitude.equals(c.getLongitude()));
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
