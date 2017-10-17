public class MarsRover {
    Navigation navigation;

    public MarsRover(int x, int y, Direction direction, int size) {
        navigation = new Navigation(x,y,size,direction);
    }

    public String move(String commands) {
        for(char command: commands.toCharArray()){
            navigation.move(command);
        }
        return navigation.getCurrentPosition();
    }

}
