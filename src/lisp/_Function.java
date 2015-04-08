package lisp;

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
	 */
	public _Sexpr apply(_Sexpr param);
}
