package league;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Scanner;
import java.util.*;
import java.lang.String;

public class DownloadPage {
    public static List<String> DownloadPage(String webURL) throws IOException {
    	
    	String[] split = null;
    	
        URL url = new URL(webURL);
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                split = line.split("[\",:{}]");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        List<String> splitLL = new LinkedList<String>(Arrays.asList(split));
        
        Iterator<String> i = splitLL.iterator();
        
        while(i.hasNext())
        {
        	String s = i.next();
        	if(s == null || s.isEmpty())
        		i.remove();
        }
        /*for(String s : splitLL)
        	System.out.println(s);
        	*/
        return splitLL;

    }
   
 }