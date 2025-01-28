import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {

    @Test
    void testIsLeapYear() {
        assertTrue(Date.isLeapYear(2000)); // Divisible by 400
        assertFalse(Date.isLeapYear(1900)); // Divisible by 100 but not 400
        assertTrue(Date.isLeapYear(2004)); // Divisible by 4 but not 100
        assertFalse(Date.isLeapYear(2001)); // Not divisible by 4
        assertTrue(Date.isLeapYear(2400)); // Divisible by 400
        assertFalse(Date.isLeapYear(2300)); // Divisible by 100 but not 400
        assertTrue(Date.isLeapYear(2028)); // Divisible by 4 but not 100
        assertFalse(Date.isLeapYear(2001)); // Not divisible by 4
    }

    @Test
    void testGetNameOfDay() {
        assertEquals("Sunday", Date.getNameOfDay(0));
        assertEquals("Monday", Date.getNameOfDay(1));
        assertEquals("Tuesday", Date.getNameOfDay(2));
        assertEquals("Wednesday", Date.getNameOfDay(3));
        assertEquals("Thursday", Date.getNameOfDay(4));
        assertEquals("Friday", Date.getNameOfDay(5));
        assertEquals("Saturday", Date.getNameOfDay(6));
    }

    @Test
    void testGetMonthNumber() {
        assertEquals(1, Date.getMonthNumber("January"));
        assertEquals(2, Date.getMonthNumber("February"));
        assertEquals(3, Date.getMonthNumber("March"));
        assertEquals(4, Date.getMonthNumber("April"));
        assertEquals(5, Date.getMonthNumber("May"));
        assertEquals(6, Date.getMonthNumber("June"));
        assertEquals(7, Date.getMonthNumber("July"));
        assertEquals(8, Date.getMonthNumber("August"));
        assertEquals(9, Date.getMonthNumber("September"));
        assertEquals(10, Date.getMonthNumber("October"));
        assertEquals(11, Date.getMonthNumber("November"));
        assertEquals(12, Date.getMonthNumber("December"));
        assertEquals(-1, Date.getMonthNumber("InvalidMonth"));
    }

    @Test
    void testGetMonthName() {
        assertEquals("January", Date.getMonthName(1));
        assertEquals("February", Date.getMonthName(2));
        assertEquals("March", Date.getMonthName(3));
        assertEquals("April", Date.getMonthName(4));
        assertEquals("May", Date.getMonthName(5));
        assertEquals("June", Date.getMonthName(6));
        assertEquals("July", Date.getMonthName(7));
        assertEquals("August", Date.getMonthName(8));
        assertEquals("September", Date.getMonthName(9));
        assertEquals("October", Date.getMonthName(10));
        assertEquals("November", Date.getMonthName(11));
        assertEquals("December", Date.getMonthName(12));
        assertEquals(-1, Date.getMonthNumber("InvalidMonth"));
    }

    @Test
    void testGetDaysInMonthWithNumbers() {
        assertEquals(31, Date.getDaysInMonth(1, 2023)); // January
        assertEquals(28, Date.getDaysInMonth(2, 2023)); // Non-leap February
        assertEquals(29, Date.getDaysInMonth(2, 2024)); // Leap February
        assertEquals(30, Date.getDaysInMonth(4, 2023)); // April
        assertEquals(30, Date.getDaysInMonth(4, 2024)); // May
        assertEquals(30, Date.getDaysInMonth(6, 2023)); // June
        assertEquals(31, Date.getDaysInMonth(7, 2023)); // July
        assertEquals(31, Date.getDaysInMonth(8, 2023)); // August
    }

    @Test
    void testGetDaysInMonthWithNames() {
        assertEquals(31, Date.getDaysInMonth("January", 2023));
        assertEquals(28, Date.getDaysInMonth("February", 2023)); // Non-leap year
        assertEquals(29, Date.getDaysInMonth("February", 2024)); // Leap year
        assertEquals(30, Date.getDaysInMonth("April", 2023));
        assertEquals(31, Date.getDaysInMonth("May", 2023)); // May
        assertEquals(30, Date.getDaysInMonth("June", 2023)); // June
        assertEquals(31, Date.getDaysInMonth("July", 2023)); // July
        assertEquals(31, Date.getDaysInMonth("August", 2023)); // August
    }

    @Test
    void testDayOfWeekWithNumbers() {
        assertEquals(0, Date.dayOfWeek(7, 23, 2023)); // Sunday
        assertEquals(1, Date.dayOfWeek(7, 24, 2023)); // Monday
        assertEquals(2, Date.dayOfWeek(4, 23, 2024)); // Sunday
        assertEquals(6, Date.dayOfWeek(11, 30, 2024)); // Monday
        assertEquals(4, Date.dayOfWeek(3, 5, 2026)); // Sunday
        assertEquals(4, Date.dayOfWeek(5, 22, 2025)); // Monday
        assertEquals(-1, Date.dayOfWeek(13, 1, 2023)); // Invalid month
        assertEquals(-1, Date.dayOfWeek(2, 30, 2023)); // Invalid day in February
    }

    @Test
    void testDayOfWeekWithNames() {
        assertEquals(0, Date.dayOfWeek("July", 23, 2023)); // Sunday
        assertEquals(1, Date.dayOfWeek("July", 24, 2023)); // Monday
        assertEquals(2, Date.dayOfWeek("April", 23, 2024)); // Sunday
        assertEquals(6, Date.dayOfWeek("November", 30, 2024)); // Monday
        assertEquals(4, Date.dayOfWeek("March", 5, 2026)); // Sunday
        assertEquals(4, Date.dayOfWeek("May", 22, 2025)); // Monday
        assertEquals(-1, Date.dayOfWeek("Sepetembereee", 1, 2023)); // Invalid month
    }

    @Test
    void testGetMonthOffset() {
        assertEquals(3, Date.getMonthOffset(2, 2023)); // February
        assertEquals(6, Date.getMonthOffset(4, 2023)); // April
        assertEquals(1, Date.getMonthOffset(5, 2023)); // May
        assertEquals(-1, Date.getMonthOffset(13, 2023)); // Invalid month
    }

    @Test
    void testDayOfWeek_1(){
         int[] expected = {
                 6, 	// January 01, 2000
                 2, 	// February 01, 2000
                 2, 	// February 15, 2000
                 1, 	// February 28, 2000
                 3, 	// March 15, 2000
                 4, 	// April 20, 2000
                 5, 	// May 12, 2000
                 1, 	// June 05, 2000
                 1, 	// January 01, 2001
                 4, 	// February 01, 2001
                 4, 	// February 15, 2001
                 3, 	// February 28, 2001
                 4, 	// March 15, 2001
                 5, 	// April 20, 2001
                 6, 	// May 12, 2001
                 2, 	// June 05, 2001
                 2, 	// January 01, 2002
                 5, 	// February 01, 2002
                 5, 	// February 15, 2002
                 4, 	// February 28, 2002
                 5, 	// March 15, 2002
                 6, 	// April 20, 2002
                 0, 	// May 12, 2002
                 3, 	// June 05, 2002
                 3, 	// January 01, 2003
                 6, 	// February 01, 2003
                 6, 	// February 15, 2003
                 5, 	// February 28, 2003
                 6, 	// March 15, 2003
                 0, 	// April 20, 2003
                 1, 	// May 12, 2003
                 4, 	// June 05, 2003
                 4, 	// January 01, 2004
                 0, 	// February 01, 2004
                 0, 	// February 15, 2004
                 6, 	// February 28, 2004
                 1, 	// March 15, 2004
                 2, 	// April 20, 2004
                 3, 	// May 12, 2004
                 6, 	// June 05, 2004
                 6, 	// January 01, 2005
                 2, 	// February 01, 2005
                 2, 	// February 15, 2005
                 1, 	// February 28, 2005
                 2, 	// March 15, 2005
                 3, 	// April 20, 2005
                 4, 	// May 12, 2005
                 0, 	// June 05, 2005
                 0, 	// January 01, 2006
                 3, 	// February 01, 2006
                 3, 	// February 15, 2006
                 2, 	// February 28, 2006
                 3, 	// March 15, 2006
                 4, 	// April 20, 2006
                 5, 	// May 12, 2006
                 1, 	// June 05, 2006
                 1, 	// January 01, 2007
                 4, 	// February 01, 2007
                 4, 	// February 15, 2007
                 3, 	// February 28, 2007
                 4, 	// March 15, 2007
                 5, 	// April 20, 2007
                 6, 	// May 12, 2007
                 2, 	// June 05, 2007
                 2, 	// January 01, 2008
                 5, 	// February 01, 2008
                 5, 	// February 15, 2008
                 4, 	// February 28, 2008
                 6, 	// March 15, 2008
                 0, 	// April 20, 2008
                 1, 	// May 12, 2008
                 4, 	// June 05, 2008
                 4, 	// January 01, 2009
                 0, 	// February 01, 2009
                 0, 	// February 15, 2009
                 6, 	// February 28, 2009
                 0, 	// March 15, 2009
                 1, 	// April 20, 2009
                 2, 	// May 12, 2009
                 5, 	// June 05, 2009
                 5, 	// January 01, 2010
                 1, 	// February 01, 2010
                 1, 	// February 15, 2010
                 0, 	// February 28, 2010
                 1, 	// March 15, 2010
                 2, 	// April 20, 2010
                 3, 	// May 12, 2010
                 6, 	// June 05, 2010
                 6, 	// January 01, 2011
                 2, 	// February 01, 2011
                 2, 	// February 15, 2011
                 1, 	// February 28, 2011
                 2, 	// March 15, 2011
                 3, 	// April 20, 2011
                 4, 	// May 12, 2011
                 0, 	// June 05, 2011
                 0, 	// January 01, 2012
                 3, 	// February 01, 2012
                 3, 	// February 15, 2012
                 2, 	// February 28, 2012
                 4, 	// March 15, 2012
                 5, 	// April 20, 2012
                 6, 	// May 12, 2012
                 2, 	// June 05, 2012
                 2, 	// January 01, 2013
                 5, 	// February 01, 2013
                 5, 	// February 15, 2013
                 4, 	// February 28, 2013
                 5, 	// March 15, 2013
                 6, 	// April 20, 2013
                 0, 	// May 12, 2013
                 3, 	// June 05, 2013
                 3, 	// January 01, 2014
                 6, 	// February 01, 2014
                 6, 	// February 15, 2014
                 5, 	// February 28, 2014
                 6, 	// March 15, 2014
                 0, 	// April 20, 2014
                 1, 	// May 12, 2014
                 4, 	// June 05, 2014
                 4, 	// January 01, 2015
                 0, 	// February 01, 2015
                 0, 	// February 15, 2015
                 6, 	// February 28, 2015
                 0, 	// March 15, 2015
                 1, 	// April 20, 2015
                 2, 	// May 12, 2015
                 5, 	// June 05, 2015
                 5, 	// January 01, 2016
                 1, 	// February 01, 2016
                 1, 	// February 15, 2016
                 0, 	// February 28, 2016
                 2, 	// March 15, 2016
                 3, 	// April 20, 2016
                 4, 	// May 12, 2016
                 0, 	// June 05, 2016
                 0, 	// January 01, 2017
                 3, 	// February 01, 2017
                 3, 	// February 15, 2017
                 2, 	// February 28, 2017
                 3, 	// March 15, 2017
                 4, 	// April 20, 2017
                 5, 	// May 12, 2017
                 1, 	// June 05, 2017
                 1, 	// January 01, 2018
                 4, 	// February 01, 2018
                 4, 	// February 15, 2018
                 3, 	// February 28, 2018
                 4, 	// March 15, 2018
                 5, 	// April 20, 2018
                 6, 	// May 12, 2018
                 2, 	// June 05, 2018
                 2, 	// January 01, 2019
                 5, 	// February 01, 2019
                 5, 	// February 15, 2019
                 4, 	// February 28, 2019
                 5, 	// March 15, 2019
                 6, 	// April 20, 2019
                 0, 	// May 12, 2019
                 3, 	// June 05, 2019
                 3, 	// January 01, 2020
                 6, 	// February 01, 2020
                 6, 	// February 15, 2020
                 5, 	// February 28, 2020
                 0, 	// March 15, 2020
                 1, 	// April 20, 2020
                 2, 	// May 12, 2020
                 5, 	// June 05, 2020
                 5, 	// January 01, 2021
                 1, 	// February 01, 2021
                 1, 	// February 15, 2021
                 0, 	// February 28, 2021
                 1, 	// March 15, 2021
                 2, 	// April 20, 2021
                 3, 	// May 12, 2021
                 6, 	// June 05, 2021
                 6, 	// January 01, 2022
                 2, 	// February 01, 2022
                 2, 	// February 15, 2022
                 1, 	// February 28, 2022
                 2, 	// March 15, 2022
                 3, 	// April 20, 2022
                 4, 	// May 12, 2022
                 0, 	// June 05, 2022
                 0, 	// January 01, 2023
                 3, 	// February 01, 2023
                 3, 	// February 15, 2023
                 2, 	// February 28, 2023
                 3, 	// March 15, 2023
                 4, 	// April 20, 2023
                 5, 	// May 12, 2023
                 1, 	// June 05, 2023
                 1, 	// January 01, 2024
                 4, 	// February 01, 2024
                 4, 	// February 15, 2024
                 3, 	// February 28, 2024
                 5, 	// March 15, 2024
                 6, 	// April 20, 2024
                 0, 	// May 12, 2024
                 3, 	// June 05, 2024
                 3, 	// January 01, 2025
                 6, 	// February 01, 2025
                 6, 	// February 15, 2025
                 5, 	// February 28, 2025
                 6, 	// March 15, 2025
                 0, 	// April 20, 2025
                 1, 	// May 12, 2025
                 4, 	// June 05, 2025
                 4, 	// January 01, 2026
                 0, 	// February 01, 2026
                 0, 	// February 15, 2026
                 6, 	// February 28, 2026
                 0, 	// March 15, 2026
                 1, 	// April 20, 2026
                 2, 	// May 12, 2026
                 5, 	// June 05, 2026
                 5, 	// January 01, 2027
                 1, 	// February 01, 2027
                 1, 	// February 15, 2027
                 0, 	// February 28, 2027
                 1, 	// March 15, 2027
                 2, 	// April 20, 2027
                 3, 	// May 12, 2027
                 6, 	// June 05, 2027
                 6, 	// January 01, 2028
                 2, 	// February 01, 2028
                 2, 	// February 15, 2028
                 1, 	// February 28, 2028
                 3, 	// March 15, 2028
                 4, 	// April 20, 2028
                 5, 	// May 12, 2028
                 1, 	// June 05, 2028
                 1, 	// January 01, 2029
                 4, 	// February 01, 2029
                 4, 	// February 15, 2029
                 3, 	// February 28, 2029
                 4, 	// March 15, 2029
                 5, 	// April 20, 2029
                 6, 	// May 12, 2029
                 2, 	// June 05, 2029
                 2, 	// January 01, 2030
                 5, 	// February 01, 2030
                 5, 	// February 15, 2030
                 4, 	// February 28, 2030
                 5, 	// March 15, 2030
                 6, 	// April 20, 2030
                 0, 	// May 12, 2030
                 3, 	// June 05, 2030
                 3, 	// January 01, 2031
                 6, 	// February 01, 2031
                 6, 	// February 15, 2031
                 5, 	// February 28, 2031
                 6, 	// March 15, 2031
                 0, 	// April 20, 2031
                 1, 	// May 12, 2031
                 4, 	// June 05, 2031
                 4, 	// January 01, 2032
                 0, 	// February 01, 2032
                 0, 	// February 15, 2032
                 6, 	// February 28, 2032
                 1, 	// March 15, 2032
                 2, 	// April 20, 2032
                 3, 	// May 12, 2032
                 6, 	// June 05, 2032
                 6, 	// January 01, 2033
                 2, 	// February 01, 2033
                 2, 	// February 15, 2033
                 1, 	// February 28, 2033
                 2, 	// March 15, 2033
                 3, 	// April 20, 2033
                 4, 	// May 12, 2033
                 0, 	// June 05, 2033
                 0, 	// January 01, 2034
                 3, 	// February 01, 2034
                 3, 	// February 15, 2034
                 2, 	// February 28, 2034
                 3, 	// March 15, 2034
                 4, 	// April 20, 2034
                 5, 	// May 12, 2034
                 1, 	// June 05, 2034
                 1, 	// January 01, 2035
                 4, 	// February 01, 2035
                 4, 	// February 15, 2035
                 3, 	// February 28, 2035
                 4, 	// March 15, 2035
                 5, 	// April 20, 2035
                 6, 	// May 12, 2035
                 2, 	// June 05, 2035
                 2, 	// January 01, 2036
                 5, 	// February 01, 2036
                 5, 	// February 15, 2036
                 4, 	// February 28, 2036
                 6, 	// March 15, 2036
                 0, 	// April 20, 2036
                 1, 	// May 12, 2036
                 4, 	// June 05, 2036
                 4, 	// January 01, 2037
                 0, 	// February 01, 2037
                 0, 	// February 15, 2037
                 6, 	// February 28, 2037
                 0, 	// March 15, 2037
                 1, 	// April 20, 2037
                 2, 	// May 12, 2037
                 5, 	// June 05, 2037
                 5, 	// January 01, 2038
                 1, 	// February 01, 2038
                 1, 	// February 15, 2038
                 0, 	// February 28, 2038
                 1, 	// March 15, 2038
                 2, 	// April 20, 2038
                 3, 	// May 12, 2038
                 6, 	// June 05, 2038
                 6, 	// January 01, 2039
                 2, 	// February 01, 2039
                 2, 	// February 15, 2039
                 1, 	// February 28, 2039
                 2, 	// March 15, 2039
                 3, 	// April 20, 2039
                 4, 	// May 12, 2039
                 0, 	// June 05, 2039
                 0, 	// January 01, 2040
                 3, 	// February 01, 2040
                 3, 	// February 15, 2040
                 2, 	// February 28, 2040
                 4, 	// March 15, 2040
                 5, 	// April 20, 2040
                 6, 	// May 12, 2040
                 2  	// June 05, 2040
         };
        for(int year = 2000; year < 2041; year++) {
            assertEquals(expected[(year-2000)*8],Date.dayOfWeek(1, 1, year));
            assertEquals(expected[(year-2000)*8+1],Date.dayOfWeek(2, 1, year));
            assertEquals(expected[(year-2000)*8+2],Date.dayOfWeek(2, 15, year));
            assertEquals(expected[(year-2000)*8+3],Date.dayOfWeek(2, 28, year));
            assertEquals(expected[(year-2000)*8+4],Date.dayOfWeek(3, 15, year));
            assertEquals(expected[(year-2000)*8+5],Date.dayOfWeek(4, 20, year));
            assertEquals(expected[(year-2000)*8+6],Date.dayOfWeek(5, 12, year));
            assertEquals(expected[(year-2000)*8+7],Date.dayOfWeek(6, 5, year));
        }
    }

    @Test
    void testDayOfWeek_2(){
        int[] expected = {
                6, 	// January 01, 2000
                2, 	// February 01, 2000
                2, 	// February 15, 2000
                1, 	// February 28, 2000
                3, 	// March 15, 2000
                4, 	// April 20, 2000
                5, 	// May 12, 2000
                1, 	// June 05, 2000
                1, 	// January 01, 2001
                4, 	// February 01, 2001
                4, 	// February 15, 2001
                3, 	// February 28, 2001
                4, 	// March 15, 2001
                5, 	// April 20, 2001
                6, 	// May 12, 2001
                2, 	// June 05, 2001
                2, 	// January 01, 2002
                5, 	// February 01, 2002
                5, 	// February 15, 2002
                4, 	// February 28, 2002
                5, 	// March 15, 2002
                6, 	// April 20, 2002
                0, 	// May 12, 2002
                3 	// June 05, 2002
        };
        for(int year = 2000; year < 2003; year++) {
            assertEquals(expected[(year-2000)*8],Date.dayOfWeek(1, 1, year));
            assertEquals(expected[(year-2000)*8+1],Date.dayOfWeek(2, 1, year));
            assertEquals(expected[(year-2000)*8+2],Date.dayOfWeek(2, 15, year));
            assertEquals(expected[(year-2000)*8+3],Date.dayOfWeek(2, 28, year));
            assertEquals(expected[(year-2000)*8+4],Date.dayOfWeek(3, 15, year));
            assertEquals(expected[(year-2000)*8+5],Date.dayOfWeek(4, 20, year));
            assertEquals(expected[(year-2000)*8+6],Date.dayOfWeek(5, 12, year));
            assertEquals(expected[(year-2000)*8+7],Date.dayOfWeek(6, 5, year));
        }
    }
}