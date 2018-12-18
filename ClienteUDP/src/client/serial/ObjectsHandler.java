/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.serial;

/**
 *
 * @author idnil
 */
import client.serial.objects.Image;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class ObjectsHandler {

	public ObjectsHandler() {
	}// ObjectsHandler()

	public byte[] objectToByte(Object o) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(o);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return baos.toByteArray();
	}// objectToByte(Object o)

	public Image byteToImage(byte[] bytes) {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(bais);
			Image image = (Image) ois.readObject();
			ois.close();
			return image;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}// byteToImage(byte[] bytes)

}// ObjectsHandler