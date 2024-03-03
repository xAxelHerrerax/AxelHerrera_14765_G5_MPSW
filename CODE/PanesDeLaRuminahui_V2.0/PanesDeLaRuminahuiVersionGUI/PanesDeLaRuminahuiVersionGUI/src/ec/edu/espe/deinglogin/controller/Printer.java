
package ec.edu.espe.deinglogin.controller;

import java.awt.print.PrinterException;
import javax.swing.JTable;

/**
 *
 * @author Jilmar Calderon, Techware, DCCO-ESPE
 */
public class Printer {

    private static Printer instance;

    private Printer() {
      
    }

    public static Printer getInstance() {
        if (instance == null) {
            instance = new Printer();
        }
        return instance;
    }

    public void printTable(JTable table) {
        try {
            boolean complete = table.print();
            if (complete) {
                System.out.println("Table printed");
            }
        } catch (PrinterException pe) {
            System.err.println("Error printing table: " + pe.getMessage());
        }
    }
}
