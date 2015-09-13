package agh;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class Parser {
	
	private File file = null;
	final static Logger logger = Logger.getLogger(Parser.class);
	
	public Parser(Downloader webpage)
	{
		if(webpage.isDownloaded == true)
		{
			file = webpage.getFile(); //DODA� LOG!!
			logger.info("Pobieranie pliku preferencji zakończone sukcesem.");
		}

	}
	
	public Parser(File f)
	{
		file = f;
	}
	
	public Parser(String fName)
	{
		file = new File(fName);
	}
	
	public ArrayList<ArrayList<String>> getTransponder(){
		
		Document doc;
		
		ArrayList<ArrayList<String>> parsedTransponders = new ArrayList<ArrayList<String>>();
		
		try {
			doc = Jsoup.parse(file, "UTF-8");
			ArrayList<Element> transponderList = new ArrayList<Element>();
			transponderList = doc.getElementsByClass("frq");
			
			ArrayList<String> transponderParams; 
				
			for(Element transponder : transponderList)
			{
				transponderParams = new ArrayList<String>();
				for(Element params : transponder.getElementsByClass("bld"))
				{
					transponderParams.add(params.text());
				}
				parsedTransponders.add(transponderParams);
			}
			
		} catch (IOException e) {
			logger.fatal("Plik preferencji nie został wczytany lub nie istnieje");
			e.printStackTrace();
		}
		
		return parsedTransponders;
	}
	
	
	
    public ArrayList<ArrayList<String>> getChannels(){
	
        ArrayList<ArrayList<String>> parsedChannels = new ArrayList<>();
        
		
			
	return parsedChannels;
    }
	
	

        private String getDate(String d){
            
            String retData = null;
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String currentDate = dateFormat.format(cal.getTime());
            
            if(d.equalsIgnoreCase("today")){
                return currentDate;
            }else if(d.equalsIgnoreCase("tommorow")){
                
                try{
                    cal.setTime(dateFormat.parse(currentDate));
                    cal.add(Calendar.DATE, 1);  // number of days to add
                    return dateFormat.format(cal.getTime()); 
                }catch(ParseException pe){
                    logger.fatal("Parsing date 'tommorow' error!");
                }
                
            }else if(d.equalsIgnoreCase("next")){
                
                try{
                    cal.setTime(dateFormat.parse(currentDate));
                    cal.add(Calendar.DATE, 2);  // number of days to add
                    return dateFormat.format(cal.getTime());   
                }catch(ParseException pe){
                 logger.fatal("Parsing date 'tommorow' error!");
                }          
            }         
            return retData;
        }


}
