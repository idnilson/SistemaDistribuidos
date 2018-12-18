/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.main;

/**
 *
 * @author idnil
 */
import java.awt.image.BufferedImage;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import javax.imageio.ImageIO;

import server.serial.ObjectsHandler;
import server.serial.objects.Image;

import com.mortennobel.imagescaling.ResampleOp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.imageio.ImageIO;

import server.serial.ObjectsHandler;
import server.serial.objects.Image;

public class ServidorUDP {

	public static void main(String[] args) {
		ServidorUDP main = new ServidorUDP();
		main.mainWrapper();
	}

	public void mainWrapper() {
		System.out.println("Server");
		try {
			DatagramSocket ss = new DatagramSocket(2500);
			byte[] buffer = new byte[250000];
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			ss.receive(dp);
			ObjectsHandler oh = new ObjectsHandler();
			Image received = oh.byteToImage(dp.getData());
			ResampleOp resampleOp = new ResampleOp(1920, 1080); 
			BufferedImage resizedImage = resampleOp.filter(received.getImage(), null);
			File outputFileResized = new File("imgnoserver.jpg");
			ImageIO.write(resizedImage, "jpg", outputFileResized);
		} catch (IOException e) {
		}
		System.out.println("End");
	}

}// ServidorUDP