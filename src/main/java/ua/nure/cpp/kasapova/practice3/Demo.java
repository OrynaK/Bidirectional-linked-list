package ua.nure.cpp.kasapova.practice3;


import ua.nure.cpp.kasapova.practice3.entity.Fabric;
import ua.nure.cpp.kasapova.practice3.list.FabricListImp;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Demo {

    public static void main(String[] args) {
        FabricListImp list=new FabricListImp();
        Fabric fabric = new Fabric("chiffon", 7, new BigDecimal(2), new BigDecimal(125));
        Fabric fabric1 = new Fabric("leather", 5, new BigDecimal(6), new BigDecimal(128));
        Fabric fabric2 = new Fabric("eco-leather", 9, new BigDecimal(3), new BigDecimal(300));
        Fabric fabric3 = new Fabric("velveteen", 1, new BigDecimal(5), new BigDecimal(230));
        list.addFirst(fabric);
        list.addFirst(null);
        list.addLast(null);
        list.addLast(fabric2);

        System.out.println("\n--------------------------The original list--------------------------");
        for (Fabric fab:list) {
            System.out.println(fab);
        }
        System.out.println("----Size of list:"+list.size());

        System.out.println("\n---------------------Remove first and last element-------------------");
        list.removeFirst();
        list.removeLast();
        for (Fabric fab:list) {
            System.out.println(fab);
        }
        System.out.println("----Size of list:"+list.size());

        System.out.println("\n---------------------------------------------------------------------");
        try {
            System.out.println("The first element of the list: " + list.getFirst());
            System.out.println("The last element of the list: " + list.getLast());
            System.out.println("Find an item: " + list.get(fabric));
            System.out.println("Remove item: " + list.remove(null));

        }
        catch (NoSuchElementException e){
            System.err.println("Exception " + e.getMessage());
        }
        System.out.println("----Result of removing: ");
        for (Fabric fab:list) {
            System.out.println(fab);
        }
        System.out.println("\n----------------------------Clear the list--------------------------");
        list.clear();
        System.out.println("----Size of list:"+list.size());



        System.out.println("\n-------------------------Testing the iterator------------------------");
        list.addFirst(fabric);
        list.addFirst(null);
        list.addLast(fabric2);
        list.addLast(fabric3);
        for (Fabric obj : list) {
            System.out.println(obj);
        }
        System.out.println("\n");
        Iterator<Fabric> it = list.iterator();
        while (it.hasNext()) {
            Fabric obj = it.next();
            System.out.println(obj);
        }
        it = list.iterator();
        while (it.hasNext()) {
            Fabric obj = it.next();
            it.remove();
            try {
                it.remove();

            } catch (IllegalStateException e) {
                System.err.println("Exception " + e.getMessage());
            }
        }

    }
}
