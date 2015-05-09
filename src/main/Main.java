package main;

import lisp.*;
import lisp.function.subr.Atom;
import lisp.function.subr.Car;
import lisp.function.subr.Cdr;
import lisp.function.subr.Cons;
import exception.*;
import reader.*;

import java.io.*;

import context.Contexts;

public class Main {

	public static void main(String[] args) {
		
		
			try {
				GrammaireLISP parser = new GrammaireLISP(System.in);
				//_Sexpr s = parser.read();
				_Sexpr s = parser.read("(ATOM A )");
				_Sexpr s2 = parser.importe("boot");
				
				
				// Test de l'architecture du projet
				//_Sexpr t = new Scons(new Scons(new Symbol("b"), new Scons(new Scons(new Symbol("c"), new Symbol("d")), Nil.nil)), new Scons(new Symbol("a"), new Scons(new Symbol("e"), Nil.nil)));
				//System.out.println(t.toString());
				
				Symbol car = new Symbol("CAR");
				Symbol cdr = new Symbol("CDR");
				Symbol cons = new Symbol("CONS");
				Symbol atom = new Symbol("ATOM");
				Symbol a = new Symbol("A");
				Symbol b = new Symbol("B");
				Symbol c = new Symbol("C");
				Contexts.addContext();
				Contexts.addSymbolToFirstContext(a, a);
				Contexts.addSymbolToFirstContext(b, b);
				Contexts.addSymbolToFirstContext(c, c);
				Contexts.addSymbolToFirstContext(car, new Car());
				Contexts.addSymbolToFirstContext(cdr, new Cdr());
				Contexts.addSymbolToFirstContext(cons, new Cons());
				Contexts.addSymbolToFirstContext(atom, new Atom());
				
				System.out.println(s);
				System.out.println(s.eval());
				
				/*_Sexpr stest = new Scons(car, new Scons(new Scons(a, new Scons(b, new Scons(c, Nil.nil))), Nil.nil));
				_Sexpr result = stest.eval();
				System.out.println(result.toString());*/
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