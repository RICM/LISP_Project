package context;

import java.util.HashMap;
import lisp.*;

public class Context {
	
	/**
	 * The map that contains the associations of <Symbol, _Sexpr> in a context
	 */
	private HashMap<Integer, _Sexpr> context;
	
	/**
	 * Used to create a new Context of <Symbol, _Sexpr>
	 */
	public Context(){
		this.context = new HashMap<Integer, _Sexpr>();
	}
	
	/**
	 * Function used to get the _Sexpr associated to a symbol
	 * @param value Symbol that
	 * @return _Sexpr if association found null if not found
	 */
	public _Sexpr getValue(Symbol value){
		return this.context.get(value.hashCode());
	}
	
	/**
	 * Function used to insert an association of Symbol and _Sexpr
	 * if Symbol is already used in association replaces old _Sexpr by new _Sexpr
	 * else insert new association
	 * @param symbol The Symbol used as key
	 * @param expression The expression to reference
	 */
	public void insertValue(Symbol symbol, _Sexpr expression){
		this.context.put(symbol.hashCode(), expression);
	}
	
	/**
	 * Function used to insert an association of Symbol and _Sexpr
	 * if Symbol is already used in association replaces old _Sexpr by new _Sexpr
	 * else insert new association
	 * @param symbol The integer used as key
	 * @param expression The expression to reference
	 */
	public void insertValue(int symbol, _Sexpr expression){
		this.context.put(symbol, expression);
	}
}
