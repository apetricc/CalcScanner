/**
 * Created by petriccione on 9/29/15.
 * <p/>
 * program −→ stmt list $$
 * stmt list −→ stmt stmt list | ε
 * stmt −→ id := expr | read id | write expr expr −→ term term tail
 * term tail −→ add op term term tail | ε
 * term −→ factor factor tail
 * factor tail −→ mult op factor factor tail | ε factor −→ ( expr ) | id | number
 * add op −→ + | -
 * mult op −→ * | /
 * Figure 2.15 LL(1) grammar for a simple calculator language.
 * <p/>
 * Write a class called CalcParser. CalcParser should have one public method (aside from its constructor)
 * called parse() that starts a recursive descent parsing of a program written in the language of fig. 2.15
 * from the textbook. (See programming assignment #1 for the grammar.) The constructor should create an instance of
 * the CalcScanner class and pass it the input source file.
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

import java.io.IOException;

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
public class CalcParser implements Tokens{
    
    private CalcScanner myScanner;
    private int lookahead;

    public CalcParser(String file) throws IOException {
        myScanner = new CalcScanner(file);
        lookahead = CalcScanner.nextToken();
    }

    /**
    private String file;
    CalcParser myParser = new CalcParser(file);
    */

    public void parse() throws IOException {
        lookahead = CalcScanner.nextToken();
        program(lookahead);
        System.out.println("Parse success!");
    }

    private void program(int lookahead) throws IOException {
/**
        if (lookahead == VAR) {
            variable_list();
        }
 */
        stmt_list();
        match(EOP);
    }
/**
    private void variable_list() throws IOException {
        match(VAR);
        while (lookahead == ID) {
            match(ID);
        }
        match(ENDVAR);
    }
*/
    private void stmt_list() throws IOException {
        while (lookahead == ID || lookahead == READ || lookahead == WRITE)
            stmt();
    }

    private void stmt() throws IOException {
        if (lookahead == ID) {
            match(ID);
            match(ASSIGN);
            expr();
        } else if (lookahead == READ) {
            match(READ);
            match(ID);
        } else if (lookahead == WRITE) {
            match(WRITE);
            expr();
        } else error(lookahead);
    }

    private void expr() throws IOException {
        term();
        while (lookahead == ADDOP) {
            match(ADDOP);
            term();
        }
    }

    private void term() throws IOException {
        factor();
        while (lookahead == MULOP) {
            match(MULOP);
            factor();
        }
    }

    private void factor() throws IOException {
        if (lookahead == LPAREN) {
            match(LPAREN);
            expr();
            match(RPAREN);
        } else if (lookahead == ID) {
            match(ID);
        } else if (lookahead == NUM) {
            match(NUM);
        } else error(lookahead);
    }

    private void match(int expected) throws IOException {
        if (lookahead == expected) {
            lookahead = CalcScanner.nextToken();
        } else error(expected);
    }
    private void error(int expected) {

        System.out.println("Error.  Token " + expected + " was expected " + lookahead + " was received.");
    }

}// class CalcParse end.
