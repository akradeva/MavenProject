import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTests {
    @DataProvider(name = "data-provider-numSum")
    public Object[][] dpMethodSum() {
        Object[][] objects = {
                {3, 7, 10},
                {5, 1, 6}
        };
        return objects;
    }
    @DataProvider(name = "data-provider-numSub")
    public Object[][] dpMethodSub() {
        Object[][] objects = {
                {13, 11, 2},
                {9, 4, 5}
        };
        return objects;
    }
    @DataProvider(name = "data-provider-numMulti")
    public Object[][] dpMethodMulti() {
        Object[][] objects = {
                {4, 5, 20},
                {18, 1, 18}
        };
        return objects;
    }
    @DataProvider(name = "data-provider-numDiv")
    public Object[][] dpMethodDiv() {
        Object[][] objects = {
                {30, 10, 3},
                {18, 3, 6}
        };
        return objects;
    }
    @DataProvider(name = "data-provider-numModul")
    public Object[][] dpMethodModul() {
        Object[][] objects = {
                {34, 10, 4},
                {18, 2, 0}
        };
        return objects;
    }

    @Test(dataProvider = "data-provider-numSum", groups = "sumGroup")
    public void sumTest(int a, int b, int result) {
        int sum = a + b;
        Assert.assertEquals(result, sum);
        Assert.assertNotEquals(13, sum);
    }

    @Test(dataProvider = "data-provider-numSub", dependsOnGroups = "sumGroup")
    public void subTest(int a, int b, int result) {
        int sub = a - b;
        Assert.assertEquals(result, sub);
        Assert.assertNotEquals(23, sub);
    }

    @Test(dataProvider = "data-provider-numMulti")
    public void multiTest(int a, int b, int result) {
        int multi = a * b;
        Assert.assertEquals(result, multi);
        Assert.assertNotEquals(33, multi);
    }

    @Test(dataProvider = "data-provider-numDiv")
    public void divTest(int a, int b, int result) {
        int div = a / b;
        Assert.assertEquals(result, div);
        Assert.assertNotEquals(5, div);
    }

    @Test(dataProvider = "data-provider-numModul")
    public void modulTest(int a, int b, int result) {
        int modul = a % b;
        Assert.assertEquals(result, modul);
        Assert.assertNotEquals(10, modul);
    }
}
