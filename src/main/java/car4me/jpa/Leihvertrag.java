/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Budda
 */
public class Leihvertrag implements Serializable{
    
    @Id
    @GeneratedValue(generator = "contract_ids")
    @TableGenerator(name = "contract_ids", initialValue = 0, allocationSize = 50)
    private String id;
    
    @ManyToOne
    private Kunde kunde;
    
    @ManyToOne
    private Fahrzeug fahrzeug;
    
    @Column(name = "BEGINNDATUM")
    @NotNull(message = "Das Beginndatum darf nicht leer sein.")
    private Date beginnDatum;
    
    @Column(name = "ENDEDATUM")
    @NotNull(message = "Das Endedatum darf nicht leer sein.")
    private Date endeDatum;

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Kunde getKunde() {
        return kunde;
    }
    
    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
    
    public Fahrzeug getFahrzeug() {
        return fahrzeug;
    }
    
    public void setFahrzeug(Fahrzeug fahrzeug) {
        this.fahrzeug = fahrzeug;
    }
    
    public Date getBeginnDatum() {
        return beginnDatum;
    }
    
    public void setBeginnDatum(Date beginnDatum) {
        this.beginnDatum = beginnDatum;
    }
    
    public Date getEndeDatum() {
        return endeDatum;
    }
    
    public void setEndeDatum(Date endeDatum) {
        this.endeDatum = endeDatum;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Leihvertrag() {
    }
    
    public Leihvertrag(Kunde kunde, Fahrzeug fahrzeug, Date beginnDatum, Date endeDatum) {
        this.kunde = kunde;
        this.fahrzeug = fahrzeug;
        this.beginnDatum = beginnDatum;
        this.endeDatum = endeDatum;
    }
//</editor-fold>
    
    
    
}
