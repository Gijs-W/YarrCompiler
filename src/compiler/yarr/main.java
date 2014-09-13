package compiler.yarr;

import compiler.parser.Parser;
import compiler.token.Token;
import compiler.token.TokenType;
import compiler.token.Tokenizer;

public class main {

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.add("sin|cos|exp|ln|sqrt", TokenType.METHOD); // function
        tokenizer.add("\\{", TokenType.CURLY_OPEN);
        tokenizer.add("\\}", TokenType.CURLY_CLOSE);
        tokenizer.add("\\(", TokenType.PARENTHESES_OPEN); // open bracket
        tokenizer.add("\\)", TokenType.PARENTHESES_CLOSE); // close bracket
        tokenizer.add("[+-]", TokenType.OPERATOR_PLUSMIN); // plus or minus
        tokenizer.add("[*/]", TokenType.OPERATOR_MULTDIV); // mult or divide
        tokenizer.add("[0-9]+", TokenType.INT); // integer number
        tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", TokenType.VARIABLE); // variable

        try {
            tokenizer.tokenize("sin(x) * \n(1 + {var_12})");

            
            Parser parser = new Parser(tokenizer.getTokens());
            parser.parse();

            for (Token tok : tokenizer.getTokens()) {
                    System.out.println(tok);
                    
                    Token partner = tok.getPartner();
                    
                    if (partner != null) {
                        System.out.println("==> HasPartner: " + partner);
                    }
                    
                    System.out.println("");
            }
        } catch (RuntimeException e) {
             System.out.println("Error: " + e.getMessage());
        }
    }
}
