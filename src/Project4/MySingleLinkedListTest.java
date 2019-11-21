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


            Car Car1 = new Car (temp1, "Outback", 18000,"LX", false);
            Car Car2 = new Car (temp2, "Chevy", 11000,"EX", false);
            Car Car3 = new Car (temp3, "Focus", 19000,"EX", true);
            Truck Truck1 = new Truck(temp4,"F150",12000,"LX",false);
            Truck Truck2 = new Truck(temp5,"F250",42000,"LX",false);
            Truck Truck3 = new Truck(temp1,"F350",2000,"EX",true);

            list.add(Car1);
            list.add(Car2);
            list.add(Car3);
            list.add(Truck1);
            list.add(Truck2);
            list.add(Truck3);


        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }
    }


    @Test
    // here is the very small example to use.
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
    }

    @Test
    public void add() {
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
