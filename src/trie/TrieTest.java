package trie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TrieTest {

	@Test
	void testOneWord() {
		String [] allWords = new String[]{"door"};
		TrieNode root = Trie.buildTrie(allWords);
		// print it for verification
		Trie.print(root, allWords);
		// do completion lists
		//Trie.completionLists(root, allWords); 
	}


	@Test
	void testTwoWords() {
		String [] allWords = new String[]{"door", "dorm"};
		TrieNode root = Trie.buildTrie(allWords);
		// print it for verification
		Trie.print(root, allWords);
		// do completion lists
		//Trie.completionLists(root, allWords); 
	}

	
	@Test
	void testThreeWords() {
		String [] allWords = new String[]{"door", "dorm", "doom"};
		TrieNode root = Trie.buildTrie(allWords);
		// print it for verification
		Trie.print(root, allWords);
		// do completion lists
		//Trie.completionLists(root, allWords); 
	}
	
	@Test
	void testFileWords1() {
		String [] allWords = new String[]{"bear","bell","bid","bull","buy","sell","stock","stop"};
		TrieNode root = Trie.buildTrie(allWords);
		// print it for verification
		Trie.print(root, allWords);
		// do completion lists
		//Trie.completionLists(root, allWords); 
	}
}
