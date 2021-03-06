package lisp.function.subr;

import lisp.AbstrSubr;
import lisp.Nil;
import lisp.Symbol;
import lisp._Sexpr;
import exception.LispException;

public class Eprogn extends AbstrSubr{

	/**
	 * Private Attributes
	 */
	private int numberOfParam = 1;

	/**
	 * Function used to evaluate a Car
	 * @return _Sexpr then _Sexpr resulting from evaluation
	 */
	@Override
	public _Sexpr eval() throws LispException {
		return new Symbol("EPROGN");
	}
	
	/**
	 * @return the function name
	 **/
	public String toString (){
		return "EPROGN";
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
	 * Function used to apply an _Sexpr to the Car function
	 * @return _Sexpr The _Sexpr resulting from application
	 * @throws LispException 
	 */
	@Override
	public _Sexpr apply(_Sexpr param) throws LispException{
		_Sexpr tmp = param;
		_Sexpr out = null;
		while(tmp != Nil.nil){
			out = tmp.getCar().eval();
			tmp = tmp.getCdr();
		}
		return out;
	}
}

