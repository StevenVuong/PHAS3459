package midTermExam;

//import necessary classes
import java.io.*;
import java.net.URL;
import java.util.*;

public class Year2016 {

	public static Hitter parseLine(String line) {
		// return a Hitter object with all the data of one Hitter

		Scanner mult = new Scanner(line).useDelimiter("\t"); // scans each value, separating by tabs

		// puts data into each variable
		String name = mult.next();
		String team = mult.next();
		String pos = mult.next();
		int games = Integer.parseInt(mult.next());
		int ab = Integer.parseInt(mult.next());
		int runs = Integer.parseInt(mult.next());
		int hits = Integer.parseInt(mult.next());
		int doubles = Integer.parseInt(mult.next());
		int triples = Integer.parseInt(mult.next());
		int hr = Integer.parseInt(mult.next());
		int rbi = Integer.parseInt(mult.next());
		double avg = Double.parseDouble(mult.next());
		double obp = Double.parseDouble(mult.next());

		mult.close(); // close scanner

		// output as new hitter Object with all of the parsed data
		return new Hitter(name, team, pos, games, ab, runs, hits, doubles, triples, hr, rbi, avg, obp);

	}

	public static ArrayList<Hitter> dataFromURLPlanet(String urlName) throws Exception {
		// Create an ArrayList of Hitter objects from a URL

		// takes url and creates a buffered reader object
		URL u = new URL(urlName);
		InputStream is = u.openStream();
		InputStreamReader r = new InputStreamReader(is);
		BufferedReader b = new BufferedReader(r);

		ArrayList<Hitter> hitters = new ArrayList<Hitter>(); // Define ArrayList containing Hitter objects
		String line = ""; // Initialise string so that it is not initially null for the while loop below

		b.readLine(); // Ignore the first two lines
		b.readLine();

		while ((line = b.readLine()) != null) { // Take an object created from each line and store in the ArrayList
			hitters.add(parseLine(line));
		}

		return hitters;

	}

	public static void main(String[] args) {
		try {
			
			ArrayList<Hitter> allHitters = dataFromURLPlanet("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/MLB2001Hitting.txt");
			System.out.println("there are  " + allHitters.size() + " Hitters in this list");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
