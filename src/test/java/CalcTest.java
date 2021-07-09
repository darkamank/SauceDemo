import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalcTest {

    private Calculator calc1 = new Calculator();

    @Test(groups = "sum")
    public void testSum() throws Exception{
        Assert.assertEquals(5,calc1.sum(2,3));
    }
    @Test(groups = "minus")
    public void testMinus()throws Exception{
        Assert.assertEquals(10,calc1.minus(25,15));
    }
    @Test(groups = "multi")
    public void testMulti() throws Exception{
        Assert.assertEquals(30,calc1.sum(5,6));
    }
    @Test(groups = "div")
    public void testDiv() throws Exception{
        Assert.assertEquals(10,calc1.div(90,9));
    }
    @Test(groups = "multi")
    public void testMulti1() throws Exception{
        Assert.assertEquals(30,calc1.sum(5,6));
    }
    @Test(groups = "sum")
    public void testSum1() throws Exception{
        Assert.assertEquals(5,calc1.sum(2,3));
    }
}
