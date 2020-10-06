package basic_client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainClient {
	
	public static void main(String[] args) {
		
		//클라이언트용
		
		try {
			//첫번째 생성자의 매개변수 IP주소, PORT번호
			Socket socket = new Socket("192.168.104.15", 8383); 
			//>(host, port) > host는 ip주소를 입력	
			
			
			
			//소켓 클래스의 inputStream으로 서버로 부터 데이터를 받는다.
			InputStream is = socket.getInputStream(); //메세지를 받기(InputStream 리턴)
			
			//서버로부터 받은 데이터를 문자열 데이터로 변경
			BufferedReader bf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			//변경한 데이터를 한줄 읽어 문자열로 저장
			String result = bf.readLine();
			System.out.println(result);
			
			socket.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
