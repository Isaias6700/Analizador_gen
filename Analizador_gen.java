package semantico;

import java.util.Stack;

public class Analizador_gen {
	
	
	int contid = 0, il=0;;
	Stack<String> pilaSint = new Stack<String>();  
	Stack<Integer> pilaSem = new Stack<Integer>();
	
	//String cadena = "int var1, var2; float var3; var1=(var2+var2)*var3";
	String cadena = "int var1, var2; float var3; var1=(var2+var2)*var3;";
	
	String cad[]={"int", "id", ",", "id", ";", "float", "id", ";", "id", "=", "(", "id", "+", "id", ")", "*", "id", ";", "$"};
	
	
	String valores[]= {"id", "int", "float", "char", ",", ";", "+", "-", "*", "/", "(", ")", "=", "$", "P", "Tipo", "V", "A", "E", "T","F"};
	String edos[] = {"I0", "I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9", "I10", "I11", "I12", "I13", "I14", "I15", "I16", "I17", "I18", "I19", "I20", "I21", "I22", "I23", "I24", "I25", "I26", "I27", "I28", "I29", "I30", "I31"};
	
	
	String tabla[][] = {
			{"I7", "I4", "I5", "I6", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I1", "I2", "x", "I3", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "P0", "x", "x", "x", "x", "x", "x", "x"},
			{"I8", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "P2", "x", "x", "x", "x", "x", "x", "x"},
			{"P3", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"P4", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"P5", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I9", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "I11", "I12", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I10", "x", "x", "x", "x"},
			{"I17", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I16", "x", "x", "x", "x", "x", "x", "x", "I13", "I14", "I15"},
			{"x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "P1", "x", "x", "x", "x", "x", "x", "x"},
			{"I18", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"I7", "I4", "I5", "I6", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I19", "I2", "x", "I3", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "I20", "I21", "I22", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x" ,"P11", "P11", "P11", "I23", "I24", "x", "P11", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "P14", "P14", "P14", "P14", "P14", "x", "P14", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"I17", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I16", "x", "x", "x", "x", "x", "x", "x", "I25", "I14", "I15"},
			{"x", "x", "x", "x", "x", "P16", "P16", "P16", "P16", "P16", "x", "P16", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "I11", "I12", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I26", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "P7", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "P8", "x", "x", "x", "x", "x", "x", "x"},
			{"I17", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I16", "x", "x", "x", "x", "x", "x", "x", "x", "I27", "I15"},
			{"I17", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I16", "x", "x", "x", "x", "x", "x", "x", "x", "I28", "I15"},
			{"I17", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I16", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I29"},
			{"I17", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I16", "x", "x", "x", "x", "x", "x", "x", "x", "x", "I30"},
			{"x", "x", "x", "x", "x", "x", "I21", "I22", "x", "x", "x", "I31", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "x", "P6", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "P9", "P9", "P9", "I23", "I24", "x", "P9", "x", "x", "x", "x", "x", "x", "x","x", "x"},
			{"x", "x", "x", "x", "x", "P10", "P10", "P10", "I23", "I24", "x", "P10", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "P12", "P12", "P12", "P12", "P12", "x", "P12", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "P13", "P13", "P13", "P13", "P13", "x", "P13", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			{"x", "x", "x", "x", "x", "P15", "P15", "P15", "P15", "P15", "x", "P15", "x", "x", "x", "x", "x", "x", "x", "x", "x"},
			};
	int tablasem[][] = {
			{1,2,-1},
			{2,2,-1},
			{-1,-1,3}};
	public void Sintactico()
	{
		pilaSint.clear();
		pilaSint.push("$");
		pilaSint.push("I0");
		int longitud = cad.length;
		for (int i = 0; i < longitud; i++) {
			 Analisis(cad[i], i);
		}
	}
	
	public void Generador(String dato, int n) 
	{	
				
	
			
			if(dato == "id")
			{
				 System.out.print("CÓDIGO INTERMEDIO[");
				if (n== 1 || n == 8)
					il=1;
				if (n== 3 || n == 11|| n == 13)
					il=2;
				if (n== 6 || n == 16)
					il=3;
				System.out.println("var"+il+"]");
			}
	
		
		if (dato =="int" || dato == "float" || dato =="char" || dato =="," || dato == ";"
				|| dato =="+"|| dato == "-"|| dato == "*"|| dato == "/"|| dato == "("|| dato == ")"|| dato == "=") 
		{
			 System.out.print("CÓDIGO INTERMEDIO[");
			System.out.print(dato+"]");
			System.out.println("");
		}
	}
	
	
	public void Analisis(String token, int n)
	{	
			System.out.println(pilaSint);
			System.out.println("Pila semántica: "+pilaSem);
			int col = BuscarValores(token);
		    int ren = BuscarEdos(pilaSint.peek());
		    	String vtabla = tabla[ren][col];
		    	
		    	Generador(token, n);
		    	
		    	if(token.equals("$") && vtabla.equals("P0"))
		    	{
		    		System.out.println("Se acepta la cadena.");
		    	}
		    	else if(tabla[ren][col] == "x")
		    	{
		    		System.out.println("Se rechaza la cadena.");
		    	}
		    	else if(vtabla.startsWith("I"))
		    	{
		    		pilaSint.push(token);
		    		pilaSint.push(vtabla);
		    		IdSem(token);
		    		
		    	}
		    	else if(vtabla.startsWith("P"))
		    	{
		    		if(vtabla.equalsIgnoreCase("P10") || vtabla.equalsIgnoreCase("P9") || vtabla.equalsIgnoreCase("P2"))
		    		{
		    			int T1 = pilaSem.pop();
		    			int T2 = pilaSem.pop();
		    			if(T1 == T2)
		    			{
		    				pilaSem.push(T1);
		    			}
		    			else if(T1 != T2)
		    			{
		    				pilaSem.push(2);
		    			}
		    		}
		    		String reduccion[] = Reducciones(vtabla);
		    		if(reduccion[1].equals("e"))
		    		{
		    			String edoanterior = pilaSint.peek();
		    			pilaSint.push(reduccion[0]);
		    			col = BuscarValores(pilaSint.peek());
		    			ren = BuscarEdos(edoanterior);
		    			vtabla = tabla[ren][col];
		    			pilaSint.push(vtabla);
		    			Analisis(token, 0);
		    		}
		    		else
		    		{
		    			String nr[] = reduccion[1].split(" ");
		    			for(int i=0; i<(nr.length*2); i++)
		    			{
		    				pilaSint.pop();
		    			}
		    			String edoanterior = pilaSint.peek();
		    			pilaSint.push(reduccion[0]);
		    			col = BuscarValores(pilaSint.peek());
		    			ren = BuscarEdos(edoanterior);
		    			vtabla = tabla[ren][col];
		    			pilaSint.push(vtabla);
		    			Analisis(token, 0);
		    		}
		    	}
		  //  }
		
	    
	}
	public void IdSem(String token)
	{
		if(token.equals("id"))
		{
			contid++;
			if(contid == 5 || contid == 6)
			{
				pilaSem.push(1);
			}
			else if(contid == 7)
			{
				pilaSem.push(2);
				contid++;
			}
		}
		
	
	}
	public void OpSem(String token)
	{
		
	}
	public String[] Reducciones(String p)
	{
		String red[] = new String[2];
		switch(p)
		{
		case "P0":
			red[0] = "P'";
			red[1] = "P";
			break;
		case "P1":
			red[0] = "P";
			red[1] = "Tipo id V";
			break;
		case "P2":
			red[0] = "P";
			red[1] = "A";
			break;
		case "P3":
			red[0] = "Tipo";
			red[1] = "int";
			break;
		case "P4":
			red[0] = "Tipo";
			red[1] = "float";
			break;
		case "P5":
			red[0] = "Tipo";
			red[1] = "char";
			break;
		case "P6":
			red[0] = "V";
			red[1] = ", id V";
			break;
		case "P7":
			red[0] = "V";
			red[1] = "; P";
			break;
		case "P8":
			red[0] = "A";
			red[1] = "id = E ;";
			break;
		case "P9":
			red[0] = "E";
			red[1] = "E + T";
			break;
		case "P10":
			red[0] = "E";
			red[1] = "E - T";
			break;
		case "P11":
			red[0] = "E";
			red[1] = "T";
			break;
		case "P12":
			red[0] = "T";
			red[1] = "T * F";
			break;
		case "P13":
			red[0] = "T";
			red[1] = "T / F";
			break;
		case "P14":
			red[0] = "T";
			red[1] = "F";
			break;
		case "P15":
			red[0] = "F";
			red[1] = "( E )";
			break;
		case "P16":
			red[0] = "F";
			red[1] = "id";
			break;
		}
		return red;
	}
	public int BuscarValores(String valor)
	 {
	       
	       for(int i=0; i<valores.length; i++)
	       {
	           if(valores[i].equalsIgnoreCase(valor))
	               return i;
	       }
	       return -1;
	}
	 public int BuscarEdos(String edo)
	   {
	       for(int i=0; i<edos.length; i++)
	       {
	           if(edos[i].equalsIgnoreCase(edo))
	               return i;
	       }
	       return -1;
	   }
	public static void main(String[] args) {
		Analizador_gen x = new Analizador_gen();
		x.Sintactico();
	}
}
