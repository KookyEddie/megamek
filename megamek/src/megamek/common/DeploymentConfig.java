package megamek.common;

public class DeploymentConfig {

    private int startingPos = Board.START_ANY;
    private int startOffset = 0;
    private int startWidth = 3;
    private int startingAnyNWx = Entity.STARTING_ANY_NONE;
    private int startingAnyNWy = Entity.STARTING_ANY_NONE;
    private int startingAnySEx = Entity.STARTING_ANY_NONE;
    private int startingAnySEy = Entity.STARTING_ANY_NONE;

    public DeploymentConfig(int startingPos, int startOffset, int startWidth, int startingAnyNWx, int startingAnyNWy,
          int startingAnySEx, int startingAnySEy) {
        this.startingPos = startingPos;
        this.startOffset = startOffset;
        this.startWidth = startWidth;
        this.startingAnyNWx = startingAnyNWx;
        this.startingAnyNWy = startingAnyNWy;
        this.startingAnySEx = startingAnySEx;
        this.startingAnySEy = startingAnySEy;
    }

    public DeploymentConfig copy() {
        return new DeploymentConfig(this.startingPos, this.startOffset, this.startWidth,
              this.startingAnyNWx, this.startingAnyNWy, this.startingAnySEx, this.startingAnySEy);
    }

    public int getStartingPos() {
        return startingPos;
    }

    public void setStartingPos(int startingPos) {
        this.startingPos = startingPos;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public void setStartOffset(int startOffset) {
        this.startOffset = startOffset;
    }

    public int getStartWidth() {
        return startWidth;
    }

    public void setStartWidth(int startWidth) {
        this.startWidth = startWidth;
    }

    public int getStartingAnyNWx() {
        return startingAnyNWx;
    }

    public void setStartingAnyNWx(int startingAnyNWx) {
        this.startingAnyNWx = startingAnyNWx;
    }

    public int getStartingAnyNWy() {
        return startingAnyNWy;
    }

    public void setStartingAnyNWy(int startingAnyNWy) {
        this.startingAnyNWy = startingAnyNWy;
    }

    public int getStartingAnySEx() {
        return startingAnySEx;
    }

    public void setStartingAnySEx(int startingAnySEx) {
        this.startingAnySEx = startingAnySEx;
    }

    public int getStartingAnySEy() {
        return startingAnySEy;
    }

    public void setStartingAnySEy(int startingAnySEy) {
        this.startingAnySEy = startingAnySEy;
    }
}
