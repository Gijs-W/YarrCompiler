package compiler.token;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tokenizes input text
 * 
 * @author Gijs
 */
public class Tokenizer {

    /**
     * Token description list
     * 
     */
    private final LinkedList<TokenRegex> tokenRegex;
    
    
    /**
     * Token result set
     * 
     * List will be empty until tokenize() is called.
     */
    private final LinkedList<Token> tokens;

    /**
     * Constructor
     */
    public Tokenizer() {
        tokenRegex = new LinkedList<>();
        tokens = new LinkedList<>();
    }

    /**
     * Adds a token description
     * 
     * @param regex A valid regex string
     * @param token The token type
     */
    public void add(String regex, int token) {
        tokenRegex.add(new TokenRegex(Pattern.compile("^("+regex+")"), token));
    }

    /**
     * Tokenizes input recursively
     * 
     * @param str   Input string which must be tokenized
     */
    private void _tokenize(String str) {
        boolean match = false;


        Iterator<TokenRegex> it = tokenRegex.iterator();
        while (it.hasNext() && !match) {
            TokenRegex info = it.next();

            Matcher m = info.regex.matcher(str.trim());
            if (m.find()) {
                match = true;
                String tok = m.group().trim();
                tokens.add(new Token(info.token, tok));

                str = m.replaceFirst("");
            }
        }

        if (!match) {
            throw new RuntimeException("Unexpected character: " + str.substring(0, 1));
        }

        if (!str.isEmpty()) {
            _tokenize(str);
        }
    }
    
    /**
     * Tokenizes input recursively
     * 
     * @param str   Input string which must be tokenized
     */
    public void tokenize(String str) {
        tokens.clear();
        _tokenize(str);
    }
    

    /**
     * Retrieve token list
     * 
     * @return List of tokens
     */
    public LinkedList<Token> getTokens() {
        return tokens;
    }
}
