/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.persistence.FetchType;

/**
 *
 * @author Budda
 */

@Entity
public class Fahrzeug implements Serializable{
    
    @Id
    @GeneratedValue(generator = "car_ids")
    @TableGenerator(name = "car_ids", initialValue = 0, allocationSize = 50)
    private String id;
    
    @Column(name = "HERSTELLER")
    @NotNull(message = "Der Hersteller darf nicht leer sein.")
    private String hersteller;
    
    @Column(name = "MODELL")
    @NotNull(message = "Das Modell darf nicht leer sein.")
    private String modell;
    
    @Column(name = "BAUJAHR")
    @NotNull(message = "Das Baujahr darf nicht leer sein.")
    private String baujahr;
    
    @OneToMany(mappedBy = "fahrzeug", fetch = FetchType.LAZY)
    List<Leihvertrag> leihvertrage = new ArrayList<>();
    

    //<editor-fold defaultstate="collapsed" desc="Setter und Getter">
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getHersteller() {
        return hersteller;
    }
    
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    
    public String getModell() {
        return modell;
    }
    
    public void setModell(String modell) {
        this.modell = modell;
    }
    
    public String getBaujahr() {
        return baujahr;
    }
    
    public void setBaujahr(String baujahr) {
        this.baujahr = baujahr;
    }

    public List<Leihvertrag> getLeihvertrage() {
        return leihvertrage;
    }

    public void setLeihvertrage(List<Leihvertrag> leihvertrage) {
        this.leihvertrage = leihvertrage;
    }
    
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Fahrzeug() {
    }
    
    public Fahrzeug(String hersteller, String modell, String baujahr) {
        this.hersteller = hersteller;
        this.modell = modell;
        this.baujahr = baujahr;
    }
//</editor-fold>
    
}
