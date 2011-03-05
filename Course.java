package CourseReg;

import java.util.ArrayList;
/**
 * <p>Title: Registrar</p>
 * <p>Description: A course registration system.</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p> </p>
 * @author John McGonegal
 * @version 1.0
 */

public class Course implements Comparable
{
    private String myTitle;
    private String myNumber;
    private String myDays;
    private int myTime;
    private int myCredits;
    private String myRoom;
    private int mySeats;
    private ArrayList enrolledStudents;
    private int filledSeats;
    public Course(String title)
    {
	myTitle = title;
    }
    public Course(String title, String number, int credits, String days, int time, String room, int seats,int filled)
    {
	enrolledStudents = new ArrayList();
	myTitle = title;
	myNumber = number;
	myCredits = credits;
	myDays = days;
	myTime = time;
	myRoom = room;
	mySeats = seats;
	filledSeats = filled;
    }
    public boolean addStudent(Student student)
    {
	if(mySeats >/* enrolledStudents.size()*/ filledSeats)
	{
	    enrolledStudents.add(student);
	    filledSeats++;
	    return true;
	}
	return false;
    }
    public int compareTo(Object obj)
    {
	String rightID = ((Course)obj).getTitle();
	String leftID = this.getTitle();
	return leftID.compareTo(rightID);
    }
    public String toString()
    {
	return myNumber + "   " + myTitle + "   " + myCredits + "   " + myDays + "   " + myTime + ":00   " + myRoom + "   " + mySeats + "   " + filledSeats;
	//return myNumber + "\t" + myTitle + "\t" + myCredits + "\t" + myDays + "\t" + myTime + "\t" + myRoom + "\t" + mySeats;
    }
    public boolean removeStudent(Student student)
    {
	filledSeats--;
	return true;
	//return enrolledStudents.remove(student);
    }
    public int getSeatsLeft()
    {
	return mySeats - filledSeats;
	//return mySeats - enrolledStudents.size();
    }
    public String getTitle()
    {
	return myTitle;
    }
    public String getCourseNumber()
    {
	return myNumber;
    }
    public String getDays()
    {
	return myDays;
    }
    public double getTimes()
    {
	return myTime;
    }
    public int getCredits()
    {
	return myCredits;
    }
    public String getRoom()
    {
	return myRoom;
    }
    public int getSeats()
    {
	return mySeats;
    }
}