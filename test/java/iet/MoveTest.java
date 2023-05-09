package test.java.iet;

import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Fields.Field;
import main.java.iet.Graphics.GameFrame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {
    Virologist virologist;
    Game game;
    GameFrame gf;
    Field field;
    Field neighbourField;

    @BeforeEach
    public void setUp() {
        game = new Game(1);
        field = new Field();
        neighbourField = new Field();
        field.addNeighbour(neighbourField);
        virologist = new Virologist(game, field);
        game.AddVirologist(virologist);
        game.activeVirologist = virologist;
        gf = new GameFrame(game);
        game.gf = gf;
    }

    @Test
    void stepTest() {
        virologist.UseMove(0);
        
        assertEquals(neighbourField, virologist.getField());
    }
}
