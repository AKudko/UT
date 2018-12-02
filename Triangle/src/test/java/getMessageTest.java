import org.testng.Assert;
import org.testng.annotations.Test;
import triangle.Triangle;

import java.util.ArrayList;

/**
 * Created by AK on 02.12.2018.
 */
public class getMessageTest {
    @Test(dataProvider = "ValidTriangle", dataProviderClass = checkTriangleTest.class)
    public void tst_getMessage(String expression, ArrayList<Double> parameters) {
        Triangle tr = new Triangle(parameters.get(0), parameters.get(1),parameters.get(2));
        Assert.assertEquals(tr.getMessage() , "", "error! mismatch result of work checkTriangle() and getter");
    }
}
