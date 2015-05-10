package context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import lisp.*;

public class Context {
	
	/**
	 * The map that contains the associations of <Integer, _Sexpr> in a context
	 */
	private HashMap<Integer, _Sexpr> context;
	
	/**
	 * The map that countains the associations of <Integer, Symbol> in a context
	 */
	private HashMap<Integer, Symbol> symbol_association;
	
	/**
	 * Used to create a new Context of <Symbol, _Sexpr>
	 */
	public Context(){
		this.context = new HashMap<Integer, _Sexpr>();
		this.symbol_association = new HashMap<Integer, Symbol>();
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
		this.symbol_association.put(symbol.hashCode(), symbol);
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
	
	/**
	 * Function used to fill the HashMap with the $this context
	 * @param mapToUpdate the HashMap to fill with $this context
	 * @return mapUpdated the HashMap filled with $this context
	 * @ensure mapUpdated = mapToUpdate+Update
	 */
	public HashMap<Symbol, _Sexpr> getScopeFromContext(){
		HashMap<Symbol, _Sexpr> mapToUpdate = new HashMap<Symbol, _Sexpr>();
		Iterator<Entry<Integer,_Sexpr>> it = this.context.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry<Integer,_Sexpr> pair = (Entry<Integer, _Sexpr>)it.next();
			mapToUpdate.put(symbol_association.get(pair.getKey()), pair.getValue());
	        it.remove();
	    }
		return mapToUpdate;
	}
}
