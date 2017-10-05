public class MarsRover {

    char direction;

    public MarsRover(int x, int y, char direction) {
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
        return "0:0:"+ direction;
    }

    private char turn_right() {
        if (direction == 'N'){
            return 'E';
        }
        if (direction == 'W'){
            return 'N';
        }
        if (direction == 'S'){
            return 'W';
        }
        return 'S';
    }

    private char turn_left() {
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
