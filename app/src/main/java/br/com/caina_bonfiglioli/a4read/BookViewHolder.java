package br.com.caina_bonfiglioli.a4read;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    final ImageView imgCover;
    final TextView txtTitle;
    final TextView txtAuthor;
    final TextView txtCategory;
    final TextView txtPublishingCompany;

    public BookViewHolder(@NonNull View view) {
        super(view);

        imgCover = (ImageView)view.findViewById(R.id.imgCapa);
        txtTitle = (TextView)view.findViewById(R.id.txtTitulo);
        txtAuthor = (TextView)view.findViewById(R.id.txtAutor);
        txtCategory = (TextView)view.findViewById(R.id.txtCategoria);
        txtPublishingCompany = (TextView)view.findViewById(R.id.txtEditora);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();

        Toast.makeText(
                itemView.getContext(),
                "Posição selecionada" + position,
                Toast.LENGTH_SHORT
        ).show();
    }
}
