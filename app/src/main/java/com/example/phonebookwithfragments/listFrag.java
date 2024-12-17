package com.example.phonebookwithfragments;

import android.app.Person;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;


public class listFrag extends Fragment {
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<ContactAdapter> contactList;



    public listFrag() {
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list, container, false);
        View rootView;
        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        contactList = new ArrayList<ContactAdapter>();
        contactList.add(new ContactAdapter("John Doe", "123-456-7890"));
        contactList.add(new ContactAdapter("Jane Smith", "987-654-3210"));

        adapter = new ContactAdapter(contactList, new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onItemClick(Person contact) {
                // Pass selected contact to the details fragment
                ContactDetailFragment detailFragment = new ContactDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString("name", ContactAdapter.getName());
                bundle.putString("phone", ContactAdapter.getPhoneNum());
                detailFragment.setArguments(bundle);

                // Replace the fragment
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, detailFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        recyclerView.setAdapter((RecyclerView.Adapter) adapter);

        return rootView;}

    private static class ContactAdapter implements Adapter {
        public ContactAdapter(List<ContactAdapter> contactList, AdapterView.OnItemClickListener onItemClickListener) {
        }

        public ContactAdapter(String janeSmith, String s) {
        }
    }
}