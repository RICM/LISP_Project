package lisp.function.subr;

import exception.LispException;
import lisp.*;


public class Cons extends AbstrSubr{

	/**
	 * Private Attributes
	 */
	private int numberOfParam = 2 ;
	
	/**
	 * Function used to evaluate a Car
	 * @return _Sexpr then _Sexpr resulting from evaluation
	 */
	@Override
	public _Sexpr eval() throws LispException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getNumberOfParam() {
		return numberOfParam;
	}

	@Override
	public _Sexpr apply(_Sexpr param) throws LispException {
		return new Scons(param.getCar(), param.getCdr());
	}
}
