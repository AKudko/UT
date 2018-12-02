import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import triangle.Triangle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by AK on 02.12.2018.
 */
public class checkTriangleTest {
    @DataProvider(name = "InvalidTriangle")
    public Object[][] createInvalidTriangleData() {
        // В этом примере: строка -- название теста,
        // а числа в массиве, длины сторон треугольника.
        return new Object[][]{
                {"a<=0", new ArrayList<Double>(Arrays.asList(0.0, 2.0, 3.0))},
                {"b<=0", new ArrayList<Double>(Arrays.asList(2.0, 0.0, 3.0))},
                {"c<=0", new ArrayList<Double>(Arrays.asList(3.0, 2.0, 0.0))},
                {"a+b<=c", new ArrayList<Double>(Arrays.asList(2.0, 2.0, 5.0))},
                {"a+c<=b", new ArrayList<Double>(Arrays.asList(2.0, 5.0, 2.0))},
                {"b+c<=a", new ArrayList<Double>(Arrays.asList(5.0, 2.0, 2.0))}
        };
    }
    @DataProvider(name = "ValidTriangle")
    public Object[][] createValidTriangleData() {
        // В этом примере: строка -- название теста,
        // а числа в массиве, длины сторон треугольника.
        return new Object[][]{
                {"triangle", new ArrayList<Double>(Arrays.asList(3.0, 4.0, 5.0))}
        };
    }

    @Test(dataProvider = "InvalidTriangle")
    public void negativeCheckTriangle(String expression, ArrayList<Double> parameters) {
        Triangle tr = new Triangle(parameters.get(0), parameters.get(1),parameters.get(2));
        Assert.assertEquals(tr.checkTriangle(), false, "error in condition of method: " + expression );
    }
    @Test(dataProvider = "ValidTriangle")
    public void positiveCheckTriangle(String expression, ArrayList<Double> parameters) {
        Triangle tr = new Triangle(parameters.get(0), parameters.get(1),parameters.get(2));
        Assert.assertEquals(tr.checkTriangle(), true, "error! returns false, when triangle valid");
    }
    @Test(dataProvider = "InvalidTriangle")
    public void massagesOfCheckTriangle(String expression, ArrayList<Double> parameters) {
        Triangle tr = new Triangle(parameters.get(0), parameters.get(1),parameters.get(2));
        tr.checkTriangle();
        Assert.assertEquals(tr.getMessage() , expression, "error in condition of method: " + expression );
    }

}
