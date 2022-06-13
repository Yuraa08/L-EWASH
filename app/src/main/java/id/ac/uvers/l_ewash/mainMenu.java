package id.ac.uvers.l_ewash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.ac.uvers.l_ewash.model.LaundrylistsItem;
import id.ac.uvers.l_ewash.model.ResponseLaundryList;
import id.ac.uvers.l_ewash.retrofit.ApiEndpoint;
import id.ac.uvers.l_ewash.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class mainMenu extends AppCompatActivity {

    Button produk, pesanan, laporan;
    TextView namalaundry;
    private String userlaundry, namaldr1;

    private List<LaundrylistsItem> ldrylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent ii = getIntent();
        userlaundry = ii.getStringExtra("userlaundry");

        produk = findViewById(R.id.btnproduk);
        pesanan = findViewById(R.id.btnpesanan);
        laporan = findViewById(R.id.btnlaporan);
        namalaundry = findViewById(R.id.namalaundry1);

//        namalaundry.setText(userldr);

        get_laundry_data();

        produk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namaldr1 =namalaundry.getText().toString().trim();

//                Intent iii = new Intent(mainMenu.this, id.ac.uvers.l_ewash.produk.class);
//                iii.putExtra("namalaundry",namaldr1);
//                startActivity(iii);
            }
        });

        pesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mainMenu.this, id.ac.uvers.l_ewash.pesanan.class);
                startActivity(i);
            }
        });

        laporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii = new Intent(mainMenu.this, id.ac.uvers.l_ewash.laporan.class);
                startActivity(iii);
            }
        });

    }

    private void get_laundry_data() {

        ApiEndpoint apidata = ApiService.getClient().create(ApiEndpoint.class);
        Call<ResponseLaundryList> tdata = apidata.ldrylist(userlaundry);

        tdata.enqueue(new Callback<ResponseLaundryList>() {
            @Override
            public void onResponse(Call<ResponseLaundryList> call, Response<ResponseLaundryList> response) {
                int id_laundry = response.body().getIdLaundry();
                String msg = response.body().getMsg();

                ldrylist = response.body().getLaundrylists();
                LaundrylistsItem laundry_data = ldrylist.get(0);

                namalaundry.setText(laundry_data.getNamalaundry());

            }

            @Override
            public void onFailure(Call<ResponseLaundryList> call, Throwable t) {
                Toast.makeText(mainMenu.this, "GAGAL KONEK" + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("Error.ResponseLdryList", t.toString());
            }
        });
    }
}




