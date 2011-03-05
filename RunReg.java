package CourseReg;

/**
 * <p>Title: CourseReg</p>
 * <p>Description: A course registration system.</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p> </p>
 * @author John McGonegal
 * @version 1.0
 */

public class RunReg
{
    public static void main(String[] args)
    {
	Registrar fall03 = new Registrar("Fall 03");
	fall03.addCourse(new Course("Intro to Anthropology","ANTH 101",3,"MWF",9,"AE 1501",2,0));
	fall03.addCourse(new Course("One-Dimensional Design","ART 102",4,"MWF",9,"MS 341",2,1));
	fall03.addCourse(new Course("Two-Dimensional Design","ART 202",4,"TTh",12,"KE 556",2,1));
	fall03.addCourse(new Course("Audiology","AUD 114",3,"TTh",12,"GHC 3201",2,2));
	fall03.addCourse(new Course("Calculus I","MATH 125",3,"MWF",11,"ECON 221",30,15));
	fall03.addCourse(new Course("Calculus II","MATH 129",3,"MWF",11,"ECON 201",25,23));
	fall03.addCourse(new Course("Vector Calculus","MATH 223",3,"TTh",11,"MATH 221",30,29));
	fall03.addCourse(new Course("Intro to Computer Science","CSC 129",3,"TTh",8,"BIOW 109",10,8));
	fall03.addCourse(new Course("Advanced Computer Science","CSC 335",3,"TTh",9,"BIOE 221",45,40));
	fall03.addCourse(new Course("First Year Composition","ENGL 101",3,"MWF",14,"HARV 221",25,23));
	fall03.addCourse(new Course("First Year Composition","ENGL 102",3,"MWF",14,"HARV 225",27,25));

	/*Course math = new Course("Math","MATH 100",3,"MWF",11.00,"ECON 100",50);
	Course math2 = new Course("Math2","MATH 102",3,"MWF",10.00,"ECON 101",40);
	Course math3 = new Course("Math3","MATH 108",3,"MWF",9.00,"ECON 102",5);
	Course math4 = new Course("Math4","MATH 110",3,"MWF",13.00,"ECON 103",3);*/
	Student john = new Student("John","123");
	/*fall03.addCourse(math);
	fall03.addCourse(math2);
	fall03.addCourse(math3);
	fall03.addCourse(math4);*/
	/*for(int i = 1; i <= 50; i++)
	{
	    fall03.addCourse(new Course("Some Random Class","RAND"+i,3,"MWF",13.00,"ECON 103",3));
	}*/
	fall03.addStudent(john);
	fall03.addStudent(new Student("James","123"));
	fall03.addStudent(new Student("Andrew","123"));
	fall03.addStudent(new Student("Drew","123"));
	fall03.addStudent(new Student("Tyler","123"));
	//john.addCourse(math,"Fall 03");
	//john.addCourse(math2,"Fall 03");
	RegistrarGUI registrarGUI = new RegistrarGUI(fall03);

    }
}