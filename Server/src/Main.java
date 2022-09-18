import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    static ServerSocket serverSocket;
    static Socket socket;

    static BufferedReader in;
    static BufferedWriter out;


    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(4004);
            socket = serverSocket.accept();
            try{
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                int result = Lexer.Calculate(in.readLine());

                out.write(result + "\n");
                out.flush();
            }
            catch (IOException exception){}
        }
        catch(IOException exception){}
        finally {
            in.close();
            out.close();
            socket.close();
            serverSocket.close();
        }
    }
}