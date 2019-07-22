package com.example.mojorejoapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginAdminActivity extends AppCompatActivity {
    Toolbar toolbarLoginAdm;
    EditText username;
    EditText password;
    Button loginAdm;
    TextView warning;
    FirebaseDatabase mDatabaseLogin;
    DatabaseReference mReferenceLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_admin);
        toolbarLoginAdm = findViewById(R.id.toolbarLoginAdm);
        setSupportActionBar(toolbarLoginAdm);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        username = findViewById(R.id.editTextUname);
        password = findViewById(R.id.editTextPass);
        loginAdm = findViewById(R.id.btnLoginAdm);
        warning = findViewById(R.id.loginAdmWarning);

        mDatabaseLogin = FirebaseDatabase.getInstance();
        mReferenceLogin = mDatabaseLogin.getReference();
        loginAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });


    }

    private void validate(final String username, final String password) {
        Query queryLogin = mReferenceLogin.child("Admin");
        final GetLogin login = new GetLogin();
        queryLogin.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                login.setUsername(dataSnapshot.child("username").getValue().toString());
                login.setPassword(dataSnapshot.child("password").getValue().toString());
                if ((username.equals(login.getUsername())) && (password.equals(login.getPassword()))) {
                    Intent loginAdm = new Intent(LoginAdminActivity.this, HomeAdminActivity.class);
                    startActivity(loginAdm);
                } else {
                    warning.setText("Username atau Password salah!");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}

