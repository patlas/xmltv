/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.utils;

import java.util.Vector;

/**
 *
 * @author PatLas
 */
public class Struct{
        
        public String kanal = null;
        public Vector<Vector<String>> program = new Vector<Vector<String>>();
        
        public Struct(String k, Vector<Vector<String>> p){
            kanal = k;
            program = p;
        }
        
        public Struct(){
            
        }
        
    }