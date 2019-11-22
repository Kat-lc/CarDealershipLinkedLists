package Project4;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class MySingleLinkedListTest {

    private Car car1;
    private Car car2;
    private Car car3;
    private Truck truck1;
    private Truck truck2;
    private Truck truck3;

    MySingleLinkedList list = new MySingleLinkedList();

    @Before
    public void createList() {
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        GregorianCalendar temp1 = new GregorianCalendar();
        GregorianCalendar temp2 = new GregorianCalendar();
        GregorianCalendar temp3 = new GregorianCalendar();
        GregorianCalendar temp4 = new GregorianCalendar();
        GregorianCalendar temp5 = new GregorianCalendar();
        GregorianCalendar temp6 = new GregorianCalendar();

        try {
            Date d1 = df.parse("3/20/2019");
            temp1.setTime(d1);
            Date d2 = df.parse("4/20/2019");
            temp2.setTime(d2);
            Date d3 = df.parse("12/20/2018");
            temp3.setTime(d3);
            Date d4 = df.parse("1/20/2019");
            temp4.setTime(d4);
            Date d5 = df.parse("1/20/2010");
            temp5.setTime(d5);
            Date d6 = df.parse("1/20/2020");
            temp6.setTime(d6);


            car1 = new Car (temp1, "Outback", 18000,"LX", false);
            car2 = new Car (temp2, "Chevy", 11000,"EX", false);
            car3 = new Car (temp3, "Focus", 19000,"EX", true);
            truck1 = new Truck(temp4,"F150",12000,"LX",false);
            truck2 = new Truck(temp5,"F250",42000,"LX",false);
            truck3 = new Truck(temp6,"F350",2000,"EX",true);

            list.add(car1);
            list.add(car2);
            list.add(car3);
            list.add(truck1);
            list.add(truck2);
            list.add(truck3);


        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }
    }

    @Test
    // here is the very small example to use. Tests size
    public void size() {
        assertEquals(6, list.size());
        createList();
        assertEquals(12, list.size());
        list.remove(0);
        assertEquals(11,list.size());
        list.remove(10);
        assertEquals(10, list.size());
        list.remove(9);
        assertEquals(9, list.size());
        list.remove(0);
        assertEquals(8, list.size());
        list.remove(0);
        assertEquals(7, list.size());
        list.remove(3);
        list.remove(4);
        list.remove(1);
        list.remove(1);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void clear() {
        assertEquals(6, list.size());
        list.clear();
        assertEquals(0, list.size());

        list.add(truck1);
        list.add(car1);

        assertEquals(2, list.size());
    }

    // Checks if top of this list is a car, not the truck
    @Test
    public void add() {
        list.clear();
        list.add(truck1);
        list.add(car1);
        assertEquals(list.get(0), car1);
    }

    //Checks if truck2 is inserted at top in list of trucks
    @Test
    public void add2() {
        list.clear();
        list.add(truck1);
        list.add(truck2);
        assertEquals(list.get(0), truck2);
    }

    //Checks if car1 is inserted at top in list of cars
    @Test
    public void add3() {
        list.clear();
        list.add(car2);
        list.add(car1);
        assertEquals(list.get(0), car1);
    }

    // Check if truck1 is inserted in between truck2 and truck 3
    @Test
    public void add4() {
        list.clear();
        list.add(truck2);
        list.add(truck3);
        list.add(truck1);
        System.out.println(list.size());
        assertEquals(list.get(1), truck1);
    }

    // Check if truck3 is inserted at the bottom
    @Test
    public void add5() {
        list.clear();
        list.add(truck2);
        list.add(truck3);
        list.add(truck1);
        System.out.println(list.size());
        assertEquals(list.get(2), truck3);
    }

    // Check if car1 is inserted between car2 and car3
    @Test
    public void add6() {
        list.clear();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        System.out.println(list.size());
        assertEquals(list.get(1), car1);
    }

    // Check if car2 is inserted at the bottom
    @Test
    public void add7() {
        list.clear();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        System.out.println(list.size());
        assertEquals(list.get(2), car2);
    }

    // Contains multiple tests for a list of both cars and trucks
    @Test
    public void add8() {
        list.clear();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(truck2);
        list.add(truck3);
        list.add(truck1);
        System.out.println(list.size());

        // Checks if car3 is on the top of TRUCK's list
        assertEquals(list.get(0), car3);

        // Checks if truck2 is on the top of TRUCK's list
        assertEquals(list.get(3), truck2);

        // Checks if car2 is on bottom of CAR's list
        assertEquals(list.get(2), car2);

        // Checks if truck3 is on bottom of CAR's list
        assertEquals(list.get(5), truck3);
    }

    @Test
    public void reOrderList() {
    }

    @Test
    public void remove() {
        assertEquals("Focus", list.get(0).getAutoName());
        list.remove(0);
        assertEquals("Outback", list.get(0).getAutoName());
        list.remove(0);
        assertEquals("Chevy", list.get(0).getAutoName());
        assertEquals("F250", list.get(1).getAutoName());
        list.remove(1);
        assertEquals("F150", list.get(1).getAutoName());
        list.remove(1);
        assertEquals("F350", list.get(1).getAutoName());

        createList();
        assertEquals("F250", list.get(4).getAutoName());
        list.remove(4);
        assertEquals("F150", list.get(4).getAutoName());
        list.remove(5);
        assertEquals("F350", list.get(5).getAutoName());
        list.remove(3);
        assertEquals("F150", list.get(3).getAutoName());
        list.remove(1);
        assertEquals("Chevy", list.get(1).getAutoName());
        list.remove(2);
        assertEquals("F350", list.get(2).getAutoName());
        list.remove(0);
        assertEquals("Chevy", list.get(0).getAutoName());
        list.remove(0);
        assertEquals("F350", list.get(0).getAutoName());
        list.remove(0);
        assertEquals(0, list.size());
        assertEquals(list.remove(0), null);
        list.add(car1);
        assertEquals(list.remove(-1), null);
    }

    // Checks if list is empty
    @Test
    public void get() {
        list.clear();
        assertEquals(list.get(0), null);
    }

    // Checks if index is out of bounds
    @Test (expected = IndexOutOfBoundsException.class)
    public void get1() {
        list.clear();
        list.add(car1);

        assertEquals(list.get(-1), null);
    }

    @Test
    public void toStringTest() {
        list.clear();
        String expected = "";
        assertEquals(list.toString(), expected);
    }
    @Test
    public void toStringTest2() {
        list.clear();
        list.add(car1);
        String expected = "";
        expected = "\n" + list.get(0);
        assertTrue(expected.equals(list.toString()));
    }
}
