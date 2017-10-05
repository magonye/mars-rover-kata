import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MarsRoverShould {

    @Test
    public void turn_left() {
        MarsRover marsRover = new MarsRover(0,0,'N');
        assertThat(marsRover.move("L"), is("0:0:W"));
    }

    @Test
    public void turn_left_twice() {
        MarsRover marsRover = new MarsRover(0,0,'N');
        assertThat(marsRover.move("LL"), is("0:0:S"));
    }
}
