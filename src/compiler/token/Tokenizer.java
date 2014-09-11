package compiler.token;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

	private LinkedList<TokenInfo> tokenInfos;
	private LinkedList<Token> tokens;

	public Tokenizer() {
		tokenInfos = new LinkedList<TokenInfo>();
		tokens = new LinkedList<Token>();
	}

	public void add(String regex, int token) {
		tokenInfos.add(new TokenInfo(Pattern.compile("^("+regex+")"), token));
	}

	public boolean tokenize(String str) {
            boolean match = false;


            Iterator<TokenInfo> it = tokenInfos.iterator();
            while (it.hasNext() && !match) {
                TokenInfo info = it.next();

                Matcher m = info.regex.matcher(str.trim());
                if (m.find()) {
                    match = true;
                    String tok = m.group().trim();
                    tokens.add(new Token(info.token, tok));

                    str = m.replaceFirst("");
                }
            }

            if (!match) {
                throw new RuntimeException("Unexpected character: " + str.substring(0, 1));
            }


            if (!str.isEmpty()) {
                tokenize(str);
            }

            return true;
	}

	public LinkedList<Token> getTokens() {
		return tokens;
	}
}
