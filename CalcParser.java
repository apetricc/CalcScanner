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
public class CalcParser {

    private int myVar;
    public CalcParser() {
        int myVar;
        myVar = this.myVar;
    }
}
