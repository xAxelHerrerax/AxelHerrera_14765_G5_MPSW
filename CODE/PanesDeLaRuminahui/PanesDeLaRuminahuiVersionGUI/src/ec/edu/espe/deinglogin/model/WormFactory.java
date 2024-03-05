package ec.edu.espe.deinglogin.model;

/**
 *
 * 
 */
public class WormFactory implements BreadFactory{

    @Override
    public Bread createbread() {
        return new WormBread();
    }
    
}
