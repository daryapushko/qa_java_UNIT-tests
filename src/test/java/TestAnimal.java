import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class TestAnimal {
    private final String animalKind;
    private final List<String> expected;

    public TestAnimal(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAnimalData() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void testValidAnimal() throws Exception {
        Animal newAnimal = new Animal();
        List<String> actual = newAnimal.getFood(animalKind);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testInvalidAnimal() throws Exception {
        Animal newAnimal = new Animal();
        List<String> actual = newAnimal.getFood("Другое");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAnimalFamily() {
        Animal newAnimal = new Animal();
        String actual = newAnimal.getFamily();
        Assert.assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actual);
    }
}
