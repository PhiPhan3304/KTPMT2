
import com.mycompany.unittestdemo.Radix;
import com.mycompany.unittestdemo.UnitTestDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class TestParam {
    @ParameterizedTest
    @ValueSource(ints = {-1, 1, 17})
    public void testThrowExp(int n){
        Assertions.assertThrows(ArithmeticException.class, () ->{
            new Radix(n);
        }); 
    }

}
