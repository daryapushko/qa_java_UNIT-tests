import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestCat {
    @Mock
    Feline mockedFeline;

    @Test
    public void testCatSound() {
        Cat newCat = new Cat(mockedFeline);
        String actual = newCat.getSound();
        Assert.assertEquals("Мяу", actual);
    }

    @Test
    public void testCatFood() throws Exception {
        Cat newCat = new Cat(mockedFeline);
        Mockito.when(mockedFeline.eatMeat()).thenReturn(List.of("Животные", "Человек"));
        Assert.assertEquals(List.of("Животные", "Человек"), newCat.getFood());
    }
}
