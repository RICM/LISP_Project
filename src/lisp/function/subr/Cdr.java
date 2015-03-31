package lisp.function.subr;

import exception.LispException;
import lisp.AbstrSubr;
import lisp._Sexpr;

public class Cdr extends AbstrSubr{

	public _Sexpr cdr;
	
	public Cdr(String name) {
		super(name);
	}
	
	public _Sexpr getCdr() throws LispException {
		return this.cdr.getCdr();
	}
}
