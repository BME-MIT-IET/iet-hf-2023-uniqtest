package test.java.iet;

import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Glove;
import main.java.iet.Fields.Field;
import main.java.iet.VirologistBehaviours.Normal;
import main.java.iet.VirologistBehaviours.Paralyzed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StealingTests {
    private Game game;
    private Field field;
    private Virologist attacker;
    private Virologist victim;

    @BeforeEach
    public void onTimeSetup() {
        game = new Game(1);
        field = new Field();
        attacker = new Virologist(game,field);
        victim = new Virologist(game,field);
    }

    @Test
    public void StealEquipmentFromNormalPlayerTest() {
        victim.setVirologistBehaviour(new Normal());
        Glove glove = new Glove(victim);
        victim.getEquipments().add(glove);
        attacker.StealEquipment(victim,glove);

        assertEquals(victim,glove.getVirologist());
        assertTrue(victim.getEquipments().contains(glove));
        assertFalse(attacker.getEquipments().contains(glove));
    }

    @Test
    public void StealEquipmentFromParalyzedPlayerTest() {
        victim.setVirologistBehaviour(new Paralyzed());
        Glove glove = new Glove(victim);
        victim.getEquipments().add(glove);
        attacker.StealEquipment(victim,glove);

        //assertEquals(attacker,glove.getVirologist());
        assertFalse(victim.getEquipments().contains(glove));
        assertTrue(attacker.getEquipments().contains(glove));
    }

    @Test
    public void StealSubstanceFromNormalPlayerTest() {
        victim.setVirologistBehaviour(new Normal());
        victim.setAmino(5);
        victim.setNucleotid(5);
        attacker.setNucleotid(0);
        attacker.setAmino(0);
        attacker.StealSubstance(victim);

        assertEquals(5,victim.getAmino());
        assertEquals(5,victim.getNucleotid());
        assertEquals(0,attacker.getAmino());
        assertEquals(0,attacker.getNucleotid());
    }

    @Test()
    public void StealSubstanceFromParalyzedPlayerTest() {
        victim.setVirologistBehaviour(new Paralyzed());
        victim.setAmino(5);
        victim.setNucleotid(5);
        attacker.setNucleotid(0);
        attacker.setAmino(0);
        attacker.StealSubstance(victim);

        assertEquals(2,victim.getAmino());
        assertEquals(2,victim.getNucleotid());
        assertEquals(3,attacker.getAmino());
        assertEquals(3,attacker.getNucleotid());

        victim.setAmino(2);
        victim.setNucleotid(0);
        attacker.setNucleotid(0);
        attacker.setAmino(0);
        attacker.StealSubstance(victim);

        assertEquals(0,victim.getAmino());
        assertEquals(0,victim.getNucleotid());
        assertEquals(2,attacker.getAmino());
        assertEquals(0,attacker.getNucleotid());

        victim.setAmino(4);
        victim.setNucleotid(4);
        attacker.setMaxSubstance(5);
        attacker.setNucleotid(5);
        attacker.setAmino(3);
        attacker.StealSubstance(victim);

        assertEquals(2,victim.getAmino());
        assertEquals(4,victim.getNucleotid());
        assertEquals(5,attacker.getAmino());
        assertEquals(5,attacker.getNucleotid());
    }

}
