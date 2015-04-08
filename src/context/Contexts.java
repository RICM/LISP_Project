package context;

import java.util.LinkedList;
import lisp.*;

public class Contexts {
	
	/**
	 * Linked list of contexts
	 * static to be sure there is only one
	 */
	private static LinkedList<Context> contexts = new LinkedList<Context>();
	
	/**
	 * Function used to create a new Context and put it in 
	 * the list of contexts
	 */
	public static void addContext(){
		contexts.add(new Context());
	}
	
	/**
	 * Used to insert an association in the last Context in contexts
	 * @param symbol the Symbol used as key
	 * @param expression The _Sexpr to reference
	 */
	public static void addSymbolToLastContext(Symbol symbol, _Sexpr expression){
		contexts.getLast().insertValue(symbol, expression);
	}
	
	/**
	 * Function used to delete the last Context from contexts
	 * This will definitely end a Context.
	 */
	public static void removeLastFromContexts(){
		contexts.removeLast();
	}
	
	/**
	 * Used to find an association of symbol->Sexpr in the contexts. Starting from the last context (local) and
	 * iterating through the upper contexts (global)
	 * @param symbol The name of the symbol you want to find
	 * @return _Sexpr The Sexpr found or null if the symbol couldn't be found
	 */
	public static _Sexpr getSexprFromContexts(Symbol symbol){
		int loopVar = contexts.size();
		while (loopVar >= 0){
			if(contexts.get(loopVar).getValue(symbol) != null){
				return contexts.get(loopVar).getValue(symbol);
			}
			loopVar --;
		}
		return null;
	}
	
	/**
	 * Used to insert an association in the first Context in contexts
	 * @param symbol the Symbol used as key
	 * @param expression The _Sexpr to reference
	 */
	public static void addSymbolToFirstContext(Symbol symbol, _Sexpr expression){
		contexts.getFirst().insertValue(symbol, expression);
	}
}
