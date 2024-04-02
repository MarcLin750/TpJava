/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biodata.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Balbali
 */
public class modelGrafik {
    
	private final StringProperty annee;
	private final IntegerProperty nombredenoms;

    public modelGrafik(String annee, int nombredenoms) {
    	this.annee = new SimpleStringProperty();
        this.nombredenoms = new SimpleIntegerProperty();
    }

    public modelGrafik() {
    	this.annee = new SimpleStringProperty();
        this.nombredenoms = new SimpleIntegerProperty();
	}

	public String getAnnee() {
        return annee.get();
    }

    public void setAnnee(String value) {
    	annee.set(value);
    }

    public StringProperty anneeProperty() {
        return annee;
    }
    
    public Integer getNombredenoms() {
        return nombredenoms.get();
    }

    public void setNombredenoms(Integer value) {
    	nombredenoms.set(value);
    }

    public IntegerProperty nombredenomsProperty() {
        return nombredenoms;
    }

	
    
}
