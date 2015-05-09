package lisp.function.subr;

import lisp.AbstrSubr;
import lisp.Nil;
import lisp._Sexpr;
import exception.LispException;

public class Print extends AbstrSubr{

	/**
	 * Private Attributes
	 */
	private int numberOfParam = Integer.MAX_VALUE;

	/**
	 * Function used to evaluate a Car
	 * @return _Sexpr then _Sexpr resulting from evaluation
	 */
	@Override
	public _Sexpr eval() throws LispException {
		// TODO Auto-generated method stub
		return null;
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
			if(tmp.getCdr() == Nil.nil)
				out = tmp.getCar();
			tmp = tmp.getCdr();
		}
		System.out.println(param.toString().substring(1, param.toString().length()-1));
		return out;
	}
}
