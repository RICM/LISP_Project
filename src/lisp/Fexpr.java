package lisp;

import context.Contexts;
import exception.LispException;

public class Fexpr extends AbstrFunction {
	
	/**
	 * Constructor with number of parameters
	 * @param numberOfParam The number of parameters
	 */
	public Fexpr(){
	}
	
	/**
	 * Function used to get the number of parameters
	 * @return int The number of parameters of the Fexpr function
	 */
	@Override
	public int getNumberOfParam() {
		return 0;
	}

	/**
	 * Function used to apply an _Sexpr to the Fexpr function
	 * @return _Sexpr The _Sexpr resulting from application
	 * @throws LispException 
	 */
	@Override
	public _Sexpr apply(_Sexpr fun) throws LispException {
		_Sexpr listOfParamFormel = fun.getCar().getCar();
		_Sexpr prog = fun.getCar().getCdr();
		_Sexpr listOfParamEffect = fun.getCdr();
		
		// liaison des parametres
		Contexts.addContext();
		
		while(listOfParamFormel != Nil.nil){
			if(listOfParamEffect == Nil.nil)
				throw new LispException("Invalid number of parameters");
			if(!(listOfParamFormel.getCar() instanceof Symbol))
				throw new LispException(listOfParamFormel.getCar()+"is not a Symbol.");
			else{
				//System.out.println("Formel : "+(Symbol)listOfParamFormel.getCar());
				//System.out.println("Effect : "+listOfParamEffect.getCar());
				Contexts.addSymbolToLastContext((Symbol)listOfParamFormel.getCar(), listOfParamEffect.getCar());
			}
			
			listOfParamFormel = listOfParamFormel.getCdr();
			listOfParamEffect = listOfParamEffect.getCdr();
		}
		if(listOfParamEffect != Nil.nil)
			throw new LispException("Invalid number of parameters");
		
		// evaluation du corps de la fonction
		//System.out.println("Function : "+prog);
		_Sexpr out = prog.getCar().eval();
		
		// destruction de la liaison
		Contexts.removeLastFromContexts();
		
		return out;
	}
}
