import java.util.*;
import java.text.SimpleDateFormat;
import static java.lang.System.*;
/**
 * Escreva a descrição da classe Timeline aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Timeline
{
    /**
     * Variáveis de Instância
     */
   private int hora;
   private int minuto;
   private int segundo;
   private int day;
   private int month;
   private int year;
   
   
  
   /**
    * Construtores
   */
   
   public Timeline() {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");    
       Calendar calendario = new GregorianCalendar();
       this.hora=calendario.get(Calendar.HOUR_OF_DAY); // 24 horas
       this.minuto=calendario.get(Calendar.MINUTE);
       this.segundo=calendario.get(Calendar.SECOND);
       this.day=calendario.get(Calendar.DAY_OF_MONTH); 
       this.month=(calendario.get(Calendar.MONTH))+1; // Jan = 0, Dezembro = 11
       this.year=calendario.get(Calendar.YEAR);
   }
   
   public Timeline(int hora, int minuto, int segundo,int day, int month, int year) {
       this.hora=hora;
       this.minuto=minuto;
       this.segundo=segundo;
       this.day=day;
       this.month=month;
       this.year=year;
   }
    
   public Timeline(Timeline t) {
       this.hora=t.getHora();
       this.minuto=t.getMinuto();
       this.segundo=t.getSegundo();
       this.day=t.getDay();
       this.month=t.getMonth();
       this.year=t.getYear();
   }
   /**
    *  Construtor específico para Datas de nascimento, variáveis hora minuto e segundo são ignoradas e deixadas a -1 com o propósito de distinguir tempos de datas
    */
   public Timeline(int day, int month,int year)
   {
        this.day=day;
       this.month=month;
       this.year=year;
       
       this.hora=-1;
       this.minuto=-1;
       this.segundo=-1;
       
   }
   
   /**
    * Distingue datas baseadas ,no construtor anterior ,de tempos 
    */
   
   public boolean isData()
   {
       return ( hora ==-1 && minuto == -1 && segundo == -1);
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
    
    public int getDay() {
        return this.day;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public int getYear() {
        return this.year;
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
    
    public void setDay(int day) {
        //deve validar o dia
        if((this.month==1 || this.month==3 || this.month==5 || this.month==7 || this.month==8 || this.month==10 || this.month==12) && day>0 && day<=31) 
            this.day=day; 
        if((this.month==4 || this.month==6 || this.month==9 || this.month==11) && day>0 && day<=30) this.day=day;
        if(this.month==2 && this.year%4==0 && day>0 && day<=29) this.day=day;
        if(this.month==2 && this.year%4!=0 && day>0 && day<=28) this.day=day;
    }
    
    public void setMonth(int month) {
        //deve validar o mês
        if(month>=1 && month<=12) this.month=month;
    }
    
    public void setYear(int year) {
        this.year=year;
    }
    
    /**
     * Clone
     */
    public Timeline clone() {
        return new Timeline(this);
    }
    
    /**
     * Equals
     */
    public boolean equals(Object obj){
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Timeline t = (Timeline) obj;
      return(this.hora==t.getHora() && this.minuto==t.getMinuto() && this.segundo==t.getSegundo() && this.day==t.getDay() && this.month==t.getMonth() && this.year==t.getYear());
    }
    
    /**
     * toString
     */
    public String toString() {
        return new String(this.hora+ ":" +this.minuto+ ":" +this.segundo+ " " +this.day+ "/" +this.month+ "/" +this.year);
    }
    
}
