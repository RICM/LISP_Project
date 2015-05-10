package lisp.function.fsubr;

import lisp.AbstrFsubr;
import lisp.Nil;
import lisp.Scons;
import lisp.Symbol;
import lisp._Sexpr;
import exception.LispException;

public class Cond extends AbstrFsubr{

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
		_Sexpr cond;
		while(tmp != Nil.nil){
			cond = tmp.getCar().getCar().eval();
			if(cond instanceof Symbol && ((Symbol)cond).name.equals("T")){
				_Sexpr out = tmp.getCar().getCdr().eval();
				if(out instanceof Scons)
					((Scons)out).isRoot = false;
				return out;
			}
			tmp = tmp.getCdr();
		}
		return Nil.nil;
	}
}