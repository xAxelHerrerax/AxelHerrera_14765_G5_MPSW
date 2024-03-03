package ec.edu.espe.deinglogin.utils;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.regex.*;
import org.bson.Document;
/**
 *
 *
 * @author Calvache Gabriel, Techware, DCCO-ESPE
 */
public class ValidationUtil {
    
public boolean validateIdNotExist(String input) {
    MongoDataConnect mongoDataConnect = new MongoDataConnect("rawMaterial");
    MongoCollection<Document> collection = mongoDataConnect.getCollection();

    // Verificar si ya existe un documento con el mismo ID
    Document existingDoc = collection.find(Filters.eq("Id", input)).first();

    return existingDoc == null;
}
    public boolean validateBarcode(String input) {
        // Expresión regular para verificar que el código de barras tenga exactamente 12 dígitos numéricos
        String regex = "\\d{12}";

        // Compilar la expresión regular
        Pattern pattern = Pattern.compile(regex);

        // Verificar si el código de barras coincide con el patrón
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
    public boolean validateInt(String input) {
        try {
            int value = Integer.parseInt(input);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getInt(String input) {
        return Integer.parseInt(input);
    }

    public boolean validateFloat(String input) {
        try {
            float value = Float.parseFloat(input);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public float getFloat(String input) {
        return Float.parseFloat(input);
    }

    public boolean ValidateNumberString(String input) {
        return input.matches("^[0-9]+$");
    }

    public boolean ValidateLetterStringWithSpaces(String input) {
        return input.matches("^[ a-zA-Z ]+$");
    }
}
