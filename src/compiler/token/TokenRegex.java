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
     * @todo refactor to enum for better readability?
     */
    public final int token;

    public TokenRegex(Pattern regex, int token) {
        super();
        this.regex = regex;
        this.token = token;
    }
}
