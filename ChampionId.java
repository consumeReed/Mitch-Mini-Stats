package league;
import java.io.*;

import java.util.*;
/**
 * ChampionId
 * 
 * @author Reed Mitchell
 * @date March 24 2022
 * 
 * ChampionId reads a file to gather the unique IDs
 * of every League of Legends champion(playable characters)
 *
 */

public class ChampionId {
	
	/*
	 * Associates champion names with their respected ID
	 * 
	 * @return 		Map containing champion ID as key and name as value
	 */
	public static Map<String, String> getList()
	{
		
		Map<String, String> champ = new HashMap<String, String>();
		BufferedReader br = null;
		try {
			File f = new File("lib\\lol_id.txt");
			br = new BufferedReader(new FileReader(f));
			String line = null;
			while((line = br.readLine()) != null)
			{
				String[] parts = line.split(":");
				
				String id = parts[0].trim();
				String name = parts[1].trim();
				champ.put(id, name);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return champ;
	
	}
	
	//test method
	public static void main(String[] args)
	{
		Map<String, String> p = getList();
		System.out.print(p.get("1"));
	}
	
}