package test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class JsonPathComplex {

    public static void main(String[] args) {

        io.restassured.path.json.JsonPath jsonPath = new io.restassured.path.json.JsonPath(payload.responseInfo());

        int size = jsonPath.getInt("data.size()");

        String name = jsonPath.getString("data.name");

        String urlString = jsonPath.getString("support.url");
        String text = jsonPath.getString("support.text");

        System.out.println(size);
        System.out.println(name);
        System.out.println(urlString);
        System.out.println(text);


        JsonPath js2 = new JsonPath(payload.listOfResonseInfo());

        int count = js2.getInt("data.size()");

        System.out.println(count);

        for (int i=0;i<count;i ++){

           String userName = js2.get("data["+i+"].name");
           int id = js2.getInt("data["+i+"].id");
           int year = js2.getInt("data["+i+"].year");


            System.out.println(userName);
            System.out.println(id);
            System.out.println(year);



        }

        for (int i=0;i<count;i ++){

            String colour = js2.get("data["+i+"].color");
            if(colour.equalsIgnoreCase("#98B2D1")){
                String values = js2.get("data["+i+"].pantone_value");
                System.out.println(values);
                break;
            }
        }

    }


}
