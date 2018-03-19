/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.ejb;

import car4me.jpa.Kunde;
import car4me.jpa.Leihvertrag;
import java.util.Date;
import java.util.List;
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
    
    public Leihvertrag createLeihvertrag(Leihvertrag leihvertrag) throws Exception{
        Long help = leihvertrag.getFahrzeug().getId();
        Date beginnDatum = leihvertrag.getBeginnDatum();
        Date endeDatum = leihvertrag.getEndeDatum();
        List <Leihvertrag> help2 = em.createQuery("SELECT l FROM Leihvertrag l WHERE l.fahrzeug.id = :help AND (l.beginnDatum <= :beginnDatum AND l.endeDatum >= :beginnDatum )OR( l.beginDatum <= :endeDatum AND l.endeDatum >= :endeDatum )OR( l.beginDatum <= :beginnDatum AND l.endedatum >= :endeDatum)")
                                     .setParameter("help", help)
                                     .setParameter("beginnDatum", beginnDatum)
                                     .setParameter("endeDatum", endeDatum)
                                     .getResultList();
        
        if(help2 == null){
            return this.saveNew(leihvertrag);
        }else{
            throw new Exception("Hilfe");
        }
        
        
    }
   
    public List<Leihvertrag> findByKUNDE_ID(Kunde kunde){
        long id = kunde.getId();
        return em.createQuery("SELECT l FROM Leihvertrag l WHERE l.kunde.id = :id")
                .setParameter("id", id)
                .getResultList();
    }
   
}
