/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.utils;

/**
 *
 * @author PatLas
 */


import agh.Downloader;
import agh.MyGUI;
import java.util.Observable;
import java.util.Observer;
import org.apache.log4j.Logger;

public class MyObserver implements Observer {
    
  final static Logger logger = Logger.getLogger(MyObserver.class);
  
  String[] fileNames = {"todayProgramm.dtd", "tommorowProgramm.dtd", "nextDayProgramm.dtd"};
  
  public void observe(Observable o) {
    o.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    int someVariable = ((MyObservable) o).getSomeVariable();
    
    if(someVariable == 3)
    {
        System.out.println("Pobrano wszystko");
        logger.debug("Pobieranie listy kanałów na najbliższe 3 dni zakończono sukcesem");
        
        for(Downloader dw : MyGUI.downloaderPoolList)
        {
            if(dw.dayString.equalsIgnoreCase("today")){
                MyGUI.todayList = dw.programs;
                FileAppender fa = new FileAppender(fileNames[0]);
                fa.appendChannels(dw.programs);
                fa.appendProgramms(dw.programs);
                fa.writer.close();
            }
            else if(dw.dayString.equalsIgnoreCase("tommorow")){
                MyGUI.tommorowList = dw.programs;
                FileAppender fa = new FileAppender(fileNames[1]);
                fa.appendChannels(dw.programs);
                fa.appendProgramms(dw.programs);
                fa.writer.close();
            }
            else if(dw.dayString.equalsIgnoreCase("next")){
                MyGUI.nextList = dw.programs;
                FileAppender fa = new FileAppender(fileNames[2]);
                fa.appendChannels(dw.programs);
                fa.appendProgramms(dw.programs);
                fa.writer.close();
            }
        }
        
        MyGUI.bPreview.setEnabled(true);
        
        
        //TODO tutaj updateować globalne zmienne z sparsowanymi kanałami
        // dodać konstruktor który przyjmie "wskaźniki" na listy tommorow itd (te na wyciągnięte informacje)
        
    }
    //System.out.println("All is flux!  Some variable is now " + someVariable);
  }
}