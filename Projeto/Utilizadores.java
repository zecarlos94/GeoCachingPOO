import java.util.*;
/**
 *  Estrutura com todos os Utilizadores
 *
 */
public class Utilizadores
{
    /**
     * Variaveis de classe para gerar Actividades
     */
    
     
        private String removeu ="removeu"; // Ambas são para quando um utilizador remover/adicionar um amigo ou uma cache 
        private String adicionou ="adicionou"; 
        private String descobriu ="descobriu"; // Serve para descobertas de caches
            // Construtores uteis para gerar Actividades
        //public ActividadeAmigo(String nome,String amigo,String acontecimento) -> Actividade, basta fazer toString
        //public ActividadeCache(String nome,Cache cache,String acontecimento) -> Actividade -> toString
        //Ambas usam a hora do sistema
        
    
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
    
    public Iterator<Map.Entry<String,Utilizador>> iterator()
    {   return this.utilizadores.entrySet().iterator(); }
    
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
     * Adiciona como amigos os dois utilizadores, actualizando a lista de amizades e activadades dos perfis dos mesmos
     *  
     */
    
    public void addAmizade(String email1,String email2) throws AmizadeExisteException
    {
        Utilizador utilizador1 = utilizadores.get(email1);
        Utilizador utilizador2 = utilizadores.get(email2);
        if( utilizador1.getAmigos().contains(email2) )
            throw new AmizadeExisteException();
        else{
        utilizador1.addAmigo(email2);
        utilizador2.addAmigo(email1);
        
        utilizador1.addActividade(utilizador2.getNome(),adicionou);
        utilizador2.addActividade(utilizador2.getNome(),adicionou);
        }
    }
      /**
     *  Apaga o estatudo de amizade dos dois utilizadores, actualizando a lista de amizades e activadades dos perfis dos mesmos
     *  
     */
    
    public void removeAmizade(String email1,String email2)
    {
        Utilizador utilizador1 = utilizadores.get(email1);
        Utilizador utilizador2 = utilizadores.get(email2);
        
        utilizador1.removeAmigo(email2);
        utilizador2.removeAmigo(email1);
        
        utilizador1.addActividade(utilizador2.getNome(),removeu);
        utilizador2.addActividade(utilizador2.getNome(),removeu);
        
    }
    
    
    /**
     *  Gera e adiciona uma actividade de descoberta ao utilizador
     */
    
    public void descobertaCache(String email,Cache cache,int geocoins)
    {
        Utilizador utilizador = utilizadores.get(email);
        utilizador.descobertaCache(cache,geocoins);
    }
   
    /**
     *  Adiciona uma cache à lista de caches do utilizador
     */
    
    public void addCache(String email, Cache cache)
    {
        utilizadores.get(email).addCache(cache);
    }
   
    /**
     *  Remove uma cache à lista de caches do utilizador
     */
    
    public void removeCache(String email, Cache cache)
    {
        utilizadores.get(email).removeCache(cache);
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
