package agh;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class DownloaderPool {

	final static Logger logger = Logger.getLogger(DownloaderPool.class);
	
	private ThreadPoolExecutor exec;
        public static int FINAL_DOWNLOADS = 0;
	
	public DownloaderPool()
	{
		//list = null;
	}
	
	
	public void startDownloads(ArrayList<Downloader> list) throws MalformedURLException
	{
					
		
		BlockingQueue<Runnable> runnables = new ArrayBlockingQueue<Runnable>(1024);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 16, Downloader.TIMEOUT, TimeUnit.SECONDS, runnables);
		
		exec = executor;
		
		for (Downloader dwn : list)
                    executor.submit(dwn);
                
		executor.shutdown();
		logger.info("Rozpoczęto procedurę wielowątkowego pobierania.");
	}
	

}
