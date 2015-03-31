package lisp.function.subr;

import exception.LispException;
import lisp.AbstrSubr;
import lisp._Sexpr;

public class Car extends AbstrSubr{

	public _Sexpr car;
	
	public Car(String name) {
		super(name);
	}
	
	public _Sexpr getCar() throws LispException {
		return this.car.getCar();
	}
}
