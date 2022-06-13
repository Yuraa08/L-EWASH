package id.ac.uvers.l_ewash.retrofit;

import id.ac.uvers.l_ewash.model.ResponseLaundryList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoint {

    @GET("selectlaundry.php")
    Call<ResponseLaundryList> ldrylist(@Query("userlaundry") String userlaundry);

}
