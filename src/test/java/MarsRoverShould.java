import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverShould {

    private MarsRover marsRover;


    @Before
    public void before(){
        marsRover = new MarsRover(0,0, Direction.NORTH);
    }

    @Test
    @Parameters({
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "LLLLLLLLLLLL, 0:0:N",
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "RRRRRRRRRRRR, 0:0:N",
            "LRL, 0:0:W",
            "RLRLRLRLRLRL, 0:0:N",

    })
    public void turn(String commands, String finalPosition) {
        assertThat(marsRover.move(commands), is(finalPosition));
    }

}
