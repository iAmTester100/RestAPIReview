package test;

import files.payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SumOfIDs {

    @Test
    public void sumOfIds(){

        int sum = 0;
        JsonPath js2 = new JsonPath(payload.listOfResonseInfo());

        int count = js2.getInt("data.size()");

        for (int i=0;i<count;i++){
            int id = js2.getInt("data["+i+"].id");
            int year = js2.getInt("data["+i+"].year");
            int multiply = id * year;
            System.out.println(multiply);
            sum = sum + multiply;

        }
        System.out.println(sum);

        int total = 42070;
        Assert.assertEquals(total,sum);


    }
}
