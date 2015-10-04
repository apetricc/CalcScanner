/**
 * Created by petriccione on 9/29/15.
 */

/**
 program −→ stmt list $$
 stmt list −→ stmt stmt list | ε
 stmt −→ id := expr | read id | write expr expr −→ term term tail
 term tail −→ add op term term tail | ε
 term −→ factor factor tail
 factor tail −→ mult op factor factor tail | ε factor −→ ( expr ) | id | number
 add op −→ + | -
 mult op −→ * | /
 Figure 2.15 LL(1) grammar for a simple calculator language.

 Write a class called CalcParser. CalcParser should have one public method (aside from its constructor)
 called parse() that starts a recursive descent parsing of a program written in the language of fig. 2.15
 from the textbook. (See programming assignment #1 for the grammar.) The constructor should create an instance of
 the CalcScanner class and pass it the input source file.
 */

/** "OFFICIAL" PSEUDO-CODE:
 *   parse() {
 *       lookahead = nextToken();
 *       program();
 *       System.out.println("Parse success!");
 *   }
 *
 *   program() {
 *       if (lookahead == VAR) {
 *           variable_list();
 *       }
 *       stmt_list()
 *       match(EOP)
 *   }
 *   variable_list() {
 *       match(VAR);
 *       while(lookahead == ID) {
 *           match(ID);
 *       }
 *       match(ENDVAR);
 *   }
 *   stmt_list() {
 *       while(lookahead == ID || lookahead == READ || lookahead == WRITE)
 *         stmt()
 *   }
 *   stmt() {
 *       if (lookahead == ID) {
 *           match(ID);
 *           match(ASSIGN);
 *           expr()
 *       }
 *       else if (lookahead == READ) {
 *           match(READ);
 *           match(ID);
 *       }
 *       else if (lookahead == WRITE) {
 *           match(WRITE);
 *           expr();
 *       }
 *       else error();
 *   }
 *   expr() {
 *       term();
 *       while (lookahead == ADDOP) {
 *           match(ADDOP);
 *           term();
 *       }
 *   }
 *   term() {
 *       factor();
 *       while(lookahead == MULOP) {
 *           match(MULOP);
 *           factor();
 *       }
 *   }
 *   factor() {
 *       if (lookahead == LPAREN) {
 *           match(LPAREN);
 *           expr();
 *           match(RPAREN);
 *       }
 *       else if (lookahead == ID) {
 *           match(ID);
 *       }
 *       else if (lookahead == NUM) {
 *           match(NUM);
 *       }
 *       else error();
 *   }
 *   match (token) {
 *       if (lookahead == token) {
 *           lookahead = nextToken();
 *       }
 *       else error();
 *   }
 *
 *
 */
public class CalcParser {

    private int myVar;
    public CalcParser() {
        int myVar;
        myVar = this.myVar;
    }
}
