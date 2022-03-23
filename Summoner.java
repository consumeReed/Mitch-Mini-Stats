package league;
import java.io.IOException;
import java.util.*;

public class Summoner 
{
	
	static String key = "RGAPI-ddea499e-a396-4909-9ba4-bca9d51ed011";
	static String urlA = "https://na1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
	static String urlB = "?api_key=";
	
	
	static HashMap<String, String> summoner = new HashMap<String, String>();
	static List<String> basicData = new LinkedList<String>();
	
	public static HashMap<String, String> createSummoner(String name)
	{
		String modName = name.replace(" ", "%20");
		DownloadPage dp = new DownloadPage();
		try {
			basicData = dp.DownloadPage(urlA+modName+urlB+key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i < basicData.size(); i+=2)
		{
			summoner.put(basicData.get(i), basicData.get(i+1));
				
		}
		return summoner;
		
	}
	
	public static String getId()
	{
		return summoner.get("id");
	}
	
	public static String getAccountId()
	{
		return summoner.get("accountId");
	}
	
	public static String getPuuid()
	{
		return summoner.get("puuid");
	}
	
	public static String getName()
	{
		return summoner.get("name");
	}
	
	public static String getIconId()
	{
		return summoner.get("ProfileIconId");
	}
	
	public static String getLevel()
	{
		return summoner.get("summonerLevel");
	}
	
	public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter a League Summoner Name: ");
        String inp = sc.nextLine();
        createSummoner(inp);
        System.out.println(getId());
        
    }

}
