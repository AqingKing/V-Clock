package fAPI;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpGetandPost {
	// ����get����
	public String sendGet(String url, String param, String imgStr) {
		String result = "";
		BufferedReader in = null;
		String urlStringName = url + "?" + param;
		try {
			URL realUrl = new URL(urlStringName);
			// �򿪺�url֮�������
			URLConnection connection = realUrl.openConnection();
			// ��������ͨ�õ�����(�ɺ���)
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			// ����ʵ�ʵ�����
			connection.connect();
			// ��ȡ������Ӧͷ�ֶ�
			Map<String, List<String>> map = connection.getHeaderFields();
			// ����������Ӧͷ�ֶ�
			for (String key : map.keySet()) {
				System.out.println(key + "-->" + map.get(key));
			}
			// ����BufferedReader����������ȡurl����Ӧ
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("����GET��������쳣��" + e);
			e.printStackTrace();
		}
		// ʹ��finally�ر�������
		finally {
			try {
				if (in != null)
					in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	// ����post����
	public String sendPost(String url, String param) throws Exception {
		String result = "";
		try {
			URL realUrl = new URL(url);
			// �򿪺�url֮�������
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			conn.setInstanceFollowRedirects(true);
			conn.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			conn.connect();
			// post����
			DataOutputStream out = new DataOutputStream(conn.getOutputStream());
			out.writeBytes(param);
			out.flush();
			out.close();
			// ��ȡ��Ӧ
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				line = new String(line.getBytes(), "utf-8");
				result += line;
			}
			reader.close();
			conn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
