import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MarsRoverShould {

    @Test
    @Parameters({
            "L, 0:0:W",
            "LL, 0:0:S"
    })
    public void turn_left(String commands, String finalPosition) {
        MarsRover marsRover = new MarsRover(0,0,'N');
        assertThat(marsRover.move(commands), is(finalPosition));
    }

}
