package test;

import files.payload;

public class JsonPathComplex {

    public static void main(String[] args) {

        io.restassured.path.json.JsonPath jsonPath = new io.restassured.path.json.JsonPath(payload.responseInfo());

        int size = jsonPath.getInt("data.size()");

        String name = jsonPath.getString("data.name");

        String urlString = jsonPath.getString("support.url");

        System.out.println(size);
        System.out.println(name);
        System.out.println(urlString);


    }


}
