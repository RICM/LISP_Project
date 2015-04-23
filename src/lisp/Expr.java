package lisp;

import lisp.function.subr.*;

public class Expr extends AbstrFunction{
	
	/**
	 * Constructor with number of parameters
	 * @param numberOfParam The number of parameters
	 */
	public Expr(){
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
	 * Function used to apply an _Sexpr to the Expr function
	 * @return _Sexpr The _Sexpr resulting from application
	 */
	@Override
	public _Sexpr apply(_Sexpr param) {
		return null;
	}
}
