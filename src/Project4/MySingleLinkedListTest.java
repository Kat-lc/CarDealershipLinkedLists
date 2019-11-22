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
    }

    @Test
    public void add() {
        // Check if top of list is a car
        list.clear();
        list.add(truck1);
        list.add(car1);
        assertEquals(list.get(0), car1);
    }

    @Test
    public void add2() {
        // Check if truck2 is inserted at top
        list.clear();
        list.add(truck1);
        list.add(truck2);
        assertEquals(list.get(0), truck2);
    }

    // Check if truck1 is inserted in between truck2 and truck 3
    @Test
    public void add3() {
        list.clear();
        list.add(truck2);
        list.add(truck3);
        list.add(truck1);
        System.out.println(list.size());
        assertEquals(list.get(1), truck1);

        // Check if Car2 is inserted in between Car1 and Car3
        assertEquals(list.get(2), truck3);
    }
    @Test
    public void add4() {
        list.clear();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        System.out.println(list.size());
        assertEquals(list.get(1), car1);

        // Check if truck3 is inserted at the bottom
        assertEquals(list.get(2), car2);
    }

    @Test
    public void reOrderList() {
    }

    @Test
    public void remove() {
        list.display();
        assertEquals("Focus", list.get(0).getAutoName());
        list.remove(0);
        list.display();
        assertEquals("Outback", list.get(0).getAutoName());
        list.remove(0);
        assertEquals("Chevy", list.get(0).getAutoName());
        assertEquals("F250", list.get(1).getAutoName());
        list.remove(1);
        assertEquals("F150", list.get(1).getAutoName());
        list.remove(1);
        assertEquals("F350", list.get(1).getAutoName());
        list.display();

        createList();
        list.display();
        assertEquals("F250", list.get(4).getAutoName());
        list.remove(4);
        assertEquals("F150", list.get(4).getAutoName());
        list.display();
        list.remove(5);
        assertEquals("F350", list.get(5).getAutoName());
        list.display();
        list.remove(3);
        assertEquals("F150", list.get(3).getAutoName());
        list.display();
        list.remove(1);
        assertEquals("Chevy", list.get(1).getAutoName());
        list.display();
        list.remove(2);
        assertEquals("F350", list.get(2).getAutoName());
        list.display();
        list.remove(0);
        assertEquals("Chevy", list.get(0).getAutoName());
        list.display();
        list.remove(0);
        assertEquals("F350", list.get(0).getAutoName());
        list.display();
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void get() {
    }

    @Test
    public void display() {
    }
}
