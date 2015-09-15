/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*

long timestamp = Long.parseLong("1442095500") * 1000;

    SimpleDateFormat sdf = new SimpleDateFormat("MMM d H:mm");
    String date = sdf.format(timestamp);
    
        System.out.println(date);
*/
package agh.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.util.Vector;
import org.apache.log4j.Logger;

/**
 *
 * @author Max
 */
public class FileAppender {
    
    final static Logger logger = Logger.getLogger(FileAppender.class);

    
    String dataFile = null;
    String channelFile = null;
    public PrintWriter writer = null;
    File file = null;
    String dir = "xmltv_files/";
    
    
    public FileAppender(String dFile){
        Boolean newFile = false;
        dataFile = dir+dFile;
        file = new File(dir+dFile);
        
        try{
            writer = new PrintWriter( new FileOutputStream(file, false) );
            if(!file.exists())
            {
                try{
                        file.createNewFile();
                        newFile = true;
                }
                catch(IOException ioe){
                 logger.error("Natrafiono na problem podczas tworzenia pliku.");
                 ioe.printStackTrace();
                }
            }
            
            writer.println("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>"); 
            writer.println("<!DOCTYPE tv SYSTEM \"xmltv.dtd\">");
            writer.println("<tv source-info-url=\"http://ncplus.pl/~/epgjson/*.ejson/\" source-info-name=\"NCplus TV channel list\">");
            
        } catch (FileNotFoundException e) {
                logger.fatal("Brak pliku lub plik otwarty.");
                e.printStackTrace();
        }

    }
    
    public void appendChannels(ArrayList<Struct> channelList)
    {			
        int index = 0;
        logger.debug("Adding TV channels to XMLTV file");
        String channel = null;
        
        for(Struct ch : channelList)
        {
            writer.println("\t<channel id=\""+(index+1)+"\">");
            writer.println("\t\t<display-name>"+ch.getChannel()+"</dislpay-name>");
            writer.println("\t</channel>");
              
            if(++index > 4 ) break;  
        }	
        
        logger.info("Lista kanałów została pomyślnie dodana do pliku");
    }
	
	
    public void appendProgramms(ArrayList<Struct> channelList)
    {
        int index = 0;
        logger.debug("Adding TV programms to XMLTV file");
        for(Struct ch : channelList)
        {
            for(Vector<String> prog : ch.program)
            {
                writer.println("\t<programme start=\""+prog.get(2)+"\" channel=\""+prog.get(0)+"\">");
                writer.println("\t\t<title lang=\"pl\">"+prog.get(1)+"</title>");
                writer.println("\t\t<subtitles type=\"teletekst\"/>");
                writer.println("\t</channel>");
            }
              
            if(++index > 4 ) break;  
        }
        writer.println("</tv>");
         
    }
    
}
