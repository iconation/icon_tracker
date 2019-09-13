// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.util;

import com.dfg.icon.core.exception.IconCode;
import java.util.Iterator;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import com.google.gson.JsonArray;

public class IRCUtil
{
    public static JsonArray IRC2_FORMAT;
    public static JsonArray eventLogInputsArray2;
    static String ircFilePath;
    
    public static void initIRC2() throws Exception {
        final File projectPath = new File("");
        final String path = projectPath.getAbsolutePath() + "/IRC/";
        final File file = new File(path + "IRC2.json");
        final BufferedReader br = new BufferedReader(new FileReader(file));
        final StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        final String jsonStr = sb.toString();
        final JsonParser parser = new JsonParser();
        final JsonElement element = parser.parse(jsonStr);
        final JsonObject rootObject = element.getAsJsonObject();
        IRCUtil.IRC2_FORMAT = rootObject.get("result").getAsJsonArray();
        for (final JsonElement je : IRCUtil.IRC2_FORMAT) {
            final String type = je.getAsJsonObject().get("type").getAsString();
            if (type.equals("eventlog")) {
                IRCUtil.eventLogInputsArray2 = je.getAsJsonObject().get("inputs").getAsJsonArray();
            }
        }
    }
    
    public static String checkIRCVersion(final JsonArray jArray, final String filePath) throws Exception {
        IRCUtil.ircFilePath = filePath;
        String IrcFormat = "-";
        if (checkIrc2(jArray)) {
            IrcFormat = IconCode.IRC2_TOKEN.getCode();
        }
        return IrcFormat;
    }
    
    private static boolean checkIrc2(final JsonArray jArray) throws Exception {
        if (IRCUtil.IRC2_FORMAT == null) {
            initIRC2();
        }
        int okCount = 0;
        JsonElement transferLog = null;
        final JsonElement fallbackLog = null;
        for (final JsonElement je : jArray) {
            final String type = je.getAsJsonObject().get("type").getAsString();
            final String name = je.getAsJsonObject().get("name").getAsString();
            if (type.equals("eventlog") && name.equals("Transfer")) {
                transferLog = je;
            }
            else if (type.equals("fallback") && name.equals("fallback")) {
                ++okCount;
            }
            else {
                for (final JsonElement je2 : IRCUtil.IRC2_FORMAT) {
                    if (je.equals(je2)) {
                        ++okCount;
                        break;
                    }
                }
            }
        }
        if (okCount == IRCUtil.IRC2_FORMAT.size() - 1 && transferLog != null) {
            final JsonArray inputsArray = transferLog.getAsJsonObject().get("inputs").getAsJsonArray();
            int checkCount = 0;
            for (int i = 0; i < inputsArray.size(); ++i) {
                final JsonObject removeNameObject = inputsArray.get(i).getAsJsonObject();
                final JsonObject targetObject = IRCUtil.eventLogInputsArray2.get(i).getAsJsonObject();
                if (removeNameObject.get("type").equals(targetObject.get("type"))) {
                    if (removeNameObject.get("type").getAsString().equals("bytes")) {
                        ++checkCount;
                    }
                    else if (removeNameObject.get("indexed").equals(targetObject.get("indexed"))) {
                        ++checkCount;
                    }
                }
            }
            if (checkCount == IRCUtil.eventLogInputsArray2.size()) {
                ++okCount;
            }
        }
        return okCount == IRCUtil.IRC2_FORMAT.size();
    }
    
    static {
        IRCUtil.IRC2_FORMAT = null;
        IRCUtil.eventLogInputsArray2 = null;
        IRCUtil.ircFilePath = "";
    }
}
