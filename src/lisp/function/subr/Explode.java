package lisp.function.subr;

import lisp.AbstrSubr;
import lisp.Nil;
import lisp.Scons;
import lisp.Symbol;
import lisp._Sexpr;
import exception.LispException;

public class Explode extends AbstrSubr{

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
		return new Symbol("EXPLODE");
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
		_Sexpr out = null;
		if(!(param instanceof Symbol))
			throw new LispException("Parameter is not a Symbol");
		String s = param.toString();
		
		char c;
		while(s.length() > 0){
			c = s.charAt(s.length()-1);
			
			if(out == null)
				out = new Scons(new Symbol(c+""), Nil.nil, false);
			else 
				out = new Scons(new Symbol(c+""), out, false);
			s = s.substring(0, s.length()-1);
		}
		
		return out;
	}
}
