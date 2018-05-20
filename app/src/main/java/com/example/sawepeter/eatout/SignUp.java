package com.example.sawepeter.eatout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    MaterialEditText edtphone,edtname,edtpassword;
    Button btnsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtname = (MaterialEditText)findViewById(R.id.edtname);
        edtpassword = (MaterialEditText)findViewById(R.id.edtnpass);
        edtphone = (MaterialEditText)findViewById(R.id.edtphone);

        btnsignup = (Button)findViewById(R.id.btnsignup);

        //intialize firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("user");
    }
}
