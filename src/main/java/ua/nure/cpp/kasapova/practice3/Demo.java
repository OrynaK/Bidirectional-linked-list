package ua.nure.cpp.kasapova.practice3;


import ua.nure.cpp.kasapova.practice3.entity.Fabric;
import ua.nure.cpp.kasapova.practice3.list.FabricListImp;

import java.math.BigDecimal;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        FabricListImp list=new FabricListImp();
        Fabric fabric = new Fabric("chiffon", 7, new BigDecimal(2), new BigDecimal(125));
        Fabric fabric1 = new Fabric("leather", 5, new BigDecimal(6), new BigDecimal(128));
        list.addFirst(fabric);
        list.addFirst(fabric1);
        list.removeFirst();
    }
}
