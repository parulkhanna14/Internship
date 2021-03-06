import mockit.Expectations;
import mockit.Mocked;
//import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
/************* "DepartmentTest.java" *********/
public class DepartmentTest{
    @Mocked
    Person person;//The mocked object.Note that I am NOT using new to create an instance.


    @Test
    public void testGetName(){
        Department  dept = new Department();
        new Expectations(){
            //locally defined objects are automatically considered mocked
            {
                person.getName();//Setting the expected behaviour here.
                returns("Nandan");//Will return Nandan instead of Abhi
            }
        };

        String name = dept.getPersonName();
        System.out.println(name);
        Assert.assertEquals("Name Should be Nandan","Nandan",name);

    }
}