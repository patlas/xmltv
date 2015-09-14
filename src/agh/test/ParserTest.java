/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.test;

import agh.Parser;
import agh.utils.Struct;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author PatLas
 */
public class ParserTest {
    
    public static void main(String[] args){
        
      String obj2 = "[[271,\"TVP 1 HD\",[[20587916,\"Transporter\",1442095500,3000,0,1387091,\"16\"],[20587917,\"Glina\",1442098500,3600,0,1387092,\"16\"],[20587918,\"Downton Abbey\",1442102100,4800,0,1387093,\"12\"],[20587919,\"Homeland\",1442106900,3300,0,1387061,\"16\"],[20587920,\"Dziewczyny z Szymanowa\",1442110200,1800,0,1387094,\"12\"],[20587921,\"Przerwa\",1442112000,3600,0,1387095,\"null\"],[20587922,\"Egzamin z życia\",1442115600,3000,0,1391932,\"12\"],[20587923,\"My, wy, oni\",1442118600,1800,0,1391933,\"12\"],[20587924,\"Msza św. z Sanktuarium Bożego Miłosierdzia w Krakowie Łagiewnikach\",1442120400,3600,0,1391934,\"null\"],[20587925,\"Tydzień\",1442124000,1800,0,1391935,\"null\"],[20587926,\"Do zobaczenia w Krakowie\",1442125800,1200,0,1391936,\"7\"],[20587927,\"Droga do zdrowia. Magazyn biegacza\",1442127000,600,0,1391937,\"null\"],[20587928,\"Ziarno\",1442127600,2400,0,1391938,\"null\"],[20587929,\"Nie ma jak Polska\",1442130000,1800,0,1391939,\"null\"],[20587930,\"Wojsko Polskie - Modernizacja\",1442131800,1800,0,1391940,\"12\"],[20587931,\"Droga do zdrowia. Magazyn biegacza\",1442133600,1500,0,1391941,\"null\"],[20587932,\"Anno Domini - Biblii ciąg dalszy\",1442135100,2700,0,1391942,\"12\"],[20587933,\"Między ziemią a niebem\",1442137800,600,0,1391943,\"4\"],[20587934,\"Anioł Pański\",1442138400,600,0,1391944,\"null\"],[20587935,\"Między ziemią a niebem\",1442139000,2400,0,1391945,\"4\"],[20587936,\"Kryptonim Szef\",1442141400,3900,0,1419759,\"12\"],[20587937,\"Dożynki prezydenckie w Spale\",1442145300,2400,0,1402607,\"4\"],[20587938,\"LOTTO 6. Warszawski Memoriał Kamili Skolimowskiej\",1442147700,600,0,1391947,\"null\"],[20587939,\"LOTTO 6. Warszawski Memoriał Kamili Skolimowskiej\",1442148300,8100,0,1391948,\"null\"],[20587940,\"Teleexpress\",1442156400,1200,0,1391949,\"null\"],[20587941,\"Pogoda\",1442157600,900,0,1391950,\"null\"],[20587942,\"Komisarz Alex\",1442158500,3600,0,1391951,\"12\"],[20587943,\"Jaka to melodia?\",1442162100,2700,0,1391952,\"null\"],[20587944,\"Wiadomości naukowe\",1442164800,600,0,1391953,\"4\"],[20587945,\"Wiadomości\",1442165400,1800,0,1391954,\"null\"],[20587946,\"Sport\",1442167200,300,0,1391955,\"null\"],[20587947,\"PZU Festiwal Biegowy Krynica-Zdrój\",1442167500,240,0,1391956,\"null\"],[20587948,\"PKO Wrocław Maraton\",1442167740,360,0,1391957,\"null\"],[20587949,\"Pogoda\",1442168100,600,0,1391958,\"null\"],[20587950,\"Dziewczyny ze Lwowa\",1442168700,3600,1,1391959,\"12\"],[20587951,\"Rolnik szuka żony\",1442172300,3600,1,1391960,\"12\"],[20587952,\"Piąta pora roku\",1442175900,6300,0,1391961,\"12\"]]]"
              + ",[271,\"TVP 1 HD\",[[20587916,\"Transporter\",1442095500,3000,0,1387091,\"16\"],[20587917,\"Glina\",1442098500,3600,0,1387092,\"16\"],[20587918,\"Downton Abbey\",1442102100,4800,0,1387093,\"12\"],[20587919,\"Homeland\",1442106900,3300,0,1387061,\"16\"],[20587920,\"Dziewczyny z Szymanowa\",1442110200,1800,0,1387094,\"12\"],[20587921,\"Przerwa\",1442112000,3600,0,1387095,\"null\"],[20587922,\"Egzamin z życia\",1442115600,3000,0,1391932,\"12\"],[20587923,\"My, wy, oni\",1442118600,1800,0,1391933,\"12\"],[20587924,\"Msza św. z Sanktuarium Bożego Miłosierdzia w Krakowie Łagiewnikach\",1442120400,3600,0,1391934,\"null\"],[20587925,\"Tydzień\",1442124000,1800,0,1391935,\"null\"],[20587926,\"Do zobaczenia w Krakowie\",1442125800,1200,0,1391936,\"7\"],[20587927,\"Droga do zdrowia. Magazyn biegacza\",1442127000,600,0,1391937,\"null\"],[20587928,\"Ziarno\",1442127600,2400,0,1391938,\"null\"],[20587929,\"Nie ma jak Polska\",1442130000,1800,0,1391939,\"null\"],[20587930,\"Wojsko Polskie - Modernizacja\",1442131800,1800,0,1391940,\"12\"],[20587931,\"Droga do zdrowia. Magazyn biegacza\",1442133600,1500,0,1391941,\"null\"],[20587932,\"Anno Domini - Biblii ciąg dalszy\",1442135100,2700,0,1391942,\"12\"],[20587933,\"Między ziemią a niebem\",1442137800,600,0,1391943,\"4\"],[20587934,\"Anioł Pański\",1442138400,600,0,1391944,\"null\"],[20587935,\"Między ziemią a niebem\",1442139000,2400,0,1391945,\"4\"],[20587936,\"Kryptonim Szef\",1442141400,3900,0,1419759,\"12\"],[20587937,\"Dożynki prezydenckie w Spale\",1442145300,2400,0,1402607,\"4\"],[20587938,\"LOTTO 6. Warszawski Memoriał Kamili Skolimowskiej\",1442147700,600,0,1391947,\"null\"],[20587939,\"LOTTO 6. Warszawski Memoriał Kamili Skolimowskiej\",1442148300,8100,0,1391948,\"null\"],[20587940,\"Teleexpress\",1442156400,1200,0,1391949,\"null\"],[20587941,\"Pogoda\",1442157600,900,0,1391950,\"null\"],[20587942,\"Komisarz Alex\",1442158500,3600,0,1391951,\"12\"],[20587943,\"Jaka to melodia?\",1442162100,2700,0,1391952,\"null\"],[20587944,\"Wiadomości naukowe\",1442164800,600,0,1391953,\"4\"],[20587945,\"Wiadomości\",1442165400,1800,0,1391954,\"null\"],[20587946,\"Sport\",1442167200,300,0,1391955,\"null\"],[20587947,\"PZU Festiwal Biegowy Krynica-Zdrój\",1442167500,240,0,1391956,\"null\"],[20587948,\"PKO Wrocław Maraton\",1442167740,360,0,1391957,\"null\"],[20587949,\"Pogoda\",1442168100,600,0,1391958,\"null\"],[20587950,\"Dziewczyny ze Lwowa\",1442168700,3600,1,1391959,\"12\"],[20587951,\"Rolnik szuka żony\",1442172300,3600,1,1391960,\"12\"],[20587952,\"Piąta pora roku\",1442175900,6300,0,1391961,\"12\"]]]"    
              + ",[314,\"TVP 2 HD\",[[20587984,\"Made in Polska\",1442096400,3900,0,1389065,\"12\"],[20587985,\"Oskar\",1442100300,7200,0,1389066,\"12\"],[20587986,\"Za szybcy, za wściekli\",1442107500,6600,0,1389067,\"12\"],[20587987,\"Przerwa\",1442114100,600,0,1389068,\"null\"],[20587988,\"Słowo na niedzielę\",1442114700,600,0,1393964,\"4\"],[20587989,\"Bliskie i groźne spotkania Steve'a\",1442115300,2100,0,1393965,\"12\"],[20587990,\"Ostoja\",1442117400,1800,0,1393966,\"12\"],[20587991,\"M jak miłość\",1442119200,3600,0,1393967,\"12\"],[20587992,\"Barwy szczęścia\",1442122800,2100,0,1393968,\"12\"],[20587993,\"Barwy szczęścia\",1442124900,1800,0,1393969,\"12\"],[20587994,\"Barwy szczęścia\",1442126700,2100,0,1393970,\"12\"],[20587995,\"Barwy szczęścia\",1442128800,1800,0,1393971,\"12\"],[20587996,\"W królestwie roślin z Davidem Attenborough\",1442130600,4200,0,1393972,\"null\"],[20587997,\"Wojciech Cejrowski - boso przez świat\",1442134800,2100,0,1393973,\"null\"],[20587998,\"Makłowicz w podróży\",1442136900,2100,0,1393974,\"null\"],[20587999,\"Gang Olsena daje dyla\",1442139000,6600,1,1393975,\"7\"],[20588000,\"Familiada\",1442145600,2400,0,1393976,\"4\"],[20588001,\"The Voice of Poland\",1442148000,3300,0,1393977,\"null\"],[20588002,\"The Voice of Poland\",1442151300,3300,0,1393978,\"null\"],[20588003,\"Na dobre i na złe\",1442154600,3300,0,1393979,\"12\"],[20588004,\"Na sygnale\",1442157900,2100,0,1393980,\"12\"],[20588005,\"Panorama\",1442160000,1800,0,1393981,\"null\"],[20588006,\"Sport-telegram\",1442161800,600,0,1393982,\"null\"],[20588007,\"Pogoda\",1442162400,900,0,1393983,\"null\"],[20588008,\"Paranienormalni Tonight - kulisy\",1442163300,600,0,1419763,\"12\"],[20588009,\"O mnie się nie martw\",1442163900,3900,0,1393985,\"12\"],[20588010,\"Za szybcy, za wściekli\",1442167800,7200,1,1393986,\"12\"],[20588011,\"Paranienormalni Tonight\",1442175000,3600,0,1393987,\"12\"],[20588012,\"Historia jazzu\",1442178600,4500,0,1393988,\"12\"]]]]"
              ;
      
//      String kanal = obj.split("]]],")[0];
//      System.out.println(kanal);
      
//      JSONArray obj = new JSONArray(obj2);
//
//      //System.out.println(obj.length());
//      
//      ArrayList<Struct> lista = new ArrayList<>(); 
      
       // JSONArray kanaly = new JSONArray(obj.get(0).toString());
        //String kanal_nazwa = kanaly.get(1).toString();
//        System.out.println("Kanal: "+ kanal_nazwa);
//        JSONArray programy = new JSONArray(kanaly.get(2).toString());
//        JSONArray program = new JSONArray(programy.get(0).toString());
//        
//        String program_id = program.get(0).toString();
//        String program_title = program.get(1).toString(); 
//        String program_start = program.get(2).toString(); 
//        System.out.println(program_id + program_title+program_start);
        
        
        
       // JSONArray obj = new JSONArray(obj2);
      
//      JSONArray obj = readJsonFromUrl("http://ncplus.pl/~/epgjson/2015-09-13.ejson");
//      
//      ArrayList<Struct> lista = new ArrayList<>(); 
//      
//        for(int kindex = 0; kindex<obj.length(); kindex++)
//        {
//            JSONArray kanaly = new JSONArray(obj.get(kindex).toString());
//            String nazwaK = kanaly.get(1).toString();
//            JSONArray programy = new JSONArray(kanaly.get(2).toString());
//            
//            //System.out.println(nazwaK);
//            
//            Struct kan = new Struct();
//            
//            kan.kanal = nazwaK;
//            
//            for(int pindex = 0; pindex<programy.length(); pindex++)
//            {
//                JSONArray program = new JSONArray(programy.get(pindex).toString());
//
//                Vector<String> prog = new Vector<>();
//                
//                prog.add(program.get(0).toString());
//                prog.add(program.get(1).toString());
//                prog.add(program.get(2).toString());
//                
//                kan.program.add(prog);
//                
////                String program_id = program.get(0).toString();
////                String program_title = program.get(1).toString(); 
////                String program_start = program.get(2).toString(); 
//            
////                System.out.println(program_id + program_title+program_start);
//            }
////            System.out.println();
//            
//            lista.add(kan);
//        }
//        
      
      Parser par = new Parser();
      
      System.out.println(par.getDescription("20587916"));
      
        ArrayList<Struct> lista = par.parseJSONProgramm("http://ncplus.pl/~/epgjson/2015-09-13.ejson");
        
        int a = 0;
        for(Struct s : lista){
            
            System.out.println(s.kanal);
            
            for(Vector<String> p : s.program){
                System.out.println(p.elementAt(1));
            }
            if(a++ == 2) break;
        }
        
        
        //Vector<String[3]>
        
    //  http://ncplus.pl/~/epgjson/2015-09-13.ejson
      
        
        
    }
    
    
    
    
    
    
    
}
