/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.parser.context;

import compiler.token.TokenType;

/**
 *
 * @author Gijs
 */
public class Validator {
    
    public static ContextValidator factory(TokenType type) {
        
        ContextValidator validator;
        switch (type) {
            case OPERATOR_PLUSMIN:
                validator = new UnitaryValidator();
                break;
            default:
                validator = new NullValidator();
                break;
        }
        
        return validator;
    }
    
}
