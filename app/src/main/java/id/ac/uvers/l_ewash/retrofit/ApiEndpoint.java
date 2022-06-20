package id.ac.uvers.l_ewash.retrofit;

import id.ac.uvers.l_ewash.model.ResponseLaundryList;
import id.ac.uvers.l_ewash.model.ResponsePriceList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoint {

    @GET("selectlaundry.php")
    Call<ResponseLaundryList> ldrylist(@Query("userlaundry") String userlaundry);

//    @GET("selectlaundry1.php")
//    Call<ResponseLaundryList> ldrylist();

    @GET("pricelist.php")
    Call<ResponsePriceList> pllist(@Query("namalaundry") String namalaundry);

}
