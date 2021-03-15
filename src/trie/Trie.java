package trie;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class implements a Trie. 
 * 
 * @author Sesh Venugopal
 *
 */
public class Trie {
	
	static short zero = 0;
	
	// prevent instantiation
	private Trie() { }
	
	/**
	 * Builds a trie by inserting all words in the input array, one at a time,
	 * in sequence FROM FIRST TO LAST. (The sequence is IMPORTANT!)
	 * The words in the input array are all lower case.
	 * 
	 * @param allWords Input array of words (lowercase) to be inserted.
	 * @return Root of trie with all words inserted from the input array
	 */
	public static TrieNode buildTrie(String[] allWords) {
		/** COMPLETE THIS METHOD **/
		short startIndex;
		short endIndex;
		String word;
		Indexes idx;
		TrieNode root = createRoot();
		TrieNode node = createFirstTrieNode(allWords[0], root);
		for (short i = 1; i < allWords.length; i++) {	
	    	word = allWords[i];
	    	//node = root;
	    	String prefix = "";
	    	//insert(root, allWords, i);
	    	insert(node, allWords, i);
		}
		return root;
	}
	
//	static TrieNode insert(TrieNode node, String[] allWords, int currIndex) {
//		String word = allWords[currIndex];
//		TrieNode newNode = null;
//		if(node == null ) {
//			Indexes newNodeIdx = new Indexes(currIndex, (short) 0, (short) (word.length() - 1) );
//			return new TrieNode(newNodeIdx, null, null);
//		}
//		String nodeWordPrefix = "";
//		String nodeWord = "";
//		short endIndex, startIndex;
//		if(node.substr != null) {
//			endIndex = node.substr.endIndex;
//			startIndex = node.substr.startIndex;
//			nodeWord = allWords[node.substr.wordIndex];
//			nodeWordPrefix = nodeWord.substring(startIndex, endIndex);
//		} else {
//			endIndex = (short) (word.length() -1) ;
//			startIndex = zero;
//		}
//		String wordPrefix = word.substring(0, endIndex);
//		int cmp = nodeWordPrefix.compareTo(wordPrefix); 
//		if(cmp < 0) {
//			node.firstChild = insert(node.firstChild, allWords, currIndex);
//		}
//		else if(cmp >  0) {
//			node.sibling = insert(node.sibling, allWords, currIndex);
//		}
//		if(cmp == 0) {
//			node.substr = new Indexes(currIndex, startIndex, endIndex);
//			//node.firstChild
//		} 
////		if (node.firstChild == null) {
////			node.firstChild = insert(node.firstChild, idx, allWords, currIndex);
////		}
//		return node;
//	}
	
	static void insert(TrieNode node, String[] allWords, int currIndex) {
		String word = allWords[currIndex];
		while(true) {
			short endIndex = node.substr.endIndex;
			short startIndex = node.substr.startIndex;
			String nodeWord = allWords[node.substr.wordIndex];
			String nodeWordPrefix = nodeWord.substring(startIndex, endIndex +1 );
			String wordPrefix = word.substring(0, endIndex + 1);
			if(wordPrefix.equalsIgnoreCase(nodeWordPrefix)) {
				//found the same prefix, go down in tree
				node = node.firstChild;
				continue;
			} 
			
			//	find matching prefix
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < allWords.length; i++) {
				if(word.charAt(i) == nodeWord.charAt(i)) {
					sb.append(word.charAt(i));
				}
			}
			if(sb.length() > 0) {
				Indexes leftIdx =  new Indexes(node.substr.wordIndex, (short) sb.length(), (short) (nodeWord.length() -1 ));
				TrieNode leftNode = new TrieNode(leftIdx, null, null);
				node.firstChild = leftNode;
				Indexes idx = new Indexes(node.substr.wordIndex, node.substr.startIndex, (short) (sb.length() -1 ) );
				node.substr = idx;
				Indexes rightIdx =  new Indexes(currIndex, (short) sb.length(), (short) (word.length() -1 ));
				TrieNode rightNode = new TrieNode(rightIdx, null, null);
				node.sibling = rightNode;
				break;
			}

		}
	}

	static TrieNode createFirstTrieNode(String word, TrieNode root) {
		Indexes idx;
		idx = new Indexes(zero, zero, (short)(word.length()-1));
		TrieNode node = new TrieNode(idx, null, null);
		root.firstChild = node;
		return node;
	}

	static TrieNode createRoot() {
    	Indexes idx = new Indexes(zero, zero, zero);
    	TrieNode root = new TrieNode(null, null, null);
		return root;
	}
	
	/**
	 * Given a trie, returns the "completion list" for a prefix, i.e. all the leaf nodes in the 
	 * trie whose words start with this prefix. 
	 * For instance, if the trie had the words "bear", "bull", "stock", and "bell",
	 * the completion list for prefix "b" would be the leaf nodes that hold "bear", "bull", and "bell"; 
	 * for prefix "be", the completion would be the leaf nodes that hold "bear" and "bell", 
	 * and for prefix "bell", completion would be the leaf node that holds "bell". 
	 * (The last example shows that an input prefix can be an entire word.) 
	 * The order of returned leaf nodes DOES NOT MATTER. So, for prefix "be",
	 * the returned list of leaf nodes can be either hold [bear,bell] or [bell,bear].
	 *
	 * @param root Root of Trie that stores all words to search on for completion lists
	 * @param allWords Array of words that have been inserted into the trie
	 * @param prefix Prefix to be completed with words in trie
	 * @return List of all leaf nodes in trie that hold words that start with the prefix, 
	 * 			order of leaf nodes does not matter.
	 *         If there is no word in the tree that has this prefix, null is returned.
	 */
	public static ArrayList<TrieNode> completionList(TrieNode root,
										String[] allWords, String prefix) {
		/** COMPLETE THIS METHOD **/
		 ArrayList<TrieNode> list = new ArrayList<>();

		// FOLLOWING LINE IS A PLACEHOLDER TO ENSURE COMPILATION
		// MODIFY IT AS NEEDED FOR YOUR IMPLEMENTATION
		return null;
	}
	
	public static void print(TrieNode root, String[] allWords) {
		System.out.println("\nTRIE\n");
		print(root, 1, allWords);
	}
	
	private static void print(TrieNode root, int indent, String[] words) {
		if (root == null) {
			return;
		}
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		
		if (root.substr != null) {
			String pre = words[root.substr.wordIndex]
							.substring(0, root.substr.endIndex+1);
			System.out.println("      " + pre);
		}
		
		for (int i=0; i < indent-1; i++) {
			System.out.print("    ");
		}
		System.out.print(" ---");
		if (root.substr == null) {
			System.out.println("root");
		} else {
			System.out.println(root.substr);
		}
		
		for (TrieNode ptr=root.firstChild; ptr != null; ptr=ptr.sibling) {
			for (int i=0; i < indent-1; i++) {
				System.out.print("    ");
			}
			System.out.println("     |");
			print(ptr, indent+1, words);
		}
	}
 }
