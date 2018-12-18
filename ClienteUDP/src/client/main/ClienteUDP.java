/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.main;

/**
 *
 * @author idnil
 */
import java.awt.image.BufferedImage;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.File;
import java.net.InetAddress;

import javax.imageio.ImageIO;

import client.serial.ObjectsHandler;
import client.serial.objects.Image;
import java.io.IOException;

public class ClienteUDP {

	public static void main(String[] args) {
		ClienteUDP main = new ClienteUDP();
		main.mainWrapper();
	}

	public void mainWrapper() {
		System.out.println("Client");
		try {
			ObjectsHandler oh = new ObjectsHandler();
			BufferedImage bi = ImageIO.read(new File("src/teste.jpg"));
			DatagramSocket clientSocket = new DatagramSocket();
			Image image = new Image(bi);
			byte[] objectData = oh.objectToByte(image);
			DatagramPacket dp = new DatagramPacket(objectData, objectData.length, InetAddress.getByName("127.0.0.1"), 2500);
			clientSocket.send(dp);
		} catch (IOException e) {
		}
		System.out.println("End");
	}
}
