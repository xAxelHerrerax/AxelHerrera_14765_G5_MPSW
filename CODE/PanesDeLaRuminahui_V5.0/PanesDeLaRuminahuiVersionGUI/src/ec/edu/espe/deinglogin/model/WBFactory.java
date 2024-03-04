package ec.edu.espe.deinglogin.model;

/**
 *
 * 
 */
public class WBFactory implements BreadFactory{

    @Override
    public Bread createbread() {
        return new WholemealBread();
    }
    
}
