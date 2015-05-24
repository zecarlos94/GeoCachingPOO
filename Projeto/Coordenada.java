import static java.lang.Math.abs;

public class Coordenada {

   private double latitude;
   private double longitude;

   public Coordenada(){ 
      latitude = 0; 
      longitude = 0; 
   }

   public Coordenada(double clat, double clong){ 
      latitude = clat; 
      longitude = clong; 
   }

   public Coordenada(Coordenada p){
      latitude = p.getLatitude();
      longitude = p.getLongitude(); 
   }

   
   public double getLatitude(){
       return latitude; 
   }
   
   public double getLongitude(){ 
       return longitude; 
   }
   

   public void setLatitude(double l){
       this.latitude=l; 
   }
   
   public void setLongitude(double l){ 
       this.longitude=l; 
   }
   
   public boolean equals(Object obj) {
      if(this == obj) return true;  
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Coordenada p = (Coordenada) obj;
      return (latitude == p.getLatitude() && longitude == p.getLongitude());
    }
   
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("A latitude é ");
      sb.append(this.latitude+"\n");
      sb.append("A longitude é ");
      sb.append(this.longitude+"\n");
      return sb.toString();
   }
   
   public Coordenada clone(){ 
      return new Coordenada(this);
   }   
}

