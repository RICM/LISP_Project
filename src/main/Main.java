package main;

import lisp.*;
import exception.*;
import reader.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		
			try {
				GrammaireLISP parser = new GrammaireLISP(System.in);
				//_Sexpr s = parser.read();
				//_Sexpr s = parser.read("(CAR (a b))");
				_Sexpr s = parser.importe("boot");
				System.out.println(s.toString());
				
				// Test de l'architecture du projet
				//_Sexpr t = new Scons(new Scons(new Symbol("b"), new Scons(new Scons(new Symbol("c"), new Symbol("d")), Nil.nil)), new Scons(new Symbol("a"), new Scons(new Symbol("e"), Nil.nil)));
				//System.out.println(t.toString());
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
