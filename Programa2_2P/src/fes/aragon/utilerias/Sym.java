/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.utilerias;

/**
 *
 * @author MASH
 */
public class Sym {
  public static final int TRUE = 0;
  public static final int FALSE = 1;  
  public static final int FIN_INSTRUCCION = 2;
  public static final int OR = 3;  
  public static final int AND = 4;
  public static final int NOT = 5;
  public static final int P_ABRE = 6;
  public static final int P_CIERRA= 7;
  public static final int EOF= 8;
  public static final String[] terminales = new String[] {
  "TRUE",  
  "FALSE",
  "FIN_INSTRUCCION",
  "OR",
  "AND",
  "NOT",
  "P_ABRE",
  "P_CIERRA",
  "EOF"
  };
}
