package program;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

import classes.Column;
import classes.Database;
import classes.DatabaseManager;
import classes.Table;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Program {
	public Program() {}

	public void showIntro() {
		System.out.println("Welcome to my DB again...\n");
	}
	
	public static File findFile(File dir, String targetName) {
	    File[] files = dir.listFiles();
	    if (files == null) return null;

	    for (File file : files) {
	        if (file.isDirectory()) {
	            File found = findFile(file, targetName); // recursive call
	            if (found != null) return found;
	        } else if (file.getName().equals(targetName)) {
	            return file;
	        }
	    }

	    return null;
	}
	
	public String parseCommand(List<String> wordlist) {
		String msg = "done";
		if (wordlist.get(0).equals("select")) {
			System.out.println("you're selecting...");
		} 
		else if (wordlist.get(0).equals("createdb")) {
			DatabaseManager manager = new DatabaseManager();
			Database db = new Database(wordlist.get(1));
			manager.addDatabase(db);
			
			try {
				ObjectMapper mapper = new ObjectMapper();
				mapper.writeValue(new File(db.getName() + ".json"), manager);	
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} 
		else if (wordlist.get(0).equals("deletedb")) {
		    try {
		        File result = findFile(new File("."), wordlist.get(1) + ".json"); 
		        // TODO: add a path to the file, so that the user can add a different directory
		        // something like createdb fruits .
		        // or createdb fruits ../databases, if no directory called databases exists then create it. 

		        if (result == null) {
		            System.out.println("File not found: " + wordlist.get(1) + ".json");
		            return msg;
		        }

		        if (!result.exists()) {
		            System.out.println("File does not exist: " + result.getAbsolutePath());
		            return msg;
		        }

		        if (result.delete()) {
		            System.out.println("Deleted: " + result.getAbsolutePath());
		        } else {
		            System.out.println("Failed to delete: " + result.getAbsolutePath());
		        }

		    } catch (SecurityException se) {
		        System.out.println("Permission denied: " + se.getMessage());
		    } catch (Exception e) {
		        System.out.println("Something went wrong: " + e.getMessage());
		    }
		}

	
		
		else if (wordlist.get(0).equals("addtable")) {
		    File result = findFile(new File("."), wordlist.get(1) + ".json");
		    
		    if (result != null) {
		        try {
		            // Load the database manager from file
		            ObjectMapper mapper = new ObjectMapper();
		            DatabaseManager dbm = mapper.readValue(result, DatabaseManager.class);

		            // Find the correct database
		            Database res = dbm.getDatabaseByName(wordlist.get(1));
		            if (res != null) {
		                Table table = new Table(wordlist.get(2));
		                res.addTable(table);
		                System.out.println("Added table: " + table.getName() + " to database: " + res.getName());

		                // Save the updated manager back
		                mapper.writeValue(result, dbm);
		            } else {
		                System.out.println("Database found in file, but no matching name inside: " + wordlist.get(1));
		            }

		        } catch (Exception e) {
		            System.out.println("Error loading or modifying database: " + e.getMessage());
		            e.printStackTrace();
		        }

		    } else {
		        System.out.println("Database file not found: " + wordlist.get(1) + ".json");
		    }
		}

		else if (wordlist.get(0).equals("addcols")) {
			Column column = new Column(wordlist.get(3));
			System.out.println("you're adding a column called .... " + column.getName());
		}
		return msg;
	}
	
	public List<String> wordList(String input) {
		String delims = "[ \t,.:;?!\"']+"; 
		List<String> strList = new ArrayList<>();
		String[] words = input.split(delims);
		
		for (String word : words) {
			strList.add(word);
		}
		return strList;
	}

	public String runCommand(String inputStr) { 
		System.out.println("YOu're running a command ---> " + inputStr);
		List<String> wordlist;
        String s = "ok";
        String lowstr = inputStr.trim().toLowerCase();        
        if (!lowstr.equals("q")) {
            if (lowstr.equals("")) {
                s = "You must enter a command";
            } else {
                wordlist = wordList(lowstr);                
                s = parseCommand(wordlist);
            }
        }
        return s;
	}
	
}
