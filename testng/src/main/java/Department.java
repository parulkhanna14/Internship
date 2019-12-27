/************* "Department.java" *********/
public class Department{
    Person person = new Person("a");//Person is the 'collaborator'- a fancy name for third party object

    public String getPersonName(){
        return person.getName();
    }
}