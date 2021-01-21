public class Test02 {
    public static void main(String[] args) {
        String path = "/F:/project/order-service/target/classes/";

        String path2 = path.substring(1, path.indexOf("/target/classes/")) + "/src/main/resources/ding/dingTemplate.json";
        System.out.println(path2);


        String str = "file:/usr/share/dapeng-microservice/orderservice.jar!/BOOT-INF/classes!/";

        str = str.substring(5, str.length()).replaceAll("!", "");

        System.out.println(str);

    }
}
