package CourseReg;
import java.util.ArrayList;
import java.util.Vector;
/**
 * <p>Title: CourseReg</p>
 * <p>Description: A course registration system.</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p> </p>
 * @author John McGonegal
 * @version 1.0
 */

public class Registrar
{
    private Vector courses; // currently offered courses
    private Vector students; // enrolled students
    private String myYear;
    public Registrar(String year)
    {
	courses = new Vector();
	students = new Vector();
	myYear = year;
    }
    public void addCourse(Course course)
    {
	courses.add(course);
    }
    public void addStudent(Student student)
    {
	students.add(student);
    }
    public Course getCourseWithName(String name)
    {
	Course compare = new Course(name);
	return (Course)courses.get(courses.indexOf(compare));
    }
    public Student getStudentWithName(String name)
    {
	for(int i = 0; i < courses.size(); i++)
	{
	    Student test = (Student) students.elementAt(i);
	    if(test.getName().equals(name))
	    {
		return test;
	    }
	}
	return null;
	/*Student compare = new Student(name);
	int index = courses.indexOf(compare);
	if(index >= 0)
	{
	    return (Student)courses.get(index);
	}
	else
	{
	    return null;
	}*/
    }
    public boolean removeCourse(Course course)
    {
	return false;
    }
    public boolean removeStudent(Student student)
    {
	return false;
    }
    // returns the Semester of the registrar
    public String getName()
    {
	return myYear;
    }
    public Vector getAllCourses()
    {
	return courses;
    }
    public Vector getAllStudents()
    {
	return students;
    }
}