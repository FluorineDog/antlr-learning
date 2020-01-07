grammar Calculator;
init: stmt*;
stmt: ID '=' expr NEWLINE       #assign
    | expr NEWLINE              #show
    | NEWLINE                   #blank
    ;

expr :
       left=expr op=('*' | '/') right=expr #MulDiv
     | left=expr op=('+' | '-') right=expr #AddSub
     | ID                       #id
     | NUM                      #num
     | '(' expr ')'             #paren
     ;
ID: [a-zA-Z]+;
NUM: [0-9]+;
NEWLINE: '\r'? '\n';
WS : [ \t]+ -> skip;

