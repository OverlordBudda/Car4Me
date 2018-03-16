/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.web;

import car4me.ejb.FahrzeugBean;
import car4me.ejb.KundeBean;
import car4me.jpa.Kunde;
import car4me.ejb.LeihvertragBean;
import car4me.jpa.Fahrzeug;
import car4me.jpa.Leihvertrag;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author Budda
 */
@WebService(serviceName = "Car4MeWS")
@Stateless
public class Car4MeWS {

    @EJB
    private KundeBean ejbK;
    
    @EJB
    private FahrzeugBean ejbF;
    
    @EJB
    private LeihvertragBean ejbL;
    
    @WebMethod(operationName = "createCustomer")
    @WebResult(name = "kunde")
    public Kunde createKunde(@WebParam(name = "kunde") Kunde kunde/**, @WebParam(name = "vorname") String vorname,@WebParam(name = "nachname") String nachname,@WebParam(name = "strasse") String strasse,@WebParam(name = "hausnummer") String hausnummer,@WebParam(name = "plz") String plz,@WebParam(name = "ort") String ort,@WebParam(name = "land") String land*/){
        return ejbK.saveNew(kunde);
    }
    
    @WebMethod(operationName = "createCar")
    @WebResult(name = "car")
    public Fahrzeug createFahrzeug(@WebParam(name = "fahrzeug")Fahrzeug fahrzeug){
        return ejbF.saveNew(fahrzeug);
    }
    
    @WebMethod(operationName = "createContract")
    @WebResult(name = "contract")
    public Leihvertrag createLeihvertrag(@WebParam(name = "leihvertrag")Leihvertrag leihvertrag){
        return ejbL.??(leihvertrag);
    }
    
    @WebMethod(operationName = "getAllVehicle")
    @WebResult(name = "vehicle")
    public List<Fahrzeug> getAllFahrzeuge(){
        return ejbF.findAll();
    }
    
    @WebMethod(operationName = "getContracts")
    @WebResult(name = "leihvertrag")
    public List<Leihvertrag> getLeihvertrage(Kunde kunde){
        return ejbL.??();
    }
    
}
