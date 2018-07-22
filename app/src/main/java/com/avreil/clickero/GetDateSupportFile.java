package com.avreil.clickero;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.net.time.TimeTCPClient;

public final class GetDateSupportFile {

    public static long currentSeconds;

    public static final void main(String[] args) {
        try {
            TimeTCPClient client = new TimeTCPClient();
            try {
                // Set timeout of 60 seconds
                client.setDefaultTimeout(60000);
                // Connecting to time server
                // Other time servers can be found at : http://tf.nist.gov/tf-cgi/servers.cgi#
                // Make sure that your program NEVER queries a server more frequently than once every 4 seconds
                client.connect("time.nist.gov");
                //System.out.println(client.getDate());
                currentSeconds = client.getTime();
                //System.out.println(Long.toString(currentSeconds));
            } finally {
                client.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}