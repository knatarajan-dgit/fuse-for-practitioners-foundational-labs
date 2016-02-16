package org.globex.usecase.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.globex.Account;
import org.globex.CorporateAccount;

@WebService(endpointInterface = "org.globex.usecase.service.CustomerWS")
public class CustomerWSImpl implements CustomerWS {

    List<String> sales;

    public CustomerWSImpl() {
        sales = new ArrayList<String>();
        sales.add("James Strachan");
        sales.add("Claus Ibsen");
        sales.add("Hiram Chirino");
        sales.add("Jeff Bride");
        sales.add("Chad Darby");
        sales.add("Rachel Cassidy");
        sales.add("Bernard Tison");
        sales.add("Nandan Joshi");
        sales.add("Rob Davies");
        sales.add("Guillaume Nodet");
        sales.add("Marc Little");
        sales.add("Mario Fusco");
        sales.add("James Hetfield");
        sales.add("Kirk Hammett");
        sales.add("Steve Perry");
    }

    @WebResult(name = "CorporateAccount")
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public CorporateAccount updateAccount(Account account) {
        CorporateAccount ca = new CorporateAccount();
        ca.setId(genRandom());
        ca.setSalesContact(getRandomSales(sales));
        return ca;
    }

    public static int genRandom() {
        return new Random().nextInt(100);
    }

    public static String getRandomSales(List<String> list) {
        //0-11
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }

}
