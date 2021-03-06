package com.example.bookcase;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookListFragment.BookInterface {




    boolean singlePane;
    BookDetailsFragment detailsFragment;
    ViewPagerFragment viewPagerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ArrayList<String> Books = new ArrayList<>();
        Books.add("Ender's Game");
        Books.add("My Brother Sam is Dead");
        Books.add("The Martian");
        Books.add("Among The Hidden");
        Books.add("Ready Player One");
        Books.add("One Flew Over The Cuckoo's Nest");
        Books.add("The Book of Basketball");
        Books.add("Fever 1793");
        Books.add("The Road");
        Books.add("Night");
        */

        //ViewPager viewPager = findViewById(R.id.BookViewPager);

        singlePane = findViewById(R.id.container_2) == null;
        detailsFragment = new BookDetailsFragment();
        BookListFragment listFragment = new BookListFragment();
        viewPagerFragment = new ViewPagerFragment();

        if(!singlePane){
            addFragment(listFragment, R.id.container_1);
            addFragment(detailsFragment, R.id.container_2);
        } else {
            addFragment(viewPagerFragment, R.id.container_3);
        }

    }

    public void addFragment(Fragment fragment, int id){
        getSupportFragmentManager().
                beginTransaction().
                replace(id, fragment).
                addToBackStack(null).
                commit();
    }

    @Override
    public void bookPicked(String bookTitle) {
        detailsFragment.bookPicked(bookTitle);
    }
}
