public class Navigation {
    int x;
    int y;
    int size;
    Compass compass;

    public Navigation(int x, int y, int size, Direction direction) {
        this.x = x;
        this.y = y;
        this.size = size;
        compass = new Compass(direction);
    }

    public void move(char command){
        if (isTurning(command)) compass.turn(command);
        if (!isTurning(command)) {
            int factor = 1;
            if (command == 'B') {
                factor = -1;
            }
            this.x = (this.size + (this.x + factor * compass.getCurrentDirection().getX())) % this.size;
            this.y = (this.size + (this.y + factor * compass.getCurrentDirection().getY())) % this.size;

        }
    }

    public String getCurrentPosition(){
        return String.format("%s:%s:%s",x, y , compass.getCurrentDirection().getValue());
    }

    private boolean isTurning(char movement){
        return movement== 'L' || movement== 'R';
    }

}
