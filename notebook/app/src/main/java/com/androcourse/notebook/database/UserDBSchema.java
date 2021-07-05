package com.androcourse.notebook.database;

public class UserDBSchema {
    public static final class UserTable {
        public static final String NAME = "users2"; // названи таблицы в бд
    }
    public static final class Cols {
        public static final String ID = "_id";
        public static final String UUID = "uuid";
        public static final String USERNAME = "user_name";
        public static final String USERLASTNAME = "user_last_name";
        public static final String PHONE = "phone";
    }
}
