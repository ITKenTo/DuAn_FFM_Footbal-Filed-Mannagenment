package com.example.ffm_footbal_field_managenment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import com.example.ffm_footbal_field_managenment.Login_register.LoginActivity;
import com.example.ffm_footbal_field_managenment.R;

public class SupportFragment extends Fragment {

    LinearLayout layoutlogout,layoutpassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_support, container, false);
        layoutlogout=view.findViewById(R.id.linner_logout);
        layoutpassword=view.findViewById(R.id.linner_doimk);

        layoutlogout.setOnClickListener(view1 -> {
            startActivity(new Intent(getActivity(), LoginActivity.class));
        });

        layoutpassword.setOnClickListener(view1 -> {
//             startActivity(new Intent(getActivity(), ChangePasswordActivity.class));
        });
        return view;
    }
}