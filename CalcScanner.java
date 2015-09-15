/**
 *  csci 431 project 1:
 *
 * Created by petriccione on 9/12/15.
 */

import java.io.*;

public class CalcScanner implements Tokens{
    String fileName;
    FileReader reader;
    PushbackReader pbReader;
    String token;

    public CalcScanner(String fileName) throws IOException {
        this.fileName = fileName;

        try {
            reader = new FileReader(fileName);
        }
        catch(FileNotFoundException e) {
            System.out.println("File " + fileName + " does not exist. Quitting.");
            System.exit(0);
        }
        pbReader = new PushbackReader(reader);
        while(token != "EOF") {
            System.out.println(nextToken());
        }
    }




    public int nextToken() {

        int  c = 0;
        StringBuilder lexeme = new StringBuilder("");
        int assign;

        try {
            while(true)

            {
                c = pbReader.read();
                if (c == -1){
                    token = "EOF";
                    break;
                }

                while(c ==' ' || c == '\n' || c == 't' || c == '\r') pbReader.read();

                if (c == '(' ||
                        c == ')' ||
                        c == '+' ||
                        c == '-' ||
                        c == '*' ||
                        c == '/'  ) {

                    switch (c) {
                        case '(': return '(';

                        case ')': return ')';
                        case '+': return '+';
                        case '-': return '-';
                        case '*': return '*';
                        case '/': return '/';
                    }
                }
                if ((char) c == ':') {
                    while(true) {
                        assign = pbReader.read();
                        if (assign != '=') return -1;
                        return ASSIGN;
                    }
                }
                if ((char) c == 'r') {
                    while(true) {
                        lexeme.append((char) c);
                        if (lexeme.equals("read")) {
                            System.out.println("GOT A READ");
                            return READ;
                        }
                    }
                }
                if (lexeme.equals("write")) return WRITE;
                System.out.println("Made it to point a");
            }
            //lexeme.append((char) c);
            return -1;


            // Test of the unread. The lexeme should have the last character
            // read repeated at the end.
            //pbReader.unread(c);
            // c = pbReader.read();
            //sb.append((char) c);
        } catch (IOException e) {
            System.out.println("Something went wrong with a read. Quitting...");
            System.exit(0);
        }

        System.out.println(lexeme);
        return -1;
    }


    public static void main(String[] args) throws IOException {
        CalcScanner myCalcScanner = new CalcScanner(args[0]);
        System.out.println(myCalcScanner.nextToken());

        if (myCalcScanner.nextToken() == '(') {
            System.out.println( "found (");
        }

        // while(true) myCalcScanner.nextToken();





    }





}