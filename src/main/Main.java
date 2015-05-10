package main;

import java.io.FileNotFoundException;

import lisp.Scons;
import lisp.Symbol;
import lisp._Sexpr;
import lisp.function.fsubr.Scope;
import reader.GrammaireLISP;
import reader.ParseException;
import context.Contexts;
import exception.LispException;

public class Main {

	public static void main(String[] args) {
		
		
			try {
				System.out.println("Size of contexts : "+Contexts.getNumberOfContexts());
				Contexts.setMinimalContexts();
				System.out.println("Size of contexts : "+Contexts.getNumberOfContexts());
				GrammaireLISP parser = new GrammaireLISP(System.in);
				parser.importe("boot", false);
				//Contexts.printScope();
				
				_Sexpr s;
				int i=0;
				do{
					System.out.print("["+i+"]\t");
					s = parser.read();
					
					//System.out.println(s);
					try{
						if (s instanceof Scons && ((Scons)s).getCar() instanceof Symbol 
								&& ((Symbol)((Scons)s).getCar()).name.equals("SCOPE")){
							((Scope)((Symbol)((Scons)s).getCar()).eval()).print();
						}else{
							System.out.println(s.eval());
						}
					}catch (LispException e){
						System.out.println("--> "+e.getMessage());
					}
					
					i++;
				}while(!(s instanceof Scons 
						&& ((Scons)s).getCar() instanceof Symbol 
						&& ((Symbol)((Scons)s).getCar()).name.equals("QUIT")));
				
			} catch (LispException e) {
				System.out.println(e.getMessage());
			} catch (FileNotFoundException e){
				System.out.println("Failed to open file : ");
				System.out.println(e.getMessage());
			} catch (ParseException e){
				System.out.println("Error when parsed file : ");
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Unknow Error Occured");
				System.out.println(e.getMessage());
			}
	}
}