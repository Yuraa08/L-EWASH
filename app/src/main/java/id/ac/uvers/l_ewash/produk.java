package id.ac.uvers.l_ewash;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import id.ac.uvers.l_ewash.model.PricelistItem;
import id.ac.uvers.l_ewash.model.ResponsePriceList;
import id.ac.uvers.l_ewash.retrofit.ApiEndpoint;
import id.ac.uvers.l_ewash.retrofit.ApiService;
import retrofit2.Call;
import retrofit2.Callback;

public class produk extends AppCompatActivity {

    EditText bajuN, bajuE, bonekaN, bonekaE, bedcoverN, bedcoverE, selimutbN, selimutbE, selimutkN, selimutkE, gordenN, gordenE, setrikaN, setrikaE;
    TextView namalaundry1;
    private String namaldr;
    Button inserthrg, updatehrg;
    private String namalaundry, baju_n, baju_e, boneka_n, boneka_e, bedcover_n, bedcover_e, selimutb_n, selimutb_e, selimutk_n, selimutk_e, gorden_n, gorden_e, setrika_n, setrika_e;

    private List<PricelistItem> pllist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk);

        Intent iii = getIntent();
        namaldr = iii.getStringExtra("namalaundry");

        namalaundry1 = findViewById(R.id.namalaundry);
        bajuN = findViewById(R.id.bajuN);
        bajuE = findViewById(R.id.bajuE);
        bonekaN = findViewById(R.id.bonekaN);
        bonekaE = findViewById(R.id.bonekaE);
        bedcoverN = findViewById(R.id.bedcoverN);
        bedcoverE = findViewById(R.id.bedcoverE);
        selimutbN = findViewById(R.id.selimutbN);
        selimutbE = findViewById(R.id.selimutbE);
        selimutkN = findViewById(R.id.selimutkN);
        selimutkE = findViewById(R.id.selimutkE);
        gordenN = findViewById(R.id.gordenN);
        gordenE = findViewById(R.id.gordenE);
        setrikaN = findViewById(R.id.setrikaN);
        setrikaE = findViewById(R.id.setrikaE);
        inserthrg = findViewById(R.id.btninserthrg);
        updatehrg = findViewById(R.id.btnupdatehrg);

        namalaundry1.setText(namaldr);

        getpricelist();

        inserthrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namalaundry = namalaundry1.getText().toString().trim();
                baju_n = bajuN.getText().toString().trim();
                baju_e = bajuE.getText().toString().trim();
                boneka_n = bonekaN.getText().toString().trim();
                boneka_e = bonekaE.getText().toString().trim();
                bedcover_n = bedcoverN.getText().toString().trim();
                bedcover_e = bedcoverE.getText().toString().trim();
                selimutb_n = selimutbN.getText().toString().trim();
                selimutb_e = selimutbE.getText().toString().trim();
                selimutk_n = selimutkN.getText().toString().trim();
                selimutk_e = selimutkE.getText().toString().trim();
                gorden_n = gordenN.getText().toString().trim();
                gorden_e = gordenE.getText().toString().trim();
                setrika_n = setrikaN.getText().toString().trim();
                setrika_e = setrikaE.getText().toString().trim();

                if (baju_n.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (baju_e.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (boneka_n.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (boneka_e.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (bedcover_n.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (bedcover_e.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (selimutb_n.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (selimutb_e.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (selimutk_n.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (selimutk_e.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (gorden_n.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (gorden_e.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (setrika_n.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else if (setrika_e.equals("")) {
                    Toast.makeText(produk.this, "Silahkan Masukkan Harga", Toast.LENGTH_LONG).show();
                } else {

                    RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
                    JsonObjectRequest jar = new JsonObjectRequest(Request.Method.GET,
                            urlcrud.insertLharga(namalaundry, baju_n, baju_e, boneka_n, boneka_e, bedcover_n, bedcover_e, selimutb_n, selimutb_e, selimutk_n, selimutk_e, gorden_n, gorden_e, setrika_n, setrika_e), null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                int berhasil = response.getInt("sukses");
                                String pesan = response.getString("pesan");
                                Toast.makeText(produk.this, pesan, LENGTH_LONG).show();
                                Intent i = new Intent(produk.this, mainMenu.class);
                                startActivity(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Error.response", error.toString());
                            Toast.makeText(produk.this, "Periksa Koneksi Internet Anda !", LENGTH_LONG).show();

                        }
                    });
                    rq.add(jar);
                }
            }
        });

        updatehrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void getpricelist() {
        ApiEndpoint apidata = ApiService.getClient().create(ApiEndpoint.class);
        Call<ResponsePriceList> tdata = apidata.pllist(namaldr);

        tdata.enqueue(new Callback<ResponsePriceList>() {
            @Override
            public void onResponse(Call<ResponsePriceList> call, retrofit2.Response<ResponsePriceList> response) {
                int id_laundry = response.body().getId();
                String msg = response.body().getMsg();

                pllist = response.body().getPricelist();
                PricelistItem current_laundry = pllist.get(0);

                bajuN.setText(current_laundry.getBajuN());
                bajuE.setText(current_laundry.getBajuE());
                bonekaN.setText(current_laundry.getBonekaN());
                bonekaE.setText(current_laundry.getBonekaE());
                bedcoverN.setText(current_laundry.getBedcoverN());
                bedcoverE.setText(current_laundry.getBedcoverE());
                selimutbN.setText(current_laundry.getSelimutbN());
                selimutbE.setText(current_laundry.getSelimutbE());
                selimutkN.setText(current_laundry.getSelimutkN());
                selimutkE.setText(current_laundry.getSelimutkE());
                gordenN.setText(current_laundry.getGordenN());
                gordenE.setText(current_laundry.getGordenE());
                setrikaN.setText(current_laundry.getSetrikaN());
                setrikaE.setText(current_laundry.getSetrikaE());

//                Log.i("terserah",current_laundry.getSetrikaN());

            }

            @Override
            public void onFailure(Call<ResponsePriceList> call, Throwable t) {

            }
        });
    }
}