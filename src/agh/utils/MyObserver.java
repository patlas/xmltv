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


import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
  public void observe(Observable o) {
    o.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    int someVariable = ((MyObservable) o).getSomeVariable();
    
    if(someVariable == 3)
    {
        System.out.println("Pobrano wszystko");
        
        //TODO tutaj updateować globalne zmienne z sparsowanymi kanałami
        // dodać konstruktor który przyjmie "wskaźniki" na listy tommorow itd (te na wyciągnięte informacje)
        
    }
    //System.out.println("All is flux!  Some variable is now " + someVariable);
  }
}