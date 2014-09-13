/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler.parser;

import compiler.token.Token;
import compiler.token.TokenType;
import java.util.List;
import java.util.Stack;

/**
 * Parses tokenlist
 * 
 * Checks whether token list is parseble. For instance, "sina()" will result in a valid TokenSet
 * sin, a, (, )
 * yet it is not valid, as a function should always be followed by an (
 * 
 * @author Gijs
 */
public class Parser {
    
    private Stack<Token> parseStack;
    /**
     * Todo: DoubleLinkedListIfY this
     */
    private final List<Token> tokenList;

    public Parser(List<Token> tokenList) {
        this.tokenList = tokenList;
        parseStack = new Stack<>();
    }
    
    /**
     * @todo refactor this with DoubleLinkedList as it is easier to use
     * @todo should contain more checks than (
     */
    public void parse() {
        Token previous = null;
        for (Token token : tokenList) {
            
            Token stackedToken;
            
            switch(token.type) {
                case PARENTHESES_OPEN:
                    parseStack.add(token);
                    break;
                case CURLY_OPEN:
                    parseStack.add(token);
                    break;
                case PARENTHESES_CLOSE:
                    stackedToken = parseStack.pop();
                    
                    assertToken(stackedToken, TokenType.PARENTHESES_OPEN);
                    
                    createPartnership(token, stackedToken);
                    
                    break;
                
                case CURLY_CLOSE:
                    stackedToken = parseStack.pop();
                   
                    assertToken(stackedToken, TokenType.CURLY_OPEN);
                    
                    createPartnership(token, stackedToken);
                    break;                    
                
            }


            if (previous != null) {
                
                if (previous.type == TokenType.METHOD && token.type != TokenType.PARENTHESES_OPEN) {
                   throw new RuntimeException("Parse Error: Unexpected '"  + token.value + "' Function must be followed by (");
                }
            }
            
            previous = token;            
        }
        
        if (parseStack.size() > 0) {
            throw new RuntimeException("Bracket or parentheses mismatch!");
        }
    }
    
    /**
     * Make sure that the token type is correct
     * 
     * @param token
     * @param type Expected type
     */
    private void assertToken(Token token, TokenType type) {
        if (token == null || token.type != type) {
            throw new RuntimeException("Unexpected token, expected: " + type);
        }
    }
    
    /**
     * Create a partnership between tokens:
     * 
     * @param token1
     * @param token2 
     */
    private void createPartnership(Token token1, Token token2) {
        token1.setPartner(token2);
        token2.setPartner(token1);
    }
}
