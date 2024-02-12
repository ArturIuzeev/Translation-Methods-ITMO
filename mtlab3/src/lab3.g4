grammar lab3;

PLUS   :    '+';
MINUS  :    '-';
MULT   :    '*';
DIV    :    '/';

INT    :    [0-9]+;
ID     :    [a-z]+;
WS     :    [ \n\t]+ -> skip;
END    :    ';';
ASSIGN  :   '=';

start  :
    expression*
  ;
  
expression
    :
    ID ASSIGN e END
    ;

e
   :
   |   e (PLUS | MINUS) t
   |   t
   ;

t
    :
    |   f (MULT | DIV) t
    |   f
    ;
f
    :
    |   '(' e ')'
    |   INT | ID
    ;

