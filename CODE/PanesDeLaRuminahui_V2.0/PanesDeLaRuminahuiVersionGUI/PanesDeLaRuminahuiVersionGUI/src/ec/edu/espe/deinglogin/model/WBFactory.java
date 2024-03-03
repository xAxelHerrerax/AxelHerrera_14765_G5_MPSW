package ec.edu.espe.deinglogin.model;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class WBFactory implements BreadFactory{

    @Override
    public Bread createbread() {
        return new WholemealBread();
    }
    
}
