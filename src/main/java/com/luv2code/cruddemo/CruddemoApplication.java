package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {
			// createInstructor(appDAO);

			// findInstructor(appDAO);

			// deleteInstructor(appDAO);
			
			// findInstructorDetail(appDAO);
			
			// deleteInstructorDetail(appDAO);
			
			// createInstructorWithCourses(appDAO);

			// findInstructorWithCourses(appDAO);

			// findCoursesForInstructor(appDAO);

			// findInstructorWithCoursesJoinFetch(appDAO);

			// updateInstructor(appDAO);

			// updateCourse(appDAO);

			// deleteCourse(appDAO);

			// createCourseAndReviews(appDAO);

			// retrieveCourseAndReviewa(appDAO);

			// deleteCourseAndReviews(appDAO);

			// createCourseAndStudents(appDAO);
			
			// findCourseAndStudents(appDAO);

			// findStudentAndCourses(appDAO);

			// addMoreCoursesForStudent(appDAO);

			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int theId = 2;

		appDAO.deleteStudentById(theId);

		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId = 2;
		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		Course tempCourse1 = new Course("Yeni kurs1");
		Course tempCourse2 = new Course("Yeni kurs2");

		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		appDAO.update(tempStudent);

		System.out.println("Done" + tempStudent.getCourses());
	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int theId = 2;

		Student tempStudent = appDAO.findStudentAndCoursesByStudentId(theId);

		System.out.println(tempStudent);
		System.out.println(tempStudent.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId = 11;

		Course tempCourse = appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println(tempCourse);
		System.out.println(tempCourse.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		Course tempCourse = new Course("New Course Paint");

		Student tempStudent1 = new Student("gozde", "kosa", "gzd@ksa.com");
		Student tempStudent2 = new Student("Barbaros", "tugcu", "brbrs@ksa.com");

		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int theId = 10;

		appDAO.deleteCourseById(theId);

		System.out.println("Done");
	}

	private void retrieveCourseAndReviewa(AppDAO appDAO) {

		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);

		System.out.println(tempCourse);

		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course tempCourse = new Course("Course Java");

		tempCourse.addReview(new Review("Great course"));
		tempCourse.addReview(new Review("wooww amazing"));
		tempCourse.addReview(new Review("I love this course"));

		appDAO.save(tempCourse);

		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		appDAO.deleteCourseById(theId);

		System.out.println("Done");
	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10;

		Course tempCourse = appDAO.findCourseById(theId);

		tempCourse.setTitle("Enjoy the Simple Things");

		appDAO.update(tempCourse);

		System.out.println("Done!" + tempCourse);
	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);
		tempInstructor.setLastName("Kosa");

		appDAO.update(tempInstructor);

		System.out.println("Done!" + tempInstructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor" + tempInstructor);
		System.out.println("the associated courses" + tempInstructor.getCourses());

		System.out.println("Done'");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor" + tempInstructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		tempInstructor.setCourses(courses);

		System.out.println("the associated courses" + tempInstructor.getCourses());

		System.out.println("Done'");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor" + tempInstructor);
		System.out.println("the associated courses:" + tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Chad", "Darby", "gozdekosa@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Kurs1");
		Course tempCourse2 = new Course("Kurs2");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor:" + tempInstructor);
		System.out.println("The courses" + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 2;

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		System.out.println("tempInstructorDetail" + tempInstructorDetail);

		System.out.println("the associated instructor:" + tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;

		appDAO.deleteInstructorById(theId);

		System.out.println("deleted" + theId);
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Find instructor id:" + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor:" + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		Instructor tempInstructor = new Instructor("Chad", "Darby", "gozdekosa@gmail.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor:" + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
