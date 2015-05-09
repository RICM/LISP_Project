package lisp.function.subr;

import lisp.AbstrSubr;
import lisp.Scons;
import lisp.Symbol;
import lisp._Sexpr;
import context.Contexts;
import exception.LispException;

public class Set extends AbstrSubr{

	/**
	 * Private Attributes
	 */
	private int numberOfParam = 2;

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
		if(!(param.getCar() instanceof Symbol))
			throw new LispException("Error : trying to apply SET to another thing than a Symbol");
		else{
			Contexts.changeSexprInContexts((Symbol)param.getCar(), param.getCdr().getCar());
			if(param.getCdr().getCar() instanceof Scons)
				((Scons)param.getCdr().getCar()).isRoot = true;
			return param.getCdr().getCar();
		}
	}
}
