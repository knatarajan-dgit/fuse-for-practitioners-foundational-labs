package org.globex.usecase;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.globex.Account;
import org.globex.CorporateAccount;

/**
 * Aggregator implementation which extract the id and salescontact
 * from CorporateAccount and update the Account
 */
public class AccountAggregator implements AggregationStrategy {

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
    	if(oldExchange != null) {
			CorporateAccount corporateAccount = newExchange.getIn().getBody(CorporateAccount.class);
			Account account = oldExchange.getIn().getBody(Account.class);
			account.setClientId(corporateAccount.getId());
			account.setSalesRepresentative(corporateAccount.getSalesContact());
			newExchange.getIn().setBody(account);
    	}
        return newExchange;
    }
    
}