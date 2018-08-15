package ag_al.com.retrofittest.api;


import ag_al.com.retrofittest.model.ResultsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {


    @GET("/search/anime")
    Call<ResultsResponse> getJson(@Query("q")String anime);
}
