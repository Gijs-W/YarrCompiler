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

    public Token(int token, String value) {
        super();
        this.token = token;
        this.value = value;
    }
}
