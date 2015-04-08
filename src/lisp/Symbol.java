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
		this.name = name;
	}	
	
	/**
	 * 
	 */
	public boolean equals(Object a){
		return this.name.equals(((Symbol)a).name);
	}

	@Override
	public _Sexpr eval() throws LispException {
		return Contexts.getSexprFromContexts(this);
	}
}
