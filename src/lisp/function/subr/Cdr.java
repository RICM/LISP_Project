package lisp.function.subr;

import exception.LispException;
import lisp.*;

public class Cdr extends AbstrSubr{

	/**
	 * Private Attributes
	 */
	private int numberOfParam = 1;
	
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
	 * @throws LispException 
	 */
	@Override
	public _Sexpr apply(_Sexpr param) throws LispException{
		
		if (param instanceof Symbol){
			throw new LispException ("Invalid apply of CDR to a Symbol");
		}
		else{
			return param.getCdr();
		}
	}
		
}
