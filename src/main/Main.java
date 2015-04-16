package main;

import lisp.*;
import exception.LispException;
import reader.*;

public class Main {

	public static void main(String[] args) {
		
		
			try {
				GrammaireLISP parser = new GrammaireLISP(System.in);
				_Sexpr s = parser.read();
				System.out.println(s.toString());
				
				// Test de l'architecture du projet
				//_Sexpr t = new Scons(new Scons(new Symbol("b"), new Scons(new Scons(new Symbol("c"), new Symbol("d")), Nil.nil)), new Scons(new Symbol("a"), new Scons(new Symbol("e"), Nil.nil)));
				//System.out.println(t.toString());
			} catch (LispException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		
		
	}

}
