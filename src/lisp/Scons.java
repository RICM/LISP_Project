package lisp;

import exception.LispException;

public class Scons implements _Slist{
	/**
	 * Private attributes
	 */
	private _Sexpr car;
	private _Sexpr cdr;
	public boolean isRoot = true;
	public boolean isPaired = false;
	
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
	 * @param isPaired TODO
	 */
	public Scons(_Sexpr car, _Sexpr cdr, boolean isPaired){
		this.car = car;
		this.cdr = cdr;
		
		if(this.car instanceof Scons)
			((Scons)this.car).isRoot = false;
		if(this.cdr instanceof Scons)
			((Scons)this.cdr).isRoot = false;
		
		this.isPaired = isPaired;
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
	 * HAVE TO BE MODIFIED // COMPLETED 
	 */
	
	/**
	 * Function used to evaluate the car and decide the treatment afterwards
	 * @return _Sexpr the _Sexpr resulting from the evaluation of car
	 */
	public _Sexpr eval() throws LispException {
		_Sexpr evaluation = car;
		
		if (evaluation == Nil.nil){
			throw new LispException("Dont expect nil as functor of Scons");
		}else if(evaluation instanceof Scons){
			if(evaluation.getCar() instanceof Symbol){
				if(((Symbol) evaluation.getCar()).name.equals("lambda"))
					return new Expr().apply(new Scons(evaluation.getCdr(), this.getCdr(), false));
				else if(((Symbol) evaluation.getCar()).name.equals("flambda"))
					return new Fexpr().apply(new Scons(evaluation.getCdr(), this.getCdr(), false));
				else
					return new Scons(evaluation.eval(), this.getCdr().eval(), false);
			}else{
				throw new LispException("Unexpected typo found as functor of Scons");
			}
		}else if(evaluation instanceof Symbol){
			
			//System.out.println(((Symbol)evaluation).name);
			
			if(evaluation.eval() instanceof AbstrSubr){
				return ((AbstrSubr)evaluation.eval()).exec((_Function)evaluation.eval(), this.getCdr());
			}
			else if(evaluation.eval() instanceof AbstrFsubr)
				return ((AbstrFsubr)evaluation.eval()).exec((_Function)evaluation.eval(), this.getCdr());
			else
				return new Scons(evaluation.eval(), getCdr().eval(), false);
		}else{
			throw new LispException("Unexpected typo found as functor of Scons");
		}
	}
	
	public String toString(){
		/*if(this.isRoot)
			return "(" + this.car.toString() + " " + this.cdr.toString() + ")";
		if(this.car instanceof Symbol && this.cdr == Nil.nil)
			return this.car.toString();
		if(this.car instanceof Symbol && this.cdr instanceof Scons)
			return this.car.toString() + " " + this.cdr.toString();
		if(this.car instanceof Scons && this.cdr == Nil.nil)
			return "(" + this.car.toString() + ")";
		/*if(this.car instanceof Scons && this.cdr != Nil.nil)
			return "((" + this.car.toString() + ") " + this.cdr.toString()+")";*/
		//if(this.car instanceof Scons)
			//return "(" + this.car.toString() + ") " + this.cdr.toString();
		
		String str = (this.isRoot)? "(" : "";
		str += (this.car instanceof Scons)? "(": "";
		str += this.car.toString();
		str += (this.car instanceof Scons)? ")" : "";
		if(!((this.car instanceof Symbol && this.cdr == Nil.nil) || (this.car instanceof Scons && this.cdr == Nil.nil)))
			if(this.isPaired)
				str += " . " + this.cdr.toString();
			else
				str += " " + this.cdr.toString();
		str += (this.isRoot)? ")" : "";
		
		
		/*String str = ((this.cdr == Nil.nil && this.car instanceof Scons) || this.isRoot)? "(" : "";
		str += this.car;
		str += (this.cdr == Nil.nil)? "" : " "+this.cdr;
		str += ((this.cdr == Nil.nil && this.car instanceof Scons) || this.isRoot)? ")" : "";*/
		return str;
		
		//DEBUG
 		//return "(" + this.car.toString() + " . " + this.cdr.toString() + ")";
	}
}
