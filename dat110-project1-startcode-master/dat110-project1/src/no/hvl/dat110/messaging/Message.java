package no.hvl.dat110.messaging;

import java.util.Arrays;

public class Message {

    private byte[] payload;

    public Message(byte[] payload) {
        this.payload = payload; // TODO: check for length within boundary
    }

    public Message() {
        super();
    }

    public byte[] getData() {
        return this.payload;
    }

    public byte[] encapsulate() {

        byte[] encoded = new byte[128];

        encoded[0] = (byte) payload.length;

        for (int i = 0; i < payload.length; i++) {
            encoded[i + 1] = payload[i];
        }

        return encoded;

    }

    public void decapsulate(byte[] received) {
        int n = (int) received[0];

        payload = new byte[n];

        for (int i = 0; i < n; i++) {
            payload[i] = received[i + 1];
        }
    }
}
