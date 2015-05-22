public class Coordenadas
{
    /**
     * Variáveis de Instância
     */
    private String latitude;
    private String longitude;
    
    public Coordenadas() {
        this.latitude="N/A";
        this.longitude="N/A";
    }
    
    public Coordenadas(String latitude, String longitude) {
        this.latitude=latitude;
        this.longitude=longitude;
    }
    
    public Coordenadas(Coordenadas c) {
        this.latitude=c.getLatitude();
        this.longitude=c.getLongitude();
    }
    
    /**
     * Getters e Setters
     */
    public String getLatitude() {
        return this.latitude;
    }
    
    public String getLongitude() {
        return this.longitude;
    }
    
    public void setLatitude(String latitude) {
        this.latitude=latitude;
    }
    
    public void setLongitude(String longitude) {
        this.longitude=longitude;
    }
    
    /**
     *  Fazer funçao de scan de coordenadas???
     */
    
  
    
    
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
}
