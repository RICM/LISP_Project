package lisp.function.subr;

import exception.LispException;
import lisp.*;

public class Atom extends AbstrSubr {

	private int numberOfParam = 1;
	
	@Override
	public int getNumberOfParam() {
		return this.numberOfParam;
	}

	@Override
	public _Sexpr apply(_Sexpr param) throws LispException {
		if(param instanceof Symbol || param instanceof Nil){
			return new Scons(new Symbol("t"), Nil.nil);
		}
		else{
			return Nil.nil;
		}
	}

	@Override
	public _Sexpr eval() throws LispException {
		// TODO Auto-generated method stub
		return null;
	}

}