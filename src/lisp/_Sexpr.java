package lisp;

import exception.LispException;

public interface _Sexpr {
	
	/**
	 * Get the first element of a S-GRAPH
	 * @return a S-EXPR
	 * @throws LispException when the S-GRAPH is an atom.
	 */
	public _Sexpr getCar() throws LispException;
	
	/**
	 * Get the list without first element of a S-GRAPH
	 * @return a S-EXPR
	 * @throws LispException when the S-GRAPH is an atom.
	 */
	public _Sexpr getCdr() throws LispException;
}
