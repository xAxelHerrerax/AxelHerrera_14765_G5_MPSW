package ec.edu.espe.deinglogin.controller;

/**
 *
 * @author Gabriel Baez, Techware, DCCO-ESPE
 */
public class Encrypted {

    public static String encryptPassword(String password) {
        String cifrada = "";
        int desplazar = 1;

        for (int i = 0; i < password.length(); i++) {
            int codigoLetra = password.codePointAt(i);
            char letraDesplazada = (char) (codigoLetra + desplazar);
            cifrada = cifrada + letraDesplazada;
        }
        return cifrada;
    }
}
