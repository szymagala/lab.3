package pl.lublin.wsei.java.cwiczenia.console;

import java.io.BufferedInputStream; // obsługa BufferedOutputStream oraz BufferedInputStream
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


public class TestBinCopy {

    public static void main(String[] args) throws IOException //po usunięciu throws podświetla się close
    {
        //FileInputStream in = null;
        //FileOutputStream out = null;
        BufferedInputStream in = null;
        BufferedOutputStream out = null;

        long startTimer = System.nanoTime();

        URL url = new URL("https://filesamples.com/samples/image/tiff/sample_1920%C3%971280.tiff");

        try  //obsługa błędu try catch
        {
            //in = new BufferedInputStream(new FileInputStream("sample_1920×1280.tiff"));   //bufferowanie

            in = new BufferedInputStream(url.openStream());
            out = new BufferedOutputStream(new FileOutputStream("img_copy_url.tiff"));
            // in = new FileInputStream("sample_1920×1280.tiff");
            // out = new FileOutputStream("img_copy.tiff");
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
            e.printStackTrace();
        } finally  //finally, próbuje xamknąć  pliki
        {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }

        long endTimer = System.nanoTime();
        long timeElapsed = endTimer - startTimer;

        System.out.println("Czas wykonania w nanosek: " + timeElapsed);
        System.out.println("Czas wykonania w milisek: " + timeElapsed / 1000000);

    }
}   //ostatnia klamra


