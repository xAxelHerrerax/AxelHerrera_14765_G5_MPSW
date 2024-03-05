package ec.edu.espe.deinglogin.controller;

import ec.edu.espe.deinglogin.model.Bread;
import ec.edu.espe.deinglogin.model.BreadFactory;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class BreadController {
    private BreadFactory breadFactory;
    
    public BreadController(BreadFactory breadFactory){
        this.breadFactory = breadFactory;
    }
    
    public void bakeBread(){
        Bread bread = breadFactory.createbread();
    }
}
