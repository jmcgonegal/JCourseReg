package CourseReg;
import java.util.Vector;
/**
 * <p>Title: CourseReg</p>
 * <p>Description: A course registration system.</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p> </p>
 * @author John McGonegal
 * @version 1.0
 */

public class Semester// implements Comparable
{
    //private String myYear;
    private Vector courses;
    private int credits;

    public Semester()
    {
	//myYear = year;
	courses = new Vector();
	credits = 0;
    }
    public Vector getCourses()
    {
	return courses;
    }
    // compares Semester names
 /*   public int compareTo(Object obj)
    {
	String comp = ((Semester)obj).getYear();
	return this.getYear().compareTo(comp);
    }
    public String getYear()
    {
	return myYear;
    }*/
    public int getCredits()
    {

	return credits;
    }
    boolean removeCourse(Course course)
    {
	credits-=course.getCredits();
	return courses.remove(course);
    }
    // adds the course if the number of credits isnt over the limit and the student isnt already registered
    boolean addCourse(Course course)
    {
	// credit check
	if(this.getCredits()+course.getCredits() <= Student.MAXCREDITS)
	{
	    // already registered?
	    if(courses.indexOf(course) >= 0)
	    {
		return false;
	    }
	    else
	    {
		// conflicting time?
		for(int i=0;i<courses.size();i++)
		{
		    Course check = (Course)courses.elementAt(i);
		    if(check.getTimes()==course.getTimes() && check.getDays().equals(course.getDays()))
		    {
			return false;
		    }
		}
		// we can add the course
		courses.add(course);
		credits+=course.getCredits();
		return true;
	    }

	}
	return false;
    }
}
