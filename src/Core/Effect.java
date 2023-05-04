package Core;

/**
 * Az interfesz feladata osszegyujteni az aktivalhato es deaktivalhato dolgokat
 */
public interface Effect {
	
	
    
    /**
	 * getter
	 * @return effectId
	 */
	public String getId();
	
	public String getName();

	
    /**
     * Aktivalja a hatast.
     * @param v A virologus, akin aktivalja a hatast.
     */
    public void Activate(Virologist v);

    /**
     * Deaktivalja a hatast.
     * @param v A virologus, akin deaktivalja a hatast.
     */
    public void Deactivate(Virologist v);

}