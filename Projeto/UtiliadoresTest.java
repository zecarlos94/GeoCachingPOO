import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;


public class UtilizadoresTest
{
    private Utilizadores m;

    /**
     * Default constructor for test class EmpresaZecaTest
     */
    public UtilizadoresTest()
    {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     * Inicializa a variável de instância m antes de cada teste
     */
    @Before
    public void setUp()
    {
        m = new Utilizadores();
        Timeline timeline_nascimento1 = new Timeline(1, 5, 30, 14, 1, 1994);
        Utilizador u1 = new Utilizador("ze1994@poo.di.uminho.pt", "123456", "José", 'M', "Rua em Gualtar",timeline_nascimento1);
        Timeline timeline_nascimento2 = new Timeline(13, 17, 15, 29, 5, 1995);
        Utilizador u2 = new Utilizador("gustavo@poo.di.uminho.pt", "pass", "Gustavo", 'M', "Rua em Real",timeline_nascimento2);
        Timeline timeline_nascimento3 = new Timeline(19, 45, 55, 2, 12, 1995);
        Utilizador u3 = new Utilizador("tigas95o@poo.di.uminho.pt", "password", "Tiago", 'M', "Rua qualquer",timeline_nascimento3);
        
        m.add(u1);
        m.add(u2);
        m.add(u3);
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     * 
     * Não precisamos de fazer nada depois dos testes executarem
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Testar a existencia ou não de um empregado.
     */
    @Test
    public void inserir_existe()
    {
        Timeline timeline_nascimentoA = new Timeline(12, 8, 36, 22, 7, 2010);
        Utilizador a = new Utilizador("maria@gmail.com", "porto", "Maria", 'F', "Rua",timeline_nascimentoA);
        
        m.add(a);
        //existente
        //se o método existe retornar "false" para um utilizador existente, este teste falha
        assertTrue(m.existe(a));
       //Se for retornado um nulo no método get, este teste falha
       assertNotNull(m.get(a.getEmail()));
       //inexistente
       //o utilizador com o mail "-1" não existe, se retornar true, o teste falha
       assertFalse(m.existe("-1"));
    }
    
    /**
     * Teste de adicionar e remover.
     */
    @Test
     public void testeAddRemove(){
         assertFalse(m.existe("mail"));
         Timeline timeline_nascimentoB = new Timeline(15, 13, 56, 12, 9, 2000);
         Utilizador b = new Utilizador("mail", "fcp", "Joana", 'F', "Rua abc",timeline_nascimentoB);
 
         m.add(b);
         
         assertTrue(m.existe("mail"));
         m.remove(b);
         
         assertFalse(m.existe("mail"));
     }

     /**
     * Teste de consulta
     */
    @Test
     public void testGet() {
       Timeline timeline_nascimentoC = new Timeline(18, 23, 16, 30, 10, 2005);
       Utilizador c = new Utilizador("tmp", "scb", "João", 'M', "Rua onde",timeline_nascimentoC);
       m.add(c);       
       Utilizador d = m.get("tmp");
    }
 
    /**
     * Teste de clones na consulta
     */
    @Test
     public void testClone() {
       Timeline timeline_nascimentoE = new Timeline(21, 3, 1, 15, 11, 2014);
       Utilizador e = new Utilizador("poo", "pass123", "Luisa", 'F', "Rua especular",timeline_nascimentoE);
       
       m.add(e);
       
       Utilizador f = m.get("poo");
       assertNotSame(e,f);
       assertEquals(e,f);
    }
}


