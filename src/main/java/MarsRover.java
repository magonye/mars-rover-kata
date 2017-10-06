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

    Direction direction;

    public MarsRover(int x, int y, Direction direction) {
        this.direction = direction;
    }

    public String move(String commands) {
        for(char command: commands.toCharArray()){
            if (command=='L') {
                direction = turn_left();
            }
            if (command=='R') {
                direction = turn_right();
            }
        }
        return "0:0:"+ direction.getValue();
    }

    private Direction turn_right() {
        if (direction == Direction.NORTH){
            return Direction.EAST;
        }
        if (direction == Direction.WEST){
            return Direction.NORTH;
        }
        if (direction == Direction.SOUTH){
            return Direction.WEST;
        }
        return Direction.SOUTH;
    }

    private Direction turn_left() {
        if (direction == Direction.NORTH){
            return Direction.WEST;
        }
        if (direction == Direction.WEST){
            return Direction.SOUTH;
        }
        if (direction == Direction.SOUTH){
            return Direction.EAST;
        }
        return Direction.NORTH;
    }


}
