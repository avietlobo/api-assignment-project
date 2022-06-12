package api.assignment;


import api.constants.Constants;
import api.constants.EndPoint;
import api.utils.ApiRequest;
import api.utils.TestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Api test for simple App.
 */
public class ApiTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://staging.unvrs.io";
    }


    @Test
    public void addComment() {
        Response response = ApiRequest.post(EndPoint.COMMENTS.url, TestData.getCommentRequestPayload());
        Assert.assertEquals(Constants.POST_ID, response.jsonPath().getString("postId"));
        Assert.assertTrue(response.jsonPath().getString("content").contains(Constants.COMMENT));
        Assert.assertEquals(200, response.statusCode());
    }
}
