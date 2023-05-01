package fes.aragon.inicio;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import fes.aragon.utilerias.Lexico;
import fes.aragon.utilerias.Parser;

public class Inicio {


	public static void main(String[] args) {
		File archivo = new File("sample");
        
        try {
            FileReader fileReader = new FileReader(archivo);
            Reader lector = new BufferedReader(fileReader);
            Lexico analizador = new Lexico(lector);            
        }
        catch (Exception e)
        {
            System.out.println("algo");
        }
	
		
		 /*String input = "not false or (false and not false)";
	        //Parser parser = new Parser(input);
	        if (parser.parse()) {
	            System.out.println("\"" + input + "\" = entrada valida");
	        } else {
	            System.out.println("Error de sintaxis: \"" + input + "\" = entrada no valida");
	        }*/
	}
}
