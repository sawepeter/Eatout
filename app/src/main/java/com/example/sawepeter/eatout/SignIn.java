package com.example.sawepeter.eatout;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sawepeter.eatout.Model.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
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
        final DatabaseReference table_user = database.getReference("user");

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Authenticating and verifying....");
                mDialog.show();


                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //check if user does not exist in database
                        if (dataSnapshot.child(edtphone.getText().toString()).exists()) {
                            //get user information
                            mDialog.dismiss();
                            user user = dataSnapshot.child(edtphone.getText().toString()).getValue(com.example.sawepeter.eatout.Model.user.class);
                            if (user.getPassword().equals(edtpassword.getText().toString())) {
                                Toast.makeText(SignIn.this, "Successfull signin !", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(SignIn.this, "Ooops!!! Incorrect password !!!", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this, "User does not exist in database", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
