package com.example.news.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.news.R;
import com.example.news.models.Article;
import com.example.news.util.TimeConversion;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<Article> mArticleList;
    private RequestOptions mRequestOptions;
    private Context mContext;

    public NewsAdapter(Context context, List<Article> articleList) {
        this.mContext = context;
        this.mArticleList = articleList;
        mRequestOptions = new RequestOptions().transform(new RoundedCorners(16));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_article_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = mArticleList.get(position);
        Glide.with(mContext)
                .load(article.getUrlToImage())
                .apply(mRequestOptions)
                .into(holder.mImage);

        String author = article.getAuthor();
        if (author == null || author.equals(""))
            author = "";
        else
            author = "By " + article.getAuthor();

        holder.mAuthor.setText(author);

        holder.mTitle.setText(article.getTitle());
        holder.mDate.setText(TimeConversion.fullDateToShortDate(article.getPublishedAt()));
        holder.mDescription.setText(article.getDescription());
        System.out.println("SIZE: " + mArticleList.size());
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImage;
        private TextView mTitle;
        private TextView mDescription;
        private TextView mDate;
        private TextView mAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImage = itemView.findViewById(R.id.iv_article_image);
            mTitle = itemView.findViewById(R.id.tv_title);
            mDescription = itemView.findViewById(R.id.tv_description);
            mDate = itemView.findViewById(R.id.tv_time);
            mAuthor = itemView.findViewById(R.id.tv_author);
        }
    }
}
