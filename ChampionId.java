package league;

import java.io.*;
import java.util.*;

public class ChampionId {
	
	
	public static Map<String, String> getList(){
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
	public static void main(String[] args)
	{
		Map<String, String> p = getList();
		System.out.print(p.get("1"));
	}
	
}