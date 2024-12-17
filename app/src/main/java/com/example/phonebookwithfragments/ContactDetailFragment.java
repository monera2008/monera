package com.example.phonebookwithfragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactDetailFragment extends Fragment {
    private TextView nameTextView;
    private TextView phoneTextView;

    public ContactDetailFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        nameTextView = rootView.findViewById(R.id.main);
        phoneTextView = rootView.findViewById(R.id.main);

        // Get the contact info passed via the Bundle
        if (getArguments() != null) {
            String name = getArguments().getString("name");
            String phone = getArguments().getString("phone");

            nameTextView.setText(name);
            phoneTextView.setText(phone);
        }

        return rootView;
    }
}
