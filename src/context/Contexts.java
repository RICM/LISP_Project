package context;

import java.util.LinkedList;

import lisp.*;
import lisp.function.fsubr.Define;
import lisp.function.fsubr.Fdefine;
import lisp.function.fsubr.Quote;
import lisp.function.subr.Atom;
import lisp.function.subr.Car;
import lisp.function.subr.Cdr;
import lisp.function.subr.Cons;
import lisp.function.subr.Eq;
import lisp.function.subr.Implode;
import lisp.function.subr.Load;
import lisp.function.subr.Print;
import lisp.function.subr.Quit;
import lisp.function.subr.Set;

public class Contexts {
	
	/**
	 * WARNING : ONLY ONE CONTEXT CAN BE USED AT THE SAME TIME
	 * DO NOT TRY TO USE MORE THAN ONE LISP WORKING MACHINE AT ONCE
	 */
	
	/**
	 * Function used to get the list with all contexts
	 * @return Contexts the list with contexts
	 */
	public static Contexts contexts(){
		return new Contexts();
	}
	
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
	
	public static void setMinimalContexts(){
		addContext();
		
		// SUBR
		contexts.getFirst().insertValue("CAR".hashCode(), new Car());
		contexts.getFirst().insertValue("CDR".hashCode(), new Cdr());
		contexts.getFirst().insertValue("CONS".hashCode(), new Cons());
		contexts.getFirst().insertValue("EQ".hashCode(), new Eq());
		contexts.getFirst().insertValue("ATOM".hashCode(), new Atom());
		
		contexts.getFirst().insertValue("IMPLODE".hashCode(), new Implode());
		contexts.getFirst().insertValue("PRINT".hashCode(), new Print());
		contexts.getFirst().insertValue("SET".hashCode(), new Set());
		contexts.getFirst().insertValue("LOAD".hashCode(), new Load());
		contexts.getFirst().insertValue("QUIT".hashCode(), new Quit());
		
		// FSUBR
		contexts.getFirst().insertValue("DE".hashCode(), new Define());
		contexts.getFirst().insertValue("DF".hashCode(), new Fdefine());
		
		// TODO remove
		contexts.getFirst().insertValue("QUOTE".hashCode(), new Quote());
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
		int loopVar = contexts.size()-1;
		while (loopVar >= 0){
			if(contexts.get(loopVar).getValue(symbol) != null){
				return contexts.get(loopVar).getValue(symbol);
			}
			loopVar--;
		}
		//System.out.println(symbol+" : Not found");
		return null;
	}
	
	/**
	 * 
	 * @param symbol
	 * @return
	 */
	public static void changeSexprInContexts(Symbol symbol, _Sexpr expression){
		contexts.getFirst().insertValue(symbol, expression);
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
