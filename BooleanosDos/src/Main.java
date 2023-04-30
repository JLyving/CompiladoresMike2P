public class Main {
    public static void main(String[] args) {
        String input = "not false or (false and not false)";
        Parser parser = new Parser(input);
        if (parser.parse()) {
            System.out.println("\"" + input + "\" = entrada valida");
        } else {
            System.out.println("Error de sintaxis: \"" + input + "\" = entrada no valida");
        }
    }
}
