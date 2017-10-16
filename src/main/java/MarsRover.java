public class MarsRover {
    Compass compass;
    int x;

    public MarsRover(int x, int y, Direction direction) {
        compass = new Compass(direction);
        this.x = x;
    }

    public String move(String commands) {
        for(char command: commands.toCharArray()){
            compass.turn(command);
            if (command == 'F') {
                this.x++;
            }
        }
        return x+":0:"+ compass.getCurrentDirection().getValue();
    }
}
