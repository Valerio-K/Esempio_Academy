package com.sql;

public interface SqlScript {
	
	public String sqlInsert="INSERT INTO iscritti(first_name,last_name,birth_day,birth_month,birth_year,birth_place,address) VALUES (?,?,?,?,?,?,?)";
	public String sqlUpdate="UPDATE iscritti SET first_name=?,last_name=?,birth_day=?,birth_month=?,birth_year=?,birth_place=?,address=? WHERE id=?";
	public String sqlDelete="DELETE FROM iscritti WHERE id=?";
	public String sqlReadAll="SELECT * FROM iscritti";
	public String sqlSearchRead="SELECT DISTINCT * FROM product WHERE product LIKE ?";
}
