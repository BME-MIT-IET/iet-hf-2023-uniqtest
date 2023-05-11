package test.java.iet;


import main.java.iet.Core.Game;
import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.*;
import main.java.iet.Fields.Field;
import main.java.iet.Fields.LaboratoryField;
import main.java.iet.Fields.ShelterField;
import main.java.iet.Fields.StorageField;
import main.java.iet.Gencodes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageFieldAndSubstanceTests {
        Virologist storageVirologist;
        Game game;
        Field storage;
        Equipment bag;

        @BeforeEach
        public void setUp() {
            game = new Game(1);
            storage = new StorageField();
            storageVirologist = new Virologist(game, storage);

            storage.setAmino(20);
            storage.setNucleotid(20);

            bag = new Bag(null);

            game.AddVirologist(storageVirologist);

        }

        @Test
        void setAminoTest() {
            storage.setAmino(13);

            assertEquals(13, storage.getAmino());
        }

        @Test
        void setNucleotidTest() {
            storage.setNucleotid(5);

            assertEquals(5, storage.getNucleotid());
        }

        @Test
        void PickUpAminoTest() {
            storageVirologist.TakeAmino();

            assertEquals(10, storage.getAmino());
            assertEquals(10, storageVirologist.getAmino());
        }

        @Test
        void PickUpNucleotidTest() {
            storageVirologist.TakeNucleotide();

            assertEquals(10, storage.getNucleotid());
            assertEquals(10, storageVirologist.getNucleotid());
        }
}
