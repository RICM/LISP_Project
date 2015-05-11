package lisp.function.subr;

import exception.LispException;
import lisp.*;

public class Car extends AbstrSubr{

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
		return new Symbol("CAR");
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
		if(param instanceof Symbol){
			throw new LispException("Error : trying to apply CAR to a Symbol");
		} else{
			if(param.getCar() instanceof Scons && param.getCdr() == Nil.nil){
				if(param.getCar().getCar() instanceof Scons)
					((Scons)param.getCar().getCar()).isRoot = true;
				return param.getCar().getCar();
			}
			else{
				if(param.getCar() instanceof Scons)
					((Scons)param.getCar()).isRoot = true;
				return param.getCar();
			}
		}
	}
	
	/**
	 * @return the function name
	 **/
	public String toString (){
		return "CAR";
	}
}
