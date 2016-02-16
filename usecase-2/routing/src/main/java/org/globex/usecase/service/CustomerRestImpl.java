package org.globex.usecase.service;

import org.globex.Account;
import org.globex.Company;


public class CustomerRestImpl implements CustomerRest {

    private static final String NA_REGION = "NORTH_AMERICA";
    private static final String SA_REGION = "SOUTH_AMERICA";
    private static final String WE_REGION = "WEST_AMERICA";
    private static final String EAST_REGION = "EAST_AMERICA";

    @Override
    public Account enrich(Account account) {
        Company company = account.getCompany();
        String region = company.getGeo();
        System.out.println("CustomerRestImpl.enrich(): "+ region);
        switch(region) {
	        case "NA":
	        	company.setGeo(NA_REGION);
	        	break;
	        case "SA":
	        	company.setGeo(SA_REGION);
	        	break;
	        case "WE":
	        	company.setGeo(WE_REGION);
	        	break;
	        case "EU":
	        	company.setGeo(EAST_REGION);
	        	break;
        }
        return account;
    }
}
