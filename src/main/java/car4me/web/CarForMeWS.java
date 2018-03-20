/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package car4me.web;

import car4me.ejb.FahrzeugBean;
import car4me.jpa.Fahrzeug;
import car4me.ejb.KundeBean;
import car4me.jpa.Kunde;
import car4me.ejb.LeihvertragBean;
import car4me.jpa.Leihvertrag;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Henry
 */
@WebService(serviceName = "CarForMeWS")
@Stateless
public class CarForMeWS {
    
    @EJB 
    private FahrzeugBean fahrzeugBean;
    
    @EJB
    private KundeBean kundeBean;
    
    @EJB
    private LeihvertragBean leihvertragBean;
   

    @WebMethod(operationName = "createCar")
    @WebResult(name = "fahrzeug")
    public Fahrzeug saveCar(@WebParam(name = "fahrzeug") Fahrzeug fahrzeug) {
        return fahrzeugBean.saveNew(fahrzeug);
    }
    @WebMethod(operationName = "createCustomer")
    @WebResult(name = "kunde")
    public Kunde saveCustomer(@WebParam(name = "kunde") Kunde kunde) {
        return kundeBean.saveNew(kunde);
    }
    @WebMethod(operationName = "searchCustomer")
    @WebResult(name = "kunde")
    public Kunde searchCustomer(@WebParam(name = "id") Long id) {
        return kundeBean.findById(id);
    }
    @WebMethod(operationName = "getAllCars")
    @WebResult(name = "fahrzeugList")
    public List<Fahrzeug> getAllCar() {
        return fahrzeugBean.findAll();
    }
    @WebMethod(operationName = "createContract")
    @WebResult(name = "contract")
    public Leihvertrag createContract(@WebParam(name = "contract") Leihvertrag leihvertrag) {
        return leihvertragBean.saveNew(leihvertrag);
    }
    @WebMethod(operationName = "getContracts")
    @WebResult(name = "contracts")
    public List<Leihvertrag> getContracts(@WebParam(name = "customer") Kunde kunde) {
        return leihvertragBean.findByKUNDE_ID(kunde);
    }
    
}
