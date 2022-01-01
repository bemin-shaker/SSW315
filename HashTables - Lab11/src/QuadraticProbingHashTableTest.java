import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class QuadraticProbingHashTableTest {

    private final QuadraticProbingHashTable Hash;
    private final QuadraticProbingHashTable Hash2;
    private final int[] num = new int[] { 7, 22, 44, 43, 27, 89, 30, 64, 85 };
    private final String[] arr = { "A", "W", "X", "Y", "CM", "CK", "BD", "H", "MOB", "BD" };

    public QuadraticProbingHashTableTest() {
        Hash = new QuadraticProbingHashTable(21);
        Hash2 = new QuadraticProbingHashTable(23);
    }

    @Test
    public void testInsert() {
    	Hash.makeEmpty();
        Hash2.makeEmpty();

        for (int i = 0; i < num.length; i++)
            Hash.insert(new MyInteger(num[i]));

        for (String s : arr)
        	Hash2.insert(new MyInteger(Hash2.hash(s, 23)));
    }

    @Test
    public void testPart1() {
    	Hash.makeEmpty();
        Hash2.makeEmpty();

        for (int i = 0; i < num.length; i++)
            Hash.insert(new MyInteger(num[i]));

        for (String s : arr)
        	Hash2.insert(new MyInteger(Hash2.hash(s, 23)));

        HashEntry[] table = Hash.getTable();

        assertEquals(7, Integer.parseInt(table[7].element.toString()));
        assertEquals(22, Integer.parseInt(table[1].element.toString()));
        assertEquals(44, Integer.parseInt(table[2].element.toString()));
        assertEquals(43, Integer.parseInt(table[5].element.toString()));
        assertEquals(27, Integer.parseInt(table[6].element.toString()));
        assertEquals(89, Integer.parseInt(table[9].element.toString()));
        assertEquals(30, Integer.parseInt(table[10].element.toString()));
        assertEquals(64, Integer.parseInt(table[17].element.toString()));
        assertEquals(85, Integer.parseInt(table[16].element.toString()));
    }

    @Test
    public void testPart2() {
    	Hash.makeEmpty();
        Hash2.makeEmpty();

        for (int i = 0; i < num.length; i++)
            Hash.insert(new MyInteger(num[i]));

        for (String s : arr)
        	Hash2.insert(new MyInteger(Hash2.hash(s, 23)));

        HashEntry[] table = Hash2.getTable();

        for (String s : arr) {
            int hash = Hash2.hash(s, 23);
            assertEquals(new MyInteger(hash), table[hash].element);
        }
    }


}

