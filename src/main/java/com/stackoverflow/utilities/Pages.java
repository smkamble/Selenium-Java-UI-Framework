package com.stackoverflow.utilities;

import com.stackoverflow.pages.*;

public class Pages {
    private HomePage homePage;


    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
}
