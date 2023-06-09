package main.java.iet.VirologistBehaviours;

import java.io.Serializable;

import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Equipment;

/**
 * A virologus benult viselkedesi formajat megvalosito osztaly.
 */
public class Paralyzed implements VirologistBehaviour, Serializable {

    /**
     * Default constructor
     */
    public Paralyzed() {
        /* */
    }

    /**
     * Param1 Felszereles torlese param3-tol param2 hatasara.
     * @param e A felszereles, amit torolni kell.
     * @param v1 Aki elveszi a felszerelest.
     * @param v2 Akitol torolni kell a felszerelest.
     */
    public void RemoveEquipment(Equipment e, Virologist v1, Virologist v2) {
    	v2.RemoveEquipment(e);
    	v1.AddEquipment(e);
    	
    }

    /**
     * Eltavolit a mennyisegu aminot es n mennyisegu nukleotidot v-tol, amennyiben van neki annyi.
     * @param a Lopni kivant amino mennyiseg.
     * @param n Lopni kivant nucleotid mennyiseg.
     * @param v Virologus, akitol lopni kivan valaki.
     */
    public void RemoveSubstance(int a, int n, Virologist v) {
       	v.setAmino(v.getAmino()-a);
        v.setNucleotid(v.getNucleotid()-n);
    }

    /**
     * Jelzi a parameterkent kapott virologus fele, hogy o kovetkezik.
     * Mivel a virologus bena, ezert egybol tovabb megy a kor.
     * @param v a virologus, akinek jelezni kell.
     */
    public void YourTurn(Virologist v) {
    	/* */
    }

}