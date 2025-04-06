package megamek.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class PlayerMinefieldManager {
    private Vector<Minefield> visibleMinefields = new Vector<>();

    // number of minefields
    private int numMfConv = 0;
    private int numMfCmd = 0;
    private int numMfVibra = 0;
    private int numMfActive = 0;
    private int numMfInferno = 0;

    private List<ICarryable> groundObjectsToPlace = new ArrayList<>();

    public Vector<Minefield> getMinefields() {
        return visibleMinefields;
    }

    public void addMinefield(Minefield mf) {
        visibleMinefields.addElement(mf);
    }

    public void addMinefields(Vector<Minefield> minefields) {
        for (int i = 0; i < minefields.size(); i++) {
            visibleMinefields.addElement(minefields.elementAt(i));
        }
    }

    public void removeMinefield(Minefield mf) {
        visibleMinefields.removeElement(mf);
    }

    public void removeMinefields() {
        visibleMinefields.removeAllElements();
    }

    public boolean containsMinefield(Minefield mf) {
        return visibleMinefields.contains(mf);
    }

    public boolean hasMinefields() {
        return (numMfCmd > 0) ||
                     (numMfConv > 0) ||
                     (numMfVibra > 0) ||
                     (numMfActive > 0) ||
                     (numMfInferno > 0) ||
                     getGroundObjectsToPlace().size() > 0;
    }

    /**
     * Collection of carryable objects that this player will be placing during the game.
     */
    public List<ICarryable> getGroundObjectsToPlace() {
        return groundObjectsToPlace;
    }

    public PlayerMinefieldManager copy(){
        PlayerMinefieldManager copy = new PlayerMinefieldManager();

        copy.setNbrMFConventional(this.numMfConv);
        copy.setNbrMFInferno(this.numMfInferno);
        copy.setNbrMFActive(this.numMfActive);
        copy.setNbrMFCommand(this.numMfCmd);
        copy.setNbrMFVibra(this.numMfVibra);

        copy.visibleMinefields = new Vector<>(visibleMinefields);

        return copy;
    }

    public void setNbrMFConventional(int nbrMF) {
        numMfConv = nbrMF;
    }

    public void setNbrMFCommand(int nbrMF) {
        numMfCmd = nbrMF;
    }

    public void setNbrMFVibra(int nbrMF) {
        numMfVibra = nbrMF;
    }

    public void setNbrMFActive(int nbrMF) {
        numMfActive = nbrMF;
    }

    public void setNbrMFInferno(int nbrMF) {
        numMfInferno = nbrMF;
    }

    public int getNbrMFConventional() {
        return numMfConv;
    }

    public int getNbrMFCommand() {
        return numMfCmd;
    }

    public int getNbrMFVibra() {
        return numMfVibra;
    }

    public int getNbrMFActive() {
        return numMfActive;
    }

    public int getNbrMFInferno() {
        return numMfInferno;
    }
}
