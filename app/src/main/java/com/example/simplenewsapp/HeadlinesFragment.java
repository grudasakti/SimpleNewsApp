package com.example.simplenewsapp;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.ListFragment;
import java.util.ArrayList;

public class HeadlinesFragment extends ListFragment {
    Ipsum headline = new Ipsum();
    String[] showHeadline = headline.getHeadlines();

    Ipsum article = new Ipsum();
    String[] showArticle = article.getArticle();

    private final ArrayList<String> showList = new ArrayList<>();
    OnHeadlineSelectedListener mCallBack;

    public interface OnHeadlineSelectedListener {
        void onArticleSelected(int position, String[] showHeadline, String[] showArticle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
            layout = android.R.layout.simple_list_item_activated_1;
        }else{
            layout = android.R.layout.simple_list_item_1;
        }

        for (int i=0; i<showHeadline.length; i++){
            showList.add(showHeadline[i].substring(0,10) + "..." + "\n" + showArticle[i].substring(0,30) + "..." + "\n");
        }

        setListAdapter(new ArrayAdapter<String>(getActivity(), layout, showList));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        mCallBack.onArticleSelected(position,showHeadline, showArticle);
        getListView().setItemChecked(position, true);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(getFragmentManager().findFragmentById(R.id.article_fragment) != null){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallBack = (OnHeadlineSelectedListener) context;
        } catch (ClassCastException ex){
            throw new ClassCastException(context.toString() + "must implement OnHeadlineSelectedListener");
        }
    }
}
