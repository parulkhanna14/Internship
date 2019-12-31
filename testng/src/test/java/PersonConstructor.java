import mockit.Mock;
import mockit.MockUp;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PersonConstructor {
    @Test
    public void testname()
    {
        new MockUp<Person>(){
            @Mock
            public void $init(String name)
            {

            }
        };
        Person p=new Person("John doe");
        String nm=p.getName();
        System.out.println(nm);
    }
}
