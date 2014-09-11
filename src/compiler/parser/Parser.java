/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler.parser;

import compiler.token.Token;
import compiler.token.TokenRegex;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gijs
 */
public class Parser {
    
    /**
     * Todo: DoubleLinkedListIfY this
     */
    private final List<Token> tokenInfoList;

    public Parser(List<Token> tokenInfoList) {
        this.tokenInfoList = tokenInfoList;
    }
    
    /**
     * @todo refactor this with DoubleLinkedList as it is easier to use
     */
    public void parse() {
        Token previous = null;
        for (Token info : tokenInfoList) {
            
            if (previous != null) {
                
                if (previous.token == 1 && info.token != 2) {
                    throw new RuntimeException("Parse Error: Unexpected '"  + info.sequence + "' Function must be followed by (");
                }
            }
            
            previous = info;            
        }
    }
}
