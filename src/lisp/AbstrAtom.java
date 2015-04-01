package lisp;

import exception.LispException;

	public abstract class AbstrAtom implements _Sexpr {
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
}
