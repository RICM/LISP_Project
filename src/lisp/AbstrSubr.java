package lisp;

import java.util.ArrayList;

import exception.LispException;


public abstract class AbstrSubr extends AbstrPrimitive{
	
	/**
	 * Evaluate the list of parameters, check if the number of parameters is conform to the
	 * parameter number of the function and apply the list of parameters to the function.
	 * @param fun The function to use.
	 * @param param The list of parameters to evaluate and use inside the function.
	 * @return The application of the parameter list to the function.
	 * @throws LispException
	 */
	public _Sexpr exec(_Function fun, _Sexpr param) throws LispException {
		ArrayList<_Sexpr> parametersList = new ArrayList<_Sexpr>();
		_Sexpr evalSexpr = null;
		_Sexpr paramTmp = param;
		_Sexpr tmp = paramTmp;
		int i = 0;
		
		//count number of parameters
		while(tmp != Nil.nil){
			i++;
			tmp = tmp.getCdr();
		}
		
		tmp = paramTmp;
		//System.out.println(fun.getClass().getName()+" : parameters origin list\t\t"+tmp);
		
		// evaluate the parameters
		while(tmp != null && tmp != Nil.nil){
			//System.out.println(fun.getClass().getName()+" : parameter to add\t\t"+tmp.getCar());
			if(tmp instanceof Scons){
				if(tmp.getCar().eval() instanceof _Function){
					parametersList.add(tmp.eval());
					tmp = Nil.nil;
				}else{
					if(tmp.getCar().eval() == null)
						throw new LispException("--> undefined function " + tmp.getCar() + ".");
					else{	
						parametersList.add(tmp.getCar().eval());
					}
				}
			}else{
				parametersList.add(tmp.eval());
			}
			paramTmp = paramTmp.getCdr();
			tmp = paramTmp.getCar();
		}
		
		// reconstruct the _Sexpr of parameters
		if(parametersList.size() == 1)
			evalSexpr = parametersList.get(0);
		else{
			while(!parametersList.isEmpty()){
				if(evalSexpr == null)
					evalSexpr = new Scons(parametersList.get(parametersList.size()-1), Nil.nil, false);
				else
					evalSexpr = new Scons(parametersList.get(parametersList.size()-1), evalSexpr, false);
				
				parametersList.remove(parametersList.size()-1);
			}
		}
		
		//System.out.println(fun.getClass().getName()+" : parameters list\t\t"+evalSexpr);
		
		if(i != fun.getNumberOfParam()) throw new LispException("Invalid number of parameters");
		return fun.apply(evalSexpr);
	}
}
