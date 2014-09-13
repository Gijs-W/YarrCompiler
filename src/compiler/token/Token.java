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
    public final TokenType type;
    
    /**
     * Token value
     */
    public final String value;
    
    public final int lineNr;
    
    /**
     * Position in lineNr;
     */
    public final int position;
    
    public final int level;
    
    private Token partner;

    public Token(TokenType type, String value, int lineNr, int position, int level) {
        super();
        this.type = type;
        this.value = value;
        this.lineNr = lineNr;
        this.position = position;
        this.level = level;
    }

    public Token getPartner() {
        return partner;
    }

    public void setPartner(Token partner) {
        this.partner = partner;
    }
    
    @Override
    public String toString() {
        return value + " | line: " + lineNr + " | pos " + position + " | level: " + level + " | " + type;
    }
    
    
}
