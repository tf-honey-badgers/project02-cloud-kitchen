package org.badgers.customer.kakao;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KakaoAccessToken {
	public static JsonNode getKakaoAccessToken(String code) {

        final String RequestUrl = "https://kauth.kakao.com/oauth/token"; // Host
 
        final List<NameValuePair> postParams = new ArrayList<NameValuePair>();

        //포스트 파라미터의 grant_type이라는 명칭에 authorization_code를 추가한다 아래도 동일
        postParams.add(new BasicNameValuePair("grant_type", "authorization_code")); 
        													
        postParams.add(new BasicNameValuePair("client_id", "3aedd6d785bf068e8df19174bf251262")); //자신의 RESTAPI 코드 

    //    postParams.add(new BasicNameValuePair("redirect_uri", "http://54.180.97.18/customer/main/kakaologin")); //  리다이렉션주소
        postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost:3001/customer/main/kakaologin")); //  리다이렉션주소
 
        postParams.add(new BasicNameValuePair("code", code));// 로그인 과정중 얻은 code 값
 
        final HttpClient client = HttpClientBuilder.create().build();
 
        final HttpPost post = new HttpPost(RequestUrl);
 
        JsonNode returnNode = null;
 
        try {
 
            post.setEntity(new UrlEncodedFormEntity(postParams));
            
            final HttpResponse response = client.execute(post);
            
            final int responseCode = response.getStatusLine().getStatusCode();


 
         // JSON 형태 반환값 처리
            ObjectMapper mapper = new ObjectMapper();
 
            returnNode = mapper.readTree(response.getEntity().getContent());
 
        } catch (UnsupportedEncodingException e) {
 
            e.printStackTrace();
 
        } catch (ClientProtocolException e) {
 
            e.printStackTrace();
 
        } catch (IOException e) {
 
            e.printStackTrace();
 
        } finally {
 
        }
 
        return returnNode;
 
    }




}
