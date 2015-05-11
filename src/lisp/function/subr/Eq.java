package lisp.function.subr;

import exception.LispException;
import lisp.*;


public class Eq extends AbstrSubr {

	private int numberOfParam = 2;
	
	@Override
	public int getNumberOfParam() {
		return this.numberOfParam;
	}

	@Override
	public _Sexpr apply(_Sexpr param) throws LispException {
		_Sexpr p1 = param.getCar();
		_Sexpr p2 = param.getCdr().getCar();
		
		if((p1 instanceof Symbol && p2 instanceof Symbol && p1.equals(p2))
				|| p1 instanceof Scons && p2 instanceof Scons && p1.equals(p2)
				|| p1 instanceof Nil && p2 instanceof Nil){
			return new Symbol("T");
		}
		else{
			return Nil.nil;
		}
	}

	@Override
	public _Sexpr eval() throws LispException {
		return new Symbol("EQ");
	}
	
	/**
	 * @return the function name
	 **/
	public String toString (){
		return "EQ";
	}

}
