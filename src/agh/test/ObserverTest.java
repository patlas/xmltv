/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.test;

import agh.utils.MyObservable;
import agh.utils.MyObserver;

/**
 *
 * @author PatLas
 */
public class ObserverTest {
    
   public static void main(String[] args){
        
        MyObserver observ =new MyObserver();
        MyObservable obs = new MyObservable();
        
        observ.observe(obs);
        obs.increment();
        
        
    }
    
}
