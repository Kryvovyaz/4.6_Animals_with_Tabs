package com.example.a46animalswithtabs.view.details;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import com.example.a46animalswithtabs.R;
import com.example.a46animalswithtabs.data.Animal;

import static com.example.a46animalswithtabs.view.list.ListFragment.KEY_ANIMAL_BUNDLE;
import static com.example.a46animalswithtabs.view.list.ListFragment.LIST_FRAGMENT_REQUEST_CODE;

public class DetailsFragment extends Fragment {
    MediaPlayer player;
    private TextView titleText;
    private ImageView animalImage;

    // Initial values
    private String title = "Dog";
    private int imageID = R.drawable.picture0;
    private Button make_sound;
    private int sound_effectID = R.raw.dog;
    private Button make_say;
    private int sound = R.raw.dog_english;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Reference your views
        titleText = view.findViewById(R.id.fragment_details_title_text);
        make_sound = view.findViewById(R.id.make_sound);
        animalImage = view.findViewById(R.id.fragment_details_image);

        titleText.setText(title);
        animalImage.setImageResource(imageID);
//

        make_say = view.findViewById(R.id.make_say);
        make_say.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                play(v, sound);

            }
        });
        make_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                play(v, sound_effectID);
            }
        });
        // Listens to the result in FragmentManager
        // If anyone sets a result using LIST_FRAGMENT_REQUEST_CODE key, we will capture it in here
        getParentFragmentManager().setFragmentResultListener(LIST_FRAGMENT_REQUEST_CODE,
                DetailsFragment.this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                        //Retrieve Animal object from bundle
                        Animal animal = bundle.getParcelable(KEY_ANIMAL_BUNDLE);
                        // Do something with the result
                        Log.d("MyApp", "Animal: " + animal.toString());
                        animalImage.setImageResource(animal.getImageId());
                        titleText.setText(animal.getName());
                        sound_effectID = animal.getSound_effectID();
                        sound = animal.getSound();
                        make_say.setSoundEffectsEnabled(false);
                        make_sound.setSoundEffectsEnabled(false);
                    }
                });
    }

    public void play(View v, int id) {
        if (player != null) {
            player.release();
        }
        player = MediaPlayer.create(getContext(), id);
        player.start();
    }

    public void stopPlayer(View v) {
        if (player != null) {
            player.release();
            player = null;
        }
    }


    @Override
    public void onPause() {
        super.onPause();
        stopPlayer(this.getView());
    }


}
