package org.badgers.business.fcmtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.ApnsConfig;
import com.google.firebase.messaging.Aps;
import com.google.firebase.messaging.ApsAlert;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.TopicManagementResponse;
import com.google.firebase.messaging.WebpushConfig;
import com.google.firebase.messaging.WebpushNotification;

/**
 * Firebase Cloud Messaging (FCM) snippets for documentation.
 */
public class FcmTest {
	
	public static void main(String[] args) throws Exception {
		FcmTest fcmTest = new FcmTest();
		fcmTest.index();
	}
	
	public String index()throws Exception{
        
//        List<MobileTokenVO> tokenList = fcmService.loadFCMInfoList(vo); 
        
            String token = "eLBXgr-xXFY:APA91bETn7493-OKe7Mn25DW_auZkMhd41xkeHCmztzWFO0aX5PQN8VMmb5wAdhLutPk8ZW_UHPdz3cwXiLC1Owqq_leOYEZhpRweZmccZFZD86_kMJbrRZsnXA9FjZyEg4f1bkiPKQC";
            
            final String apiKey = "AAAAirDSVJU:APA91bELk-vmeH3kQD2YRm3zrpAueunhkJVop1pF3L-G4mTQtfeAANIhnRBW5-yUcYDpupZ2ByjjzQ4sCXCo0bPNOkehZszbe3eat_SFgpKHsbL8N7gzxcx0Y3lvJsvFMrZ9Ly8fewf3";
            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "key=" + apiKey);

            conn.setDoOutput(true);
//            String userId =(String) request.getSession().getAttribute("ssUserId");

            // 이렇게 보내면 주제를 ALL로 지정해놓은 모든 사람들한테 알림을 날려준다.
//            String input = "{\"notification\" : {\"title\" : \"여기다 제목 넣기 \", \"body\" : \"여기다 내용 넣기\"}, \"to\":\"/topics/ALL\"}";
            
//            // 이걸로 보내면 특정 토큰을 가지고있는 어플에만 알림을 날려준다  위에 둘중에 한개 골라서 날려주자
            String input = "{\"notification\" : {\"title\" : \" hello Eunice \", \"body\" : \"알지도 못하면서 까부러\"}, \"to\":\""+token+"\"}";

            OutputStream os = conn.getOutputStream();
            
            // 서버에서 날려서 한글 깨지는 사람은 아래처럼  UTF-8로 인코딩해서 날려주자
            os.write(input.getBytes("UTF-8"));
            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post parameters : " + input);
            System.out.println("Response Code : " + responseCode);
            
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // print result
            System.out.println(response.toString());
            

    return "jsonView";
}


	public void sendToToken() throws FirebaseMessagingException {
		// [START send_to_token]
		// This registration token comes from the client FCM .SDKs.
		String registrationToken = "d2kieDesIyw:APA91bEjra6yzCwzXLc1TG5ORuHNAPDcV_ti6CM-IcVKhEBdy4iJxA9WLnBMHTOkA3uLvLhBsTRUo51YXRLx9_Z_3jWTFTllCbbeEezw215V8H2N6IdDP9--D9zQ4XYJGd7HoNAyjgkv";

		// See documentation on defining a message payload.
		Message message = Message.builder().putData("score", "850").putData("time", "2:45").setToken(registrationToken)
				.build();

		// Send a message to the device corresponding to the provided
		// registration token.
		String response = FirebaseMessaging.getInstance().send(message);
		// Response is a message ID string.
		System.out.println("Successfully sent message: " + response);
		// [END send_to_token]
	}

	public void sendToTopic() throws FirebaseMessagingException {
		// [START send_to_topic]
		// The topic name can be optionally prefixed with "/topics/".
		String topic = "highScores";

		// See documentation on defining a message payload.
		Message message = Message.builder().putData("score", "850").putData("time", "2:45").setTopic(topic).build();

		// Send a message to the devices subscribed to the provided topic.
		String response = FirebaseMessaging.getInstance().send(message);
		// Response is a message ID string.
		System.out.println("Successfully sent message: " + response);
		// [END send_to_topic]
	}

	public void sendToCondition() throws FirebaseMessagingException {
		// [START send_to_condition]
		// Define a condition which will send to devices which are subscribed
		// to either the Google stock or the tech industry topics.
		String condition = "'stock-GOOG' in topics || 'industry-tech' in topics";

		// See documentation on defining a message payload.
		Message message = Message.builder()
				.setNotification(new Notification("$GOOG up 1.43% on the day",
						"$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day."))
				.setCondition(condition).build();

		// Send a message to devices subscribed to the combination of topics
		// specified by the provided condition.
		String response = FirebaseMessaging.getInstance().send(message);
		// Response is a message ID string.
		System.out.println("Successfully sent message: " + response);
		// [END send_to_condition]
	}

	public void sendDryRun() throws FirebaseMessagingException {
		Message message = Message.builder().putData("score", "850").putData("time", "2:45").setToken("token").build();

		// [START send_dry_run]
		// Send a message in the dry run mode.
		boolean dryRun = true;
		String response = FirebaseMessaging.getInstance().send(message, dryRun);
		// Response is a message ID string.
		System.out.println("Dry run successful: " + response);
		// [END send_dry_run]
	}

	public Message androidMessage() {
		// [START android_message]
		Message message = Message.builder().setAndroidConfig(AndroidConfig.builder().setTtl(3600 * 1000) // 1 hour in
																											// milliseconds
				.setPriority(AndroidConfig.Priority.NORMAL)
				.setNotification(AndroidNotification.builder().setTitle("$GOOG up 1.43% on the day")
						.setBody("$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.")
						.setIcon("stock_ticker_update").setColor("#f45342").build())
				.build()).setTopic("industry-tech").build();
		// [END android_message]
		return message;
	}

	public Message apnsMessage() {
		// [START apns_message]
		Message message = Message.builder()
				.setApnsConfig(ApnsConfig.builder().putHeader("apns-priority", "10").setAps(Aps.builder()
						.setAlert(ApsAlert.builder().setTitle("$GOOG up 1.43% on the day")
								.setBody("$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.").build())
						.setBadge(42).build()).build())
				.setTopic("industry-tech").build();
		// [END apns_message]
		return message;
	}

	public Message webpushMessage() {
		// [START webpush_message]
		Message message = Message.builder()
				.setWebpushConfig(WebpushConfig.builder()
						.setNotification(new WebpushNotification("$GOOG up 1.43% on the day",
								"$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day.",
								"https://my-server/icon.png"))
						.build())
				.setTopic("industry-tech").build();
		// [END webpush_message]
		return message;
	}

	public Message allPlatformsMessage() {
		// [START multi_platforms_message]
		Message message = Message.builder()
				.setNotification(new Notification("$GOOG up 1.43% on the day",
						"$GOOG gained 11.80 points to close at 835.67, up 1.43% on the day."))
				.setAndroidConfig(AndroidConfig.builder().setTtl(3600 * 1000)
						.setNotification(AndroidNotification.builder().setIcon("stock_ticker_update")
								.setColor("#f45342").build())
						.build())
				.setApnsConfig(ApnsConfig.builder().setAps(Aps.builder().setBadge(42).build()).build())
				.setTopic("industry-tech").build();
		// [END multi_platforms_message]
		return message;
	}

	public void subscribeToTopic() throws FirebaseMessagingException {
		String topic = "highScores";
		// [START subscribe]
		// These registration tokens come from the client FCM SDKs.
		List<String> registrationTokens = Arrays.asList("YOUR_REGISTRATION_TOKEN_1",
				// ...
				"YOUR_REGISTRATION_TOKEN_n");

		// Subscribe the devices corresponding to the registration tokens to the
		// topic.
		TopicManagementResponse response = FirebaseMessaging.getInstance().subscribeToTopic(registrationTokens, topic);
		// See the TopicManagementResponse reference documentation
		// for the contents of response.
		System.out.println(response.getSuccessCount() + " tokens were subscribed successfully");
		// [END subscribe]
	}

	public void unsubscribeFromTopic() throws FirebaseMessagingException {
		String topic = "highScores";
		// [START unsubscribe]
		// These registration tokens come from the client FCM SDKs.
		List<String> registrationTokens = Arrays.asList("YOUR_REGISTRATION_TOKEN_1",
				// ...
				"YOUR_REGISTRATION_TOKEN_n");

		// Unsubscribe the devices corresponding to the registration tokens from
		// the topic.
		TopicManagementResponse response = FirebaseMessaging.getInstance().unsubscribeFromTopic(registrationTokens,
				topic);
		// See the TopicManagementResponse reference documentation
		// for the contents of response.
		System.out.println(response.getSuccessCount() + " tokens were unsubscribed successfully");
		// [END unsubscribe]
	}

}