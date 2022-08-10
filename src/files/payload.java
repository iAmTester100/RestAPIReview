package files;

public class payload {

    public static String addUser(){

        return "{\n" +
                "    \"name\": \"Abhishek\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
    }

    public static String updateUser(){

        return "{\n" +
        "    \"name\": \"Ajay\",\n" +
                "    \"job\": \"Lead\"\n" +
                "}";
    }

    public static String deleteUser(){

        return "{\n" +
                "    \"name\": \"Abhishek\",\n" +
                "    \"job\": \"Lead\"\n" +
                "}";
    }

    public static String responseInfo(){

        return "{\n" +
                "    \"data\": {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"fuchsia rose\",\n" +
                "        \"year\": 2001,\n" +
                "        \"color\": \"#C74375\",\n" +
                "        \"pantone_value\": \"17-2031\"\n" +
                "    },\n" +
                "    \"support\": {\n" +
                "        \"url\": \"https://reqres.in/#support-heading\",\n" +
                "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                "    }\n" +
                "}";

    }
}
