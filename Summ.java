package league;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.io.BufferedReader;

public class Summ {
	
	static String key = "xxx";
	static String urlA = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
	static String urlB = "?api_key=";
	static String summonerName;
	static String name;
	
	static HashMap<String, String> summoner = new HashMap<String, String>();
	static List<String> basicData = new LinkedList<String>();
	
	static String accountId;
	static String puuid;
	static String id;
	static String profileIconId;
	
	public Summ(String name) {
		summonerName = name.replace(" ", "%20");
		this.name = name;
		try {
			basicData = DownloadPage(urlA+summonerName+urlB+key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i < basicData.size(); i+=2)
		{
			summoner.put(basicData.get(i), basicData.get(i+1));
				
		}
		accountId = summoner.get("accountId");
		puuid = summoner.get("puuid");
		id = summoner.get("id");
		profileIconId = summoner.get("profileIconId");
	}
	
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
	
	public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter a League Summoner Name: ");
        String inp = sc.nextLine();
        Summ s = new Summ(inp);
        System.out.println("id: "+s.id);
        System.out.println("puuid: "+s.puuid);
        System.out.println("accountId: "+s.accountId);
    }

}
