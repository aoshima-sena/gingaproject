package properties;

import java.io.InputStreamReader;
import java.util.Properties;

public class MessageProperties {
	private Properties properties;
	private InputStreamReader instream;
	private String FILE="messages properties";
	private String ROOT="/src/mainfresource/properties/";


	public static MessageProperties getMessage=new MessageProperties();

public String getMessage(String resourced) {
	System.out.println("昭和クイズゲームを開始します。");

	return this.FILE;

}
/**
public 	String getMessage(String resourced,String arguments) {

}
private void Identifier () {

}
**/
}
