/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agh.utils;

import agh.Parser;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.apache.log4j.Logger;

/**
 *
 * @author patryk.las
 */
public class ViewUpdater {
    
    private JTree tree = null;
    private final DefaultMutableTreeNode root = new DefaultMutableTreeNode( "" );
    final static Logger logger = Logger.getLogger(ViewUpdater.class.getName());
    
    
    public ViewUpdater(JTree tree){
        this.tree = tree;
        
    }
    
    public void addTvProgrammToTree(ArrayList<Struct> channelList){
        
        logger.debug("Adding TV programm to tree");
        //ArrayList<Struct>
        DefaultMutableTreeNode channel = null;
        int index = 0;
        for(Struct ch : channelList){
            
            channel = new DefaultMutableTreeNode(ch.getChannel());
            
            
            for(Vector<String> prog : ch.program)
            {
                channel.add( new DefaultMutableTreeNode( "[godzina: "+Parser.convertTimestamp(prog.get(2))+ "] " + prog.get(1)+ "     ID:"+prog.get(0)));
            }
            
            root.add(channel);
            
            if(++index > 4 ) break;  
        }
        tree.setModel(new DefaultTreeModel( root ));
        //tree.setRootVisible(false);
        
        
        
        ///////////dwa poniższe są bardzo ważne
       // System.out.println(tree.getModel().getChild(root, 1).toString());
        
        //((DefaultMutableTreeNode)((DefaultMutableTreeNode)tree.getModel().getChild(root, 1)).getChildAt(1)).add(new DefaultMutableTreeNode("Frequency:"));
        ////////////
    }

    
    
    private int findTransponderIndexById(String id){
        int index;
        String str = null;
        for(index=0; index<(tree.getModel().getChildCount(root)); index++){
            
            str = (tree.getModel().getChild(root, index).toString().split(" "))[1];
            
            if( str.equalsIgnoreCase(id)){
                return index;
            }
            
        }
        return index;
    }
    
    
}
