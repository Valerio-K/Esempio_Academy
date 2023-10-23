package com.main;

import java.sql.SQLException;

import com.strategy.Context;
import com.strategy.Strategy;
import com.strategy.CustomerStrategy;
import com.strategy.ProductStrategy;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Strategy strategyC = new CustomerStrategy();
		Context contextC = new Context(strategyC);
		contextC.executeStrategy().forEach(customer -> System.out.println(customer));
		
		Strategy strategyP = new ProductStrategy();
		Context contextP = new Context(strategyP);
		contextP.executeStrategy().forEach(product -> System.out.println(product));
	}

}
