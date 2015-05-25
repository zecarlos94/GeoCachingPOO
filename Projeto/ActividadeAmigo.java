
/**
 * Write a description of class ActividadeAmigo here.
 * 
 *  Tem como objectivo principal gerar notificaçoes das actividades dos utilizadores quando interagem com um amigo:
 *          
 *   As notificações cobertas por esta classe são adições/remoções de amigos
 *   
 */
public class ActividadeAmigo extends Actividade
{
    // instance variables - replace the example below with your own
    private String amigo;
    
    private String acontecimento; // Acontecimento = "removeu" ou "adicionou"
    
    /**
     * Constructor for objects of class ActividadeAmigo
     * 
     *  Recebe o nome do user, o nome do amigo e a ação(removeu ou adicionou) 
     * 
     *      Cria a actividade com as horas do sistema
     * 
     */
    public ActividadeAmigo(String nome,String amigo,String acontecimento) throws NumberFormatException, StringExisteException
    {
        super(nome);
        this.amigo = amigo;
        this.acontecimento = acontecimento;
    }
    /**
     *  Igual ao anterior mas com horas predefinindas  
     */
    public ActividadeAmigo(Timeline time,String nome,String amigo,String acontecimento) throws NumberFormatException, StringExisteException
    {
        super(time,nome);
        this.amigo = amigo;
        this.acontecimento = acontecimento;
    }
    public ActividadeAmigo( ActividadeAmigo a)
    {
        super(a);
        this.amigo = a.getAmigo();
        this.acontecimento = a.getAcontecimento();
    }
    
    public String getAmigo()
    {   return this.amigo;}
    
    public String getAcontecimento()
    {   return this.acontecimento;}
    
    public ActividadeAmigo clone()
    {   return new ActividadeAmigo(this);   }
    
     /**
     *  Gera string com o seguinte formato:
     *      Tempo
     *          Nome Acontecimento NomeDoAmigo 
     *          
     *          Acontecimento = "removeu" || "adicionou"  
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( super.toString() + " "); 
        sb.append( acontecimento + " " + amigo + "\n");
        return sb.toString();
    }
    
    public ActividadeAmigo Clone()
    {   return new ActividadeAmigo(this);}

}
