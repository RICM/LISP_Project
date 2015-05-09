package main;

import lisp.*;
import lisp.function.subr.*;
import lisp.function.fsubr.*;
import exception.*;
import reader.*;

import java.io.*;

import context.Contexts;

public class Main {

	public static void main(String[] args) {
		
		
			try {
				
				Symbol car = new Symbol("CAR");
				Symbol cdr = new Symbol("CDR");
				Symbol cons = new Symbol("CONS");
				Symbol atom = new Symbol("ATOM");
				Symbol quote = new Symbol("QUOTE");
				Symbol quit = new Symbol("QUIT");
				Symbol eq = new Symbol("EQ");
				Symbol set = new Symbol("SET");
				Symbol de = new Symbol("DE");
				Symbol imp = new Symbol("IMPLODE");
				Symbol prt = new Symbol("PRINT");
				Contexts.addContext();
				Contexts.addSymbolToFirstContext(car, new Car());
				Contexts.addSymbolToFirstContext(cdr, new Cdr());
				Contexts.addSymbolToFirstContext(cons, new Cons());
				Contexts.addSymbolToFirstContext(atom, new Atom());
				Contexts.addSymbolToFirstContext(eq, new Eq());
				Contexts.addSymbolToFirstContext(set, new Set());
				Contexts.addSymbolToFirstContext(de, new Define());
				Contexts.addSymbolToFirstContext(imp, new Implode());
				Contexts.addSymbolToFirstContext(prt, new Print());
				Contexts.addSymbolToFirstContext(quote, new Quote());
				Contexts.addSymbolToFirstContext(quit, new Quit());
				
				GrammaireLISP parser = new GrammaireLISP(System.in);
				_Sexpr s2 = parser.importe("boot");
				//_Sexpr s = parser.read("(CONS ( A B)A)");
				_Sexpr s;
				int i=0;
				do{
					System.out.print("["+i+"]\t");
					s = parser.read();
					
					//System.out.println(s);
					try{
						System.out.println(s.eval());
					}catch (LispException e){
						System.out.println("--> "+e.getMessage());
					}
					
					i++;
				}while(!(s instanceof Scons 
						&& ((Scons)s).getCar() instanceof Symbol 
						&& ((Symbol)((Scons)s).getCar()).name.equals("QUIT")));
				
			} catch (LispException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			} catch (FileNotFoundException e){
				System.out.println("Failed to open file : ");
				System.out.println(e.getMessage());
			} catch (ParseException e){
				System.out.println("Error when parsed file : ");
				System.out.println(e.getMessage());
			}
	}
}