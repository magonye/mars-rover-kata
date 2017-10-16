public class Gps {
    int x;
    int size;
    Compass compass;
    public Gps(int x, int y, int size, Direction direction) {
        this.x = x;
        this.size = size;
        compass = new Compass(direction);
    }

    public void move(char command){
        compass.turn(command);
        if (command == 'F') {
            this.x = (this.x +1)%this.size;
        }
        if (command == 'B') {
            this.x = (this.x -1);
            if (this.x<0){
                this.x = this.size-1;
            }
        }
    }

    public String getCurrentPosition(){
        return x+":0:"+ compass.getCurrentDirection().getValue();
    }
}
