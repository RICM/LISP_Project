package lisp.function.subr;

import lisp.AbstrSubr;
import lisp.Scons;
import lisp.Symbol;
import lisp._Sexpr;
import exception.LispException;

public class Eval extends AbstrSubr{

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
		return new Symbol("EVAL");
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
		_Sexpr out = param.eval().getCar();
		if(out instanceof Scons)
			((Scons)out).isRoot = true;
		return out;
	}
	
	/**
	 * @return String The function name
	 */
	public String toString(){
		return "EVAL";
	}
}
