/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.ejb;

import car4me.jpa.Fahrzeug;
import javax.ejb.Stateless;

/**
 *
 * @author Budda
 */

@Stateless
public class FahrzeugBean extends EntityBean<Fahrzeug, Long>{
    
    public FahrzeugBean(){
        super(Fahrzeug.class);
    }
    
    
}
