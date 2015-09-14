package agh;



import agh.utils.Struct;
import java.util.ArrayList;
import org.apache.log4j.Logger;



public class Downloader implements Runnable {

	public static long TIMEOUT=0;
	
        public String dayString = null;
        public  String id = "";
        private boolean descORchannel = false;
        
        public ArrayList<Struct> programs = null;
        public String description = null;
        
        public String channelURL = "http://ncplus.pl/~/epgjson/";//2015-09-13.ejson
    
	final static Logger logger = Logger.getLogger(Downloader.class);

        @Override
	public void run()
	{
	try {
	      doRun();
	    } finally 
	    {
	     
	    }
	}
	
	public void doRun()
	{
            Parser parser = new Parser();
            
            
            if(descORchannel == false)
            {
               programs = parser.parseJSONProgramm(channelURL+Parser.getDate(dayString)+".ejson");
               MyGUI.downloadObservable.increment();
               logger.info("Ruszył wątek pobierający liste kanałów i programów"); 
            }
            else
            {
                description = parser.getDescription(id);
              
                logger.info("Ruszył wątek pobierający opis programu");  
            }

            

	    Thread.currentThread().setName(dayString);
	    logger.debug("Teraz działam ja: "+dayString);
        }
	
	public Downloader(String day, String ID) //today, tommorow, next
	{
            dayString = day;
            id = ID;
            if(id.length() == 0) descORchannel = false;
	}
	
	
}
