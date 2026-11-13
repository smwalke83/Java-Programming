package employeeinheritance;

/***************************************************************
* FullTimeDriver.java
*
* The describes a full-time employee.
***************************************************************/

public class FullTimeDriver
{
  public static void main(String[] args)
  {
    FullTime fullTimer = new FullTime("Pat", 5733, 80000);
    fullTimer.display();
    System.out.println(fullTimer.getName());
  }
} // end FullTimeDriver class