package compiler.token;

/**
 * Token
 * 
 * @author Gijs
 */
public class Token {
    
    /**
     * Token type
     */
    public final int token;
    
    /**
     * Token value
     */
    public final String value;
    
    public final int lineNr;
    
    /**
     * Position in lineNr;
     */
    public final int position;

    public Token(int token, String value, int lineNr, int position) {
        super();
        this.token = token;
        this.value = value;
        this.lineNr = lineNr;
        this.position = position;
    }
}
