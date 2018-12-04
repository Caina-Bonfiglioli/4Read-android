package br.com.caina_bonfiglioli.a4read.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.caina_bonfiglioli.a4read.R;
import br.com.caina_bonfiglioli.a4read.controller.ApiService;
import br.com.caina_bonfiglioli.a4read.model.Result;
import br.com.caina_bonfiglioli.a4read.model.ResultBook;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavoritesFragment extends Fragment {

    private Button btnFindBook;
    private EditText editFilter;
    private TextView txtResponseError;
    private View view = null;

    private static final String TAG = FavoritesFragment.class.getSimpleName();
    public static final String BASE_URL = "http://192.168.0.109:8080/book/";
    private static Retrofit retrofit = null;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorites, null);

        editFilter = (EditText)view.findViewById(R.id.editFilter);
        txtResponseError = (TextView)view.findViewById(R.id.txt_responseError);
        btnFindBook = (Button)view.findViewById(R.id.btn_findBook);
        btnFindBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFindBook.setOnClickListener(this);
                getBookApi();
            }
        });

        return view;
    }

    public void getBookApi(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiService api = retrofit.create(ApiService.class);

        Call<ResultBook> call = api.getBookByTitle(editFilter.getText().toString());

        call.enqueue(new Callback<ResultBook>() {
            @Override
            public void onResponse(Call<ResultBook> call, Response<ResultBook> response) {
                if (response.body() == null){
                    txtResponseError.setText("Nenhum livro encontrado");
                }

                Byte[] book = response.body().getBookFile();
            }

            @Override
            public void onFailure(Call<ResultBook> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
