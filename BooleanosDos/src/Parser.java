public class Parser {
    private final String input; // variable que almacena la entrada del usuario
    private int index; // variable que almacena la posición actual de la entrada que se está procesando

    public Parser(String input) { // constructor que inicializa las variables input y index
        this.input = input;
        this.index = 0;
    }

    public boolean parse() { // método que se encarga de ejecutar el análisis sintáctico
        try {
            E(); // se inicia el análisis sintáctico desde la regla E
            return index == input.length(); // se verifica si se llegó al final de la entrada
        } catch (ParseException e) { // si ocurre una excepción, se asume que la entrada no es válida
            return false;
        }
    }

    private void E() throws ParseException { // método que implementa la regla E
        T(); // se llama al método que implementa la regla T
        Eprima(); // se llama al método que implementa la regla E'
    }

    private void Eprima() throws ParseException { // método que implementa la regla E'
        if (match("or")) { // si se encuentra el token "or" en la entrada
            T(); // se llama al método que implementa la regla T
            Eprima(); // se llama al método que implementa la regla E'
        }
    }

    private void T() throws ParseException { // método que implementa la regla T
        F(); // se llama al método que implementa la regla F
        Tprima(); // se llama al método que implementa la regla T'
    }

    private void Tprima() throws ParseException { // método que implementa la regla T'
        if (match("and")) { // si se encuentra el token "and" en la entrada
            F(); // se llama al método que implementa la regla F
            Tprima(); // se llama al método que implementa la regla T'
        }
    }

    private void F() throws ParseException { // método que implementa la regla F
        if (match("not")) { // si se encuentra el token "not" en la entrada
            E(); // se llama al método que implementa la regla E
        } else if (match("true") || match("false")) { // si se encuentra el token "true" o "false" en la entrada
            // no se hace nada, ya que son terminales válidos
        } else if (match("(")) { // si se encuentra el token "(" en la entrada
            E(); // se llama al método que implementa la regla E
            if (!match(")")) { // si no se encuentra el token ")" en la entrada, se lanza una excepción
                throw new ParseException("Expected ')'");
            }
        } else { // si se encuentra cualquier otro token en la entrada, se lanza una excepción
            throw new ParseException("Unexpected token");
        }
    }

    private boolean match(String token) { // método que verifica si el token dado se encuentra en la entrada
        if (index < input.length() && input.substring(index).startsWith(token)) { // si el token se encuentra en la entrada
            index += token.length(); // se actualiza la posición actual de la entrada que se está procesando
            skipWhitespace(); // se saltan los caracteres en blanco
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
