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

    public static String listOfResonseInfo(){

        return "{\n" +
                "    \"page\": 1,\n" +
                "    \"per_page\": 6,\n" +
                "    \"total\": 12,\n" +
                "    \"total_pages\": 2,\n" +
                "    \"data\": [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"name\": \"cerulean\",\n" +
                "            \"year\": 2000,\n" +
                "            \"color\": \"#98B2D1\",\n" +
                "            \"pantone_value\": \"15-4020\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"name\": \"fuchsia rose\",\n" +
                "            \"year\": 2001,\n" +
                "            \"color\": \"#C74375\",\n" +
                "            \"pantone_value\": \"17-2031\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 3,\n" +
                "            \"name\": \"true red\",\n" +
                "            \"year\": 2002,\n" +
                "            \"color\": \"#BF1932\",\n" +
                "            \"pantone_value\": \"19-1664\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 4,\n" +
                "            \"name\": \"aqua sky\",\n" +
                "            \"year\": 2003,\n" +
                "            \"color\": \"#7BC4C4\",\n" +
                "            \"pantone_value\": \"14-4811\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 5,\n" +
                "            \"name\": \"tigerlily\",\n" +
                "            \"year\": 2004,\n" +
                "            \"color\": \"#E2583E\",\n" +
                "            \"pantone_value\": \"17-1456\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 6,\n" +
                "            \"name\": \"blue turquoise\",\n" +
                "            \"year\": 2005,\n" +
                "            \"color\": \"#53B0AE\",\n" +
                "            \"pantone_value\": \"15-5217\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"support\": {\n" +
                "        \"url\": \"https://reqres.in/#support-heading\",\n" +
                "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\n" +
                "    }\n" +
                "}";
    }

    public static String addUserDynamic(String name, String position){

        String newUser = "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+position+"\"\n" +
                "}";
        return newUser;
    }
}
