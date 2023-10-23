package com.sql;

public interface SqlScript {
	
	public String sqlInsert="INSERT INTO libreria(titolo,autore,pubblicazione) VALUES (?,?,?)";
	public String sqlReadAll="SELECT * from libreria";
	public String sqlFindTitoloLibro = "SELECT DISTINCT libreria.titolo FROM libreria WHERE libreria.titolo LIKE ?";
}
