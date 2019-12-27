public class SampleClass
{
    String name="John Doe";
    public String getname()
    {
        return name;
    }
    public String mergeStrings(String str1, String str2)
    {
        return str1.concat(str2);
    }
    public String mergeStringsWithDash(String str1, String str2)
    {
        return str1.concat("-").concat(str2);
    }
}