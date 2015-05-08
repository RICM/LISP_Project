package lisp;

import exception.LispException;

public class Fexpr extends AbstrFunction {
	
	/**
	 * Constructor with number of parameters
	 * @param numberOfParam The number of parameters
	 */
	public Fexpr(){
	}
	
	/**
	 * Function used to get the number of parameters
	 * @return int The number of parameters of the Fexpr function
	 */
	@Override
	public int getNumberOfParam() {
		return 0;
	}

	/**
	 * Function used to apply an _Sexpr to the Fexpr function
	 * @return _Sexpr The _Sexpr resulting from application
	 * @throws LispException 
	 */
	@Override
	public _Sexpr apply(_Sexpr fun) throws LispException {
		_Sexpr listOfParamFormel = fun.getCar().getCar();
		_Sexpr prog = fun.getCar().getCdr();
		
		// liaison des parametres
		
		
		// evaluation du corps de la fonction
		prog.eval();
		
		// destruction de la liaison
		
		
		return null;
	}
}
