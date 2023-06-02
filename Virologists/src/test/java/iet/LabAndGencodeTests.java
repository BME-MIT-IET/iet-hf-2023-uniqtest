package test.java.iet;

import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Fields.Field;
import main.java.iet.Fields.LaboratoryField;
import main.java.iet.Gencodes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabAndGencodeTests {
    Virologist labVirologist;
    Game game;
    Field lab;
    Gencode alzGencode;
    Gencode dancerGencode;
    Gencode resistGencode;
    Gencode paraGencode;

    @BeforeEach
    public void setUp() {
        game = new Game(1);
        lab = new LaboratoryField();
        labVirologist = new Virologist(game, lab);

        alzGencode = new AlzheimerGencode();
        dancerGencode = new DancerGencode();
        resistGencode = new ResistanceGencode();
        paraGencode = new ParalyzingGencode();

        lab.setGencode(alzGencode);
        game.AddVirologist(labVirologist);

    }


    @Test
    void setAlzheimerGencodeTest() {
        lab.setGencode(alzGencode);

        assertEquals("AlzheimerGencode", lab.getGencode().getName());
    }

    @Test
    void setDancerGencodeTest() {
        lab.setGencode(dancerGencode);

        assertEquals("DancerGencode", lab.getGencode().getName());
    }

    @Test
    void setParalyzingGencodeTest() {
        lab.setGencode(paraGencode);

        assertEquals("ParalyzingGencode", lab.getGencode().getName());
    }

    @Test
    void setResistanceGencodeTest() {
        lab.setGencode(resistGencode);

        assertEquals("ResistanceGencode", lab.getGencode().getName());
    }



    @Test
    void LearnGencodeTest() {
        labVirologist.TakeGencode(labVirologist.getField().getGencode());

        assertEquals(1, labVirologist.getGencodes().size());
    }



}
