package multi_server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServer {
	
	//한명이 들어올 때마다 clientManage에게 보내서 관리
	//연결된 socket을 static으로 생성해서 관리..?
	
	//PrintWriter를 저장하는 list를 생성 > 서버에 접속하는 클라이언트의 output을 저장할 리스트
	public static ArrayList<PrintWriter> list = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		/*
		 * 채팅은, 클라이언트와 클라이언트간의 대화이다.
		 * 즉 서버의 역활은 클라이언트의 채팅글을 전달만하고, 채팅을 참여하진 않습니다.
		 * 그래서 서버는 여러 클라이언트를 서로 연결할 수 있게하고,
		 * 클라이언트에게 받은 데이터를 모든 클라이언트에게 전달하도록 처리한다.
		 */
		try {
			
			ServerSocket serverSocket = new ServerSocket(8383);//port번호 넣고 생성
			
			//무한히 돌며 접속하는 클라이언트들을 관리한다.
			while(true) {
				System.out.println("------연결 대기------");
				Socket socket = serverSocket.accept();
				System.out.println("------연결 성공------");
				
				
				//연결이 들어올 때 마다, 클라이언트 관리 클래스를 생성해준다.
				ClientManage client = new ClientManage(socket);
				
//				OutputStream os = socket.getOutputStream();
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				list.add(out);
//				list.add(new PrintWriter(socket.getOutputStream()));

				client.start();
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
	
}

















































