package lisp;

import exception.LispException;
import context.Contexts;

public class Symbol extends AbstrAtom {
	
	public String name;
	
	/**
	 * Default constructor for Symbol class
	 * @param name
	 */
	public Symbol(String name){
		this.name = name.toUpperCase();
	}	
	
	/**
	 * Function used to know if a symbol equals another one based on name
	 */
	public boolean equals(Object a){
		return this.name.equals(((Symbol)a).name);
	}

	/**
	 * Evaluates a symbol
	 * @return _Sexpr The _Sexpr associated to $this
	 */
	@Override
	public _Sexpr eval() throws LispException {
		_Sexpr out = Contexts.getSexprFromContexts(this);
		if(out == null)
			throw new LispException("Variable "+this.name+" has no value");
		return out;
	}
	
	public String toString(){
		return this.name;
	}
	
	public int hashCode(){
		return name.hashCode();
	}
}
