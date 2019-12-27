import mockit.Expectations;
import mockit.Mocked;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
public class TestSampleClass implements ITestListener {
    public static void main(String[] args) {
        
    }
    SampleClass sc;
    String str1, str2,name;
    @BeforeTest //(groups = "stringgroup")
    public void initStringsAndObjects()
    {
        sc = new SampleClass();
        str1 = "abc";
        str2 = "def";
        name="John Doe";
    }
    @Test (priority = 1)//(groups = "stringgroup")
    private void testMergeStrings()
    {
        Assert.assertNotNull(sc.mergeStrings(str1, str2));
        Assert.assertEquals(sc.mergeStrings(str1, str2), "abcdef");

    }
    @Test(priority = 2)
    public void testMergeStringsWithDash()
    {
        Assert.assertNotNull(sc.mergeStringsWithDash(str1, str2));
        Assert.assertEquals(sc.mergeStringsWithDash(str1, str2), "abc-def");
        Assert.assertNotSame(sc.mergeStringsWithDash(str1, str2), "abcdef");
    }
    @AfterTest
    public void cleanup()
    {
        str1 = null;
        str2 = null;
        sc = null;
        name=null;
    }

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test successful!"+iTestResult.getName());
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Oops! Test failed!");

    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        System.out.println("starting");
    }

    public void onFinish(ITestContext iTestContext) {

    }
}