package reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import exception.LispException;
import lisp.*;

public class Reader {


	/** le support de lecture */
	protected static java.io.Reader in = new BufferedReader(new InputStreamReader (System.in));
	
	/** lecture d'une S-EXPR au terminal
	 *  @return Sexpr : la Sexpr construite.
	 *  @throws LispException une erreur de syntaxe
	 */
	public static _Sexpr read() throws LispException{
		_Sexpr toReturn = new Nil(); //TO BE MODIFIED
		return (toReturn); // TO BE MODIFIED
	}
	
	/** lecture d'une S-EXPRs à partir de la chaine
	 * @param s : le nom du fichier
	 * @return Sexpr : la Sexpr construite
	 * @throws LispException une erreur de syntaxe
	 */
	public static _Sexpr read(String s) throws LispException{
		_Sexpr toReturn = new Nil(); //TO BE MODIFIED
		return (toReturn); // TO BE MODIFIED
	}
	
	/** évaluation de la séquence S-EXPRs à partir du fichier s
	 *  @param s : le nom du fichier
	 *  @return Sexpr : synbole du nom du fichier
	 *  @throws LispException une erreur de lecture
	 */
	public static _Sexpr importe(String s) throws LispException{
		_Sexpr toReturn = new Nil(); //TO BE MODIFIED
		return (toReturn); // TO BE MODIFIED
	}
	

}
