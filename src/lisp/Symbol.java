package lisp;

import exception.LispException;

public class Symbol extends AbstrAtom {
	
	public String name;
	
	/**
	 * Default constructor for Symbol class
	 * @param name
	 */
	public Symbol(String name){
		this.name = name;
	}
	
	/**
	 * Get the first element of a S-GRAPH
	 * 		{in this case, this function always returns an exception}
	 * @return a S-EXPR
	 * @throws LispException when the S-GRAPH is an atom.
	 */
	public _Sexpr getCar() throws LispException{
		throw new LispException("Unvalid function for atome.");
	}
	
	/**
	 * Get the list without first element of a S-GRAPH
	 * 		{in this case, this function always returns an exception}
	 * @return a S-EXPR
	 * @throws LispException when the S-GRAPH is an atom.
	 */
	public _Sexpr getCdr() throws LispException{
		throw new LispException("Unvalid function for atome.");
	}
	
	
	/**
	 * 
	 */
	public boolean equals(Object a){
		return this.name.equals(((Symbol)a).name);
	}
}
