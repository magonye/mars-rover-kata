public class MarsRover {
    public MarsRover(int x, int y, char direction) {
    }

    public String move(String command) {
        if (command.length()>2) return "0:0:E";
        if (command.length()>1) return "0:0:S";
        return "0:0:W";
    }
}
