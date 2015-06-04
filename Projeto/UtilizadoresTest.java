import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * A classe de teste UtilizadoresUnity.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class UtilizadoresTest
{
    private Utilizadores u;    
    private Timeline tn;                                    
    private TreeMap<Timeline, Actividade> act; 
    private HashMap<String, Integer> stat;
    private ArrayList<String> amgs;    
    private Caches mc;
    
/*
    Timeline tn2=new Timeline();
    TreeMap<Timeline, Actividade> act=new TreeMap<Timeline, Actividade>();
    HashMap<String, Integer> stat=new HashMap<String, Integer>();
    ArrayList<String> amgs=new ArrayList<String>();
    Caches mc = new Caches();
    Utilizadores u = new Utilizadores();
  */ 
    public UtilizadoresTest()
    {
    }

    @Before
    public void setUp()
    {
        
        Utilizador a = new Utilizador("POO@uminho.pt","123456","Grupo 46",'M',"Rua em Gualtar",tn,act,stat,amgs,mc);
        Utilizador b = new Utilizador("poo@uminho.pt","789012","Grupo 45",'F',"Rua em Frossos",tn,act,stat,amgs,mc);
        Utilizador c = new Utilizador("um@uminho.pt","999999","Grupo 12",'M',"Rua em Azurem",tn,act,stat,amgs,mc);
        Utilizador d = new Utilizador("uminho@uminho.pt","674532","Grupo 90",'F',"Rua ...",tn,act,stat,amgs,mc);
        u.add(a);
        u.add(b);
        u.add(c);
        u.add(d);
    }

    
    @After
    public void tearDown()
    {
    }

    /**
     * Testar a existencia ou não de um Utilizador
     * 
     * Para falhar: alterar o método existeUtilizador() para retornar sempre false (ou true)
     * Alternativamente, alterar o método getUtilizador() para retornar sempre null
     */
    @Test
    public void inserir_existe()
    {
        Utilizador e = new Utilizador("poo@gmail.pt","187302","LEI",'M',"Rotunda",tn,act,stat,amgs,mc);
        u.add(e);
         //existente
        //se o método existe retornar "false" para um utilizador existente, este teste falha
        assertTrue(u.existe("poo@gmail.pt"));
        //Se for retornado um nulo no método get, este teste falha
        assertNotNull(u.get("poo@gmail.pt"));
        //inexistente
        //o utilizador com o código "-1" não existe, se retornar true, o teste falha
        assertFalse(u.existe("-1"));
        //da mesma forma, o teste falha se retornar algo que não null
        assertNull(u.get("-1"));
    }

    /**
     * Teste de adicionar e remover.
     * 
     * Para falhar: comentar o put em add(), ou, remove em remove()
     */
    @Test
    public void testeAddRemove(){
        assertFalse(u.existe("ABC"));
        Utilizador u1 = new Utilizador("ABC","poo","POO","M","Rua",tn,act,stat,amgs,mc);
        u.add(u1);
        assertTrue(u.existe("ABC"));
        U.remove(u1);
        assertFalse(u.existe("ABC"));
    }

    /**
     * Teste de consulta
     * 
     * Para falhar: alterar o return de get() para "return null"
     */
    @Test
    public void testGet() {
        Utilizador u1 = new Utilizador();
        assertNull(u.get(u1.getEmail()));
        u.add(u1);
        Utilizador u2 = u.get(u1.getEmail());
        assertNotNull(u2);
    }

    /**
     * Teste de clones na consulta
     * 
     * Para falhar: comentar o clone em get() e em add()
     */
    @Test
    public void testClone() {
        Utilizador u1 = new Utilizador();
        u.add(u1);
        Utilizador u2 = u.get(u1.getEmail());
        assertNotSame(u1,u2);
        assertEquals(u1,u2);
    }
}