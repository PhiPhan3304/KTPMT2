
import com.mycompany.unittestdemo.UnitTestDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class TestSuite {
    @Test
    public void testBangKhong(){
        int n =0 ;
        double expectedOutput = 1.0;
        double actualOutput = UnitTestDemo.Power(2, n);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testLonHonKhong(){
        int n =1 ;
        double expectedOutput = 3.0;
        double actualOutput = UnitTestDemo.Power(3, n);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void testNhoHonKhong(){
        int n =-2 ;
        double expectedOutput = 0.25;
        double actualOutput = UnitTestDemo.Power(2, n);
     
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
    
    
}
