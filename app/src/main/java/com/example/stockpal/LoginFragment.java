package com.example.stockpal;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class LoginFragment extends Fragment {

    EditText nameTextBox;
    Button loginBtn;
    TextView textGreeting;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);
    }

    private void setContentView(int fragment_login) {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login,container,false);
        nameTextBox = (EditText) v.findViewById(R.id.nameText);
        loginBtn = v.findViewById(R.id.btn_login);
        textGreeting = v.findViewById(R.id.textGreeting);
        loginBtn.setEnabled(false);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SayHello(view);
            }
        });

        nameTextBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String name = nameTextBox.getText().toString();
                loginBtn.setEnabled(!name.isEmpty());
                String displayGreeting = "Hello " + name + "!";
                textGreeting.setText(displayGreeting);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        return v;
    }


    public void SayHello(View view){
        String name = nameTextBox.getText().toString();
        Toast.makeText(getContext(), "Hello " + name, Toast.LENGTH_SHORT).show();


    }

}
