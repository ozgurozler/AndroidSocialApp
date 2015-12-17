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
import com.yenitsrm.androidsekmeliarayuz.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by javakaian on 12/12/2015.
 */
public class RegisterActivity extends Activity
{
    private String url ="http://ukos.ogu.edu.tr/php/kayit.php";

    private ProgressDialog progressDialog;

    private Button buttonRegister;
    private EditText editName;
    private EditText editUsername;
    private EditText editPassword;
    private EditText editEmail;
    private EditText editAge;

    private String name,username,password,email,age;

    JSONObject jsonObject;
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register);

        buttonRegister =(Button)findViewById(R.id.btnRegRegister);


        editName = (EditText)findViewById(R.id.editTextRegisterName);
        editUsername=(EditText)findViewById(R.id.editTextRegisterUsername);
        editPassword=(EditText) findViewById(R.id.editTextRegisterPassword);
        editEmail = (EditText) findViewById(R.id.editTextRegisterEmail);
        editAge = (EditText) findViewById(R.id.editTextRegisterAge);




        buttonRegister.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                name=editName.getText().toString();
                username=editUsername.getText().toString();
                password=editPassword.getText().toString();
                email=editEmail.getText().toString();
                age=editAge.getText().toString();
                new UserRegister().execute();



            }
        });
    }


    class UserRegister extends AsyncTask<String, String, String>
    {
        @Override
        protected void onPreExecute()
        {
            progressDialog = new ProgressDialog(RegisterActivity.this);
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Kullanıcı kaydediliyor..");
            progressDialog.show();
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(String... params)
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("name", name);
            map.put("username", username);
            map.put("password", password);
            map.put("email", email);
            map.put("age", age);

            JsonParser json = new JsonParser();

            String text = json.makeHttpPost(url, map);
            System.out.println(text);
            // TODO Auto-generated method stub
            return text;
        }
        @Override
        protected void onPostExecute(String result)
        {
            progressDialog.dismiss();
            // TODO Auto-generated method stub
            super.onPostExecute(result);


            try {
                jsonObject = new JSONObject(result);
                if(jsonObject.getInt("succes")==0)
                {
                    Toast t = Toast.makeText(RegisterActivity.this, "Kayıt Olunamadı", Toast.LENGTH_SHORT);
                    t.show();
                }
                if(jsonObject.getInt("succes")==1)
                {
                    Toast t = Toast.makeText(RegisterActivity.this, "Başarıyla Kayıt Olundu", Toast.LENGTH_SHORT);
                    t.show();

                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }




        }
    }



}
