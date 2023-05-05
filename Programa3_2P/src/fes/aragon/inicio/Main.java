package fes.aragon.inicio;

import java.util.List;

public class Main {
	public static void main(String[] args) {
        String input = "abcd;";
        List<Token> tokens = Lexer.lex(input);
        Parser parser = new Parser(tokens, Grammar.primero, Grammar.siguiente, Grammar.prediccion, Grammar.productions);
        parser.parse();
        System.out.println("La cadena es válida.");
    }
}
