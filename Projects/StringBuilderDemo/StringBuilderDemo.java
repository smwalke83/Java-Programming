import javax.swing.JOptionPane;

public class StringBuilderDemo
{
	static class Student 
	{
		String name;
		int age;
		
		public Student(String name, int age)
		{
			this.name = name;
			this.age = age;
		}
		
		@Override
		public String toString()
		{
			// didn't see the whole line
			return "Student(name:
		}
	}
	
	public static void main(String[] args)
	{
		String firstName = "John";
		String lastName = "Doe";
		
		String fullName = firstName + " " + lastName;
		
		System.out.println("Using String: ")
		System.out.println(fullname);
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("Welcome ");
		builder.append(firstName);
		builder.append(" ");
		builder.append(lastName);
		builder.append("!");
		
		System.out.println("\nUsing StringBuilder: ");
		System.out.println(builder.toString());
		
		JOptionPane.showMessageDialog(null, "Hello, " + fullName, "Greeting", JOptionPane.INFORMATION_MESSAGE);
		
		Student student1 = new Student("Alice", 20);
		
		System.out.println("\nStudent Object: ");
		System.out.println(student1);
		
		String studentInfo = student1.toString();
		
		JOptionPane.showMessageDialog(null, studentInfo, "Student Information", JOptionPane.INFORMATION_MESSAGE);
		
		StringBuilder message = new StringBuilder("Java Programming");
		
		message.insert(5, "Awesome ");
		message.replace(0, 4, "Advanced");
		message.delete(9, 17);
		
		System.out.println("\nModified StringBuilder: ");
		System.out.println(message.toString());
	}
}