
package biodata.interfaces;

import biodata.model.modelGrafik;
import javafx.collections.ObservableList;

/**
 *
 * @author Balbali
 */
public interface interGrafik {
    ObservableList<modelGrafik> getAnneDeNaissance();
    ObservableList<Object> anneedenaissanceToGrafik();
}
