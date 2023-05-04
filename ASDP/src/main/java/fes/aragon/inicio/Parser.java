package fes.aragon.inicio;

import java.util.*;

public class Parser {
    private List<Token> tokens;
    private int index;
    private Map<Symbol, Set<String>> primero;
    private Map<Symbol, Set<String>> siguiente;
    private Map<Production, Set<String>> prediccion;
    private List<Production> productions;

    public Parser(List<Token> tokens, Map<Symbol, Set<String>> primero, Map<Symbol, Set<String>> siguiente, Map<Production, Set<String>> prediccion, List<Production> productions) {
        this.tokens = tokens;
        this.index = 0;
        this.primero = primero;
        this.siguiente = siguiente;
        this.prediccion = prediccion;
        this.productions = productions;
    }


    public void parse() {
        parseS();
        expect();
    }

    private void parseS() {
        Set<String> prediction = prediccion.get(productions.get(0));
        if (prediction.contains(tokens.get(index).getValue())) {
            parseA();
            parseB();
        } else {
            error(prediction);
        }
    }

    private void parseA() {
        Set<String> prediction = prediccion.get(productions.get(1));
        if (prediction.contains(tokens.get(index).getValue())) {
            if (tokens.get(index).getType().equals(TokenType.A.toString())) {
                consume();
            }
        } else if (prediction.contains("")) {
            // No hace nada, A -> lambda
        } else {
            error(prediction);
        }
    }

    private void parseB() {
        Set<String> prediction = prediccion.get(productions.get(3));
        if (prediction.contains(tokens.get(index).getValue())) {
            if (tokens.get(index).getType().equals(TokenType.B.toString())) {
                consume();
            }
            parseC();
            if (tokens.get(index).getType().equals(TokenType.D.toString())) {
                consume();
            }
        } else {
            error(prediction);
        }
    }

    private void parseC() {
        Set<String> prediction = prediccion.get(productions.get(4));
        if (prediction.contains(tokens.get(index).getValue())) {
            if (tokens.get(index).getType().equals(TokenType.C.toString())) {
                consume();
            }
        } else if (prediction.contains("")) {
            // No hace nada, C -> lambda
        } else {
            error(prediction);
        }
    }

    private void consume() {
        index++;
    }

    private void expect() {
        if (tokens.get(index).getType().equals(TokenType.PUNTOYCOMA.toString())) {
            consume();
        } else {
            error(TokenType.PUNTOYCOMA.toString());
        }
    }



    private void error(Set<String> expected) {
        throw new RuntimeException("Error de sintaxis: esperaba " + expected.toString() + ", encontre " + tokens.get(index).getValue());
    }

    private void error(String expected) {
        throw new RuntimeException("Error de sintaxis: esperaba " + expected + ", encontre " + tokens.get(index).getValue());
    }

}
