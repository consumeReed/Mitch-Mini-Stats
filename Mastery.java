package league;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Mastery {
	
	static String key = "RGAPI-ddea499e-a396-4909-9ba4-bca9d51ed011";
	static String urlA = "https://na1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-summoner/";
	static String urlB = "?api_key=";
	static List<String> masteryInfo = new LinkedList<String>();
	static String id = "";
	static String url;
	
	static Summoner summ = new Summoner();
	
	
	public static void createSummoner(String name)
	{
		summ.createSummoner(name);
		id = summ.getId();
		url=urlA+id+urlB+key;
	}
	
	public static void getMastery()
	{
		
	}
	

	
	
	
	public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Enter a League Summoner Name: ");
        String inp = sc.nextLine();
        createSummoner(inp);
        System.out.println("");
        
    }

}
