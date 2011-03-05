package CourseReg;
import java.util.ArrayList;
/**
 * <p>Title: CourseReg</p>
 * <p>Description: A course registration system.</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p> </p>
 * @author John McGonegal
 * @version 1.0
 */

public class RegistrarCollection
{
    private ArrayList Semesters;
    public RegistrarCollection()
    {
	Semesters = new ArrayList();
    }
    public void add(Registrar reg)
    {
	Semesters.add(reg);
    }
    public int size()
    {
	return Semesters.size();
    }
    public Registrar get(int i)
    {
	return (Registrar) Semesters.get(i);
    }
}