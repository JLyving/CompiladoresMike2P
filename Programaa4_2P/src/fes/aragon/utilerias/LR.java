package fes.aragon.utilerias;

import java.util.Stack;

public class LR {
	private String[][] tabla = {{"D5",null,null,"D4",null,null,"1","2","3"}
								,{null,"D6",null,null,null,"Aceptar",null,null,null}
								,{null,"R2","D7",null,"R2","R2",null,null,null}
								,{null,"R4","R4",null,"R4","R4",null,null,null}
								,{"D5",null,null,"D4",null,null,"8","2","3"}
								,{null,"R6","R6",null,"R6","R6",null,null,null}
								,{"D5",null,null,"D4",null,null,null,"9","3"}
								,{"D5",null,null,"D4",null,null,null,null,"10"}
								,{null,"D6",null,null,"D11",null,null,null,null}
								,{null,"R1","D7",null,"R1","R1",null,null,null}
								,{null,"R3","R3",null,"R3","R3",null,null,null}
								,{null,"R5","R5",null,"R5","R5",null,null,null}};
	
	private Stack<Integer> estados = new Stack<>();
	private Stack<Analizador> simbolo = new Stack<>();
	private Analizador obj = null;
	
	public LR(Analizador obj) {
		this.obj = obj;
	}
	
	public void Desplazar(int x) {
		estados.push(x);
		simbolo.push(obj);
	}
	
	public void Reducir(int x) {
		
	}
	
	public void Aceptar() {
		
		System.out.println("Gramatica aceptada");
	}
	
	public void Error() {
		
	}
}
