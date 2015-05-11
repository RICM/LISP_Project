package lisp.function.fsubr;

import lisp.AbstrFsubr;
import lisp.Symbol;
import context.Contexts;
import lisp._Sexpr;
import exception.LispException;

public class Scope extends AbstrFsubr {

	private int numberOfParam = 0;
	
	/**
	 * Function used to evaluate a Scope, returns null since can't evaluate this
	 * @return _Sexpr then _Sexpr resulting from evaluation
	 */
	@Override
	public _Sexpr eval() throws LispException {
		return new Symbol("SCOPE");
	}
	
	/**
	 * Function used to get the number of parameters
	 * @return int The number of parameters of the Scope function
	 */
	@Override
	public int getNumberOfParam() {
		return this.numberOfParam;
	}
	
	/**
	 * Function used to apply an _Sexpr to the Scope function
	 * @return null
	 * @throws LispException 
	 */
	@Override
	public _Sexpr apply(_Sexpr param) throws LispException{
		Contexts.printScope();
		return null;
	}
	
	public void print () {
		Contexts.printScope();
	}
	
	/**
	 * @return String The function name
	 */
	public String toString(){
		return "SCOPE";
	}
}
