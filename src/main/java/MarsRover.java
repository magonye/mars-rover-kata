public class MarsRover {


    public enum Direction {
        NORTH("N"), EAST("E"), SOUTH("S"), WEST("W");

        private final String value;

        Direction(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public class Compass {
        private Direction[] space = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

        private int directionIndex = 0;

        public Direction turn(char side){
            if (side == 'R'){
                directionIndex = (directionIndex + 1)%4;
            }
            if (side == 'L'){
                directionIndex = directionIndex - 1;
                if (directionIndex<0) directionIndex = 3;
            }
            return space[directionIndex];
        }
    }

    Direction direction;
    Compass compass;

    public MarsRover(int x, int y, Direction direction) {
        this.direction = direction;
        compass = new Compass();
    }

    public String move(String commands) {
        for(char command: commands.toCharArray()){
            direction = compass.turn(command);
        }
        return "0:0:"+ direction.getValue();
    }
}
