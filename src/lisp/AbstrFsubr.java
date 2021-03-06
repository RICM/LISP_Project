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
		_Sexpr tmp = param;
		int i = 0;
		while(tmp != Nil.nil){
			i++;
			tmp = tmp.getCdr();
		}
		if(i != fun.getNumberOfParam())
			if((fun.getNumberOfParam() == Integer.MAX_VALUE && i == 0) || fun.getNumberOfParam() != Integer.MAX_VALUE) 
				throw new LispException("Invalid number of parameters");
		return fun.apply(param);
	}
}
