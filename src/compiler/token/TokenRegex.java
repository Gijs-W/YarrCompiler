package compiler.token;

import java.util.regex.Pattern;

public class TokenRegex {
	public final Pattern regex;
	public final int token;
	
	public TokenRegex(Pattern regex, int token) {
		super();
		this.regex = regex;
		this.token = token;
	}
}
