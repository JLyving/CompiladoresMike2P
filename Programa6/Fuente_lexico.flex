package fes.aragon.compilador;
import java_cup.runtime.Symbol;
import java.io.Reader;
%%
%{
	private TablaSimbolos tabla;
	public Lexico(java.io.InputStream in, TablaSimbolos t){
		this(in);
		this.tabla = t;
	}	
	public int getYyline() {
        return yyline;
    }

    public int getYy_currentPos() {
        return yy_currentPos-1;
    }
%}
%class Lexico
%public
%char
%line
%cup
%ignorecase
%type java_cup.runtime.Symbol
//%implements java_cup.runtime.Scanner
%eofval{
 return new Symbol(sym.EOF,new String("Fin del archivo"));
//return null;
%eofval}

%%
"true" {System.out.println("true"); return new Symbol(sym.TRUE); }
"false" {System.out.println("false"); return new Symbol(sym.FALSE); }
"and" {System.out.println("and"); return new Symbol(sym.AND); }
"or" {System.out.println("or"); return new Symbol(sym.OR); }
";" {System.out.println("puntocoma"); return new Symbol(sym.PUNTOYCOMA); }
"(" {System.out.println("parAbre"); return new Symbol(sym.LPAREN); }
")" {System.out.println("parCierra"); return new Symbol(sym.RPAREN); }
"not" {System.out.println("not"); return new Symbol(sym.NOT); }

"PRINT" { return new Symbol(sym.PRINT); }

[\t\r\f]  {}
[\n] {}
" " {System.out.println("Simbolo ."+yytext());}
. { System.out.println("Caracter no valido. "+yytext()+"-"); }


