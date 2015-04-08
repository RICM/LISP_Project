package lisp;

import exception.LispException;


public abstract class AbstrSubr extends AbstrPrimitive{
	
	/**
	 * Evaluate the list of parameters, check if the number of parameters is conform to the
	 * parameter number of the function and apply the list of parameters to the function.
	 * @param fun The function to use.
	 * @param param The list of parameters to evaluate and use inside the function.
	 * @return The application of the parameter list to the function.
	 * @throws LispException
	 */
	public _Sexpr exec(_Function fun, _Sexpr param) throws LispException {
		_Sexpr evalSexpr = new Scons(Nil.nil, Nil.nil);
		_Sexpr tmp = param;
		int i = 0;
		
		while(tmp.getCar() != Nil.nil){
			evalSexpr = new Scons(evalSexpr, tmp.getCar().eval());
			tmp = tmp.getCdr();
			i++;
		}
		if(i != fun.getNumberOfParam()) throw new LispException("Invalid number of parameters");
		return fun.apply(tmp);
	}
}
