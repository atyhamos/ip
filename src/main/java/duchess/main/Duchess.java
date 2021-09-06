package duchess.main;

import java.util.Scanner;

/**
 * This class implements a Duke Chatbot variant: Duchess
 *
 * @author Amos Tan
 * @version CS2103T AY21/22 Semester 1
 */

public class Duchess {
    /** The DuchessList which holds the string stored by the user.*/
    private DuchessList duchessList;
    /** The Scanner used to read in user input.*/
    private Scanner sc;
    /** The Ui object which handles printing to screen.*/
    private Ui ui;
    /** The parser to determine the respective commands from the user input.*/
    private Parser parser;


    /**
     * Constructs a Duchess object.
     */
    public Duchess() {
        this.ui = new Ui();
        this.sc = new Scanner(System.in);
        this.duchessList = DuchessFileHandler.load();
        this.parser = new Parser();
    }

    public Ui getUi() {
        return this.ui;
    }

    public DuchessList getDuchessList() {
        return this.duchessList;
    }

    public String getResponse(String input) {
        try {
            return parser.checkPrefix(input).handleLogic(this);
        } catch (DuchessException d) {
            return d.getMessage();
        }
    }
}
