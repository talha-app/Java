package com.talha.springboot.app.test;

import com.talha.springboot.app.service.ICourseService;
import com.talha.springboot.app.service.IInstructorService;
import com.talha.springboot.app.service.IReviewService;
import com.talha.springboot.app.service.IStudentService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Test {
    private final IInstructorService m_instructorService;
    private final ICourseService m_courseService;
    private final IReviewService m_reviewService;
    private final IStudentService m_studentService;


    public Test(IInstructorService instructorService, ICourseService courseService, IReviewService reviewService, IStudentService studentService) {
        m_instructorService = instructorService;
        m_courseService = courseService;
        m_reviewService = reviewService;
        m_studentService = studentService;
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            Random rnd = new Random();
//            for (int i = 0; i < 15; i++) {
//                var instructor = new Instructor("talha" + rnd.nextInt(1000), "aydeger", "email");
//                var course1 = new Course("math" + rnd.nextInt(10000));
//
//                instructor.addCourse(course1);
//                m_instructorService.save(instructor);
//            }

//            var instructor2 = new Instructor("talha"+rnd.nextInt(1000), "aydeger", "email");
//            var course2 = new Course("math"+rnd.nextInt(10000));
//
//            instructor2.addCourse(course2);
//
//
//            m_courseService.save(course2);

//            Instructor instructor10 = m_instructorService.findById(43);
//            var lis = instructor10.getCourseList();
//
//            System.out.println(lis);

            //m_courseService.findById(44).stream().forEach(System.out::println);
            //System.out.println(m_courseService.findCoursesByInstructorId(43));

//            Course course0 = m_courseService.findById(44);
//            course0.addReview(new Review("review"+rnd.nextInt(1000)));
//            course0.addReview(new Review("review"+rnd.nextInt(1000)));
//            course0.addReview(new Review("review"+rnd.nextInt(1000)));

//            m_courseService.save(course0);

//            course0.getReviewList().forEach(System.out::println);


//            for (int i = 0; i < 5; i++) {
//                Student st1 =new Student("talha"+rnd.nextInt(1000),"aydeger"+rnd.nextInt(1000),"email"+rnd.nextInt(1000));
//
//                m_studentService.save(st1);
//            }

//            Student st1 = m_studentService.findById(9);
//            st1.addCourse(m_courseService.findById(2));
//            st1.addCourse(m_courseService.findById(4));
//            st1.addCourse(m_courseService.findById(6));
//            st1.addCourse(m_courseService.findById(8));
//            st1.addCourse(m_courseService.findById(10));
//
//            System.out.println(st1 + st1.getCourseList().toString());
//            m_studentService.save(st1);
//
            var courseIds =  m_studentService.findCoursesById(9);
            System.out.println(courseIds.toString());

            var courses = m_courseService.findAllById(courseIds);
            System.out.println(courses.toString());


        };
    }
}