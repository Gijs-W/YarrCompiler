/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.parser.context;


/**
 *
 * @author Gijs
 */
public class UnitaryValidator extends ContextValidator {



    @Override
    public boolean isValid() {
        boolean flag = false;
        
        switch (getPreContext().getType()) {
            case CURLY_OPEN:
            case PARENTHESES_OPEN:
            case ENDLINE:
                flag = true;
                break;
        }
        
         switch (getPostContext().getType()) {
            case INT:
            case METHOD:
            case VARIABLE:
                flag = true;
                break;
        }
        return flag;
        
    }
    
    
    
}
