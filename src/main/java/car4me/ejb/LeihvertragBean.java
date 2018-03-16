/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.ejb;

import car4me.jpa.Leihvertrag;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author giesler
 */
@Stateless
public class LeihvertragBean extends EntityBean<Leihvertrag, Long>{
    
    public LeihvertragBean(){
        super(Leihvertrag.class);
    }
    
    @PersistenceContext
    EntityManager em;
}
