package id.ac.uvers.l_ewash;

import static android.widget.Toast.LENGTH_LONG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

public class registerL extends AppCompatActivity {

    TextInputLayout usernameL, namaL, passwordL, nohpL, alamatL, jambukaL, jamtutupL;
    CheckBox selfdel, kurirdel;
    Button register;
    String userlaundry,password,namalaundry, nohp, alamatlaundry, jambuka, jamtutup;
    int selfdelivery, kurirdelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_l);

        usernameL = (TextInputLayout) findViewById(R.id.usernameLRg);
        namaL = (TextInputLayout) findViewById(R.id.namaLRg);
        passwordL = (TextInputLayout) findViewById(R.id.passwordLRg);
        nohpL = (TextInputLayout) findViewById(R.id.nohpLRg);
        alamatL = (TextInputLayout) findViewById(R.id.alamatLRg);
        jambukaL = (TextInputLayout) findViewById(R.id.jambukaLRg);
        jamtutupL = (TextInputLayout) findViewById(R.id.jamtutupLRg);
        selfdel = (CheckBox) findViewById(R.id.checkselfLRg);
        kurirdel = (CheckBox) findViewById(R.id.checkkurirLRg);
        register = (Button) findViewById(R.id.btnRegis);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userlaundry = usernameL.getEditText().getText().toString().trim();
                password = passwordL.getEditText().getText().toString().trim();
                namalaundry = namaL.getEditText().getText().toString().trim();
                nohp = nohpL.getEditText().getText().toString().trim();
                alamatlaundry = alamatL.getEditText().getText().toString().trim();
                jambuka = jambukaL.getEditText().getText().toString().trim();
                jamtutup = jamtutupL.getEditText().getText().toString().trim();
                if (selfdel.isChecked()){
                    selfdelivery = 1;
                }
                if (kurirdel.isChecked()){
                    kurirdelivery = 1;
                }
                else {
                    kurirdelivery = 0;
                }
                if (userlaundry.equals("")) {
                    Toast.makeText(registerL.this, "Silahkan Isi Username Anda !", Toast.LENGTH_LONG).show();
                } else if (password.equals("")) {
                    Toast.makeText(registerL.this, "Silahkan Isi Password Anda !", Toast.LENGTH_LONG).show();
                } else if (namalaundry.equals("")) {
                    Toast.makeText(registerL.this, "Silahkan Isi Nama Anda !", Toast.LENGTH_LONG).show();
                } else if (nohp.equals("")) {
                    Toast.makeText(registerL.this, "Silahkan Isi Nomor HP Anda !", Toast.LENGTH_LONG).show();
                } else if (alamatlaundry.equals("")) {
                    Toast.makeText(registerL.this, "Silahkan Isi Alamat Anda !", Toast.LENGTH_LONG).show();
                } else if (jambuka.equals("")) {
                    Toast.makeText(registerL.this, "Silahkan Isi Jam Buka !", Toast.LENGTH_LONG).show();
                } else if (jamtutup.equals("")) {
                    Toast.makeText(registerL.this, "Silahkan Isi Jam Tutup !", Toast.LENGTH_LONG).show();
                }
                else {
                    RequestQueue rq = Volley.newRequestQueue(getApplicationContext());
                    JsonObjectRequest jar = new JsonObjectRequest(Request.Method.GET,
                            urlcrud.insertLUser(userlaundry,password, namalaundry, nohp, alamatlaundry, jambuka, jamtutup, selfdelivery, kurirdelivery), null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                int berhasil = response.getInt("sukses");
                                String pesan = response.getString("pesan");
                                Toast.makeText(registerL.this, pesan, LENGTH_LONG).show();
                                Intent i = new Intent(registerL.this, login.class);
                                startActivity(i);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.e("Error.response", error.toString());
                            Toast.makeText(registerL.this, "Periksa Koneksi Internet Anda !", LENGTH_LONG).show();

                        }
                    });
                    rq.add(jar);
                }
            }
        });

    }
}