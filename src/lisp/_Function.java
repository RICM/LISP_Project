package lisp;

import exception.LispException;

public interface _Function {
	
	/**
	 * Get the function number of parameter.
	 * @return An integer.
	 */
	public int getNumberOfParam();
	
	/**
	 * Apply a function with the list of parameters.
	 * @param param The list of parameters.
	 * @return The application of the parameter list to the function.
	 * @throws LispException 
	 */
	public _Sexpr apply(_Sexpr param) throws LispException;
}
