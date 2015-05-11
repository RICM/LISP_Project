package context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import lisp.Nil;
import lisp.Symbol;
import lisp._Sexpr;
import lisp.function.fsubr.Cond;
import lisp.function.fsubr.Define;
import lisp.function.fsubr.Fdefine;
import lisp.function.fsubr.Scope;
import lisp.function.subr.Atom;
import lisp.function.subr.Car;
import lisp.function.subr.Cdr;
import lisp.function.subr.Cons;
import lisp.function.subr.Eprogn;
import lisp.function.subr.Eq;
import lisp.function.subr.Eval;
import lisp.function.subr.Explode;
import lisp.function.subr.Implode;
import lisp.function.subr.Load;
import lisp.function.subr.Print;
import lisp.function.subr.Quit;
import lisp.function.subr.Set;
import lisp.function.subr.Toplevel;
import lisp.function.subr.Typefn;

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
		contexts.getFirst().insertValue("EVAL".hashCode(), new Eval());
		
		contexts.getFirst().insertValue("EXPLODE".hashCode(), new Explode());
		contexts.getFirst().insertValue("IMPLODE".hashCode(), new Implode());
		contexts.getFirst().insertValue("PRINT".hashCode(), new Print());
		contexts.getFirst().insertValue("EPROGN".hashCode(), new Eprogn());
		contexts.getFirst().insertValue("SET".hashCode(), new Set());
		contexts.getFirst().insertValue("LOAD".hashCode(), new Load());
		contexts.getFirst().insertValue("QUIT".hashCode(), new Quit());
		contexts.getFirst().insertValue("TYPEFN".hashCode(), new Typefn());
		contexts.getFirst().insertValue("TOPLEVEL".hashCode(), new Toplevel());
		contexts.getFirst().insertValue("SCOPE".hashCode(), new Scope());
		
		// FSUBR
		contexts.getFirst().insertValue("DE".hashCode(), new Define());
		contexts.getFirst().insertValue("DF".hashCode(), new Fdefine());
		contexts.getFirst().insertValue("COND".hashCode(), new Cond());
		
		contexts.getFirst().insertValue("T".hashCode(), new Symbol("T"));
		
		contexts.getFirst().insertValue("0".hashCode(), new Symbol("0"));
		contexts.getFirst().insertValue("1".hashCode(), new Symbol("1"));
		contexts.getFirst().insertValue("2".hashCode(), new Symbol("2"));
		contexts.getFirst().insertValue("3".hashCode(), new Symbol("3"));
		contexts.getFirst().insertValue("4".hashCode(), new Symbol("4"));
		contexts.getFirst().insertValue("5".hashCode(), new Symbol("5"));
		contexts.getFirst().insertValue("6".hashCode(), new Symbol("6"));
		contexts.getFirst().insertValue("7".hashCode(), new Symbol("7"));
		contexts.getFirst().insertValue("8".hashCode(), new Symbol("8"));
		contexts.getFirst().insertValue("9".hashCode(), new Symbol("9"));
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
	
	/**
	 * Function used to get Scope from all the current contexts
	 * @return HashMap<Symbol, _Sexpr> the hashmap with the scope
	 */
	public static HashMap<Symbol, _Sexpr> getScope(){
		HashMap<Symbol, _Sexpr> scope = new HashMap<Symbol, _Sexpr>();
		ListIterator<Context> listIterator = contexts.listIterator();
        while (listIterator.hasNext()) {
            scope.putAll(listIterator.next().getScopeFromContext());
        }
		return scope;
	}
	
	public static void printScope(){
		HashMap<Symbol, _Sexpr> scope = getScope();
		Iterator<Entry<Symbol, _Sexpr>> it = scope.entrySet().iterator();
		while (it.hasNext()){
			 Map.Entry<Symbol,_Sexpr> pair = (Entry<Symbol, _Sexpr>)it.next();
			 if (pair.getValue() != null && pair.getKey() != null && pair.getValue() != Nil.nil){
				 System.out.println(pair.getKey().toString()
						 +"\t\t--->\t"
						 +pair.getValue().toString());
			 }
		}
	}
}
