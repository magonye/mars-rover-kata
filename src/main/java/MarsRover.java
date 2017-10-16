public class MarsRover {
    Compass compass;
    int x;
    int size;

    public MarsRover(int x, int y, Direction direction, int size) {
        compass = new Compass(direction);
        this.x = x;
        this.size = size;
    }

    public String move(String commands) {
        for(char command: commands.toCharArray()){
            compass.turn(command);
            if (command == 'F') {
                this.x = (this.x +1)%this.size;
            }
        }
        return x+":0:"+ compass.getCurrentDirection().getValue();
    }
}
