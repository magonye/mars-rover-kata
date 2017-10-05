public class MarsRover {
    char direction;
    public MarsRover(int x, int y, char direction) {
        this.direction = direction;
    }

    public String move(String commands) {
        for(char command: commands.toCharArray()){
            direction = turn();
        }
        return "0:0:"+ direction;
    }

    private char turn() {
        if (direction == 'N'){
            return 'W';
        }
        if (direction == 'W'){
            return 'S';
        }
        if (direction == 'S'){
            return 'E';
        }
        return 'N';
    }


}
