import java.util.*;

public class Hora
{
    /**
     * Variáveis de Instância
     */
   private int hora;
   private int minuto;
   private int segundo;
   
   /**
    * Construtores
    */
   public Hora() {
       this.hora=0;
       this.minuto=0;
       this.segundo=0;
   }
    
   public Hora(int hora, int minuto, int segundo) {
       this.hora=hora;
       this.minuto=minuto;
       this.segundo=segundo;
   }
    
   public Hora(Hora h) {
       this.hora=h.getHora();
       this.minuto=h.getMinuto();
       this.segundo=h.getSegundo();
   }
   
   /**
    * Getters
    */
   public int getHora() {
       return this.hora;
    }
    
    public int getMinuto() {
        return this.minuto;
    }
    
    public int getSegundo() {
        return this.segundo;
    }
    
    /**
     * Setters
     */
    public void setHora(int hora) {
        this.hora=hora;
    }
    
    public void setMinuto(int minuto) {
        this.minuto=minuto;
    }
    
    public void setSegundo(int segundo) {
        this.segundo=segundo;
    }
    
    /**
     * Clone
     */
    public Hora clone() {
        return new Hora(this);
    }
    
    /**
     * Equals
     */
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Hora c = (Hora) obj;
      return(this.hora==c.getHora() && this.minuto==c.getMinuto() && this.segundo==c.getSegundo());
    }
    
    /**
     * toString
     */
    public String toString() {
        return new String(this.hora+ ":" +this.minuto+ ":" +this.segundo);
    }
}
