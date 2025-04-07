package megamek.common;

import megamek.common.event.GameBoardChangeEvent;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class GameMinefield {

    public final Hashtable<Coords, Vector<Minefield>> minefields = new Hashtable<>();

    /**
     * Get the coordinates of all mined hexes in the game.
     *
     * @return an <code>Enumeration</code> of the <code>Coords</code> containing minefields. This will not be
     *       <code>null</code>.
     */
    public Enumeration<Coords> getMinedCoords() {
        return minefields.keys();
    }

    public boolean containsMinefield(Coords coords) {
        return minefields.containsKey(coords);
    }

    public Vector<Minefield> getMinefields(Coords coords) {
        Vector<Minefield> mfs = minefields.get(coords);
        return (mfs == null) ? new Vector<>() : mfs;
    }

    public int getNbrMinefields(Coords coords) {
        Vector<Minefield> mfs = minefields.get(coords);
        return (mfs == null) ? 0 : mfs.size();
    }



    public void addMinefieldHelper(Minefield mf) {
        Vector<Minefield> mfs = minefields.get(mf.getCoords());
        if (mfs == null) {
            mfs = new Vector<>();
            mfs.addElement(mf);
            minefields.put(mf.getCoords(), mfs);
            return;
        }
        mfs.addElement(mf);
    }

    public void removeMinefieldHelper(Minefield mf) {
        Vector<Minefield> mfs = minefields.get(mf.getCoords());
        if (mfs == null) {
            return;
        }

        Enumeration<Minefield> e = mfs.elements();
        while (e.hasMoreElements()) {
            Minefield minefieldTemp = e.nextElement();
            if (minefieldTemp.equals(mf)) {
                mfs.removeElement(minefieldTemp);
                break;
            }
        }
        if (mfs.isEmpty()) {
            minefields.remove(mf.getCoords());
        }
    }
}
