package org.mousehole.ebaybooks.view.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.mousehole.ebaybooks.R;
import org.mousehole.ebaybooks.model.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    private List<PostModel> postsList = new ArrayList<>();

    @NonNull
    @Override
    public PostsAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.PostViewHolder holder, int position) {

        holder.titletv.setText(postsList.get(position).getTitle());
        holder.authortv.setText(postsList.get(position).getAuthor());

        Glide.with(holder.itemView.getContext()).load(postsList.get(position).getImageURL())
                .centerCrop().placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.bookIMG);
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public void setList(List<PostModel> postsList){
        this.postsList = postsList;
        notifyDataSetChanged();
    }


    public class PostViewHolder extends RecyclerView.ViewHolder{

        TextView authortv, titletv;
        ImageView bookIMG;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titletv = itemView.findViewById(R.id.title_tv);
            authortv = itemView.findViewById(R.id.auhtor_tv);
            bookIMG = itemView.findViewById(R.id.book_iv);
        }
    }
}
