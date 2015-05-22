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
    
    //fazer funçao de hash
}
