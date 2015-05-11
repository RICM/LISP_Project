package lisp.function.subr;

import exception.LispException;
import lisp.*;

public class Atom extends AbstrSubr {

	/**
	 * Private Attributes
	 */
	private int numberOfParam = 1;
	
	@Override
	public int getNumberOfParam() {
		return this.numberOfParam;
	}

	@Override
	public _Sexpr apply(_Sexpr param) throws LispException {
		if(param instanceof Symbol || param instanceof Nil){
			return new Symbol("T");
		}
		else{
			return Nil.nil;
		}
	}

	@Override
	public _Sexpr eval() throws LispException {
		return new Symbol("ATOM");
	}
	
	/**
	 * @return the function name
	 **/
	public String toString (){
		return "ATOM";
	}

}
