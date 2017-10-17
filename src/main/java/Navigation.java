public class Navigation {
    int x;
    int y;
    int size;
    Compass compass;

    public Navigation(int x, int y, int size, Direction direction) {
        this.x = x;
        this.y = y;
        this.size = size;
        compass = new Compass(direction);
    }

    public void move(char command){
        compass.turn(command);
        if (command == 'F') {
            this.x = (this.size + (this.x + compass.getCurrentDirection().getX())) % this.size;
            this.y = (this.size + (this.y + compass.getCurrentDirection().getY())) % this.size;
        }
        if (command == 'B') {
            this.x = (this.size + (this.x - compass.getCurrentDirection().getX())) % this.size;
            this.y = (this.size + (this.y - compass.getCurrentDirection().getY())) % this.size;
        }
    }

    public String getCurrentPosition(){
        return String.format("%s:%s:%s",x, y , compass.getCurrentDirection().getValue());
    }

}
