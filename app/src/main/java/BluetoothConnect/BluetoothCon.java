package BluetoothConnect;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class BluetoothCon {
    private static final String TAG = "bluetooth1";
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;
    private String address;

    public BluetoothCon(String address) {
        this.address = address;
        btAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public void connect() {
        checkBTState();

        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        try {
            btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
            btAdapter.cancelDiscovery();
            btSocket.connect();
            outStream = btSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        if (outStream != null) {
            try {
                outStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            btSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData(String message) {
        byte[] msgBuffer = message.getBytes();

        try {
            outStream.write(msgBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkBTState() {
        if (btAdapter == null) {
            errorExit("Fatal Error", "Bluetooth не поддерживается");
        } else {
            if (!btAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(btAdapter.ACTION_REQUEST_ENABLE);
            }
        }
    }

    private void errorExit(String title, String message) {
        Log.e(TAG, title + " - " + message);
    }
}
