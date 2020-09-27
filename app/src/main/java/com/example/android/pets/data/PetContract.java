package com.example.android.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class PetContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private PetContract() {}
    //uri for content
    public final static String CONTENT_AUTHORITY = "com.example.android.pets";
    //create usable URI
    public static final Uri BASE_CONTENT_URI =Uri.parse("content://"+CONTENT_AUTHORITY);
    //constant for each table in pets
    public static final String PATH_PETS="pets";

    /**
     * inner class that defines values for the pets database table
     */
    public static final class PetEntry implements BaseColumns{

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /** The content URI to access the pet data in the provider */
        public  final static Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        //name of table
        public final static String TABLE_NAME="pets";

        //define names of columns header
        //_id present unique id number for a pet
        public final static String _ID =BaseColumns._ID;

        //name of pet = string value
        public final static String COLUMN_PET_NAME="name";

        //breed of pet
        public final static String COLUMN_PET_BREED="breed";

        /**
         * Gender of the pet.
         * values are:{@link #GENDER_UNKNOWN}{@link #GENDER_MALE}{@link #GENDER_FEMALE}
         * Type:INTEGER
         */
        public final static String COLUMN_PET_GENDER="gender";

        // weight of the pet

        public final static String COLUMN_PET_WEIGHT="weight";

        /**
         * values of gender
         */
        public final static int GENDER_UNKNOWN=0;

        public final static int GENDER_MALE =1;

        public final static int GENDER_FEMALE=2;

        /**
         * Returns whether or not the given gender is {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         */
        public static boolean isValidGender(int gender) {
            if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
                return true;
            }
            return false;
        }


    }
}
