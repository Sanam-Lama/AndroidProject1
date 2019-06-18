package com.example.twtprojectpart2;

import android.os.Parcel;
import android.os.Parcelable;

public class ObjectClass implements Parcelable {

   public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

       @Override
       public Object createFromParcel(Parcel source) {
           return null;
       }

       @Override
       public Object[] newArray(int size) {
           return new Object[0];
       }
   };

   private int titleNumber, subtitleNumber, iconNumber;

   // constructor
    public ObjectClass(int titleNumber, int subtitleNumber, int iconNumber) {
        this.titleNumber = titleNumber;
        this.subtitleNumber = subtitleNumber;
        this.iconNumber = iconNumber;
    }

    public int getTitleNumber() {
        return titleNumber;
    }

    public void setTitleNumber(int titleNumber) {
        this.titleNumber = titleNumber;
    }

    public int getSubtitleNumber() {
        return subtitleNumber;
    }

    public void setSubtitleNumber(int subtitleNumber) {
        this.subtitleNumber = subtitleNumber;
    }

    public int getIconNumber() {
        return iconNumber;
    }

    public void setIconNumber(int iconNumber) {
        this.iconNumber = iconNumber;
    }

    public ObjectClass(Parcel source) {
        titleNumber = source.readInt();
        subtitleNumber = source.readInt();
        iconNumber = source.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(titleNumber);
        dest.writeInt(subtitleNumber);
        dest.writeInt(iconNumber);
    }
}
