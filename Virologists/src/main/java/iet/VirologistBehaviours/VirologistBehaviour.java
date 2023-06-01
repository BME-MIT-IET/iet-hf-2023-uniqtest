package main.java.iet.VirologistBehaviours;

import main.java.iet.Core.Virologist;
import main.java.iet.Equipments.Equipment;

import java.io.Serializable;

/**
 * A virologus viselkedesi formajat tartalmazo interfesz.
 */
public interface VirologistBehaviour extends Serializable {


    /**
     * Param1 Felszereles torlese param3-tol param2 hatasara.
     * @param e  A felszereles, amit torolni kell.
     * @param v1 Aki elveszi a felszerelest.
     * @param v2 Akitol torolni kell a felszerelest.
     */
    public void RemoveEquipment(Equipment e, Virologist v1, Virologist v2);

    /**
     * Eltavolit a mennyisegu aminot es n mennyisegu nukleotidot v-tol, amennyiben van neki annyi.
     * @param a Lopni kivant amino mennyiseg.
     * @param n Lopni kivant nucleotid mennyiseg.
     * @param v Virologus, akitol lopni kivan valaki.
     */
    public void RemoveSubstance(int a, int n, Virologist v);

    /**
     * Jelzi a parameterkent kapott virologus fele, hogy o kovetkezik.
     * @param v A virologus, akinek jelezni kell.
     */
    public void YourTurn(Virologist v);

}