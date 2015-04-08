package lisp.function.subr;

import exception.LispException;
import lisp.AbstrSubr;
import lisp._Sexpr;

public class Cdr extends AbstrSubr{

	/**
	 * Private Attributes
	 */
	private int numberOfParam;
	
	/**
	 * Public Attributes (strange)
	 */
	public _Sexpr cdr;

	/**
	 * Constructor with number of parameters
	 * @param numberOfParam The number of parameters
	 */
	public Cdr(int numberOfParam){
		this.numberOfParam = numberOfParam;
	}
	
	/**
	 * Function used to evaluate a Cdr
	 * @return _Sexpr then _Sexpr resulting from evaluation
	 */
	@Override
	public _Sexpr eval() throws LispException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Function used to get the number of parameters
	 * @return int The number of parameters of the Cdr function
	 */
	@Override
	public int getNumberOfParam() {
		return this.numberOfParam;
	}

	/**
	 * Function used to apply an _Sexpr to the Cdr function
	 * @return _Sexpr The _Sexpr resulting from application
	 */
	@Override
	public _Sexpr apply(_Sexpr param) {
		// TODO Auto-generated method stub
		return null;
	}
}
