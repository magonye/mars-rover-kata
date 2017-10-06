public class MarsRover {
    Compass compass;

    public MarsRover(int x, int y, Direction direction) {
        compass = new Compass(direction);
    }

    public String move(String commands) {
        for(char command: commands.toCharArray()){
            compass.turn(command);
        }
        return "0:0:"+ compass.getCurrentDirection().getValue();
    }
}
