package lisp;

import exception.LispException;

public class Nil extends AbstrAtom implements _Slist {
	
	public static Nil nil = new Nil();
	
	private Nil(){	
	}
	
	/**
	 * Get the first element of a S-GRAPH
	 * 		{in this case, this function always returns null}
	 * @return a S-EXPR
	 * @throws LispException when the S-GRAPH is an atom.
	 */
	public _Sexpr getCar() throws LispException {return Nil.nil;}
	
	/**
	 * Get the list without first element of a S-GRAPH
	 * 		{in this case, this function always returns null}
	 * @return a S-EXPR
	 * @throws LispException when the S-GRAPH is an atom.
	 */
	public _Sexpr getCdr() throws LispException {return Nil.nil;}
	
	public boolean equals(_Sexpr a){
		return true;
	}

	public _Sexpr eval() throws LispException {
		return this;
	}
	
	public String toString(){
		return "nil";
	}
}
