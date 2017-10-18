import java.util.ArrayList;
import java.util.List;

public class Navigation {
    int size;
    Compass compass;
    Position obstacle;
    boolean collision;
    Position position;

    List<Position> obstacles;

    public Navigation(int x, int y, int size, Direction direction) {
        this.position = new Position(x,y);
        this.size = size;
        compass = new Compass(direction);
        obstacles = new ArrayList<>();
    }

    public void move(char command){
        if (isTurningMovement(command)) {
            compass.turn(command);
        } else {
            int factor = 1;
            if (command == 'B') {
                factor = -1;
            }
            int newX = (this.size + (this.position.getX() + factor * compass.getCurrentDirection().getX())) % this.size;
            int newY = (this.size + (this.position.getY() + factor * compass.getCurrentDirection().getY())) % this.size;

            Position newPosition = new Position(newX, newY);
            if (obstacles.contains(newPosition)){
                collision = true;
            } else {
                this.position = new Position(newPosition.getX(),newPosition.getY());
            }
        }
    }

    public String printCurrentStatus(){
        return StatusPrinter.printCurrentStatus(position, collision, compass.getCurrentDirection());
    }

    private boolean isTurningMovement(char movement){
        return movement== 'L' || movement== 'R';
    }

    public void setObstacle(Position obstacle) {
        this.obstacle = obstacle;
    }

    public boolean isCollision() {
        return collision;
    }

    public void setObstacles(List<Position> obstacles) {
        this.obstacles = obstacles;
    }
}
