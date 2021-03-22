/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Department;

import CourseCatalog.Course;
import CourseCatalog.CourseCatalog;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import Employer.EmployerDirectory;
import Faculty.FacultyDirectory;
import Student.PersonDirectory;
import Student.StudentDirectory;
import Student.StudentProfile;
import java.util.HashMap;

/**
 *
 * @author ramulyarao
 */
public class Department {
    
    public String name;
    public CourseCatalog coursecatalog;
    public PersonDirectory persondirectory;
    public StudentDirectory studentdirectory;
    public FacultyDirectory facultydirectory;
    public EmployerDirectory employerdirectory;

    public HashMap<String, CourseSchedule> mastercoursecatalog;

    public Department(String n) {
        name = n;
        mastercoursecatalog = new HashMap<String, CourseSchedule>();
        coursecatalog = new CourseCatalog(this);
        studentdirectory = new StudentDirectory(this); //pass the department object so it stays linked to it
        persondirectory = new PersonDirectory();
        facultydirectory = new FacultyDirectory(this);
        employerdirectory = new EmployerDirectory(this);
    }

    public EmployerDirectory getEmployerdirectory() {
        return employerdirectory;
    }

    public PersonDirectory getPersonDirectory() {
        return persondirectory;
    }

    public FacultyDirectory getFacultydirectory() {
        return facultydirectory;
    }

    public StudentDirectory getStudentDirectory() {
        return studentdirectory;
    }

    public CourseSchedule newCourseSchedule(String semester) {
        CourseSchedule cs = new CourseSchedule(semester, coursecatalog);
        mastercoursecatalog.put(semester, cs);
        return cs;
    }

    public CourseSchedule getCourseSchedule(String semester) {
        return mastercoursecatalog.get(semester);
    }

    public CourseCatalog getCourseCatalog() {
        return coursecatalog;
    }

    public Course newCourse(String n, String nm, int cr) {
        Course c = coursecatalog.newCourse(n,nm,cr);
        return c;
    }

    public int calculateRevenuesBySemester(String semester) {
        CourseSchedule css = mastercoursecatalog.get(semester);
        return css.calculateTotalRevenues();
    }

    public void RegisterForAClass(String studentid, String cn, String semester) {

        StudentProfile sp = studentdirectory.findStudent(studentid);
        CourseLoad cl = sp.getCurrentCourseLoad();
        CourseSchedule cs = mastercoursecatalog.get(semester);
        CourseOffer co = cs.getCourseOfferByNumber(cn);
        co.assignEmptySeat(cl);

    }
}
