/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler.parser;

import compiler.token.Token;
import java.util.List;

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
    
    /**
     * Todo: DoubleLinkedListIfY this
     */
    private final List<Token> tokenList;

    public Parser(List<Token> tokenList) {
        this.tokenList = tokenList;
    }
    
    /**
     * @todo refactor this with DoubleLinkedList as it is easier to use
     * @todo should contain more checks than (
     */
    public void parse() {
        Token previous = null;
        for (Token token : tokenList) {
            
            if (previous != null) {
                
                if (previous.token == 1 && token.token != 2) {
                    throw new RuntimeException("Parse Error: Unexpected '"  + token.value + "' Function must be followed by (");
                }
            }
            
            previous = token;            
        }
    }
}
