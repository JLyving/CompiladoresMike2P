/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.inicio;

import fes.aragon.codigo.Lexico;
import fes.aragon.codigo.Sym;
import fes.aragon.codigo.Tokens;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author MASH
 */
public class Inicio {
	private boolean error = true;
	private Tokens tokens = null;
	private Lexico analizador = null;

	public static void main(String[] args) {
		Inicio ap = new Inicio();
		BufferedReader buf;
		try {
			System.out.println(new FileReader(System.getProperty("user.dir") + "/Sintactico_V1/archivo.txt"));

			buf = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/Sintactico_V1/archivo.txt"));
			ap.analizador = new Lexico(buf);
			ap.siguienteToken();
			ap.sentencia();
			// ap.F();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sentencia() {
		do {

			E();
			if (tokens.getLexema() != Sym.FIN_INSTRUCCION) {
				errorSintactico();
				siguienteToken();
			}
			if (!this.error) {
				System.out.println("Invalida linea= " + (tokens.getLinea() + 1));
				this.error = true;
			} else {
				System.out.println("Valida  linea= " + (tokens.getLinea() + 1));
			}
			siguienteToken();
		} while (tokens.getLexema() != Sym.EOF);
	}

	private void F() {
		if (tokens.getLexema() == Sym.FALSE || tokens.getLexema() == Sym.TRUE || tokens.getLexema() == Sym.NOT
				|| tokens.getLexema() == Sym.P_ABRE) {
			//siguienteToken();
			if (tokens.getLexema() == Sym.NOT) {
				siguienteToken();
				F();
			} else if (tokens.getLexema() == Sym.TRUE || tokens.getLexema() == Sym.FALSE) {
				siguienteToken();
				if(tokens.getLexema()==Sym.AND) {
					siguienteToken();
					T();
					if(tokens.getLexema()==Sym.P_CIERRA) {
						siguienteToken();
					}
				}
			}
			else if (tokens.getLexema() == Sym.P_ABRE) {
				siguienteToken();
				E();
			}
			else {
				errorSintactico();
			}

	}else
	{
		errorSintactico();
	}
	}

	private void T() {
		siguienteToken();
		if (tokens.getLexema() == Sym.FALSE || tokens.getLexema() == Sym.TRUE || tokens.getLexema() == Sym.NOT
				|| tokens.getLexema() == Sym.P_ABRE) {
			siguienteToken();

			
		}
		
		if (tokens.getLexema() == Sym.AND) {
			siguienteToken();
			T();	
		}
		if (tokens.getLexema() == Sym.P_CIERRA) {
			siguienteToken();
		}
		

	}

	private void E() {
		if (tokens.getLexema() == Sym.FALSE || tokens.getLexema() == Sym.TRUE || tokens.getLexema() == Sym.NOT
				|| tokens.getLexema() == Sym.P_ABRE) {
			F();
				//siguienteToken();
				if (tokens.getLexema() == Sym.OR) {
					T();

				} else if (tokens.getLexema() != Sym.FIN_INSTRUCCION) {
					errorSintactico();
				}

			
		}
	}

	private void errorSintactico() {
		this.error = false;
		// descartar todo hasta encontrar ;
		do {
			System.out.println(tokens.toString());
			if (tokens.getLexema() != Sym.FIN_INSTRUCCION) {
				siguienteToken();
			}
		} while (tokens.getLexema() != Sym.FIN_INSTRUCCION && tokens.getLexema() != Sym.EOF);

	}

	private void siguienteToken() {
		try {
			tokens = analizador.yylex();
			if (tokens == null) {
				tokens = new Tokens("EOF", Sym.EOF, 0, 0);
				throw new IOException("Fin Archivo");
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
