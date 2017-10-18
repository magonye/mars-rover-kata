import java.util.List;

public class Navigation {
    int size;
    Compass compass;
    Position position;
    CollisionDetection collisionDetection;

    public Navigation(int x, int y, int size, Direction direction) {
        this.position = new Position(x,y);
        this.size = size;
        compass = new Compass(direction);
        collisionDetection = new CollisionDetection();
    }

    public void move(char command){
        if (isTurningMovement(command)) {
            compass.turn(command);
        } else {
            int factor = 1;
            if (command == 'B') {
                factor = -1;
            }
            int newX = calculateNewPositionValue(this.position.getX(),compass.getCurrentDirection().getX(),factor);
            int newY = calculateNewPositionValue(this.position.getY(),compass.getCurrentDirection().getY(),factor);

            Position newPosition = new Position(newX, newY);
            collisionDetection.checkCollision(newPosition);

            if (!collisionDetection.isCollision()){
                this.position = new Position(newPosition.getX(),newPosition.getY());
            }
        }
    }

    private int calculateNewPositionValue(int position, int acumulation, int factor){
        return (this.size + (position + factor * acumulation)) % this.size;
    }

    public String printCurrentStatus(){
        return StatusPrinter.printCurrentStatus(position, collisionDetection.isCollision(), compass.getCurrentDirection());
    }

    private boolean isTurningMovement(char movement){
        return movement== 'L' || movement== 'R';
    }

    public boolean isCollision() {
        return collisionDetection.isCollision();
    }

    public void setObstacles(List<Position> obstacles) {
        collisionDetection.setObstacles(obstacles);
    }
}
