package lisp.function.subr;

import lisp.AbstrSubr;
import lisp.Scons;
import lisp.Symbol;
import lisp._Sexpr;
import exception.LispException;

public class Typefn extends AbstrSubr{

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
		_Sexpr out;
		if(param instanceof Symbol){
			out = ((Symbol)param).eval();
			if(out instanceof AbstrSubr)
				return new Symbol("subr");
			else
				return new Symbol("fsubr");
		}
		else if(param instanceof Scons){
			if(param.getCar() instanceof Symbol)
				if(((Symbol)param.getCar()).name.equals("LAMBDA"))
					return new Symbol("expr");
				else if(((Symbol)param.getCar()).name.equals("FLAMBDA"))
					return new Symbol("fexpr");
				else
					throw new LispException("Parameter not valable for this function.");
			else
				throw new LispException("Parameter not valable for this function.");
		}
		else
			throw new LispException("Nil is not valable for this function.");
	}
}
