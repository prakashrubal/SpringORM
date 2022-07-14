package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;


/**
 * Hello world!
 *
 */

/**
 * Welcome to Spring ORM Application
 *
 * PRESS 1 for adding new student
 * PRESS 2 for displaying all students
 * PRESS 3 to get details of single student
 * PRESS 4 to delete a student using id
 * PRESS 5 to update details of a student
 * PRESS 6 to Exit
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext context = new ClassPathXmlApplicationContext("springormconfig.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student(774, "Rubal Prakash", "Rajgir");
//        int insert = studentDao.insert(student);
//        System.out.println("Student inserted " + insert );

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean go = true;

        while (go){
            System.out.println("PRESS 1 for adding new student");
            System.out.println("PRESS 2 for displaying all students");
            System.out.println("PRESS 3 to get details of single student");
            System.out.println("PRESS 4 to delete a student using id");
            System.out.println("PRESS 5 to update details of a student");
            System.out.println("PRESS 6 to Exit");

            try{
                int input = Integer.parseInt(br.readLine());

                switch (input) {
                    case 1:
                        //Adding new student
                        System.out.println("Enter User ID");
                        int uid = Integer.parseInt(br.readLine());

                        System.out.println("Enter Student Name");
                        String studentName= br.readLine();

                        System.out.println("Enter City Name");
                        String cityName= br.readLine();

                        int studentId = studentDao.insert(new Student(uid, studentName, cityName));
                        System.out.println("Student with ID "+ studentId+ " added");
                        break;
                    case 2:
                        //Displaying all Students
                        List<Student> allStudents = studentDao.getAllStudents();
                        for (Student s: allStudents){
                            System.out.println(s);
                        }
                        break;
                    case 3:
                        //Get Details of a single Student
                        System.out.println("Enter User ID to Get Details of that Student");
                        int userid = Integer.parseInt(br.readLine());
                        Student student = studentDao.getStudent(userid);
                        System.out.println(student);
                        break;
                    case 4:
                        //Delete a student
                        System.out.println("Enter User ID to DELETE that Student");
                        int deleteId = Integer.parseInt(br.readLine());
                        studentDao.deleteStudent(deleteId);
                        System.out.println("Student with ID "+ deleteId+ " deleted");
                        break;
                    case 5:
                        //Update details of a Student
                        System.out.println("Enter User ID");
                        int idToUpdate = Integer.parseInt(br.readLine());

                        System.out.println("Enter Student Name");
                        String newStudentName = br.readLine();

                        System.out.println("Enter City Name");
                        String newCityName = br.readLine();

                        studentDao.updateStudent(new Student(idToUpdate, newStudentName,
                                newCityName));
                        System.out.println("Student with ID "+ idToUpdate+ " updated");
                        break;
                    case 6:
                        //Exit the Command
                        go = false;
                        break;
                }
            }
            catch (Exception e){
                System.out.println("Invalid input please try again!!");
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Thank you for using my application... SEE YOU SOON!");
    }
}
