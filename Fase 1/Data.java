public class Data
{
    /**
     * Declaração de variáveis
     */
    private int day;
    private int month;
    private int year;
    
    /**
     * Construtores
     */
    public Data() {
        this.day=1;
        this.month=1;
        this.year=2000;
    }
    
    public Data(int day, int month, int year) {
        this.day=day;
        this.month=month;
        this.year=year;
    }
    
    public Data(Data d) {
        this.day=d.getDay();
        this.month=d.getMonth();
        this.year=d.getYear();
    }
    
    /**
     * Getters
     */
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
     * Equals
     */
    public boolean equals(Data d) {
        if(this.day==d.getDay() && this.month==d.getMonth() && this.year==d.getYear()) return true;
        else return false;
    }
    
    /**
     * Clone
     */
    public Data clone() {
        return new Data(this);
    }
    
    /**
     * ToString
     */
    public String toString() {
        return new String(this.day+ "/" +this.month+ "/" +this.year);
    }
}
