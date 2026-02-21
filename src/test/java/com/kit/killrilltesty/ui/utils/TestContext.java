package com.kit.killrilltesty.ui.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestContext {

    private static TestContext instance = new TestContext();

    public static synchronized TestContext getInstance() {
        if(instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    private String removedItemTitle;
}
