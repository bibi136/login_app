package com.example.framgia.login_app.realm.activity;

import android.support.annotation.Nullable;

import com.example.framgia.login_app.realm.model.Book;

import io.realm.OrderedRealmCollection;
 
public class RealmBooksAdapter extends RealmModelAdapter<Book> {

    public RealmBooksAdapter(@Nullable OrderedRealmCollection<Book> data) {
        super(data);
    }
}