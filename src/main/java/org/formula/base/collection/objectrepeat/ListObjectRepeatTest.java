package org.formula.base.collection.objectrepeat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListObjectRepeatTest {
    public static void main(String[] args) {
        User user1 = new User("zhangsan", 11);
        User user2 = new User("zhangsan", 11);

        //将user对象放进list
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        //将list转换成成set, 去重
        Set<User> userSet = new HashSet<>();
        userSet.addAll(userList);

        System.err.println(userSet.size());
    }

    static class User {
        public String account;
        public Integer age;

        public User(String account, int age) {
            this.account = account;
            this.age = age;
        }

        public int hashCode() {
            return account.hashCode() + age.hashCode();
        }

        public boolean equals(Object obj) {
            User user = null;
            if (obj instanceof User) {
                user = (User) obj;
            }
            return (this.age == user.age && this.account.equals(user.account));
        }
    }
}



