package lisp.function.subr;

import lisp.AbstrSubr;
import lisp.Symbol;
import lisp._Sexpr;
import exception.LispException;

public class Apply extends AbstrSubr{

	/**
	 * Private Attributes
	 */
	private int numberOfParam = 2;

	/**
	 * Function used to evaluate a Car
	 * @return _Sexpr then _Sexpr resulting from evaluation
	 */
	@Override
	public _Sexpr eval() throws LispException {
		return new Symbol("APPLY");
	}

	/**
	 * Function used to get the number of parameters
	 * @return int The number of parameters of the Car function
	 */
	@Override
	public int getNumberOfParam() {
		return this.numberOfParam;
	}

	/**
	 * Function used to apply an _Sexpr to the Apply function
	 * @return _Sexpr The _Sexpr resulting from application
	 * @throws LispException 
	 */
	@Override
	public _Sexpr apply(_Sexpr param) throws LispException{
				return param.getCar() ;
	}
	
	/**
	 * @return String The function name
	 */
	public String toString(){
		return "APPLY";
	}
		
}

