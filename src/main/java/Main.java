
import car4me.jpa.Fahrzeug;
import car4me.jpa.Kunde;
import car4me.jpa.Leihvertrag;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.ws.Holder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henry
 */
public class Main {
    public static void main(String args){
        
        System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.client.HttpTransportPipe.dump", "true");
        System.setProperty("com.sun.xml.ws.transport.http.HttpAdapter.dump", "true");
        System.setProperty("com.sun.xml.internal.ws.transport.http.HttpAdapter.dump", "true");
        
        Soap soap = new Soap();
        Car4MeWS car4MeWS = soap.getcar4MeWSWebservicePort();
        
        System.out.println("=============");
        System.out.println("Hauptmenü");
        System.out.println("=============");
        System.out.println("");
        System.out.println("[K] Kunde anlegen");
        System.out.println("[F] Fahrzeug anlegen");
        System.out.println("[A] Fahrzeug ausleihen");
        System.out.println("[L] Leihverträge auflisten");
        System.out.println("[E] Ende");
        System.out.println("");
        try{
        BufferedReader fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
        String input = fromKeyboard.readLine();
        
        System.out.println("Deine Auswahl:  "+input);
        
        if (input.equals("k")||input.equals("K")){
            
                String vorname="";
                String nachname="";
                String strasse="";
                String nr="";
                String plz="";
                String ort="";
                String land="";
                
                System.out.println("=============");
                System.out.println("Kunde anlegen");
                System.out.println("=============");
                System.out.println("");
                System.out.println("Vorname:");
                        try{
                             fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                             input = fromKeyboard.readLine();
                             vorname=input;
                        }
                       catch (IOException ioe){
                            System.out.println("Fehlerhafte eingabe!");
                        }
                System.out.println("Nachname:");
                        try{
                             fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                             input = fromKeyboard.readLine();
                             nachname=input;
                        }
                       catch (IOException ioe){
                            System.out.println("Fehlerhafte eingabe!");
                        }
                System.out.println("Straße:");
                        try{
                             fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                             input = fromKeyboard.readLine();
                             strasse=input;
                        }
                       catch (IOException ioe){
                            System.out.println("Fehlerhafte eingabe!");
                        }
                System.out.println("Hausnummer:");
                        try{
                             fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                             input = fromKeyboard.readLine();
                             nr=input;
                        }
                       catch (IOException ioe){
                            System.out.println("Fehlerhafte eingabe!");
                        }
                System.out.println("Postleitzahl:");
                        try{
                             fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                             input = fromKeyboard.readLine();
                             plz=input;
                        }
                       catch (IOException ioe){
                            System.out.println("Fehlerhafte eingabe!");
                        }
                System.out.println("Ort:");
                        try{
                             fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                             input = fromKeyboard.readLine();
                             ort=input;
                        }
                       catch (IOException ioe){
                            System.out.println("Fehlerhafte eingabe!");
                        }
                System.out.println("Land:");
                        try{
                             fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                             input = fromKeyboard.readLine();
                             land=input;
                        }
                       catch (IOException ioe){
                            System.out.println("Fehlerhafte eingabe!");
                        }
                        
                Kunde neuKunde = new Kunde(vorname, nachname, strasse, nr, plz, ort, land);
                Holder<Kunde> hKunde = new Holder<>(neuKunde);
                car4MeWS.createCustomer(hKunde);
                System.out.println("Kundennummer "+hKunde.value.getId()+" wurde angelegt.");
                        
            }
        if (input.equals("a")||input.equals("A")){
                Long kdnr=null;
                Long fahrzeugId=null;
                Date abholung = null;
                Date rueckgabe =null;
                
                System.out.println("=============");
                System.out.println("Fahrzeug ausleihen");
                System.out.println("=============");
                System.out.println("");
                System.out.println("Folgende Fahrzeuge stehen zur Verfügung:");
                System.out.println("");
                for (Fahrzeug x : car4MeWS.getAllVehicle() ){
                   System.out.println(x); 
                }
                System.out.println("Kundennummer: ");
                    try{
                                 fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                                 input = fromKeyboard.readLine();
                                 kdnr= Long.valueOf(input).longValue();  
                            }
                    catch (IOException ioe){
                                System.out.println("Fehlerhafte eingabe!");
                            }
                System.out.println("Fahrzeug-ID: ");
                    try{
                                 fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                                 input = fromKeyboard.readLine();
                                 fahrzeugId= Long.valueOf(input).longValue();  
                            }
                    catch (IOException ioe){
                                System.out.println("Fehlerhafte eingabe!");
                            }
                System.out.println("Abholung am (yyyy-mm-dd): ");
                    try{
                                fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                                input = fromKeyboard.readLine();
                                SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");
                                abholung = fmt.parse(input);
                            }
                    catch (IOException ioe){
                                System.out.println("Fehlerhafte eingabe!");
                            }
                    catch (ParseException pE){
                               System.out.println("Fehlerhafte eingabe!");
                            }
                System.out.println("Rückgabe am (yyyy-mm-dd): ");
                    try{
                                fromKeyboard = new BufferedReader(new InputStreamReader(System.in));
                                input = fromKeyboard.readLine();
                                SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yyyy");
                                rueckgabe = fmt.parse(input);
                              //  abholung.toGregorianCalendar().getTime();
                            }
                    catch (IOException ioe){
                                System.out.println("Fehlerhafte eingabe!");
                            }
                    catch (ParseException pE){
                               System.out.println("Fehlerhafte eingabe!");
                            }
            //Leihvertrag contract = new Leihvertrag();
                   
          //  Holder<Kunde> hKunde = new Holder<>(neuKunde);
            //        car4MeWS.createCustomer(hKunde);
              //      System.out.println("Kundennummer "+hKunde.value.getId()+" wurde angelegt.");
                //    (Kunde kunde, Fahrzeug fahrzeug, Date beginnDatum, Date endeDatum)
        }
        if (input.equals("L")||input.equals("L")){
                System.out.println("=============");
                System.out.println("Leihverträge auflisten");
                System.out.println("=============");
                System.out.println("");
                System.out.println("Folgende Leihverträge stehen zur Verfügung:");
                System.out.println("");
                for (Leih x : car4MeWS.getContracts() ){
                   System.out.println(x); 
                }
        }
        }catch (IOException ioe){
            System.out.println("Fehlerhafte eingabe!");
        }
    }
    
}
