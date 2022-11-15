package com.example.ffm_footbal_field_managenment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ffm_footbal_field_managenment.Adapter.AccountAdapter;
import com.example.ffm_footbal_field_managenment.Database.RoomDatabase_DA;
import com.example.ffm_footbal_field_managenment.Entity.UserEntity;
import com.example.ffm_footbal_field_managenment.R;

import java.util.ArrayList;
import java.util.List;

public class AccountAdminFragment extends Fragment {

    RoomDatabase_DA db;
    RecyclerView recyclerView;
    List<UserEntity> list;
    AccountAdapter accountAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_account_admin, container, false);
        db=RoomDatabase_DA.getInstance(getActivity());

        recyclerView=view.findViewById(R.id.recyaccount);
        accountAdapter=new AccountAdapter();
        list=new ArrayList<>();

        list=db.userDAO().getSelect();
        accountAdapter.setData(list,getActivity());

        LinearLayoutManager layoutManager= new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(accountAdapter);
        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menutool_admin, menu);

        MenuItem menuItem = menu.findItem(R.id.lookfor_admin);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Nhập tìm kiếm");
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                accountAdapter.filter(newText);
                recyclerView.setAdapter(accountAdapter);
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

}