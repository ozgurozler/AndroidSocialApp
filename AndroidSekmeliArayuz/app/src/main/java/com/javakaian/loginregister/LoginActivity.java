package com.javakaian.loginregister;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.javakaian.json.JsonParser;
import com.yenitsrm.androidsekmeliarayuz.MainActivity;
import com.yenitsrm.androidsekmeliarayuz.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by javakaian on 12/12/2015.
 */
public class LoginActivity extends Activity
{
    private Button btnLogin,btnRegister;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private ProgressDialog progressDialog;


    private String tag_Username="username";
    private String tag_Email="email";
    private String tag_Age ="age";
    private String tag_Name="name";

    private String username, password;

    private JSONObject jsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        editTextUsername = (EditText)findViewById(R.id.editTextLoginUsername);
        editTextPassword = (EditText)findViewById(R.id.editTextLoginPassword);
        btnRegister =(Button)findViewById(R.id.btnRegister);






        btnLogin.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                username = editTextUsername.getText().toString();
                password=editTextPassword.getText().toString();
                new Ekle().execute();



            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);

            }

        });
    }

    class Ekle extends AsyncTask<String, String, String>
    {

        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setTitle("Giriş Yapılıyor...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            super.onPreExecute();

        }


        protected String doInBackground(String... params)
        {

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("username", username);
            map.put("password", password);

            JsonParser json = new JsonParser();
            String text= json.makeHttpPost("http://ukos.ogu.edu.tr/php/giris.php",map);




            return text;
        }


        protected void onPostExecute(String result)
        {

            super.onPostExecute(result);
            progressDialog.dismiss();

            System.out.println(result);

            try {
                jsonObject = new JSONObject(result);

                if(jsonObject.getInt("success")==0)
                {
                    Toast t = Toast.makeText(LoginActivity.this, "Lütfen Kayıt Olunuz", Toast.LENGTH_SHORT);
                    t.show();
                }
                if(jsonObject.getInt("success")==1)
                {

                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    i.putExtra(tag_Name, jsonObject.getString(tag_Name));
                    i.putExtra(tag_Username, jsonObject.getString(tag_Username));
                    i.putExtra(tag_Email, jsonObject.getString(tag_Email));
                    i.putExtra(tag_Age, jsonObject.getString(tag_Age));
                    startActivity(i);
                }



            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }



        }

    }



}
