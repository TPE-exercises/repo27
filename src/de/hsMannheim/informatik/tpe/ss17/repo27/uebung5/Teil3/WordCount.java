package de.hsMannheim.informatik.tpe.ss17.repo27.uebung5.Teil3;

/*TPE Übungsblatt 5 Aufgabe 3
 * 
 * @author repo 2-7
 */

	import java.io.*;
	import java.util.*;
	import java.util.logging.Level;
	import java.util.logging.Logger;

	public final class WordCount {

	    Hashtable hashtable;
	    BufferedReader bufferedReader;
	    
	    /**
	     * Array to confirm letters and words of the text.
	     */
	    private Character alphabet[] = new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
	        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
	        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'Ä', 'Ö', 'Ü', 'ä', 'ö',
	        'ü'};

	    public WordCount(String fileToBeAnalyzed) throws IOException {
	    	//the "programm" starts upon initalizing an object with the file to count words from
	    	try {
	        	
	            this.bufferedReader = new BufferedReader(new FileReader(fileToBeAnalyzed));
	            this.hashtable = new Hashtable<String, Integer>();
	            //extracting the words from the file to the hashtable
	            extractWords();
	         
	            //after extractiong all words we sort them by frequency
	            listWordsByFrequencyDescending();
	            
	            //simply closing the file we used
	            closeReader();
	            
	            
	            //catch exception if the file to use doesn´t exist 
	        } catch (FileNotFoundException ex) {
	        	
	            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    /**
	     * Closes the reader which was opened upon initalizing an object of this
	     * class WordCount.
	     */
	    protected void closeReader() {
	        try {
	            bufferedReader.close();
	        } catch (IOException ex) {
	            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    /**
	     * Reads a text file and spots each single word in there. Words are Strings,
	     * that only consist of letters. These words will be saved into a hashtable.
	     *
	     * Here, Words are not case sensitive, they will all be treated as if they
	     * were written with small letters only.
	     */
	    public void extractWords() {
	        try {
	            // System.out's for observation purposes
	            System.out.println("bufferedReader.ready() " + bufferedReader.ready());
	            while (bufferedReader.ready()) {
	                String line = bufferedReader.readLine();
	                System.out.println("bufferedReader.readLine()" + line);
	                if (line != null) {
	                    extractWordsFromLine(line);
	                }
	            }
	        } catch (IOException ex) {
	            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    /**
	     * Extracts the words from a text line and saves them into the hashtable of
	     * WordCount.
	     *
	     * Here, Words are not case sensitive, they will all be treated as if they
	     * were written with small letters only.
	     *
	     * @param line the line of text to be analyzed.
	     */
	    public void extractWordsFromLine(String line) {
	       
	    	int lineLength = line.length();
	        int lineIndex = 0;
	        boolean wordInExamination = true;
	        String nextWord = "";
	        
	        while (lineIndex < lineLength && wordInExamination) {

	            int alphabetIndex = 0;
	            boolean charFound = false;
	            // Checks whether the current symbol is a letter from the alphabet
	            while (alphabetIndex < this.alphabet.length && !charFound) {
	                if (alphabet[alphabetIndex].equals(line.charAt(lineIndex))) {
	                    nextWord += line.charAt(lineIndex);
	                    charFound = true;
	                }
	                alphabetIndex++;
	                // The current symbol is none of the alphabet
	                if (alphabetIndex == this.alphabet.length) {
	                    wordInExamination = false;
	                }
	            }

	            if (nextWord.length() != 0 && !wordInExamination) {
	                nextWord = nextWord.toLowerCase();
	                if (this.hashtable.get(nextWord) == null) {
	                    // inserts a word for its first time
	                    this.hashtable.put(nextWord, 1);
	                } else {
	                    // Increases the count of this word being found in the text
	                    Integer number = (Integer) this.hashtable.get(nextWord);
	                    number = number + 1;
	                    this.hashtable.put(nextWord, number);
	                }
	                nextWord = "";
	                wordInExamination = true;
	            }
	            lineIndex++;
	        }
	    }

	    /**
	     * Lists all the words currently saved in the hashtable of WordCount sorted
	     * by frequency, descending.
	     */
	    //TODO: Implement
	    public void listWordsByFrequencyDescending() {
	       
//	        Enumeration e = hashtable.keys();
//	        Enumeration f = hashtable.elements();
//	        Integer maxValue = 0;
//	        SortedMap map = new TreeMap(Collections.reverseOrder());
//	        while (e.hasMoreElements()) {
//	            System.out.println(e.nextElement() + " " + f.nextElement());	         
//	         }
	        sortValues(hashtable);
	    }

	    public void sortValues(Hashtable<?, Integer> t) {
	        ArrayList<Map.Entry<?, Integer>> list = new ArrayList(t.entrySet());
	        Collections.sort(list, new Comparator<Map.Entry<?, Integer>>() {
	            @Override
	            public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
	                return o1.getValue().compareTo(o2.getValue());
	            }
	        });
//	        Comparator cmp = Collections.reverseOrder();
//	        Collections.sort(list, cmp);
	        Iterator it;
	        if (list.size() >= 100) {
	            it = list.listIterator(list.size() - 100);
	        } else {
	            it = list.listIterator();
	        }
	        System.out.println();
	        System.out.println("Iterator über der Liste: ");
	        while (it.hasNext()) {
	            
	            System.out.println(it.next());
	        }

	    }

	    public static void main(String[] args) {
	        long time = System.currentTimeMillis();
	        try {
	            WordCount wordcountExample = new WordCount("C:\\Users\\Max\\git\\repo27\\src\\de\\hsMannheim\\informatik\\tpe\\ss17\\repo27\\uebung5\\Teil3\\Bible");
	        } catch (IOException ex) {
	            Logger.getLogger(WordCount.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        time = System.currentTimeMillis() - time;
	        System.out.println("Benötigte Zeit (in ms): " + time);
	    }
	}

