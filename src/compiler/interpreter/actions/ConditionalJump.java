/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler.interpreter.actions;

/**
 *
 * @author Gijs
 */
public class ConditionalJump {
    private Action onFalse;
    private Action onTrue;
    
    public Action jump(boolean value) {
        if (value) {
            return onTrue;
        }
        return onFalse;
    }
    
}
