package id.ac.uvers.l_ewash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {

    Button bLoginL;
    TextInputLayout userL, passL;
    TextView newAcctL;
    String userldrlgn, passldrlgn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLoginL = (Button) findViewById(R.id.btnLoginL);
        userL = (TextInputLayout) findViewById(R.id.usernameL);
        passL = (TextInputLayout) findViewById(R.id.passwordL);
        newAcctL = (TextView) findViewById(R.id.btnNewActL);

        bLoginL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userldrlgn = userL.getEditText().getText().toString().trim();
                passldrlgn = passL.getEditText().getText().toString().trim();

                if (userldrlgn.equals("")){
                    Toast.makeText(login.this, "Silahkan Isi Username Anda !", Toast.LENGTH_LONG).show();
                }
                else if (passldrlgn.equals("")){
                    Toast.makeText(login.this, "Silahkan Isi Password Anda !", Toast.LENGTH_LONG).show();
                }
                else{
                    RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
                    JsonObjectRequest jor =new JsonObjectRequest(Request.Method.GET,
                            urlcrud.selectLUser(userldrlgn, passldrlgn), null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                int berhasil = response.getInt("sukses");
                                if (berhasil == 1) {
                                    JSONArray ja = response.getJSONArray("data");
                                    for (int i = 0; i < ja.length(); i++) {
                                        JSONObject jo = ja.getJSONObject(i);
                                        String userlaundry = jo.getString("userlaundry");
                                        String password = jo.getString("password");

                                        Intent ii = new Intent(login.this, mainMenu.class);
                                        ii.putExtra("userlaundry",userldrlgn);
                                        startActivity(ii);

                                    }
                                } else {
                                    String pesan = response.getString("pesan");
                                    Toast.makeText(login.this, pesan, Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException jsonException) {
                                jsonException.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Error.ResponsePricelist", error.toString());
                            Toast.makeText(login.this, "Periksa Koneksi Internet !", Toast.LENGTH_LONG).show();
                        }
                    });
                    rq.add(jor);
                }
            }
        });
        newAcctL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii = new Intent(login.this,registerL.class);
                startActivity(iii);
                finish();
            }
        });

    }
}