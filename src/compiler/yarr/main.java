package compiler.yarr;

import compiler.parser.Parser;
import compiler.token.Token;
import compiler.token.Tokenizer;

public class main {

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.add("sin|cos|exp|ln|sqrt", 1); // function
        tokenizer.add("\\(", 2); // open bracket
        tokenizer.add("\\)", 3); // close bracket
        tokenizer.add("[+-]", 4); // plus or minus
        tokenizer.add("[*/]", 5); // mult or divide
        tokenizer.add("\\^", 6); // raised
        tokenizer.add("[0-9]+", 7); // integer number
        tokenizer.add("[a-zA-Z][a-zA-Z0-9_]*", 8); // variable

        try {
            tokenizer.tokenize("sin(x) * \n(1 + var_12)");

            
            Parser parser = new Parser(tokenizer.getTokens());
            parser.parse();

            for (Token tok : tokenizer.getTokens()) {
                    System.out.println("" + tok.token + " " + tok.value + " | line: " + tok.lineNr + " | pos " + tok.position);
            }
        } catch (RuntimeException e) {
                System.out.println(e.getMessage());
        }
    }
}
