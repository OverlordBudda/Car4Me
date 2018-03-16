/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Budda
 */

@Entity
public class Leihvertrag implements Serializable{
    
    @Id
    @GeneratedValue(generator = "contract_ids")
    @TableGenerator(name = "contract_ids", initialValue = 0, allocationSize = 50)
    private Long id;
    
    @ManyToOne
    private Kunde kunde;
    
    @ManyToOne
    private Fahrzeug fahrzeug;
    
    @Column(name = "BEGINNDATUM")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Das Beginndatum darf nicht leer sein.")
    private Date beginnDatum = new Date();
    
    @Column(name = "ENDEDATUM")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Das Endedatum darf nicht leer sein.")
    private Date endeDatum = new Date();

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
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
