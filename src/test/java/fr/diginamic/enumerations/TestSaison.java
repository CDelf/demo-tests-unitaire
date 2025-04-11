package fr.diginamic.enumerations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestSaison {

    @Test
    public void testValueOfLibelleValide(){
        // Rechercher la saison avec libellé correct et la bonne casse
        Saison testPrintemps = Saison.valueOfLibelle("Printemps");
        Saison testEte = Saison.valueOfLibelle("Eté");
        Saison testAutomne = Saison.valueOfLibelle("Automne");
        Saison testHiver = Saison.valueOfLibelle("Hiver");
        // Vérifier si la méthode retrouve bien l'instance
        assertEquals(Saison.PRINTEMPS, testPrintemps);
        assertEquals(Saison.ETE, testEte);
        assertEquals(Saison.AUTOMNE, testAutomne);
        assertEquals(Saison.HIVER, testHiver);
    }

    @Test
    public void testValueOfLibelleCasseDiff(){
        // Rechercher la saison avec libellé correct en majuscules ou minuscules
        Saison testPrintemps = Saison.valueOfLibelle("PRINTEMPS");
        Saison testEte = Saison.valueOfLibelle("été");
        Saison testAutomne = Saison.valueOfLibelle("AUTOMNE");
        Saison testHiver = Saison.valueOfLibelle("hiver");
        // Vérifier si la méthode retrouve bien l'instance
        assertEquals(Saison.PRINTEMPS, testPrintemps);
        assertEquals(Saison.ETE, testEte);
        assertEquals(Saison.AUTOMNE, testAutomne);
        assertEquals(Saison.HIVER, testHiver);
    }

    @Test
    public void testValueOfLibelleAvecEspaces(){
        // Rechercher la saison avec libellé correct mais espaces superflus avant/après
        Saison testPrintemps = Saison.valueOfLibelle("  printemps  ");
        Saison testEte = Saison.valueOfLibelle("  ETE");
        Saison testAutomne = Saison.valueOfLibelle("automne  ");
        Saison testHiver = Saison.valueOfLibelle("  HIVER          ");
        // Vérifier si la méthode retrouve bien l'instance
        assertEquals(Saison.PRINTEMPS, testPrintemps);
        assertEquals(Saison.ETE, testEte);
        assertEquals(Saison.AUTOMNE, testAutomne);
        assertEquals(Saison.HIVER, testHiver);
    }

    @Test
    public void testValueOfLibelleIncorrectDevraitRetournerNull(){
        // Rechercher la saison avec libellé incorrect, vide ou null
        Saison test1 = Saison.valueOfLibelle("N'importe quoi");
        Saison test2 = Saison.valueOfLibelle(null);
        Saison test3 = Saison.valueOfLibelle("");
        // Vérifier si la méthode retourne null
        assertNull(test1);
        assertNull(test2);
        assertNull(test3);
    }

    @Test
    public void testValueOfLibelleAvecNumber() {
        // Rechercher la saison avec un nombre
        Saison test = Saison.valueOfLibelle("123");
        // Vérifier si la méthode retourne null
        assertNull(test);
    }
}
