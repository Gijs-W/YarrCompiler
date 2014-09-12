package compiler.token;

import java.util.regex.Pattern;

/**
 * Token Regex
 * 
 * Used to extract tokens from a string based on the regex in this class
 * 
 * @author Gijs
 */
public class TokenRegex {
    
    /**
     * Regex
     * 
     * If the token matches with this, it is a valid token
     */
    public final Pattern regex;
    
    /**
     * Token type
     * 
     */
    public final TokenType type;

    public TokenRegex(Pattern regex, TokenType type) {
        super();
        this.regex = regex;
        this.type = type;
    }
}
