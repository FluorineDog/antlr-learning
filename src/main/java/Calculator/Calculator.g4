grammar Calculator;
init: stmt*;
stmt: ID '=' expr NEWLINE
    | expr NEWLINE
    | NEWLINE;
expr :
       expr ('*' | '/') expr
     | expr ('+' | '-') expr
     | ID
     | NUM
     | '(' expr ')'
     ;
ID: [a-zA-Z]+;
NUM: [0-9]+;
NEWLINE: '\r'? '\n';
WS : [ \t]+ -> skip;

