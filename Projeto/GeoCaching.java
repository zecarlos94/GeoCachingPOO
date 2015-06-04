import java.util.*;
import java.io.*;
/**
 * Classe que contém todas as estruturas contidas na aplicação
 */
public class GeoCaching implements Serializable
{
    Utilizadores utilizadores;
    ArrayList<String> admins;           // Estes nomes são comparados com os emails dos users em isAdmin();
    Caches caches;
    CacheReports reports;
    boolean inscricoesAbertas;
    ArrayList<String>  utilizadoresRegistados;
    int limiteParticipantes;
    
    public GeoCaching() {
        this.utilizadores=new Utilizadores();
        this.admins=new ArrayList<String>(); this.admins.add("Gustavo"); this.admins.add("Zé"); this.admins.add("Tiago"); 
        this.caches=new Caches();
        this.reports=new CacheReports();
        inscricoesAbertas = false;
        utilizadoresRegistados = new ArrayList<String>();
        limiteParticipantes = 0;
    }
    
    public GeoCaching(Utilizadores users, Caches caches, CacheReports reports) {
        this.utilizadores=new Utilizadores(users);
        this.caches=new Caches(caches);
        this.reports=new CacheReports(reports);

    }
    
    public GeoCaching(GeoCaching gc) {
        this.utilizadores=gc.getUtilizadores();
        this.admins=gc.getAdmins();
        this.caches=gc.getCaches();
        this.reports=gc.getReports();
    }
    
    public Utilizadores getUtilizadores() {
        return this.utilizadores.clone();
    }
    
    public ArrayList<String> getAdmins() {
        return this.admins;
    }
    
    public Caches getCaches() {
        return this.caches.clone();
    }
    
    public CacheReports getReports() {
        return this.reports.clone();
    }
    
    public ArrayList<String> getUtilizadoresRegistados() {
        return this.utilizadoresRegistados;
    }
    
    public boolean getInscricoesAbertas() {
        return this.inscricoesAbertas;
    }
    
    public void setInscricoesAbertas(boolean bool) {
        this.inscricoesAbertas = bool;
    }
    public void setLimiteParticipantes(int l){
        this.limiteParticipantes = l;
    }
    
    public void setUtilizadores(Utilizadores u) {
        this.utilizadores=u.clone();
    }
    
    public void setCaches(Caches c) {
        this.caches=c.clone();
    }
    
    public void setReports(CacheReports reports) {
        this.reports=reports.clone();
    }
    
    public boolean equals(Object obj) {
       if(this == obj) return true;  // é o próprio
       if((obj == null) || (this.getClass() != obj.getClass())) return false;
       GeoCaching c = (GeoCaching) obj;
       return(this.utilizadores.equals(c.getUtilizadores()) && this.admins.equals(c.getAdmins()) && this.caches.equals(c.getCaches()) && this.reports.equals(c.getReports()));
    }
    
    public GeoCaching clone() {
        return new GeoCaching(this);
    }
    /**
     *  Criação de conta / signin
     */
    
    public void addUtilizador(Utilizador u){
     utilizadores.add(u);
    }
    /**
     *  Verificação para log in do utilizador ou admin
     */
    
    public boolean contaExiste(String email){
        return utilizadores.existe(email);
    }
    public boolean passwordCerta(String email,String pw){
        Utilizador u = utilizadores.get(email);
        return u.getPassword().equals(pw);
    }
    public boolean isAdmin(String email){
        return admins.contains(email);
    }
    /**
     *  Implementação das possibilidades do utilizador no seu menu
     */
    public Utilizador getUtilizador(String email){
        return utilizadores.get(email);
    }
    // Adiciona uma amizada nos dois perfis
    public void addAmizade(String email1,String email2){
        this.utilizadores.addAmizade(email1,email2);   
    }
    public void removeAmizade(String email1,String email2){
        this.utilizadores.removeAmizade(email1,email2);    
    }
    public void addReport(Report r){
        this.reports.add(r);
    }
    public void addCache(Cache c){
        caches.add(c);
    }
    public void removeCache(Coordenadas c){
        caches.remove(c);
    }
    /**
     *  Opções do evento
     */
    public void registarEvento(String email) throws EventoCheioException {
        
        if ( this.limiteParticipantes >= utilizadoresRegistados.size() )
            throw new EventoCheioException();
        
        else this.utilizadoresRegistados.add(email);
    }
    
}
