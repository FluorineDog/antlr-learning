DIR=/usr/local/lib
JAR=${DIR}/antlr-4.7.2-complete.jar
CLASSPATH=".:${JAR}"
alias antlr="java -jar ${JAR}"
alias grun="java org.antlr.v4.gui.TestRig"

