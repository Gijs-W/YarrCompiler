/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package compiler.token;

/**
 *
 * @author Gijs
 */
public enum TokenType {
      NEWLINE, METHOD, CURLY_OPEN, CURLY_CLOSE, PARENTHESES_OPEN, PARENTHESES_CLOSE,
      OPERATOR_PLUSMIN, OPERATOR_PLUSMIN_UNI, OPERATOR_PLUSMIN_UNI_DOUBLE, OPERATOR_MULTDIV, OPERATOR_BIGSMALL, OPERATOR_ASSIGN,
      INT, STRING, VARIABLE, IF, ELSE, ENDLINE, NULLTOKEN
}
