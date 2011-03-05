package CourseReg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * <p>Title: CourseReg</p>
 * <p>Description: A course registration system.</p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p> </p>
 * @author John McGonegal
 * @version 1.0
 */

public class RegistrarGUI extends JFrame
{
    private JButton myLogin = new JButton("Login");
    private JButton myLogout = new JButton("Logout");
    private JButton myAdd = new JButton("Add");
    private JButton myDel = new JButton("Delete");
    private JButton myWeek = new JButton("View Week");
    private JTextField findCourse = new JTextField();
    private JList myScedule = new JList();
    private JList myCourses;
    private Registrar registration;
    private Student currentStudent;
    public RegistrarGUI(Registrar reg)
    {
	super("Registration");
	registration = reg;
	setSize(800,600);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container pane = getContentPane();
	GridBagLayout gb = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();
	c.fill = GridBagConstraints.HORIZONTAL;
	setResizable(false);
	pane.setLayout(gb);
	JPanel left = new JPanel(new GridLayout(2,1,2,2));
	JPanel right = new JPanel(new GridLayout(2,1,2,2));
	c.gridx = 0;
	c.gridy = 0;
	gb.setConstraints(left, c);
	pane.add(left);
	c.gridx = 1;
	c.gridy = 0;
	gb.setConstraints(right, c);
	pane.add(right);

	myCourses = new JList(registration.getAllCourses());

	JScrollPane scrollPane1 = new JScrollPane(myCourses);
	JScrollPane scrollPane2 = new JScrollPane(myScedule);
	c.gridx = 0;
	c.gridy = 1;
	gb.setConstraints(scrollPane1, c);
	pane.add(scrollPane1);
	c.gridx = 1;
	c.gridy = 1;
	gb.setConstraints(scrollPane2, c);
	pane.add(scrollPane2);

	JLabel cl = new JLabel(registration.getName() + " Class List");
	cl.setHorizontalAlignment(JLabel.CENTER);
	left.add(cl);
	JPanel bLeft = new JPanel(new GridLayout(1,4,5,5));

	left.add(bLeft);
	bLeft.add(myLogin);
	bLeft.add(myLogout);
	bLeft.add(new JLabel("Find Course"));
	bLeft.add(findCourse);
	JLabel sc = new JLabel("Schedule");


	sc.setHorizontalAlignment(JLabel.CENTER);
	right.add(sc);
	JPanel bRight = new JPanel(new GridLayout(1,3,5,5));

	right.add(bRight);
	bRight.add(myAdd);
	bRight.add(myDel);
	bRight.add(myWeek);

	myLogin.addActionListener(new LoginButton());
	myLogout.addActionListener(new LogoutButton());
	myAdd.addActionListener(new AddButton());
	myDel.addActionListener(new DelButton());
	myWeek.addActionListener(new ViewButton());
	findCourse.addActionListener(new FindButton());
	updateStudentGUI();
	pack();
	show();
    }

    // updates the status of buttons and lists
    private void updateStudentGUI()
    {
	// TODO: move the selection on each list so they update themselves
	if(currentStudent==null)
	{
	    myLogin.setEnabled(true);
	    myLogout.setEnabled(false);
	    myAdd.setEnabled(false);
	    myDel.setEnabled(false);
	    myWeek.setEnabled(false);
	}
	else
	{
	    myLogin.setEnabled(false);
	    myLogout.setEnabled(true);
	    myAdd.setEnabled(true);
	    myDel.setEnabled(true);
	    myWeek.setEnabled(true);
	    DefaultListModel listModel = new DefaultListModel();
	    for(int i = 0; i < currentStudent.getCourses().size(); i++)
	    {
		listModel.addElement(currentStudent.getCourses().get(i));
	    }
	    myScedule.setModel(listModel);
	}
    }
    private class LoginButton implements ActionListener
    {
	public void actionPerformed(ActionEvent ae)
	{
	    String name = JOptionPane.showInputDialog(null,"What is your name?","Login",JOptionPane.QUESTION_MESSAGE);
	    Student student = registration.getStudentWithName(name);
	    if(student == null)
	    {
		JOptionPane.showMessageDialog(null,"User does not exist");
	    }
	    else
	    {
		String pin = JOptionPane.showInputDialog(null,"Hello " + student.getName() + ", what is your pin?","Login",JOptionPane.QUESTION_MESSAGE);
		if(student.getPin().equals(pin))
		{
		    currentStudent = student;
		    updateStudentGUI();
		}
		else
		{
		    JOptionPane.showMessageDialog(null,"Invalid PIN");
		}
	    }
	}
    }

    private class LogoutButton implements ActionListener
    {
	public void actionPerformed(ActionEvent ae)
	{
	    currentStudent = null;
	    updateStudentGUI();
	}
    }

    private class AddButton implements ActionListener
    {
	public void actionPerformed(ActionEvent ae)
	{
	    // TODO: check if a class is really selected
	    Course temp = (Course) myCourses.getSelectedValue();
	    //JOptionPane.showMessageDialog(null,temp.getTitle());
	    if(!currentStudent.addCourse(temp))
	    {
		JOptionPane.showMessageDialog(null,"Can't add course. It's either full, at a conflicting time, or it makes you exceed " + Student.MAXCREDITS + " credits.");
	    }
	    else
	    {
		updateStudentGUI();
	    }
	}
    }

    private class DelButton implements ActionListener
    {
	public void actionPerformed(ActionEvent ae)
	{
	    // TODO: check if a class is really selected
	    Course temp = (Course) myScedule.getSelectedValue();
	    currentStudent.removeCourse(temp);
	    updateStudentGUI();
	}
    }

    private class ViewButton implements ActionListener
    {
	public void actionPerformed(ActionEvent ae)
	{

	}
    }
    // finds the course number and selects it, IE Math 101
    private class FindButton implements ActionListener
    {
	public void actionPerformed(ActionEvent ae)
	{
	    int index = myCourses.getNextMatch(findCourse.getText(),0,javax.swing.text.Position.Bias.Forward);
	    myCourses.setSelectedIndex(index);
	}
    }
}