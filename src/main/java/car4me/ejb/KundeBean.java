/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.ejb;

import javax.ejb.Stateless;
import car4me.jpa.Kunde;

/**
 *
 * @author Henry
 */

@Stateless
public class KundeBean extends EntityBean<Kunde, Long> {
    
    public KundeBean() {
        super(Kunde.class);
    }
    
}
