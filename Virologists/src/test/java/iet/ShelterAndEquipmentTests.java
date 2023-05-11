package test.java.iet;

import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.*;
import main.java.iet.Fields.Field;
import main.java.iet.Fields.ShelterField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShelterAndEquipmentTests {

    Virologist shelterVirologist;
    Game game;
    Field shelter;
    Equipment cape;
    Equipment axe;
    Equipment bag;
    Equipment glove;

    @BeforeEach
    public void setUp() {
        game = new Game(1);
        shelter = new ShelterField();
        shelterVirologist = new Virologist(game, shelter);

        cape = new Cape(shelterVirologist);
        axe = new Axe(shelterVirologist);
        glove = new Glove(shelterVirologist);
        bag = new Bag(null);

        shelterVirologist.AddEquipment(cape);
        shelterVirologist.AddEquipment(axe);
        shelterVirologist.AddEquipment(bag);

        shelter.AddEquipment(glove);

    }


    @Test
    void PickUpAnEquipmentWhenFullTest() {
        int eqNumBefore = shelterVirologist.getEquipments().size();

        shelterVirologist.TakeEquipment(glove);

        assertEquals(eqNumBefore, shelterVirologist.getEquipments().size());
    }

    @Test
    void PickUpAnEquipmentWhenNotFullTest() {
        shelterVirologist.DropEquipment(glove);

        shelterVirologist.TakeEquipment(bag);

        assertEquals(true, shelterVirologist.getEquipments().contains(bag));
    }


    @Test
    void PutDownAnEquipmentTest() {
        int originalItemNum = shelterVirologist.getEquipments().size();

        shelterVirologist.DropEquipment(cape);

        assertEquals(originalItemNum-1, shelterVirologist.getEquipments().size());
    }
}
