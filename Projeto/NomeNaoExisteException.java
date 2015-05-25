public class NomeNaoExisteException extends Exception
{
    /**
     * COnstrutor para objetos da classe NomeNaoExisteException
     */
    public NomeNaoExisteException()
    {
        super();
    }

    public NomeNaoExisteException(String str)
    {
       super(str);
    }
}