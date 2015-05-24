

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste CachesTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class CachesTest
{

    private Caches cs;

    /**
     * Construtor default para a classe de teste CachesTest
     */
    public CachesTest()
    {
    }


    /**
     * Sets up the test fixture.
     * Called before every test case method.
     * Inicializa a variável de instância mEmpresa antes de cada teste
     */
    @Before
    public void setUp()
    {

        cs=new Caches();
        MultiCache m1 = new MultiCache();
        MisteryCache m2 = new MisteryCache();
        MicroCache m3 = new MicroCache();
        cs.add(m1);
        cs.add(m2);
        cs.add(m3);
        cs.add(new MultiCache());
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
     * 
     * Para falhar: alterar o método existe() para retornar sempre false (ou true)
     * Alternativamente, alterar o método get() para retornar sempre null
     */
    @Test
    public void inserir_existe()
    {
        MultiCache mma = new MultiCache();
        cs.add(mma);
        //existente
        //se o método existe retornar "false" para uma cache existente, este teste falha
        assertTrue(cs.existe(mma));
        //Se for retornado um nulo no método get, este teste falha
        assertNotNull(u.get(mma));
        //inexistente
        //a cache abc não existe, se retornar true, o teste falha
        assertFalse(cs.existe(abc));
         //da mesma forma, o teste falha se retornar algo que não null
        assertNull(u.get(abc));
    }

    /**
     * Teste de adicionar e remover.
     * 
     * Para falhar: comentar o put em add(), ou, remove em remove()
     */
    @Test
    public void testeAddRemove(){
        assertFalse(cs.existe(abc));
        cs.add(new MicroCache(abc));/*inserir abc*/
        assertTrue(cs.existe(abc));
        cs.remove(abc);
        assertFalse(cs.existe(abc));
    }

    /**
     * Teste de consulta
     * 
     * Para falhar: alterar o return de get() para "return null"
     */
    @Test
    public void testGet() {
        Cache n = new Cache(poo);
        assertNull(cs.get(poo));
        cs.add(n);
        Cache n2 = cs.get(poo);
        assertNotNull(n2);
    }

    /**
     * Teste de consulta
     * 
     * Para falhar: alterar o return de getCaches() para "return null"
     */
    @Test
    public void testGet() {
        HashMap<Coordenadas,Cache> a = new HashMap<Coordenadas,Cache>();
        a=cs.getCaches();
        assertNotNull(a);

    }
    /**
     * Teste de clones na consulta
     * 
     * Para falhar: comentar o clone em get() e em add()
     */
    @Test
    public void testClone() {
        MicroCache n = new MicroCache(abc);/*inserir abc*/
        cs.add(n);
        Cache t = cs.get(abc);/*Devolve so 1 cache*/
        assertNotSame(n,t);
        assertEquals(n,t);
    }

}
