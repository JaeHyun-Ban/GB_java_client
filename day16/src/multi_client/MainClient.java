package multi_client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainClient {
	
	static String userId;
	
	public static void main(String[] args) {
		
		//클라이언트측 코드는 크게 다르지 않다
		//1. sender측에 아이디를 입력받아서 전송하는 부분 추가
		//2. receive측에 내가 쓴 글이라면 출력을 생략하는 부분을 추가.
		
		try {
			Socket socket = new Socket("192.168.104.30", 8383);
			

			Sender sender = new Sender(socket);//메세지 전송 클래스 객체 생성
			Receive receive = new Receive(socket);//메세지 수신 클래스 객체 생성
			
			
			sender.start();//전송 On
			receive.start();//수신 기능 On
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}






































