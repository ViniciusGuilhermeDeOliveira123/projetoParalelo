package com.za.tutorial.rmi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import com.za.tutorial.rmi.server.ChatServerIF;

public class ChatClient extends UnicastRemoteObject implements ChatClientIF,Runnable {
	private static final long serialVersionUID = 1L;
	private String name = null;
	private ChatServerIF chatServer;
	protected ChatClient(String name,ChatServerIF chatServer) throws RemoteException {
		this.name = name;
		this.chatServer = chatServer;
		chatServer.registerChatClient(this);
	}

	@Override
	public void retrieveMessage(String message) throws RemoteException {
		System.out.println(message);
	}

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		String message;
		while(true) {
			message = scanner.nextLine();
			try {
				chatServer.broadcastMessage(name +" : "+message);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
