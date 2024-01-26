package proje1;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class Client {
    private static final int MAX_SERVERS = 3;
    private static final int MIN_CLIENT_ID = 1;
    private static final int MAX_CLIENT_ID = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Kullanıcıdan istemci numarasını girmesini iste
        int clientID = getInputNumber(scanner, "Enter client ID (between " + MIN_CLIENT_ID + " and " + MAX_CLIENT_ID + "): ",
                MIN_CLIENT_ID, MAX_CLIENT_ID);
        
        // Rastgele bir sunucu seç
        Random random = new Random();
        int selectedServer = random.nextInt(MAX_SERVERS) + 1; // Server numaraları 1'den başlıyor
        
        System.out.println("Selected server: Server" + selectedServer);
        
        // Konsoldan istekler için numara girilmesini iste
        int choice;
        do {
        	System.out.println("SERILESTIRILMISNESNE_otomatiktir");
        	System.out.println("1-5 arası seçim yap:");
            System.out.println("1. ABONOL");
            System.out.println("2. ABONIPTAL");
            System.out.println("3. GIRIS");
            System.out.println("4. CIKIS"); 
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (choice) {
                case 1:
                    sendAndReceiveMessage("localhost", 5000 + selectedServer, clientID, "ABONOL");
                    break;
                case 2:
                    sendAndReceiveMessage("localhost", 5000 + selectedServer, clientID, "ABONIPTAL");
                    break;
                case 3:
                    sendAndReceiveMessage("localhost", 5000 + selectedServer, clientID, "GIRIS");
                    break;
                case 4:
                    sendAndReceiveMessage("localhost", 5000 + selectedServer, clientID, "CIKIS");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 to 5.");
                    break;
            }
        } while (choice != 5);
        
        scanner.close();
    }

    private static void sendAndReceiveMessage(String host, int port, int clientID, String message) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send a message to the server with client ID
            out.println(message + " " + clientID);

            // Receive the response from the server
            String response = in.readLine();
            String response2 = in.readLine();
            System.out.println("Response from server on port " + port + ": " + response);
            System.out.println("Response from server on port " + port + ": " + response2);
            socket.close();
        } catch (IOException e) {
            System.out.println("Error connecting to server on port " + port + ": " + e.getMessage());
        }
    }

    private static int getInputNumber(Scanner scanner, String message, int min, int max) {
        int number;
        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                System.out.print(message);
                scanner.next();
            }
            number = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } while (number < min || number > max);
        return number;
    }
}
