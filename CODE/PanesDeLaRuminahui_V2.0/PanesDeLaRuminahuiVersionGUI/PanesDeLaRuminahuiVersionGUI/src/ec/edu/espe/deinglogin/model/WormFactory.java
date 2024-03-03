package ec.edu.espe.deinglogin.model;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class WormFactory implements BreadFactory{

    @Override
    public Bread createbread() {
        return new WormBread();
    }
    
}
