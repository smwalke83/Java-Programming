package employeeinheritance;

/*******************************************************
* Person.java
*
* This is a base class for an inheritance hierarchy.
*******************************************************/

public class Person
{
  private String name = "";

  //****************************************************

  public Person()
  { }

  public Person(String name)
  {
    this.name = name;
  }

  //****************************************************

  public String getName()
  {
    return this.name;
  }
} // end Person class