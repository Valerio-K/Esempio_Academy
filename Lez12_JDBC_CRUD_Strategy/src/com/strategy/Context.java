package com.strategy;

import java.sql.SQLException;
import java.util.ArrayList;

public class Context {
	
	/*
	 * Questo costruttore prevede in input una Interfaccia padre di due Strategy
	 * L'applicazione invocante potrà usare tale costruttore passandogli
	 * in input qualsiasi strategia figlia (CustomerStrategy o ProductStrategy)
	 * A seconda deglla Strategia figlia passata in input dall'invocante,
	 * la Strategy padre si trasformerà nel corretto figlio (POLIMORFISMO)
	 */
	private Strategy strategy;
	
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public ArrayList<Object> executeStrategy() throws ClassNotFoundException, SQLException {
		return strategy.findAllObject();
	}
}
