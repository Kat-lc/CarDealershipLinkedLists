package Project4;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class ListEngine extends AbstractListModel {

    private MySingleLinkedList listAutos;

    public ListEngine() {
        super();
        listAutos = new MySingleLinkedList ();
        createList();
    }

    public Auto remove(int i) {
        Auto unit = listAutos.remove(i);
        fireIntervalRemoved(this, 0, listAutos.size());
        return unit;
    }

    public void add (Auto a) {
        listAutos.add(a);
        fireIntervalAdded(this, 0, listAutos.size());
    }

    public Auto get (int i) {
        return listAutos.get(i);
    }

    public Object getElementAt(int arg0) {
        Auto unit = listAutos.get(arg0);
        return unit.toString();
    }

    public int getSize() {
        return listAutos.size();
    }

    public void saveDatabase(String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(listAutos);
            os.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error in saving db");

        }
    }

    public void loadDatabase(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream is = new ObjectInputStream(fis);

            listAutos = (MySingleLinkedList) is.readObject();
            fireIntervalAdded(this, 0, listAutos.size() - 1);
            is.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in loading db");
        }
    }

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


            Car Car1 = new Car(temp1, "Outback", 18000,"LX", false);
            Car Car2 = new Car(temp2, "Chevy", 11000,"EX", false);
            Car Car3 = new Car(temp3, "Focus", 19000,"EX", true);
            Truck Truck1 = new Truck(temp4,"F150",12000,"LX",false);
            Truck Truck2 = new Truck(temp5,"F250",42000,"LX",false);
            Truck Truck3 = new Truck(temp6,"F350",2000,"EX",true);

            add(Truck1);
            add(Car1);
            add(Truck2);
            add(Car2);
            add(Car3);
            add(Truck3);

            System.out.println(listAutos.size());
            System.out.println(listAutos.size());


        } catch (ParseException e) {
            throw new RuntimeException("Error in testing, creation of list");
        }

    }
}
