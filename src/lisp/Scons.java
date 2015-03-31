package lisp;

public class Scons implements _Slist{
	
	public _Sexpr car;
	public _Sexpr cdr;
	
	public _Sexpr getCar(){return this.car;}
	public _Sexpr getCdr(){return this.cdr;}
	
	public Scons(_Sexpr car, _Sexpr cdr){
		this.car = car;
		this.cdr = cdr;
	}
	
	public boolean equals(_Sexpr a){
		return this == a;
	}
}
