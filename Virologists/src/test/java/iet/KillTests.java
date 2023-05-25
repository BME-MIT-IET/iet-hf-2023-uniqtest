package test.java.iet;

import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Axe;
import main.java.iet.Fields.Field;
import main.java.iet.KillBehaviours.CantKill;
import main.java.iet.KillBehaviours.KillWithAxe;
import main.java.iet.MoveBehaviours.BearMove;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KillTests {
    private Game game;
    private Field field;
    private Virologist attacker;
    private Virologist victim;

    @BeforeEach
    public void onTimeSetup() {
        game = new Game(2);
        field = new Field();
        attacker = new Virologist(game,field);
        victim = new Virologist(game,field);
    }

    @Test
    public void KillBearWithAxeTest() {
        Axe axe = new Axe(attacker);
        attacker.getEquipments().add(axe);
        attacker.setKillBehaviour(new KillWithAxe(axe));

        victim.setMoveBehaviour(new BearMove());
        attacker.UseKill(victim);

        assertFalse(field.getVirologists().contains(victim));
        assertFalse(game.getVirologists().contains(victim));
        assertEquals(0,axe.getNumberOfUse());
        assertEquals(CantKill.class,attacker.getKillBehaviour().getClass());
        assertFalse(attacker.getEquipments().contains(axe));


    }

    @Test
    public void KillNormalPlayerWithAxe() {
        Axe axe = new Axe(attacker);
        attacker.getEquipments().add(axe);
        attacker.setKillBehaviour(new KillWithAxe(axe));
        attacker.UseKill(victim);

        assertTrue(field.getVirologists().contains(victim));
        assertTrue(game.getVirologists().contains(victim));
        assertEquals(1,axe.getNumberOfUse());
    }

    @Test
    public void KillWhenCantKillTest() {
        attacker.setKillBehaviour(new CantKill());
        attacker.UseKill(victim);

        assertTrue(field.getVirologists().contains(victim));
        assertTrue(game.getVirologists().contains(victim));
    }
}
