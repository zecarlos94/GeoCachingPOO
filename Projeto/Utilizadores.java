import java.util.*;
/**
 *  Estrutura com todos os Utilizadores
 *
 */
public class Utilizadores
{
    HashMap<String, Utilizador> utilizadores;
    /**
     * Constructor for objects of class Utilizadores
     */
    public Utilizadores()
    {
        utilizadores = new HashMap<String,Utilizador>();
    }

    public Utilizadores(HashMap<String,Utilizador> utilizadores)
    {
        setUtilizadores(utilizadores);
    }
    
    public Utilizadores(Utilizadores u)
    {
        utilizadores = u.getUtilizadores();
    }
    
    public HashMap<String,Utilizador> getUtilizadores()
    {
        HashMap<String,Utilizador> resultado = new HashMap<String,Utilizador>();
        Iterator<Map.Entry<String,Utilizador>> it = utilizadores.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Utilizador> elem = it.next();
            resultado.put(elem.getKey(),elem.getValue().clone());
        }
        return resultado;
        
    }
    
    public void setUtilizadores(HashMap<String,Utilizador> utilizadores)
    {
        HashMap<String,Utilizador> resultado = new HashMap<String,Utilizador>();
        Iterator<Map.Entry<String,Utilizador>> it = utilizadores.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Utilizador> elem = it.next();
            resultado.put(elem.getKey(),elem.getValue().clone());
        }
        this.utilizadores = resultado;
  
    }
    
    /**
     *  Adiciona um utilizador
     */
    public void add(Utilizador u)
    {
        utilizadores.put(u.getEmail(),u.clone());
    }
    /**
     *  Remove um utilizador
     */
    public void remove(Utilizador u)
    {
        utilizadores.remove(u.getEmail());
    }
    
    public Utilizador get(String email)
    {
        return utilizadores.get(email).clone();
    }
    
    /**
     *  Verifica se existe o utilizador
     */
    public boolean existe(Utilizador u)
    {
        return utilizadores.containsKey(u.getEmail());
    }
    
    public boolean existe(String email)
    {
        return utilizadores.containsKey(email);
    }
    
    
    public Utilizadores clone()
    {
        return new Utilizadores(this);
    }
    
    public boolean equals(Object obj)
    {
       if(this == obj) return true;  // é o próprio
       if((obj == null) || (this.getClass() != obj.getClass())) return false;
      Utilizadores c = (Utilizadores) obj;
      return this.utilizadores.equals(c.getUtilizadores());
    }
}
