package lisp.function.subr;

import exception.LispException;
import lisp.*;


public class Cons extends AbstrSubr{

	/**
	 * Private Attributes
	 */
	private int numberOfParam = 2 ;
	
	/**
	 * Public Attributes (strange)
	 */
	public _Sexpr cons;
	
	@Override
	public int getNumberOfParam() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public _Sexpr apply(_Sexpr param) throws LispException {
		_Sexpr p1=param.getCar();
		_Sexpr p2=param.getCdr();
		
		if(p2 instanceof Scons){
			return new Scons(p1, p2);
		}
		else if (p2 instanceof AbstrAtom){
			return new Scons(p1, p2); // TODO Change this shit
		}
		return null;
	}
	

	@Override
	public _Sexpr eval() throws LispException {
		return cons;

	}
}
