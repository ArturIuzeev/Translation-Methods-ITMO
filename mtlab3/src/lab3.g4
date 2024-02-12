grammar lab3;

PLUS   :    '+';
MINUS  :    '-';
MULT   :    '*';
DIV    :    '/';

END    :    ';';
ASSIGN  :   '=';

INT    :    [0-9]+;
ID     :    [a-z]+;
WS     :    [ \n\t]+ -> skip;

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
    |   q MULT t
    |   q
    ;
q
    :
    |   f DIV q
    |   f
    ;
f
    :
    |   '(' e ')'
    |   INT | ID
    ;

