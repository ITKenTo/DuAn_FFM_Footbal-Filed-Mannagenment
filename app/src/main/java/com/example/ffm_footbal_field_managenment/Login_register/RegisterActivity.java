package com.example.ffm_footbal_field_managenment.Login_register;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.ffm_footbal_field_managenment.Database.RoomDatabase_DA;
import com.example.ffm_footbal_field_managenment.Entity.UserEntity;
import com.example.ffm_footbal_field_managenment.R;
import com.example.ffm_footbal_field_managenment.databinding.ActivityRegisterBinding;


public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    RoomDatabase_DA db;
    int temp=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_register);
        db=RoomDatabase_DA.getInstance(this);
        binding.btnLogin.setOnClickListener(view -> {
           validate();
           if (temp==0) {
               UserEntity user= new UserEntity();
               user.setUsername(binding.edUsername.getText().toString());
               user.setFullname(binding.edFullname.getText().toString());
               user.setPhonenumber(binding.edPhonenumber.getText().toString());
               user.setPassword(binding.edPassword.getText().toString());
               user.setPassword(binding.edCofmirmpassword.getText().toString());
               db.userDAO().insert(user);
               Toast.makeText(this, "Đăng Kí Thành Công", Toast.LENGTH_SHORT).show();
           }else {
               temp=0;
           }
        });

        binding.tvLogin.setOnClickListener(view -> {
            onBackPressed();
        });
    }
    public void validate() {
        if (binding.edUsername.length()==0) {
            binding.edUsername.setError("Vui lòng không để trống username");
            temp++;
        }else {
            binding.edUsername.setError("");
        }

        if (binding.edFullname.length()==0) {
            binding.edFullname.setError("Vui lòng không để trống Họ Tên");
            temp++;
        }else {
            binding.edFullname.setError("");
        }

        if (binding.edPhonenumber.length()==0) {
            binding.edPhonenumber.setError("Vui lòng không để trống Số điện thoại");
            temp++;
        }else {
            binding.edPhonenumber.setError("");
        }
        if (binding.edPassword.length()==0) {
            binding.edPassword.setError("Vui lòng không để trống Mật Khẩu");
            temp++;
        }else

        if (binding.edPassword.length()<6) {
            binding.edPassword.setError("Mật khẩu phải lớn hơn 6 kí tự");
            temp++;
        }else
        {
            binding.edPassword.setError("");
        }
        if (binding.edCofmirmpassword.length()==0) {
            binding.edPassword.setError("Vui lòng không để trống Số điện thoại");
            temp++;
        }else
        if (binding.edCofmirmpassword != binding.edPassword) {
            binding.edPassword.setError("Bạn phải nhập giống với mật khẩu trước");
            temp++;
        }else {
            binding.edPassword.setError("");
        }
    }
}