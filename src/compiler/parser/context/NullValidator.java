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
public class NullValidator extends ContextValidator {

    @Override
    public boolean isValid() {
        return true;
    }
    
}
