package ro.pub.cs.systems.eim.practical02;

import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private String address;
    private int port;
    private String informationType;
    private TextView currencyTextView;

    private Socket socket;

    public ClientThread(String address, int port, String informationType, TextView currencyTextView) {
        this.address = address;
        this.port = port;
        this.informationType = informationType;
        this.currencyTextView = currencyTextView;
    }

    @Override
    public void run() {
        try {
            socket = new Socket(address, port);
            if (socket == null) {
                Log.e(Constants.TAG, "[CLIENT THREAD] Could not create socket!");
                return;
            }
            BufferedReader bufferedReader = Utilities.getReader(socket);
            PrintWriter printWriter = Utilities.getWriter(socket);
            if (bufferedReader == null || printWriter == null) {
                Log.e(Constants.TAG, "[CLIENT THREAD] Buffered Reader / Print Writer are null!");
                return;
            }
            printWriter.println(informationType);
            printWriter.flush();
            String currency;
            while ((currency = bufferedReader.readLine()) != null) {
                final String finalizedCurrencyInformation = currency;
                currencyTextView.post(new Runnable() {
                    @Override
                    public void run() {
                        currencyTextView.setText(finalizedCurrencyInformation);
                    }
                });
            }
        } catch (IOException ioException) {
            Log.e(Constants.TAG, "[CLIENT THREAD] An exception has occurred: " + ioException.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ioException) {
                    Log.e(Constants.TAG, "[CLIENT THREAD] An exception has occurred: " + ioException.getMessage());
                }
            }
        }
    }
}
