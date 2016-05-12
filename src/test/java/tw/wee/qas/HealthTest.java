package tw.wee.qas;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HealthTest {
    @Test
    public void should_return_up_status() {
        assertThat(Health.checkHealth(), is("up"));
    }
}
