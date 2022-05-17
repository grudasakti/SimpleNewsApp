package com.example.simplenewsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ArticleFragment extends Fragment {
    final static String ARG_POSITION = "position";
    int mCurrentPosition = 0;

    private TextView txtHeadline, txtArticle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        View view = inflater.inflate(R.layout.article_view, container, false);
        txtHeadline = view.findViewById(R.id.article_title);
        txtArticle = view.findViewById(R.id.article_news);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public void updateArticleView(int position, String[] showHeadline, String[] showArticle){
        txtHeadline.setText(showHeadline[position]);
        txtArticle.setText(showArticle[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}
