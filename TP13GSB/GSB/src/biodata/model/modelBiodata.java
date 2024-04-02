
package biodata.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Balbali
 */
public class modelBiodata {
    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty nom = new SimpleStringProperty();
    private final StringProperty adresse = new SimpleStringProperty();
    private final ObjectProperty<Date> DateDeNaissance = new SimpleObjectProperty<>();
    private String formatdate;

    public modelBiodata() {
    }
    

    public String getId() {
        return id.get();
    }

    public void setId(String value) {
        id.set(value);
    }

    public StringProperty idProperty() {
        return id;
    }
    
    public String getNom() {
        return nom.get();
    }

    public void setNom(String value) {
    	nom.set(value);
    }

    public StringProperty nomProperty() {
        return nom;
    }
    
    public String getAdresse() {
        return adresse.get();
    }

    public void setAdresse(String value) {
        adresse.set(value);
    }

    public StringProperty adresseProperty() {
        return adresse;
    }

    public Date getDateDeNaissance() {
        return DateDeNaissance.get();
    }

    public void setDateDeNaissance(Date value) {
    	DateDeNaissance.set(value);
    }

    public ObjectProperty DateDeNaissanceProperty() {
        return DateDeNaissance;
    }
    
    public String getFormatDate() {
        Date date = getDateDeNaissance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String format = df.format(date);
        return format;
    }

    public void setFormatdate(String formatdate) {
        this.formatdate = formatdate;
    }

    
    
}
