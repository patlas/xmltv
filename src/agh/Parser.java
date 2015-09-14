package agh;

import agh.utils.Struct;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
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
        
        public Parser(){
            
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

        public ArrayList<Struct> parseJSON(String url){
            
        
            ArrayList<Struct> lista = new ArrayList<>();
            JSONArray obj = null;
            try{
                obj = readJsonFromUrl(url);
            }catch(IOException io){
                logger.fatal("Cannot parse JSON url file!");
                return null;
            }

            for(int kindex = 0; kindex<obj.length(); kindex++)
            {
                JSONArray kanaly = new JSONArray(obj.get(kindex).toString());
                String nazwaK = kanaly.get(1).toString();
                JSONArray programy = new JSONArray(kanaly.get(2).toString());

                //System.out.println(nazwaK);

                Struct kan = new Struct();

                kan.kanal = nazwaK;

                for(int pindex = 0; pindex<programy.length(); pindex++)
                {
                    JSONArray program = new JSONArray(programy.get(pindex).toString());

                    Vector<String> prog = new Vector<>();

                    prog.add(program.get(0).toString());
                    prog.add(program.get(1).toString());
                    prog.add(program.get(2).toString());

                    kan.program.add(prog);

    //                String program_id = program.get(0).toString();
    //                String program_title = program.get(1).toString(); 
    //                String program_start = program.get(2).toString(); 

    //                System.out.println(program_id + program_title+program_start);
                }
    //            System.out.println();

                lista.add(kan);
            }
            return lista;
        }
        
        
    public String getDescription(String id)
    {
        id = id.replaceAll("\\s", ""); // remove whitespaces
        String desc = "Description unavailable";
        
        String url = "http://ncplus.pl/program-tv?rm=ajax&id="+id;
        
        JSONArray obj = null;
        try{
            obj = readJsonFromUrl(url);
        }catch(IOException io){
            logger.fatal("Cannot parse JSON url file!");
            logger.error("Cannot obtain programm description");
            return null;
        }
        
        desc = obj.get(0).toString();
            

        return desc;
    }    
        
        
    public  JSONArray readJsonFromUrl(String url) throws IOException, JSONException 
    {
        InputStream is = new URL(url).openStream();
        try {
          BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
          String jsonText = readAll(rd);
          JSONArray json = new JSONArray(jsonText);
          return json;
        } finally {
          is.close();
        }
    }
    
    
    private  String readAll(Reader rd) throws IOException 
    {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
          sb.append((char) cp);
        }
        return sb.toString();
    }
        
        
        

}
