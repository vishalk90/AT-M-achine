package com.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by vishalkulkarni on 11/30/16.
 */
public class demo {

    public List<String> findActiveAccountUsers() {
        TransactionObject request = new TransactionObject();
        request.setId("FETCH_ACTIVE_USERS");

        TransactionObject response = ContactServer.sendTransaction(request);
        List<String> users = new ArrayList<String>();

        if (response != null && response.getMessage() != null && response.getMessage().length() > 0) {
            String temp = response.getMessage();
            temp = temp.substring(1, temp.length()) + ",";
            users = Arrays.asList(temp.split(","));
        }

        return users;
    }

    public List<String> findFrozenAccountUsers() {
        TransactionObject request = new TransactionObject();
        request.setId("FETCH_FROZEN_USERS");

        TransactionObject response = ContactServer.sendTransaction(request);
        List<String> users = new ArrayList<String>();

        if (response != null && response.getMessage() != null && response.getMessage().length() > 0) {
            String temp = response.getMessage();
            temp = temp.substring(1, temp.length()) + ",";
            users = Arrays.asList(temp.split(","));
        }

        return users;
    }

    public static void main(String args[]){



    }
}
