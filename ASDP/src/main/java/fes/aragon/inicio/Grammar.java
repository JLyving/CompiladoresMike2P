package fes.aragon.inicio;

import java.util.*;

public class Grammar {
    public static final Symbol S = new Symbol(false, "S");
    public static final Symbol A = new Symbol(false, "A");
    public static final Symbol B = new Symbol(false, "B");
    public static final Symbol C = new Symbol(false, "C");
    public static final Symbol a = new Symbol(true, "a");
    public static final Symbol b = new Symbol(true, "b");
    public static final Symbol c = new Symbol(true, "c");
    public static final Symbol d = new Symbol(true, "d");
    public static final Symbol lambda = new Symbol(true, "λ");

    public static List<Production> productions = new ArrayList<>();

    static {
        productions.add(new Production(S, Arrays.asList(A, B)));
        productions.add(new Production(A, Arrays.asList(a)));
        productions.add(new Production(A, Arrays.asList(lambda)));
        productions.add(new Production(B, Arrays.asList(b, C, d)));
        productions.add(new Production(C, Arrays.asList(c)));
        productions.add(new Production(C, Arrays.asList(lambda)));
    }

    public static Map<Symbol, Set<String>> primero = new HashMap<>();
    public static Map<Symbol, Set<String>> siguiente = new HashMap<>();
    public static Map<Production, Set<String>> prediccion = new HashMap<>();

    static {
        primero.put(S, new HashSet<>(Arrays.asList("a", "b")));
        primero.put(A, new HashSet<>(Arrays.asList("a", "λ")));
        primero.put(B, new HashSet<>(Arrays.asList("b")));
        primero.put(C, new HashSet<>(Arrays.asList("c", "λ")));

        siguiente.put(S, new HashSet<>(Arrays.asList(";")));
        siguiente.put(A, new HashSet<>(Arrays.asList("b")));
        siguiente.put(B, new HashSet<>(Arrays.asList(";")));
        siguiente.put(C, new HashSet<>(Arrays.asList("d")));

        prediccion.put(productions.get(0), new HashSet<>(Arrays.asList("a", "b")));
        prediccion.put(productions.get(1), new HashSet<>(Arrays.asList("a")));
        prediccion.put(productions.get(2), new HashSet<>(Arrays.asList("b")));
        prediccion.put(productions.get(3), new HashSet<>(Arrays.asList("b")));
        prediccion.put(productions.get(4), new HashSet<>(Arrays.asList("c")));
        prediccion.put(productions.get(5), new HashSet<>(Arrays.asList("d")));
    }
}
