public class Parser {
    private String input;
    private int index;

    public Parser(String input) {
        this.input = input;
        this.index = 0;
    }

    public boolean parse() {
        try {
            E();
            return index == input.length();
        } catch (ParseException e) {
            return false;
        }
    }

    private void E() throws ParseException {
        T();
        Eprima();
    }

    private void Eprima() throws ParseException {
        if (match("or")) {
            T();
            Eprima();
        }
    }

    private void T() throws ParseException {
        F();
        Tprima();
    }

    private void Tprima() throws ParseException {
        if (match("and")) {
            F();
            Tprima();
        }
    }

    private void F() throws ParseException {
        if (match("not")) {
            E();
        } else if (match("true") || match("false")) {
            // si se encuentra el token "true" o "false" en la entrada
            // no se hace nada, ya que son terminales válidos
        } else if (match("(")) {
            E();
            if (!match(")")) {
                throw new ParseException("Expected ')'");
            }
        } else {
            throw new ParseException("Unexpected token");
        }
    }

    private boolean match(String token) {
        if (index < input.length() && input.substring(index).startsWith(token)) {
            index += token.length();
            skipWhitespace();
            return true;
        }
        return false;
    }

    private void skipWhitespace() {
        while (index < input.length() && Character.isWhitespace(input.charAt(index))) {
            index++;
        }
    }

}

class ParseException extends Exception {
    public ParseException(String message) {
        super(message);
    }
}
