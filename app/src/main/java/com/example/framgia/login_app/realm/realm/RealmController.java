package com.example.framgia.login_app.realm.realm;

import com.example.framgia.login_app.realm.model.Book;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by framgia on 02/03/2017.
 */

public class RealmController {
    private static RealmController instance;
    private final Realm realm;

    public RealmController() {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController get() {
        if (instance == null) {
            instance = new RealmController();
        }
        return instance;
    }

    public static RealmController getInstance() {
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    // Clear all object from Book.class
    public void clearAllBooks() {
        realm.beginTransaction();
        realm.delete(Book.class);
        realm.commitTransaction();
    }

    // Find all objects in the Book.class
    public RealmResults<Book> getBooks() {
        return realm.where(Book.class).findAll();
    }

    // Query a single item with the given id
    public Book getBook(String id) {
        return realm.where(Book.class).equalTo("id", id).findFirst();
    }

    // check if Book.class is empty
    public boolean hasBooks() {
        return !realm.isEmpty();
    }

    // query example
    public RealmResults<Book> queryedBook() {
        return realm.where(Book.class)
                .contains("author", "Author 0")
                .or()
                .contains("title", "Realm")
                .findAll();
    }
}
