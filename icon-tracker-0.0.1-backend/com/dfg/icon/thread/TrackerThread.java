// 
// Decompiled by Procyon v0.5.36
// 

package com.dfg.icon.thread;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TrackerThread extends Thread
{
    private static String serverUrl;
    
    public TrackerThread(final String serverUrl) {
        TrackerThread.serverUrl = serverUrl;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                while (true) {
                    final String url = TrackerThread.serverUrl + "/v0/exchange/updateExchageInfo";
                    final URL obj = new URL(url);
                    final HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                    con.setRequestMethod("GET");
                    final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    final StringBuffer response = new StringBuffer();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    Thread.sleep(600000L);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            break;
        }
    }
}
