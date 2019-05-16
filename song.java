import java.util.*;
import java.io.*;

public class song {
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {

      // Create a list from elements of HashMap
      List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

      // Sort the list
      Collections.sort(list, new java.util.Comparator<Map.Entry<String, Integer> >() {
      	public int compare(Map.Entry<String, Integer> o1,
                           Map.Entry<String, Integer> o2) {
        	return (o2.getValue()).compareTo(o1.getValue());
        }
      });

      // put data from sorted list to hashmap
      HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
      for (Map.Entry<String, Integer> aa : list) {
      	temp.put(aa.getKey(), aa.getValue());
      }
      return temp;
    }

	
	
	

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        // open the file
        Scanner console = new Scanner(System.in);
        String fileName = "song.txt";
        Scanner input = new Scanner(new File(fileName));

        // count occurrences
        HashMap<String, Integer> wordCounts = new HashMap<String, Integer>();
        while (input.hasNext()) {
            String next1 = input.next().toLowerCase();
            String next= next1.replaceAll("\\p{Punct}", "").toLowerCase();
            if (!wordCounts.containsKey(next)) {

               
                wordCounts.put(next, 1);
            } else {
                wordCounts.put(next, wordCounts.get(next) + 1);
            }
        }
        //print out put in text file created in computer
        PrintWriter writer = new PrintWriter("output.doc");
      	
        writer.println("Total words = " + wordCounts.size());
        writer.println("\t");
        HashMap<String, Integer> sortedMapAsc = sortByValue(wordCounts);

        // Report frequencies
        for (String word : sortedMapAsc.keySet()) {
            int count = sortedMapAsc.get(word);
            writer.println(count + ":\t" + word);
        }
        writer.close();
    }
}
