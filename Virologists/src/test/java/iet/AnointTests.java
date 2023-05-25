package test.java.iet;

import main.java.iet.Agents.DancerAgent;
import main.java.iet.AnointedBehaviours.BlockAnoint;
import main.java.iet.AnointedBehaviours.MightBlockAnoint;
import main.java.iet.AnointedBehaviours.ReturnAnoint;
import main.java.iet.AnointedBehaviours.TakeAnoint;
import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Glove;
import main.java.iet.Fields.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnointTests {
    private Game game;
    private Field field;
    private Virologist virologist;

    @BeforeEach
    public void onTimeSetup() {
        game = new Game(1);
        field = new Field();
        virologist = new Virologist(game,field);
    }


    @Test
    public void TakeAnointTest() {
        virologist.setAnointedBehaviour(new TakeAnoint());
        Virologist tempVir = new Virologist(game,field);
        DancerAgent dancerAgent = new DancerAgent();
        tempVir.Anoint(virologist,dancerAgent);

        assertTrue(virologist.getEffects().contains(dancerAgent));
    }

    @Test
    public void BlockAnointTest() {
        virologist.setAnointedBehaviour(new BlockAnoint());
        Virologist tempVir = new Virologist(game,field);
        DancerAgent dancerAgent = new DancerAgent();
        tempVir.Anoint(virologist,dancerAgent);

        assertFalse(virologist.getEffects().contains(dancerAgent));
    }

    @Test
    public void ReturnAnointTest() {
        virologist.setAnointedBehaviour(new ReturnAnoint(new Glove(virologist)));
        Virologist tempVir = new Virologist(game,field);
        DancerAgent dancerAgent = new DancerAgent();
        tempVir.Anoint(virologist,dancerAgent);

        assertFalse(virologist.getEffects().contains(dancerAgent));
        assertTrue(tempVir.getEffects().contains(dancerAgent));
    }

    @Test
    public void MightBlockAnointTest() {
        MightBlockAnoint mgb =new MightBlockAnoint();
        mgb.setDet("on");
        virologist.setAnointedBehaviour(mgb);
        Virologist tempVir = new Virologist(game,field);
        DancerAgent dancerAgent = new DancerAgent();

        assertFalse(virologist.getEffects().contains(dancerAgent));

        mgb.setDet("off");
        tempVir.Anoint(virologist,dancerAgent);
        assertTrue(virologist.getEffects().contains(dancerAgent));

    }


}
