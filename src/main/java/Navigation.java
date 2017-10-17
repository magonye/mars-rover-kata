public class Navigation {
    int size;
    Compass compass;
    Position obstacle;
    boolean collision;
    Position position;

    public Navigation(int x, int y, int size, Direction direction) {
        this.position = new Position(x,y);
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
            int newX = (this.size + (this.position.getX() + factor * compass.getCurrentDirection().getX())) % this.size;
            int newY = (this.size + (this.position.getY() + factor * compass.getCurrentDirection().getY())) % this.size;

            Position newPosition = new Position(newX, newY);
            if (newPosition.equals(obstacle)){
                collision = true;
            } else {
                this.position = new Position(newPosition.getX(),newPosition.getY());
            }
        }
    }

    public String getCurrentPosition(){
        return String.format("%s%s:%s:%s",this.collision?"O:":"",position.getX(), position.getY() , compass.getCurrentDirection().getValue());
    }

    private boolean isTurning(char movement){
        return movement== 'L' || movement== 'R';
    }

    public void setObstacle(Position obstacle) {
        this.obstacle = obstacle;
    }

    public boolean isCollision() {
        return collision;
    }
}
