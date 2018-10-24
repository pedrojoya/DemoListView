package es.iessaladillo.pedrojoya.demolistviewadapter.data.local.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {

    private final long id;
    private final String name;
    private final int age;

    public Student(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    private Student(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
