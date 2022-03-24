package league;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.io.BufferedReader;

/**
 * Summ
 * 
 * @author Reed Mitchell
 * @date March 24 2022
 * 
 * Summ Class is used to create an instance of a League of Legends summoner.
 * General information is pulled from the Riot Games API.
 *
 */

public class Summ {
	
	static String key = "xxx";	//API Key from Riot Games
	
	static String urlA = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/"; 
	static String urlB = "?api_key=";
	//Pieces of a web url to access the API
	
	static String summonerName; 	//Summoner name with replaced characters
	static String name;				//Summoner name
	
	static HashMap<String, String> summoner = new HashMap<String, String>();	//Stores summoner data
	static List<String> basicData = new LinkedList<String>();					//Stores unformatted summoner data
	
	static String accountId;
	static String puuid;
	static String id;
	static String profileIconId;
	//IDs associated with each summoner
	
	/**
	 * Constructor that accesses API using the given summoner name.
	 * Parses the data on the web url and stores it
	 * 
	 * @param name		Summoner name to check
	 */
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
	
	/* Given a web url, it will read all information and store
	 * the information in a formatted list
	 *
	 * @param webURL	web url to read data from
	 * @return 			List with all information from url
	 */
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
	
	//test method
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
