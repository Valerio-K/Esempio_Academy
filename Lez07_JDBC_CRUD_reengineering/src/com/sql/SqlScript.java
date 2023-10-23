package com.sql;

public interface SqlScript {
	
	public String sqlInsert="INSERT into student(first_name,last_name,age) VALUES (?,?,?)";
	public String sqlUpdate="UPDATE student SET first_name=?,last_name=?,age=? WHERE id=?";
	public String sqlDelete="DELETE from student WHERE id=?";
	public String sqlRead="SELECT * from student";
}
