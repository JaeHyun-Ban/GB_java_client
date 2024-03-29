package multi_client;

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

			InputStream is = socket.getInputStream();//전송받은 소켓을 받음(receive)
			BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));//받은 것을 읽음
			
			while(true) {
				
				//받은 메세지 객체 생성
				String message = bf.readLine();
				
				//추가: 메세지를 받을 때, 자신이라면 콘솔창에서 출력하지 않는 코드를 생성
				//서버로 부터 받은 message를 > 기반으로 자르고 id부분이 userId와 같다면 출력부분은 생략
				String[] split = message.split(">");//이름> 대화 / 를 기준으로 자른다
				if(split.length == 2 && split[0].equals(MainClient.userId)) { //이건 내가 쓴거 안보게하는용
					//잘려나간 길이가 2 `이며` 잘라낸 아이디가 메인에 등록된 아이디 라면
					continue;
				}
				
				System.out.println(message);
				
			}//while
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}





























