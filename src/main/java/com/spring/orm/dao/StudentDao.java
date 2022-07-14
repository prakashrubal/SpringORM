package com.spring.orm.dao;

import com.spring.orm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;
import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {

    private HibernateTemplate hibernateTemplate;

    //    save method
    @Transactional
    public int insert(Student student){
//        insert
        int i = (int) hibernateTemplate.save(student);
        return i;
    }

    //R- READ get single student object
    public Student getStudent(int studentId){
        return hibernateTemplate.get(Student.class, studentId);
    }

    //R- READ get list of all Students
    public List<Student> getAllStudents(){
        return hibernateTemplate.loadAll(Student.class);
    }

    //D- DELETE delete the student using ID
    @Transactional
    public void deleteStudent(int studentId){
        Student student = hibernateTemplate.get(Student.class, studentId);
        hibernateTemplate.delete(student);
    }

    //U - UPDATE update the student data
    @Transactional
    public void updateStudent(Student student){
        hibernateTemplate.update(student);
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
}
