package fr.diginamic.immobilier.entites;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMaison {
    private Maison maison;
    private Piece sdb;
    private Piece chambre;
    private Piece salon;
    private Piece cuisine;
    private Piece wc;

    @BeforeEach
    public void setUp() {
        maison = new Maison();
        sdb = new SalleDeBain(2, 20);
        chambre = new Chambre(2, 25);
        salon = new Salon(1, 30);
        cuisine = new Cuisine(1, 20);
        wc = new WC(1, 10);
    }

    /** Ajoute les 5 pièces à la maison */
    private void ajouterToutesLesPieces() {
        maison.ajouterPiece(sdb);
        maison.ajouterPiece(chambre);
        maison.ajouterPiece(salon);
        maison.ajouterPiece(cuisine);
        maison.ajouterPiece(wc);
    }

    @Test
    public void ajouterPieceTest() {
        assertEquals(0, maison.getPieces().length);
        maison.ajouterPiece(sdb);
        assertEquals(1, maison.getPieces().length);
        maison.ajouterPiece(chambre);
        assertEquals(2, maison.getPieces().length);
        maison.ajouterPiece(salon);
        assertEquals(3, maison.getPieces().length);
        maison.ajouterPiece(cuisine);
        assertEquals(4, maison.getPieces().length);
        maison.ajouterPiece(wc);
        assertEquals(5, maison.getPieces().length);
    }

    @Test
    public void ajouterPieceNullDevraitAnnulerSonAjoutTest(){
        maison.ajouterPiece(null);
        assertEquals(0, maison.getPieces().length);
    }

    @Test
    public void nbPiecesTest() {
        assertEquals(0, maison.nbPieces());
        ajouterToutesLesPieces();
        assertEquals(5, maison.nbPieces());
    }

    @Test
    public void superficieEtageTest() {
        assertEquals(0, maison.superficieEtage(1));
        assertEquals(0, maison.superficieEtage(2));

        ajouterToutesLesPieces();

        assertEquals(60,  maison.superficieEtage(1));
        assertEquals(45, maison.superficieEtage(2));
    }

    @Test
    public void superficieEtageInexistantTest() {
        ajouterToutesLesPieces();
        assertEquals(0, maison.superficieEtage(3));
    }

    @Test
    public void superficieTypePieceBienEcritTest() {
        assertEquals(0, maison.superficieTypePiece("Salle de bain"));
        assertEquals(0, maison.superficieTypePiece("Chambre"));
        assertEquals(0, maison.superficieTypePiece("Salon"));
        assertEquals(0, maison.superficieTypePiece("Cuisine"));
        assertEquals(0, maison.superficieTypePiece("WC"));

        ajouterToutesLesPieces();

        assertEquals(20, maison.superficieTypePiece("Salle de bain"));
        assertEquals(25, maison.superficieTypePiece("Chambre"));
        assertEquals(30, maison.superficieTypePiece("Salon"));
        assertEquals(20, maison.superficieTypePiece("Cuisine"));
        assertEquals(10, maison.superficieTypePiece("WC"));
    }

    @Test
    public void superficieTypePieceCasseTest() {
        ajouterToutesLesPieces();

        assertEquals(20, maison.superficieTypePiece("SALLE DE BAIN"));
        assertEquals(25, maison.superficieTypePiece("chambre"));
        assertEquals(30, maison.superficieTypePiece("saLON"));
        assertEquals(20, maison.superficieTypePiece("CUISine"));
        assertEquals(10, maison.superficieTypePiece("Wc"));
    }

    @Test
    public void superficieTypePieceIncorrectTest() {
       assertEquals(0, maison.superficieTypePiece("Piece"));
       assertEquals(0, maison.superficieTypePiece("Maison"));
        assertEquals(0, maison.superficieTypePiece(null));
    }

    @Test
    public void calculerSurfaceTest() {
        assertEquals(0, maison.calculerSurface());
        ajouterToutesLesPieces();
        assertEquals(105, maison.calculerSurface());
    }
}
