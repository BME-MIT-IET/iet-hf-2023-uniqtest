package main.java.iet.Core;

import java.io.Serializable;

/**
 * Az idobeli lepest megvalosito interface.
 */
public interface Steppable extends Serializable {

    /**
     * Az idobeli lepest megvalosito fuggveny kerete.
     */
    public int Step();

}