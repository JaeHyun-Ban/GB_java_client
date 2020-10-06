package single_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Receive extends Thread {
	
	private Socket socket;
	
	//기본생성자 - 소캣을 받음
	public Receive(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		
		try {
			//전송받은 소켓을 받음(receive)
			InputStream is = socket.getInputStream();
			//받은 것을 읽음
			BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			while(true) {
				
				//받은 메세지 객체 생성
				String message = bf.readLine();
				if(message == null) { //메세지가 null이라면
					System.out.println("연결을 종료합니다.");
					break;
				}else { 
					System.out.println("서버:" + message);
				}
			}//while
			
			//사용한거 닫아주기
			is.close();
			bf.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}





























