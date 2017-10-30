package com.clouway.main;

import java.io.File;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class UsageConfiguration {

    private String type;
    private String action;

    public UsageConfiguration(String configArgs[]) {
        if (configArgs[0].equals("-type")) {
            type = configArgs[1];
        }
        action = configArgs[3];
    }

    public boolean printsAverage() {
        return action.equals("--printAverageStats");
    }

    public boolean isJson() {
        return type.equals("json");
    }

    public boolean isXml() {
        return type.equals("xml");
    }
}
