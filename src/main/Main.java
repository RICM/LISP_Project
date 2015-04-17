package main;

import lisp.*;
import exception.LispException;
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
				System.out.println("Le fichier n'a pas pû etre trouvé :");
				System.out.println(e.getMessage());
			} catch (ParseException e) {
				System.out.println("Une erreur est survenue lors du parcours du code LISP :");
				System.out.println(e.getMessage());
			}
		
		
	}

}
