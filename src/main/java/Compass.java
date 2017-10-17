public class Compass {
    private Direction[] space = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

    private int directionIndex = 0;

    public Compass(Direction initialDirection) {
        for (int i = 0; i < space.length; i++) {
            if (space[i]==initialDirection){
                directionIndex = i;
                break;
            }
        }
    }

    public void turn(char side){
        if (side == 'R'){
            directionIndex = (4+(directionIndex + 1))%4;
        }
        if (side == 'L') {
            directionIndex = directionIndex - 1;
            if (directionIndex < 0)
                directionIndex = 3;
        }
    }

    public Direction getCurrentDirection(){
        return space[directionIndex];
    }
}