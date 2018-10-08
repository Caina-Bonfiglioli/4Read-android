package br.com.caina_bonfiglioli.a4read;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter {

    private final List<Book> list;
    private Context context;


    public BookAdapter(List<Book> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                        .inflate(R.layout.item_list,
                                viewGroup, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BookViewHolder vh = (BookViewHolder)viewHolder;
        Book book = list.get(i);

        int img = context.getResources().getIdentifier(
                "drawable/capa" + book.getId(),
                null,
                context.getPackageName());
        vh.imgCover.setImageResource(img);
        vh.txtTitle.setText(book.getTitle());
        vh.txtAuthor.setText(book.getAuthor());
        vh.txtCategory.setText(book.getCategory());
        vh.txtPublishingCompany.setText(
                String.format("%s ,%d", book.getPublishingCompany(),
                        book.getYear())
        );
    }

    @Override
    public int getItemCount() {
        return (list!=null)?list.size():0;
    }


}
