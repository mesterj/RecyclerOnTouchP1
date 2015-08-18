package com.kite.joco.recyclerontouchp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rvPersons = (RecyclerView) findViewById(R.id.rvPersons);
        PersonAdapter adapter = new PersonAdapter(this,getPersons());
        rvPersons.setAdapter(adapter);
        rvPersons.setLayoutManager(new LinearLayoutManager(this));

        rvPersons.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {

            }
        });
    }

    private ArrayList<Person> getPersons() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Joe","Brown"));
        persons.add(new Person("Sam","Gray"));
        persons.add(new Person("Helga","Red"));
        persons.add(new Person("Ethan","Black"));
        persons.add(new Person("Kevin","Brown"));
        persons.add(new Person("John","Brown"));
        persons.add(new Person("Samuel","White"));
        return persons;
    }


}

/*
 @Override
     protected void onCreate(Bundle savedInstanceState) {
         // ...
         // Lookup the recyclerview in activity layout
         RecyclerView rvUsers = (RecyclerView) findViewById(R.id.rvUsers);
         // Create adapter passing in the sample user data
         UserRecyclerViewAdapter adapter = new UserRecyclerViewAdapter(this, getThronesCharacters());
         // Attach the adapter to the recyclerview to populate items
         rvUsers.setAdapter(adapter);
         // Set layout manager to position the items
         rvUsers.setLayoutManager(new LinearLayoutManager(this));
         // That's all!
     }

     private ArrayList<User> getThronesCharacters() {
        ArrayList<User> items = new ArrayList<>();
        items.add(new User("Dany Targaryen", "Valyria"));
        items.add(new User("Rob Stark", "Winterfell"));
        items.add(new User("Jon Snow", "Castle Black"));
        items.add(new User("Tyrion Lanister", "King's Landing"));
        return items;
    }
 */