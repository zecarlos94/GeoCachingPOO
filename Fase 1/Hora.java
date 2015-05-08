import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Hora
{
   private int hora;
   private int minuto;
   private int segundo;
   
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
   
   
}
