package fr.diginamic.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {

    @Test
    public void levenshteinDistanceInf1Test() {
        int test = StringUtils.levenshteinDistance("java", "java");
        int test1 = StringUtils.levenshteinDistance("chat", "chats");
        int test2 = StringUtils.levenshteinDistance("aviron", "avion");

        assertEquals(0, test);
        assertEquals(1, test1);
        assertEquals(1, test2);
    }

    @Test
    public void  levenshteinDistanceSup1Test() {
        int test1 = StringUtils.levenshteinDistance("chien", "chine");
        int test2 = StringUtils.levenshteinDistance("distance", "instancie");

        assertEquals(2, test1);
        assertEquals(3, test2);
    }

    @Test
    public void levenshteinDistanceEspacesVidesTest() {
        int test1 = StringUtils.levenshteinDistance(" ",  " a");
        int test2 = StringUtils.levenshteinDistance(" a ", "  a");

        assertEquals(1, test1);
        assertEquals(2, test2);
    }

    @Test
    public void testLevenshteinAvecNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.levenshteinDistance(null, "chat");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.levenshteinDistance("chien", null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.levenshteinDistance(null, null);
        });
    }

}
