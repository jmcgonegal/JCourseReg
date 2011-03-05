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

public class Student implements Comparable
{
    public static final int MAXCREDITS = 19;

   // private Vector mySemesters;
    private String myName;
    private String myPin;
    private Semester current = new Semester();
    public Student(String name)
    {
	myName = name;
    }
    public Student(String name, String pin)
    {
	myName = name;
	myPin = pin;
	//mySemesters = new Vector();
	//mySemesters.add(new Semester("Fall 03"));
    }
    public Vector getCourses()
    {
	return current.getCourses();
    }
    public String getName()
    {
	return myName;
    }
    public String getPin()
    {
	return myPin;
    }
    public String toString()
    {
	return myName;
    }
    public boolean removeCourse(Course course)
    {
	course.removeStudent(this);
	return current.removeCourse(course);
    }
    // checks if there is room in the class and trys to add the class to the students sceduel
    public boolean addCourse(Course course)
    {
	if(course.addStudent(this))
	{
	    if(!current.addCourse(course))
	    {
		course.removeStudent(this);
		return false;
	    }
	    return true;
	}
	return false;
	/*
	int i = mySemesters.indexOf(year);
	/*if(i < 0)
	{
	    mySemesters.add(new Semester(year));
	}
	i = mySemesters.indexOf(year);
	Semester sem = (Semester)mySemesters.get(i);
	return sem.addClass(course); */
    }
    public int getCredits(String year)
    {
	return current.getCredits();
	/*
	Semester sem = (Semester)mySemesters.get(mySemesters.indexOf(year));
	return sem.getCredits();*/
    }
    // compares the students names
    public boolean equals(Object comp)
    {
	//System.out.println("CompEqual:" + test + " to " + this.getName());
	return comp.toString().equals(this.getName());
    }
    public int compareTo(Object comp)
    {
	String test = ((Student)comp).getName();
	//System.out.println("Comparing:" + test + " to " + this.getName());
	return test.compareTo(this.getName());
    }
}