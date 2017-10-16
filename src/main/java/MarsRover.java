public class MarsRover {
    Gps gps;

    public MarsRover(int x, int y, Direction direction, int size) {
        gps = new Gps(x,y,size,direction);
    }

    public String move(String commands) {
        for(char command: commands.toCharArray()){
            gps.move(command);
        }
        return gps.getCurrentPosition();
    }

}
