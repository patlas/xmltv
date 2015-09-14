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

public class MyObservable extends Observable {
  private int someVariable = 0;

  public void increment() {
    synchronized (this) {
      someVariable++;
    }
    setChanged();
    notifyObservers();
  }

  public synchronized int getSomeVariable() {
    return someVariable;
  }
}