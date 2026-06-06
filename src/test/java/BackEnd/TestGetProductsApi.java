package BackEnd;

import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.template.framework.BackEnd.Enums.RestMethods;
import org.template.framework.BackEnd.Pojo.Products;
import org.template.framework.BackEnd.RestRequest.RestReq;
import org.template.framework.Utility.Annotation.Author;
import org.template.framework.Utility.BackEnd.BackEndUtils;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.template.framework.BackEnd.RestExecutor.RestExe.executeRestCall;

@Author(name = "Ankit Dwivedi",
        date = "2026-05-22",
        email = "ankitdwivedi46@live.com")
public class TestGetProductsApi {

    private String BASE_URL = "https://dummyjson.com";
    private String BASE_PATH = "/products/category/smartphones";
    private RestMethods REST_METHOD = RestMethods.GET;
    private boolean USE_RELAXED_HTTP_VALIDATION_FLAG = true;
    private Map<String,String> HEADERS = new HashMap<>();
    private Map<String,String> QUERY_PARAMS = new HashMap<>();
    private List<Products> productsList;
    private Response response;
    private String GET_RESPONSE_BASE_KEY= "products";
    private String PRODUCT_QUERY_PARAM_KEY = "q";
    private String PRODUCT_QUERY_PARAM_VALUE = "Iphone";
    private String PRODUCT_LIMIT_QUERY_PARAM_KEY = "limit";
    private String PRODUCT_LIMIT_QUERY_PARAM_VALUE = "5";
    private int SUCCESS_STATUS_CODE = 200;

    @Test
    public void testGetProductApi(){
        HEADERS = BackEndUtils.setCommonApiHeaders();
        QUERY_PARAMS.put(PRODUCT_QUERY_PARAM_KEY,PRODUCT_QUERY_PARAM_VALUE);
        QUERY_PARAMS.put(PRODUCT_LIMIT_QUERY_PARAM_KEY,PRODUCT_LIMIT_QUERY_PARAM_VALUE);

        response = executeRestCall(RestReq.builder()
                .setBaseUrl(BASE_URL)
                .setBasePath(BASE_PATH)
                .setHeaders(HEADERS)
                .setQueryParam(QUERY_PARAMS)
                .setUseRelaxedHttpValidation(USE_RELAXED_HTTP_VALIDATION_FLAG)
                .setRestMethod(REST_METHOD).build());

        MatcherAssert.assertThat(response.statusCode(), Matchers.equalTo(SUCCESS_STATUS_CODE));
        productsList = response.jsonPath().getList(GET_RESPONSE_BASE_KEY,Products.class);
    }

    @Test(dependsOnMethods = "testGetProductApi")
    public void testResponseId(){
        for(int i = 0; i < productsList.size(); i++){
            MatcherAssert.assertThat(productsList.get(i).getID(),Matchers.greaterThan(0));
        }
    }

   @Test(dependsOnMethods = "testGetProductApi")
   public void testResponseCategory() {
    try {
        for (int i = 0; i < productsList.size(); i++) {
            MatcherAssert.assertThat(
                productsList.get(i).getCATEGORY(),
                Matchers.equalToIgnoringCase("smartphones")
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("Exception occurred while validating category: " + e.getMessage());
    }
}

    @Test(dependsOnMethods = "testGetProductApi")
    public void testResponseBrand(){
        for(int i = 0; i < productsList.size(); i++){
            MatcherAssert.assertThat(productsList.get(i).getBRAND(),Matchers.equalToIgnoringCase("APPLE"));
        }
    }

    @Test(dependsOnMethods = "testGetProductApi")
    public void testResponseDimensionWidth(){
        for(int i = 0; i < productsList.size(); i++){
            MatcherAssert.assertThat(productsList.get(i).getDIMENSIONS().getWIDTH(),Matchers.greaterThan(5.0));
        }
    }

    @Test(dependsOnMethods = "testGetProductApi")
    public void testResponseDimensionHeight(){
        for(int i = 0; i < productsList.size(); i++){
            MatcherAssert.assertThat(productsList.get(i).getDIMENSIONS().getHEIGHT(),Matchers.greaterThan(18.0));
        }
    }

    @Test(dependsOnMethods = "testGetProductApi")
    public void testResponseDimensionDepth(){
        for(int i = 0; i < productsList.size(); i++){
            MatcherAssert.assertThat(productsList.get(i).getDIMENSIONS().getDEPTH(),Matchers.greaterThan(17.0));
        }
    }

    @Test(dependsOnMethods = "testGetProductApi")
    public void testResponseReviewsRating(){
        for(int i = 0; i < productsList.size(); i++){
            for(int j = 0; j < productsList.get(i).getREVIEWS().size(); i++){
                MatcherAssert.assertThat(productsList.get(i).getREVIEWS().get(j).getRATING(),Matchers.greaterThan(4));
            }

        }
    }


}
