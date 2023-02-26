import com.example.IFeline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

@RunWith(Parameterized.class)
public class TestLion {
    private final String sex;
    private final boolean expected;

    public TestLion(String sex, boolean expected) {
        this.sex = sex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void testValidLionSex() throws Exception {
        Lion newLion = new Lion(sex);
        boolean actual = newLion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testInvalidLionSex() throws Exception {
        Lion newLion = new Lion("Другое");
        boolean actual = newLion.doesHaveMane();
        Assert.assertEquals(expected, actual);
    }


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    IFeline mockedLion;

    @Test
    public void testLionKittens() throws Exception {
        Lion newLion = new Lion(mockedLion);
        Mockito.when(mockedLion.getKittens()).thenReturn(1);
        Assert.assertEquals(1, newLion.getKittens());
    }

    @Test
    public void testFelineEatMeat() throws Exception {
        Lion newLion = new Lion(mockedLion);
        Mockito.when(mockedLion.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба")); //  стаб
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), newLion.getFood("Хищник"));
    }
}
