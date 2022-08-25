import org.junit.*;
import static org.junit.Assert.*;

public class Tests
{
    
    @Test
    public void test1()
    {
        Solution solution = new Solution();

        assertEquals("3a2bc4d", solution.runLengthEncoding("aaabbcdddd"));
    }
}
