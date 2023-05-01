package fes.aragon.inicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

import fes.aragon.utilerias.Analizador;



public class Inicio {
	public static void main(String[] args) {
File archivo = new File("sample");
        
        try {
            FileReader fileReader = new FileReader(archivo);
            Reader lector = new BufferedReader(fileReader);
            Analizador analizador = new Analizador(lector);          
        }
        catch (Exception e)
        {
            System.out.println("algo");
        }
	}
}
