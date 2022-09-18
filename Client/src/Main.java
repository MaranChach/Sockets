import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Socket socket;
    static BufferedReader reader;

    static BufferedReader in;
    static BufferedWriter out;


    public static void main(String[] args) throws IOException {

        try {
            socket = new Socket("localhost", 4004);
            reader = new BufferedReader(new InputStreamReader(System.in));

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            System.out.println("Введите выражение n1+n2+...+ni");

            out.write(scanner.nextLine() +"\n");
            out.flush();

            System.out.println(in.readLine());
        }
        catch (IOException e){}
        finally {
            in.close();
            out.close();
            socket.close();
            reader.close();
        }



    }
}