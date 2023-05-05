package fes.aragon.inicio;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
	private static int pos;
    private static String input;

    public static List<Token> lex(String input) {
        Lexer.input = input;
        Lexer.pos = 0;
        List<Token> tokens = new ArrayList<>();

        while (pos < input.length()) {
            char currentChar = peek();
            switch (currentChar) {
                case 'a':
                    advance();
                    tokens.add(new Token("A", "a"));
                    break;
                case 'b':
                    advance();
                    tokens.add(new Token("B", "b"));
                    break;
                case 'c':
                    advance();
                    tokens.add(new Token("C", "c"));
                    break;
                case 'd':
                    advance();
                    tokens.add(new Token("D", "d"));
                    break;
                case ';':
                    advance();
                    tokens.add(new Token("PUNTOYCOMA", ";"));
                    break;
                default:
                    throw new RuntimeException("Caracter no valido: " + currentChar);
            }
        }
        return tokens;
    }

    private static char peek() {
        if (pos < input.length()) {
            return input.charAt(pos);
        }
        return '\0';
    }

    private static void advance() {
        pos++;
    }
}
