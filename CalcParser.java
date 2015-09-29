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
 */
public class CalcParser {
}
