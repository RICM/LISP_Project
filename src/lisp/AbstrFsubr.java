package lisp;

import exception.LispException;


public abstract class AbstrFsubr extends AbstrPrimitive{
	/**
	 * Apply the list of parameters to the function.
	 * @param fun The function to use.
	 * @param param The list of parameters to use inside the function.
	 * @return The application of the parameter list to the function.
	 * @throws LispException
	 */
	public _Sexpr exec(_Function fun, _Sexpr param) throws LispException {
		return fun.apply(param);
	}
}
