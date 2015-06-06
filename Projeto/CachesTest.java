import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;


public class CachesTest
{
    private Caches c;

    /**
     * Default constructor for test class EmpresaZecaTest
     */
    public CachesTest()
    {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     * Inicializa a variável de instância c antes de cada teste
     */
    @Before
    public void setUp()
    {
        c = new Caches();
        Coordenadas coord1 = new Coordenadas(10,10);
        MicroCache c1 = new MicroCache(coord1);
        Coordenadas coord2 = new Coordenadas(12,12);
        MicroCache c2 = new MicroCache(coord2);
        Coordenadas coord3 = new Coordenadas(14,14);
        MicroCache c3 = new MicroCache(coord3);
        
        c.add(c1);
        c.add(c2);
        c.add(c3);
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
     * Testar a existencia ou não de uma Cache.
     */
    @Test
    public void inserir_existe()
    {
       Coordenadas coordA = new Coordenadas(4,4);
       MicroCache cA = new MicroCache(coordA);
        
       c.add(cA);
        //existente
        //se o método existe retornar "false" para uma cache existente, este teste falha
        assertTrue(c.existe(cA));
       //Se for retornado um nulo no método get, este teste falha
       assertNotNull(c.getCache(coordA));
       //inexistente
       //a cache com coordenadas cA2 não existe, se retornar true, o teste falha
       Coordenadas coordA2 = new Coordenadas(11,4);
       MicroCache cA2 = new MicroCache(coordA2);
       assertFalse(c.existe(cA2));
    }

    /**
     * Teste de adicionar e remover.
     */
    @Test
     public void testeAddRemove(){
         Coordenadas aux = new Coordenadas(1,1);
         assertFalse(c.existe(aux));
         
         Coordenadas coordB = new Coordenadas(3,3);
         MicroCache cB = new MicroCache(coordB);
       
         c.add(cB);
         
         assertTrue(c.existe(cB));
         
         c.remove(cB);
         
         assertFalse(c.existe(cB));
     }

     /**
     * Teste de consulta
     */
    @Test
     public void testGet() {
       Coordenadas coordC = new Coordenadas(2,2);
       MicroCache cC = new MicroCache(coordC);
       c.add(cC);
         
       MicroCache cD = (MicroCache) c.getCache(coordC);
       assertTrue(c.existe(cD));
    }
 
    /**
     * Teste de clones na consulta
     */
    @Test
     public void testClone() {
       Coordenadas coordE = new Coordenadas(7,7);
       MicroCache cE = new MicroCache(coordE);
       c.add(cE);
         
       MicroCache f = (MicroCache) c.getCache(coordE);
       assertNotSame(cE,f);
       assertEquals(cE,f); 
    }
}


