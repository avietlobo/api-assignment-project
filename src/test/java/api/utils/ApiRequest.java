package api.utils;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiRequest extends SpecBuilder{

    public static Response post(String endPoint,String body){
        return given(getRequestSpec()).
                headers(getHeaders())
        .body(body).
        when().
                post(endPoint).
        then().spec(getResponseSpec()).
                extract().
                response();
    }

    public static Headers getHeaders(){
        Header h1= new Header("Content-type", "application/json");
        Header h2 = new Header("x-csrf-token", "9ee65373250115b7537ae047289be783");
        Header h3 = new Header("cookie", "G_ENABLED_IDPS=google; _ga=GA1.2.318986142.1654523772; _gid=GA1.2.2035183058.1654857997; unvrsession=292ef308104c48119db6b33bfa520d47.5af5e082284138d1842684e7f4933672331fa808; xsrftoken=9ee65373250115b7537ae047289be783; happeo.nogoogleprompt=true");
        List<Header> list = new ArrayList<Header>();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        Headers header = new Headers(list);
        return header;
    }

}
