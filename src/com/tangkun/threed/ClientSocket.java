package com.tangkun.threed;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.xml.registry.BusinessLifeCycleManager;

public class ClientSocket extends Thread {

	private Socket socket;

	private boolean flag;

	private DataInputStream dis;

	private DataOutputStream dos;

	private String filePath;

	private static int BUFF_SIZE = 1024 * 100;
	
	private byte[] buff = new byte[1024 * 100];

	public ClientSocket() {

		try {
			socket = new Socket("127.0.0.1", 90);

			if (socket != null) {

				dis = new DataInputStream(socket.getInputStream());

				dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream(), BUFF_SIZE));
			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {
			
			int len = 0;
			int sendSize = 0;
			FileInputStream fis = new FileInputStream(new File(filePath));
			
			try {
				while ((len = fis.read(buff)) != -1 ) {
					dos.write(buff,0,len);
					dos.flush();
					System.out.println(sendSize += len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
