/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import CourseCatalog.Course;
import CourseSchedule.CourseLoad;
import CourseSchedule.CourseOffer;
import CourseSchedule.CourseSchedule;
import CourseSchedule.SeatAssignment;
import Department.College;
import Department.Department;
import Department.DepartmentDirectory;
import Employer.EmployerDirectory;
import Employer.EmployerProfile;
import Faculty.FacultyAssignment;
import Faculty.FacultyDirectory;
import Faculty.FacultyProfile;
import Student.Person;
import Student.PersonDirectory;
import Student.StudentDirectory;
import Student.StudentProfile;
import com.github.javafaker.Faker;
import java.util.Scanner;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author ramulyarao
 */
public class Main {
    public static void main(String[] args) {
        College coe = new College("College of Engineering");
        DepartmentDirectory dd = coe.newdeptdir();//new DepartmentDirectory();

        Department department = dd.newDepartment("Information Systems");

        Course course = department.newCourse("Application Engineering and Development", "INFO5100", 4);

        CourseSchedule courseschedule = department.newCourseSchedule("Fall2020");

        CourseOffer courseoffer = courseschedule.newCourseOffer("Info5100");
        
        courseoffer.generatSeats(10);
        
        PersonDirectory pd = department.getPersonDirectory();
        Person person = pd.newPerson("67112303", "John Wayne", "360 Huntington Ave", "6785691089");
        StudentDirectory sd = department.getStudentDirectory();
        StudentProfile student = sd.newStudentProfile(person);
        CourseLoad courseload = student.newCourseLoad("Fall2020"); 
        FacultyDirectory fd = department.getFacultydirectory();
        EmployerDirectory ed = department.getEmployerdirectory();
        
        generatePersons(pd, sd, fd, ed);
        dd = generateDepts(dd);
        generateCourses(dd);
        generateCourseSchedule(dd, sd, fd);
        courseload.newSeatAssignment(courseoffer); //register student in class
        //System.out.print("Total: " + total);
        int runcount = 0;
        Scanner scuser = new Scanner(System.in);
        while (runcount == 0){
            System.out.println("1. Person Information\n2. Department Information\n0.Exit");
            int usrinp1 = scuser.nextInt();
            if (usrinp1 == 1) {
                System.out.println("1. List of students\n2. List of faculty\n3. List of Employers\n4. List of all Persons");
                int usrinp2 = scuser.nextInt();
                if (usrinp2 == 1){
                    System.out.println("\n__________________________________Student Info_________________________\n");
                    for (StudentProfile s1: sd.studentlist){
                        String[] sems = {"Fall 2020", "Spring 2021", "Fall 2021", "Spring 2022"};
                        System.out.println("\n___________________________________________");
                        System.out.println("\nStudent Name: " + s1.person.getName());
                        System.out.println("Student ID: " + s1.person.getId()); 
                        System.out.println("Student Contact Number: " + s1.person.getPhonenumber());
                        System.out.println("Student Address: " + s1.person.getAddress());
                        int b = 0;
                        while(b < sems.length){
                            CourseLoad cl1 = s1.getCurrentCourseLoad();
                            if (cl1 == null){
                                System.out.println("No current CourseLoad");
                                break;
                            }
                            else{
                                System.out.println("Student's Current CourseLoad: " + cl1.seatassignments.size());
                            }
                            b++;
                        }
                        System.out.println("\n___________________________________________");
                    }
                }
                
                else if(usrinp2 == 2){
                    System.out.println("\n__________________________________Faculty Info_________________________\n");
                    for (FacultyProfile fp1 : fd.teacherlist){
                        System.out.println("\n___________________________________________");
                        System.out.println("\nFaculty Name: " + fp1.person.getName());
                        System.out.println("Faculty ID: " + fp1.person.getId());
                        for (FacultyAssignment fa1: fp1.facultyassignments){
                            System.out.println("\nCourse Name: " + fa1.courseoffer.course.getName());
                            System.out.println("Course Number: " + fa1.courseoffer.course.getCOurseNumber() + "\n");
                        }
                        System.out.println("\n___________________________________________");
                    }
                }
                else if(usrinp2 == 3){
                    System.out.println("\n__________________________________Employer Info_________________________\n");
                    for(EmployerProfile ep1 : ed.employerlist){
                        System.out.println("\n___________________________________________");
                        System.out.println("\nEmployer Name: " + ep1.person.getName());
                        System.out.println("Emplyer ID: " + ep1.person.getId());
                        System.out.println("Employer Contact Number: " + ep1.person.getPhonenumber());
                        System.out.println("Employer Address: " + ep1.person.getAddress());
                        System.out.println("\n___________________________________________");
                    }
                    
                }
                else if(usrinp2 == 4){
                    System.out.println("\n__________________________________Person Info_________________________\n");
                    for(Person p1: pd.personlist){
                        System.out.println("\n___________________________________________");
                        System.out.println("\nName: " + p1.getName());
                        System.out.println("Id: " + p1.getId());
                        System.out.println("Role: " + p1.getRole());
                        System.out.println("Contact Number: " + p1.getPhonenumber());
                        System.out.println("Address: " + p1.getAddress());
                        System.out.println("\n___________________________________________");
                    }
                    
                }
            }
            
            else if(usrinp1 == 2){
                System.out.println("\n__________________________________Department Info_________________________\n");
                System.out.println("\n___________________________________________");
                int e = 1;
                for (Department d: dd.departmentlist){
                    
                    System.out.println(e + ". Departmen Name: " + d.name);
                    e++;
                }
                System.out.println("\n___________________________________________");
                System.out.println("\nSelect a department");
                int usrinp3 = scuser.nextInt();
                int c = 0;
                while (c == 0){
                    Department d1 = dd.departmentlist.get(usrinp3 -1);
                    String[] sems = {"Fall 2020", "Spring 2021", "Fall 2021", "Spring 2022"};
                    
                    int a1 = 0;
                    while (a1 == 0){
                        int f = 0;
                        System.out.println("\n___________________________________________");
                        System.out.println("\nSemesters: \n");
                        while(f < sems.length){    
                            System.out.println((f + 1) + ". Semester: " + sems[f]);
                            f++;
                        }
                        System.out.println("\nSelect a semester\nEnter 0 to go back");
                        int usrinp4 = scuser.nextInt();
                        if (usrinp4 == 0){
                            a1++;
                            c++;
                            
                        }
                        else {
                            String sem = sems[(usrinp4 - 1)];
                            System.out.println("\nSemester: " + sem);
                            CourseSchedule cs1 = d1.getCourseSchedule(sem);
                            for (CourseOffer co1 : cs1.schedule){
                                System.out.println("___________________________________________");
                                System.out.println("Course Name: " + co1.course.getName());
                                System.out.println("Course Number: " + co1.course.getCOurseNumber());
                                System.out.println("Course Credits " + co1.course.getCredits());
                                System.out.println("Course Faculty: " + co1.getFacultyProfile().person.getName());
                                System.out.println("No. of seats: " + co1.seatlist.size());
                                System.out.println("___________________________________________\n");
                            }
                        }
                    }
                    
                    
                }
            }
            else if(usrinp1 == 0){
                runcount = 1;
            }
            int total = department.calculateRevenuesBySemester("Fall 2020");
            
//            System.out.println("__________________________________\n Course Info \n _________________________");
//            for (Department d : dd.departmentlist){
//                System.out.println(d.name);
//                String[] sems = {"Fall 2020", "Spring 2021", "Fall 2021", "Spring 2022"};
//                int a = 0;
//                while (a < sems.length){
//
//                    CourseSchedule cs1 = d.getCourseSchedule(sems[a]);
//                    System.out.println("Semester : " + cs1.semester);
//                    for (CourseOffer co1 : cs1.schedule){
//                        System.out.println("___________________________________________");
//                        System.out.println("Course Name: " + co1.course.getName());
//                        System.out.println("Course Number: " + co1.course.getCOurseNumber());
//                        System.out.println("Course Credits " + co1.course.getCredits());
//                        System.out.println("Course Faculty: " + co1.getFacultyProfile().person.getName());
//                        System.out.println("No. of seats: " + co1.seatlist.size());
//                        System.out.println("___________________________________________\n");
//                    }
//                    a++;
//                }
//            }

            
        }
    }

     public static void generatePersons(PersonDirectory pd, StudentDirectory sd, FacultyDirectory fd, EmployerDirectory ed){
        Faker faker = new Faker();
        String[] names = {};
        String[] idnumbers = {};
        String[] addresses = {};
        String[] phonenums = {};
        String[] empnames = {};
        int x = 0;
        
        while(x < 500){
            String name = faker.name().fullName();
            String idnum = faker.number().digits(9);
            String addr = faker.address().streetAddress();
            String phonenum = faker.number().digits(10);
            String emp = faker.company().name();
            names = ArrayUtils.add(names,name);
            idnumbers = ArrayUtils.add(idnumbers,idnum);
            addresses = ArrayUtils.add(addresses, addr);
            phonenums = ArrayUtils.add(phonenums, phonenum);
            empnames = ArrayUtils.add(empnames, emp);  
            x++;
        }
        
        int y =0;
        while (y < 100){
            Person p = pd.newPerson(idnumbers[y], names[y], addresses[y], phonenums[y]); 
            y++;
        }
        
        int z = 0;
        while (z < 100){
            Person p = pd.newPerson(idnumbers[z], names[z], addresses[z], phonenums[z]);
            z++;
        }
        
        int a = 0;
        while(a < 50){
            Person p = pd.newPerson(idnumbers[a], empnames[a], addresses[a], phonenums[a]);
            a++;
        }
        
        for (Person p1 : pd.getPersonlist()){
            if (p1.getRole().equalsIgnoreCase("student")){
                StudentProfile sp = sd.newStudentProfile(p1);
            }
            else if (p1.getRole().equalsIgnoreCase("faculty")){
                FacultyProfile fp = fd.newFacultyProfile(p1);
            }
            else if ((p1.getRole().equalsIgnoreCase("employer"))){
                EmployerProfile ep = ed.newEmployerProfile(p1);
            }
        }
    }
    
    public static DepartmentDirectory generateDepts(DepartmentDirectory dd){
        String[] deptnames = {"BioEngineering", "Chemical Engineering", "Civil and Environmental Engineering","Electrical and Computer Engineering", "Mechanical Engineering"};
        int x = 0;
        while (x < deptnames.length){
            Department dept = dd.newDepartment(deptnames[x]);
            x++;
        }
        return dd;
    }
    
    public static void generateCourses(DepartmentDirectory dd){
        Faker faker = new Faker();
        String[] bioengsubs = {"Bioinformatics","Bioinstrumentation", "Biomaterials", "Biomechanics", "Biosignal Processing", "Biotechnology"};
        String[] chemeng = {"Fundamentals of Heat and Mass Transfer","Process Fluid Mechanics","Environmental Studies","Introduction to Numerical Analysis"};
        String[] civeng =  {"Construction Engineering","Geotechnical Engineering","Structural Engineering","Coastal and Ocean Engineering","Transportation engineering"};
        String[] eleceng =  {"Electro-magnetism","Control systems","Electricity Technology and Machines","Circuit Analysis", "Electronics","Electrical Engineering ","Material Transmission & Distribution"};
        String[] mecheng = {"Structural materials","Solid mechanics","Thermodynamics","Thermofluids"};
        
        Department d1 = dd.departmentlist.get(1);
        int y1 = 0;
        while(y1 < bioengsubs.length){
            Course c1 = d1.newCourse(bioengsubs[y1], "BIO" + faker.number().digits(4), 4);
            y1++;
        }
        
        Department d2 = dd.departmentlist.get(2);
        int y2 = 0;
        while(y2 < chemeng.length){
            Course c2 = d2.newCourse(chemeng[y2], "CHEM" + faker.number().digits(4), 4);
            y2++;
        }
        
        Department d3 = dd.departmentlist.get(3);
        int y3 = 0;
        while(y3 < civeng.length){
            Course c3 = d3.newCourse(civeng[y3], "CIV" + faker.number().digits(4), 4);
            y3++;
        }
        
        Department d4 = dd.departmentlist.get(4);
        int y4 = 0;
        while(y4 < eleceng.length){
            Course c4 = d4.newCourse(eleceng[y4], "ELE" + faker.number().digits(4), 4);
            y4++;
        }
        
        Department d5 = dd.departmentlist.get(5);
        int y5 = 0;
        while(y5 < mecheng.length){
            Course c5 = d5.newCourse(mecheng[y5], "MECH" + faker.number().digits(4), 4);
            y5++;
        }
        
    }
    
    public static void generateCourseSchedule(DepartmentDirectory dd, StudentDirectory sd, FacultyDirectory fd){
        Faker faker = new Faker();
        String[] sems = {"Fall 2020", "Spring 2021", "Fall 2021", "Spring 2022"};
        for (Department d: dd.departmentlist){
            int x = 0;
            while(x < sems.length){
                CourseSchedule cs = d.newCourseSchedule(sems[x]);
                for(Course c : d.coursecatalog.courselist){
                    int numofseats = faker.number().numberBetween(10, 50);
                    CourseOffer co1 = cs.newCourseOffer(c.getCOurseNumber());
                    co1.generatSeats(numofseats);
                    co1.AssignAsTeacher(fd.teacherlist.get(faker.number().numberBetween(0, 99)));
                    int y = 0;
                    while (y < numofseats){
                        StudentProfile sp1 = sd.studentlist.get(faker.number().numberBetween(0, 99));
                        CourseLoad cl1 = sp1.newCourseLoad(sems[x]);
                        SeatAssignment sa1 = co1.assignEmptySeat(cl1);
                        y++;
                    }
                }
                x++;
            }
        }
    }
    
}
