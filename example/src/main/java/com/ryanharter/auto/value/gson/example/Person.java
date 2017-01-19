package com.ryanharter.auto.value.gson.example;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.ryanharter.auto.value.gson.GsonTypeAdapter;
import java.util.Date;

@AutoValue
public abstract class Person {
    public abstract String name();

    public abstract int gender();

    public abstract int age();

    @GsonTypeAdapter(BirthdateAdapter.class)
    public abstract Date birthdate();

    public abstract Address address();

    public static Builder builder() {
        return new AutoValue_Person.Builder();
    }

    public static TypeAdapter<Person> typeAdapter(Gson gson) {
        return new AutoValue_Person.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder name(String name);

        public abstract Builder gender(int gender);

        public abstract Builder age(int age);

        public abstract Builder birthdate(Date birthdate);

        public abstract Builder address(Address address);

        public abstract Person build();
    }
}
