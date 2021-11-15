package test.twest.data.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
    private Trie example;
    private String[] tests = {"Hello", "cruel", "word"};

    @Before
    public void setUp() throws Exception {
        example = new Trie();
    }

    @Test
    public void insert() {
        for(String aWord : tests) {
            example.insert(aWord);
        }
    }

    @Test
    public void testToString() {
        insert();
        System.out.println(example.toString());
    }

    @Test
    public void searchTest() {
        insert();
        for(String aWord : tests) {
            System.out.println(example.search(aWord));
        }

        System.out.println("Searching for [ell] " + example.search("ell"));

        // false
        System.out.println(example.search("Futurama"));
    }

    @Test
    public void delete() {
        insert();
        System.out.println("Size of trie: " + example.size());
        for(String aWord : tests) {
            example.delete(aWord);
            System.out.println("Size of trie: " + example.size() + "' when deleted " + aWord);
        }
    }
}