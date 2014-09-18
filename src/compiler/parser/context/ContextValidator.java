/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.parser.context;

import compiler.token.Token;
import compiler.token.TokenType;

/**
 *
 * @author Gijs
 */
public abstract class ContextValidator {
    
    private Token preContext;
    
    private Token postContext;
    
    private  Token subject;
    
    public ContextValidator() {
      
    }
    
    public void setPreContextToken(Token preContext) {
        if (preContext == null) preContext = new Token(TokenType.NULLTOKEN, "", 0,0,0);
        
        this.preContext = preContext;
    }
    public void setPostContextToken(Token postContext) {
        if (preContext == null) preContext = new Token(TokenType.NULLTOKEN, "", 0,0,0);
        
        this.postContext = postContext;
    }

    public void setSubject(Token subject) {
        this.subject = subject;
    }

    public Token getPreContext() {
        return preContext;
    }

    public Token getPostContext() {
        return postContext;
    }

    public Token getSubject() {
        return subject;
    }
    
    
    
    

    
    public abstract boolean isValid();
    
}
