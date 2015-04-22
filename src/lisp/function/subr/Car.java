package lisp.function.subr;

import exception.LispException;

import lisp.*;

public class Car extends AbstrSubr{

	/**
	 * Private Attributes
	 */
	private int numberOfParam = 1;
	
	/**
	 * Public Attributes (strange)
	 */
	public _Sexpr car;
	
	/**
	 * Constructor with number of parameters
	 * @param numberOfParam The number of parameters
	 */
	Car(int numberOfParam){
		this.numberOfParam = numberOfParam;
	}

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
		_Sexpr tmp = Nil.nil;
		tmp = param.getCar();
		
		if(param instanceof Symbol){
			throw new LispException("Error : trying to apply car to a Symbol");
		} else {
			return tmp;
		}
	}
	
}
