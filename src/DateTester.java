import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by trevor.campbell on 3/31/16.
 */
public class DateTester {

    @Test
    public void testEqualsMethodIsTrue() {
        Date date = new Date(2, 29, 2016);
        Date date2 = new Date(2, 29, 2016);

        Assert.assertTrue(date.equals(date2), "The objects should be equal");
    }

    @Test
    public void testEqualsMethodIsFalse() {
        Date date = new Date(2, 29, 2016);
        Date date2 = new Date(2, 20, 2016);

        Assert.assertFalse(date.equals(date2), "The objects should not be equal");
    }

    @Test
    public void testSetDaysMethodWorks() {
        Date date = new Date();
        date.setDay(15);

        Assert.assertEquals(date.getDay(), 15, "The day should have been set to 15");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowIfDayIsInvalid() {
        Date date = new Date(1, 31, 2010);
        date.setDay(45);
    }


}

