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
    public void testSetDaysMethodSetsTheDay() {
        Date date = new Date();
        date.setDay(15);

        Assert.assertEquals(date.getDay(), 15, "The day should have been set to 15");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowExceptionIfDayIsInvalid() {
        Date date = new Date(1, 31, 2010);
        date.setDay(45);
    }

    @Test
    public void testSetMonthSetsTheMonth() {
        Date date = new Date(1, 1, 2016);
        date.setMonth(12);

        Assert.assertEquals(date.getMonth(), 12, "The month should be set to 12");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowExceptionIfMonthIsInvalid() {
        Date date = new Date(1, 31, 2010);
        date.setMonth(15);
    }

    @Test
    public void testSetYearSetsTheYear() {
        Date date = new Date(1, 1, 2016);
        date.setYear(2019);

        Assert.assertEquals(date.getYear(), 2019, "The year should be set to 2019");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testThrowExceptionIfYearIsInvalid() {
        Date date = new Date(1, 31, 2010);
        date.setYear(-10);
    }

    @Test
    public void testCompareToIsLessThanAnother() {
        Date earlierDate = new Date(1, 1, 2016);
        Date laterDate = new Date(2, 1, 2016);

        Assert.assertTrue(earlierDate.compareTo(laterDate) == -1, "The value should be -1");
    }

    @Test
    public void testCompareToIsGreaterThanAnother() {
        Date earlierDate = new Date(2, 1, 2016);
        Date laterDate = new Date(1, 1, 2016);

        Assert.assertTrue(earlierDate.compareTo(laterDate) == 1, "The value should be 1");
    }

    @Test
    public void testCompareToIsEqualToAnother() {
        Date earlierDate = new Date(2, 1, 2016);
        Date laterDate = new Date(2, 1, 2016);

        Assert.assertTrue(earlierDate.compareTo(laterDate) == 0, "The value should be 0");
    }

    @Test
    public void testToStringFormatsProperly() {
        Date date = new Date(3, 1, 2015);
        String stringDate = date.toString();

        Assert.assertTrue(stringDate.equals("MAR-1-2015"), "the date should be in the format of \"MAR-1-2015\"");
    }

    @Test
    public void testGetDayNumberReturnsTheCorrectDateLeapYear() {
        Date date = new Date(5, 1, 2016);

        Assert.assertEquals(date.getDayNumber(), 122, "The day of the year should be 122");
    }

    @Test
    public void testGetDayNumberReturnsTheCorrectDate() {
        Date date = new Date(5, 1, 2015);

        Assert.assertEquals(date.getDayNumber(), 121, "The day of the year should be 121");
    }

    @Test
    public void testAddDaysLeapYearShortTerm() {
        Date date1 = new Date(2, 28, 2016);
        Date date2 = new Date(3, 1, 2016);
        date1.addDays(2);

        String stringDate1 = String.valueOf(date1);
        String stringDate2 = String.valueOf(date2);

        Assert.assertEquals(stringDate1, stringDate2, "The date should be set to MAR-1-2016" );
    }

    @Test
    public void testAddDaysNotLeapYearShortTerm() {
        Date date1 = new Date(3, 1, 2015);
        Date date2 = new Date(2, 28, 2015);
        date1.addDays(-1);

        String stringDate1 = String.valueOf(date1);
        String stringDate2 = String.valueOf(date2);

        Assert.assertEquals(stringDate1, stringDate2, "The date should be set to MAR-1-2015" );
    }

    @Test
    public void testAddDaysNotLeapYearLongTerm() {
        Date date1 = new Date(3, 1, 2015);
        Date date2 = new Date(3, 1, 2016);
        date1.addDays(365);

        String stringDate1 = String.valueOf(date1);
        String stringDate2 = String.valueOf(date2);

        Assert.assertEquals(stringDate1, stringDate2, "The date should be set to MAR-1-2016" );
    }

    @Test
    public void testAddDaysLeapYearLongTerm() {
        Date date1 = new Date(3, 1, 2016);
        Date date2 = new Date(3, 1, 2015);
        date1.addDays(-366);

        String stringDate1 = String.valueOf(date1);
        String stringDate2 = String.valueOf(date2);

        Assert.assertEquals(stringDate1, stringDate2, "The date should be set to MAR-1-2015" );
    }


}

