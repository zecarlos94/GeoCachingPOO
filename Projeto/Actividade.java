
/**
 * Abstract class Actividade - Serve como base para as actividades: adicionar cache,adicionar amigo,adicionar cache
 * 

 */
public abstract class Actividade
{
    protected Timeline time; // Hora em que se deu a actividade
    protected String nome; // Nome do user que gerou a actividade

    public Actividade()
    {
        time = new Timeline();  //Cria a actividade com a hora do sistema
        nome = "N/A";
    }
    
    /**
     *  Cria uma actividade com o nome do individuo que gerou a actividade com as horas do sistema 
     */
    
    public Actividade(String nome)
    {
        time = new Timeline();
        nome = nome;
    }
    
    public Actividade(Timeline time,String nome)
    {
        this.time = time;
        this.nome = nome;
    }
    
    public Actividade(Actividade a)
    {
        time = a.getTime();
        nome = a.getNome();
    }
    
    public Timeline getTime()
    { return time;}
    
    public String getNome()
    {
        return this.nome;
    }
    
    public abstract String getAcontecimento();
    
    public void setTime(Timeline t)
    { this.time = t;}
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String toString()
    { 
        StringBuilder sb = new StringBuilder();
        sb.append( time.toString() + nome );
        return sb.toString();
     }
    
    public boolean equals(Object obj)
    {
      if(this == obj) return true;  // é o próprio
      if((obj == null) || (this.getClass() != obj.getClass())) return false;
      return(this.time.equals(  ( (Actividade) obj).getTime())  );
    }
    
}
