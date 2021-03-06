package com.androcourse.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserFormActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextLastName;
    EditText editTextPhone;
    boolean newUser;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        Bundle extras = getIntent().getExtras();
        user = null;
        if (extras != null)
            user = (User) extras.getSerializable("user");
        if (user == null) {
            newUser = true;
            user = new User();
        } else
            newUser = false;

        editTextName = findViewById(R.id.editUserName);
        editTextName.setText(user.getUserName());

        editTextLastName = findViewById(R.id.editUserLastName);
        editTextLastName.setText(user.getUserLastName());

        editTextPhone = findViewById(R.id.editPhone);
        editTextPhone.setText(user.getPhone());

        findViewById(R.id.buttonSaveEdit).setOnClickListener(view -> {
            user.setUserName(editTextName.getText().toString());
            user.setUserLastName(editTextLastName.getText().toString());
            user.setPhone(editTextPhone.getText().toString());
            Users users = new Users(UserFormActivity.this);
            if (newUser)
                users.addUser(user);
            else
                users.updateUser(user);
            onBackPressed();
        });

        findViewById(R.id.buttonCancel).setOnClickListener(view -> onBackPressed());

        Button del = findViewById(R.id.buttonDelete);
        if (user == null)
            del.setVisibility(View.GONE);
        else {
            del.setOnClickListener(view -> {
                Users users = new Users(UserFormActivity.this);
                users.deleteUser(user);
                onBackPressed();
            });
        }
    }
}