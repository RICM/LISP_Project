// les prédicats de base
(de false () ())
(de true () t)
(de null (l) (eq l nil))
(de not (a) (cond (a nil) (t t)))
(de atomp (a) (atom a))
(de consp (a) (cond ((atom a) nil) (t a)))
// les fonctions standard
(df quote (a) a)
(de list (l) (cons l ()))
(de mcons (l)
	(cond ((null (cdr l)) (car l))
		(t (cons (car l) (apply mcons (cdr l))))))
(df lambda (args) (cons 'lambda args))
(df flambda (args) (cons 'flambda args))
// les fonctions de contrôle
(df progn (c) (apply eprogn c))
// les fonctions du contexte
(df let (f e . c)
	(eval (cons (cons 'lambda (cons f c)) e)))
// les fonctions I/O
(de println (l) ((lambda (a) (print) a) (apply print l)))
