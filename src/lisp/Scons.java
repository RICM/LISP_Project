package lisp;

import exception.LispException;

public class Scons implements _Slist{
	/**
	 * Private attributes
	 */
	private _Sexpr car;
	private _Sexpr cdr;
	
	/**
	 * @return car The _Sexpr car
	 */
	public _Sexpr getCar(){return this.car;}
	
	/**
	 * @return cdr The _Sexpr car
	 */
	public _Sexpr getCdr(){return this.cdr;}
	
	/**
	 * The constructor
	 * @param car _Sexpr car
	 * @param cdr _Sexpr cdr
	 */
	public Scons(_Sexpr car, _Sexpr cdr){
		this.car = car;
		this.cdr = cdr;
	}
	
	/**
	 * Function used to know if an _Sexpr equals $this
	 * @param a _Sexpr to compare to this
	 * @return true if equals false else
	 */
	public boolean equals(_Sexpr a){
		return this == a;
	}
	
	/**
	 * Function used to evaluate the car and decide the treatment afterwards
	 * @return _Sexpr the _Sexpr resulting from the evaluation of car
	 */
	public _Sexpr eval() throws LispException {
		_Sexpr evaluation = car.eval();
		if (evaluation == Nil.nil){
			throw new LispException("Dont expect nil as functor of Scons");
		}else if(evaluation instanceof Scons){
			throw new LispException ("Dont expect Scons as functor of Scons");
		}else if(evaluation instanceof AbstrPrimitive){
			return null;
		}else if(evaluation instanceof Fexpr){
			return null;
		}
		else{
			throw new LispException("Unexpected typo found as functor of Scons");
		}
	}
	
	public String toString(){
		return "(" + this.car.toString() + " . " + this.cdr.toString() + ")";
	}
}
