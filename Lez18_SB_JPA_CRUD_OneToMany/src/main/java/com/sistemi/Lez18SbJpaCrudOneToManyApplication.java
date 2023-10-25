package com.sistemi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.entity.Course;
import com.sistemi.entity.Review;
import com.sistemi.repository.CourseReviewRepository;

@SpringBootApplication
public class Lez18SbJpaCrudOneToManyApplication implements CommandLineRunner {
	
	@Autowired
	private CourseReviewRepository CourseReviewRepo;

	public static void main(String[] args) {
		SpringApplication.run(Lez18SbJpaCrudOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course courseOne = new Course("Java SE","Java base");
		CourseReviewRepo.insertCourse(courseOne);
		
		Review reviewOne = new Review("Roma",courseOne);
		Review reviewTwo = new Review("Milano",courseOne);
		CourseReviewRepo.insertReview(reviewOne);
		CourseReviewRepo.insertReview(reviewTwo);
		
		Course courseTwo = new Course("Java EE","Java web avanzato");
		CourseReviewRepo.insertCourse(courseTwo);
		
		Review reviewThree = new Review("Torino",courseTwo);
		Review reviewFour = new Review("Napoli",courseTwo);
		CourseReviewRepo.insertReview(reviewThree);
		CourseReviewRepo.insertReview(reviewFour);
		
		CourseReviewRepo.readReviewsByCourse(1).forEach(review->System.out.println(review.toString()));
	}

}
