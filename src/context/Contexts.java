package context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

import lisp.Nil;
import lisp.Scons;
import lisp.Symbol;
import lisp._Sexpr;
import lisp.function.fsubr.Cond;
import lisp.function.fsubr.Define;
import lisp.function.fsubr.Fdefine;
import lisp.function.fsubr.Scope;
import lisp.function.subr.Apply;
import lisp.function.subr.Atom;
import lisp.function.subr.Car;
import lisp.function.subr.Cdr;
import lisp.function.subr.Cons;
import lisp.function.subr.End;
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

		contexts.getFirst().insertValue(new Symbol("CAR"), new Car());
		contexts.getFirst().insertValue(new Symbol("CDR"), new Cdr());
		contexts.getFirst().insertValue(new Symbol("CONS"), new Cons());
		contexts.getFirst().insertValue(new Symbol("EQ"), new Eq());
		contexts.getFirst().insertValue(new Symbol("ATOM"), new Atom());
        contexts.getFirst().insertValue(new Symbol("APPLY"), new Apply());
        contexts.getFirst().insertValue(new Symbol("EVAL"), new Eval());
		
        contexts.getFirst().insertValue(new Symbol("EXPLODE"), new Explode());
		contexts.getFirst().insertValue(new Symbol("IMPLODE"), new Implode());
		contexts.getFirst().insertValue(new Symbol("PRINT"), new Print());
		contexts.getFirst().insertValue(new Symbol("EPROGN"), new Eprogn());
		contexts.getFirst().insertValue(new Symbol("SCOPE"), new Scope());
		contexts.getFirst().insertValue(new Symbol("SET"), new Set());
		contexts.getFirst().insertValue(new Symbol("LOAD"), new Load());
		contexts.getFirst().insertValue(new Symbol("QUIT"), new Quit());
        contexts.getFirst().insertValue(new Symbol("TYPEFN"), new Typefn());
        contexts.getFirst().insertValue(new Symbol("TOPLEVEL"), new Toplevel());
        contexts.getFirst().insertValue(new Symbol("END"), new End());
		
		// FSUBR
		contexts.getFirst().insertValue(new Symbol("DE"), new Define());
		contexts.getFirst().insertValue(new Symbol("DF"), new Fdefine());
		contexts.getFirst().insertValue(new Symbol("COND"), new Cond());
		
		contexts.getFirst().insertValue(new Symbol("T"), new Symbol("T"));
		
		contexts.getFirst().insertValue(new Symbol("0"), new Symbol("0"));
		contexts.getFirst().insertValue(new Symbol("1"), new Symbol("1"));
		contexts.getFirst().insertValue(new Symbol("2"), new Symbol("2"));
		contexts.getFirst().insertValue(new Symbol("3"), new Symbol("3"));
		contexts.getFirst().insertValue(new Symbol("4"), new Symbol("4"));
		contexts.getFirst().insertValue(new Symbol("5"), new Symbol("5"));
		contexts.getFirst().insertValue(new Symbol("6"), new Symbol("6"));
		contexts.getFirst().insertValue(new Symbol("7"), new Symbol("7"));
		contexts.getFirst().insertValue(new Symbol("8"), new Symbol("8"));
		contexts.getFirst().insertValue(new Symbol("9"), new Symbol("9"));
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
		it.next();
		while (it.hasNext()){
			 Map.Entry<Symbol,_Sexpr> pair = (Entry<Symbol, _Sexpr>)it.next();
			 if (pair.getValue() != null && pair.getKey() != null && pair.getValue() != Nil.nil){
				 if(pair.getValue() instanceof Scons)
					 ((Scons)pair.getValue()).isRoot = true;
				 /*System.out.println(pair.getKey().toString()
						 +"\t\t--->\t"
						 +pair.getValue().toString());*/
				 System.out.println(String.format("%-20s--> %s" , pair.getKey().toString(), pair.getValue().toString() ));
			 }
		}
	}
	
	/**
	 * Function used to get contexts size
	 * @return int The size of contexts
	 */
	public static int getNumberOfContexts(){
		return contexts.size();
	}
}
