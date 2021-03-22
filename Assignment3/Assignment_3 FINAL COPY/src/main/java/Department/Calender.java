/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Department;

import CourseSchedule.CourseSchedule;
import java.util.HashMap;

/**
 *
 * @author ramulyarao
 */
public class Calender {
   HashMap<String, CourseSchedule> mastercatalog; 
    
    public Calender(){
    mastercatalog = new HashMap<String, CourseSchedule>();    
    }
    
    public void addCourseSchedule(String semester, CourseSchedule cs){
        
        mastercatalog.put(semester, cs);
        
    }
}
