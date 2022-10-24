package by.Jlevk.sqliteapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import by.Jlevk.sqliteapp.App;
import by.Jlevk.sqliteapp.R;
import by.Jlevk.sqliteapp.model.dao.UserDao;
import by.Jlevk.sqliteapp.model.entities.UserModel;
import by.Jlevk.sqliteapp.ui.list.UserListActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameEditText = findViewById(R.id.user_name_input);

        Button createUserButton = findViewById(R.id.create_user_button);
        Button seeUsersButton = findViewById(R.id.see_users_button);

        UserDao dao = App.getInstance().getUserDao();

        createUserButton.setOnClickListener(view -> {
            UserModel user =
                    new UserModel(
                            userNameEditText.getText().toString());
            dao.insertUser(user);
        });

        seeUsersButton.setOnClickListener(view -> startActivity(new Intent(
                MainActivity.this,
                UserListActivity.class)
        ));
    }

}