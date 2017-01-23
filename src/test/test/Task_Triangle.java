package test;

import com.softserve.edu.task3.Task3_1;
import com.softserve.edu.task3.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.softserve.edu.task3.Task3_1.*;

/**
 * Created by Natalia on 20.01.2017.
 */
public class Task_Triangle {
    @Test
    public void the_correct_values_triangle() throws Exception {
        String str = "First,2,3,4";
        double expected = 2.9d;
        //Task3_1 task3_1 = new Task3_1();
        Triangle triangle = new Triangle(str);
        //Act
        double actual = Task3_1.Heron(triangle);
        //Assert
        Assert.assertEquals(actual, expected, 0.01);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void there_is_no_triangle() throws Exception {
        String str = "First,10,1,1";

        Triangle triangle = new Triangle(str);
        //Act
        double actual = Task3_1.Heron(triangle);
        //Assert

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void there_is_no_triangle_0_Exeption() throws Exception {
        String str = "First,0,1,1";

        Triangle triangle = new Triangle(str);
        //Act
        double actual = Task3_1.Heron(triangle);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void there_is_no_triangle_0_Exeption2() throws Exception {
        String str = "First,0,1,0";

        Triangle triangle = new Triangle(str);
        //Act
        double actual = Task3_1.Heron(triangle);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void string_instead_of_the_length_of_the_side_Exeption3() throws Exception {
        String str = "First,0,dfhgjdhfg,0";

        Triangle triangle = new Triangle(str);
        //Act
        double actual = Task3_1.Heron(triangle);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negative_meaning_triangle_Exeption4() throws Exception {
        String str = "First,6,6,-1";

        Triangle triangle = new Triangle(str);
        //Act
        double actual = Task3_1.Heron(triangle);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void negative_meaning_triangle_Exeption6() throws Exception {
        String str = "475,6,6,-1";

        Triangle triangle = new Triangle(str);
        //Act
        double actual = Task3_1.Heron(triangle);
    }
    }


