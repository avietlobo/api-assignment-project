package api.assignment;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

import api.constants.EndPoint;
import api.utils.ApiRequest;
import api.utils.PropertyUtils;
import api.utils.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Api test for simple App.
 */
public class ApiTest
{

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://staging.unvrs.io";
    }


    @Test
    public void addComment()
    {
        String expectedPostId="72317180";
        String comment="Hello";
        Response response =ApiRequest.post(EndPoint.COMMENTS.url,TestData.getCommentRequestPayload());
        Assert.assertEquals(expectedPostId, response.jsonPath().getString("postId"));
        Assert.assertTrue(response.jsonPath().getString("content").contains(comment));
        Assert.assertEquals(200, response.statusCode());
    }
}
