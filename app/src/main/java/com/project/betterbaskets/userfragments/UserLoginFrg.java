package com.project.betterbaskets.userfragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.VolleyError;
import com.project.betterbaskets.BaseFrg;
import com.project.betterbaskets.R;
import com.project.betterbaskets.activities.RegisterActivity;
import com.project.betterbaskets.databinding.UserLoginFrgBinding;
import com.project.betterbaskets.utilities.Utils;

import org.json.JSONObject;

import java.util.Map;

public class UserLoginFrg extends BaseFrg {

    UserLoginFrgBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = UserLoginFrgBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateFields()){


                }


            }
        });

        binding.mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RegisterActivity.class));
            }
        });
    }


    private boolean validateFields() {
        Utils.hideKeyboard(getActivity());
        if (binding.mMobileNumberEt.getText().toString().trim().isEmpty()) {
            Toast.makeText(getActivity(), getString(R.string.enter_phone), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (binding.mMobileNumberEt.getText().toString().length() < 10) {
            Toast.makeText(getActivity(), getString(R.string.enter_valid_phone), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (binding.mPasswordEt.getText().toString().trim().isEmpty()) {
            Toast.makeText(getActivity(), getString(R.string.enter_password), Toast.LENGTH_SHORT).show();
            return false;
        }

        if (binding.mPasswordEt.getText().toString().length() < 6) {
            Toast.makeText(getActivity(), getString(R.string.password_not_less_than_6), Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }
}
