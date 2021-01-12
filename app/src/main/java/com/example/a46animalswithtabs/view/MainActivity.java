package com.example.a46animalswithtabs.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.a46animalswithtabs.LanguageActivity;
import com.example.a46animalswithtabs.R;
import com.example.a46animalswithtabs.view.list.AnimalListAdapter;
import com.example.a46animalswithtabs.view.list.ListFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends FragmentActivity {
private  Button button_ru;
private  Button button_en;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Reference your views
button_ru= findViewById(R.id.button_russian);
button_en= findViewById(R.id.button_english);

button_ru.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(v.getContext(), LanguageActivity.class);
        v.getContext().startActivity(intent);
    }
});
    }
}
;