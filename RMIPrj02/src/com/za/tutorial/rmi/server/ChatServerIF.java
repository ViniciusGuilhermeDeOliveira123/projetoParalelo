package com.za.tutorial.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.za.tutorial.rmi.client.ChatClientIF;

public interface ChatServerIF extends Remote {
	void registerChatClient(ChatClientIF chatClient) throws RemoteException;
	void broadcastMessage(String message) throws RemoteException;
	

}
