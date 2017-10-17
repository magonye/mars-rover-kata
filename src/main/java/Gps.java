public class Gps {
    int x;
    int y;
    int size;
    Compass compass;

    public Gps(int x, int y, int size, Direction direction) {
        this.x = x;
        this.y = y;
        this.size = size;
        compass = new Compass(direction);
    }

    public void move(char command){
        compass.turn(command);
        if (command == 'F') {
            if (compass.getCurrentDirection()==Direction.NORTH) {
                this.x = (this.x + 1) % this.size;
            } else if (compass.getCurrentDirection()==Direction.SOUTH) {
                this.x = (this.size + (this.x - 1)) % this.size;
            } else {
                this.y = (this.y + 1) % this.size;
            }
        }
        if (command == 'B') {
            this.x = (this.size + (this.x -1))% this.size;
        }
    }

    public String getCurrentPosition(){
        return x+":"+y+":"+ compass.getCurrentDirection().getValue();
    }
}
