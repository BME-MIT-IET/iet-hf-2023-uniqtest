package test.java.iet;

import main.java.iet.Core.*;
import main.java.iet.Equipments.*;
import main.java.iet.Gencodes.*;
import main.java.iet.Fields.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTests {
    Virologist virologist;
    Game game;
    Field field;
    Field neighbourField;

    @BeforeEach
    public void setUp() {

        game = new Game(1);
        field = new Field();
        neighbourField = new Field();
        virologist = new Virologist(game, field);
        field.addNeighbour(neighbourField);
        game.AddVirologist(virologist);
        game.activeVirologist = virologist;
    }

    @Test
    void stepTest() {
        virologist.UseMove(0);
        
        assertEquals(neighbourField, virologist.getField());
    }

    @Test
    void putVirologistOnFieldTest() {
        Virologist newVirologist = new Virologist(game, neighbourField);

        assertEquals(true, neighbourField.getVirologists().contains(newVirologist));
    }

    @Test
    void RemoveVirologistFromFieldTest() {
        field.RemoveVirologist(virologist);

        assertEquals(0, field.getVirologists().size());
    }

}
