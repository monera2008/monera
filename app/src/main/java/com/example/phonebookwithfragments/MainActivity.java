package com.example.phonebookwithfragments;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity   {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            // Load the ContactListFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ContactListFragment())
                    .commit();
        }
    }

    private class ContactListFragment extends Fragment {
    }
}