package test.java.iet;

import main.java.iet.Core.*;
import main.java.iet.Equipments.*;
import main.java.iet.Gencodes.*;
import main.java.iet.Fields.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTest {
    Virologist virologist;
    Virologist storageVirologist;
    Virologist labVirologist;
    Virologist shelterVirologist;
    Game game;
    Field field;
    Field neighbourField;
    Field lab;
    Field storage;
    Field shelter;
    Gencode alzGencode;
    Gencode dancerGencode;
    Gencode resistGencode;
    Gencode paraGencode;
    Equipment cape = new Cape(null);
    Equipment axe = new Cape(null);
    Equipment bag = new Bag(null);
    Equipment glove = new Glove(null);

    @BeforeEach
    public void setUp() {
        game = new Game(1);
        field = new Field();
        neighbourField = new Field();
        lab = new LaboratoryField();
        storage = new StorageField();
        shelter = new ShelterField();

        virologist = new Virologist(game, field);
        storageVirologist = new Virologist(game, storage);
        labVirologist = new Virologist(game, lab);
        shelterVirologist = new Virologist(game, shelter);

        storage.setAmino(20);
        storage.setNucleotid(20);

        alzGencode = new AlzheimerGencode();
        dancerGencode = new DancerGencode();
        resistGencode = new ResistanceGencode();
        paraGencode = new ParalyzingGencode();

        lab.setGencode(alzGencode);

        cape = new Cape(shelterVirologist);
        axe = new Axe(shelterVirologist);
        glove = new Glove(shelterVirologist);
        bag = new Bag(null);

        shelterVirologist.AddEquipment(cape);
        shelterVirologist.AddEquipment(axe);
        shelterVirologist.AddEquipment(bag);

        shelter.AddEquipment(glove);

        field.addNeighbour(neighbourField);
        /*
        neighbourField.addNeighbour(lab);
        neighbourField.addNeighbour(storage);
        neighbourField.addNeighbour(shelter);
*/
        game.AddVirologist(virologist);
        game.AddVirologist(storageVirologist);
        game.AddVirologist(labVirologist);
        game.activeVirologist = virologist;

    }

    @Test
    void stepTest() {
        virologist.UseMove(0);
        
        assertEquals(neighbourField, virologist.getField());
    }

    @Test
    void setVirologistOnFieldTest() {
        Virologist newVirologist = new Virologist(game, neighbourField);

        assertEquals(1, neighbourField.getVirologists().size());
    }

    @Test
    void RemoveVirologistFromFieldTest() {
        field.RemoveVirologist(virologist);

        assertEquals(0, field.getVirologists().size());
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

    @Test
    void LearnGencodeTest() {
        labVirologist.TakeGencode(labVirologist.getField().getGencode());

        assertEquals(1, labVirologist.getGencodes().size());
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
