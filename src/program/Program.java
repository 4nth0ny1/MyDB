package program;

import java.util.ArrayList;
import java.util.List;

import classes.Column;
import classes.Database;
import classes.Table;

public class Program {
	public Program() {}

	public void showIntro() {
		System.out.println("Welcome to my DB again...\n");
	}
	

	
	public String parseCommand(List<String> wordlist) {
		String msg = "done";
		if (wordlist.get(0).equals("select")) {
			System.out.println("you're selecting...");
		} else if (wordlist.get(0).equals("createdb")) {
			Database db = new Database(wordlist.get(1));
			System.out.println("you're creating a ..." + db.getName() + " database.\n");
		} else if (wordlist.get(0).equals("addtable")) {
			Table table = new Table(wordlist.get(2));
			System.out.println("you're creating a table called ... " + table.getName());
		} else if (wordlist.get(0).equals("addcols")) {
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
