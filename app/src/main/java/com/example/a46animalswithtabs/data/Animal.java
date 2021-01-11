package com.example.a46animalswithtabs.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Simple class to represent single Animal
 * Implements Parcelable interface so it can be passed within Bundle
 */
public class Animal implements Parcelable {
    private String name;
    private int imageId;
    private int sound_effectID;
    private int sound;

    public Animal(String name, int imageId, int sound_effecrID,int sound) {
        this.name = name;
        this.imageId = imageId;
        this.sound_effectID = sound_effecrID;
        this.sound=sound;
    }

    public int getSound() {
        return sound;
    }

    protected Animal(Parcel in) {
        name = in.readString();
        imageId = in.readInt();
        sound_effectID = in.readInt();
        sound = in.readInt();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public int getSound_effectID() {
        return sound_effectID;
    }

    public void setSound_effectID(int sound_effectID) {
        this.sound_effectID = sound_effectID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(imageId);
        parcel.writeInt(sound_effectID);
    }
}
