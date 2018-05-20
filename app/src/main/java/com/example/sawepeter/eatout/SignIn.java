package com.example.sawepeter.eatout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    EditText edtphone,edtpassword;
    Button btnsignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtpassword = (MaterialEditText)findViewById(R.id.edtnpass);
        edtphone = (MaterialEditText)findViewById(R.id.edtphone);
        btnsignin = (Button)findViewById(R.id.btnsignin);

        //intialize firebase database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference table_user = database.getReference("user");
    }
}
