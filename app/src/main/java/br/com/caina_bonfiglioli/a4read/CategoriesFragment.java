package br.com.caina_bonfiglioli.a4read;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CategoriesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_categories, null);

        RecyclerView rv = (RecyclerView)view.findViewById(R.id.rcvFiction);

        rv.setAdapter(new BookAdapter(Book.listFiction(), getContext()));

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);

        rv.setLayoutManager(manager);

        RecyclerView rv2 = (RecyclerView)view.findViewById(R.id.rcvRomance);

        rv2.setAdapter(new BookAdapter(Book.listRomance(), getContext()));

        RecyclerView.LayoutManager manager2 = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);

        rv.setLayoutManager(manager2);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
