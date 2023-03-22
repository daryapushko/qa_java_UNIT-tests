import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {
    @Test
    public void testFelineFood() throws Exception {
        Feline newFeline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = newFeline.eatMeat();
        assertEquals(expected, actual);
    }

    @Spy
    private Feline feline = new Feline();

    @Test
    public void testFelineKittensCount() {
        int actual = feline.getKittens(10);
        assertEquals(10, actual);
    }

    @Test
    public void testFelineKittens() {
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }

    @Test
    public void getFelineKittensInvokeGetKittensCountTimes() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testFelineFamily() {
        Feline newFeline = new Feline();
        assertEquals("Кошачьи", newFeline.getFamily());
    }
}
