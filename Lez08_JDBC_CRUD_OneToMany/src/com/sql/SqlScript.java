package com.sql;

public interface SqlScript {
	
	public String sqlCourseInsert="INSERT into course(title,description) VALUES (?,?)";
	public String sqlReviewInsert="INSERT into review(location,course_id) VALUES (?,?)";
	public String sqlCourseMaxID="SELECT max(id) FROM course";
	public String sqlReviewLocationByCourse =
			"SELECT review.location FROM review,course WHERE review.course_id=course.id AND course.id=?";
}
