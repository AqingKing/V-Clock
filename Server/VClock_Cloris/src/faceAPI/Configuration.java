package faceAPI;

public class Configuration {
	public String getUrl1() {
		return url1;
	}

	public String getUrl2() {
		return url2;
	}

	public String getUrl3() {
		return url3;
	}

	public String getUrl4() {
		return url4;
	}

	public String getUrl5() {
		return url5;
	}

	public String getUrl6() {
		return url6;
	}

	public String getAppID() {
		return appID;
	}

	public String getAppKey() {
		return appKey;
	}

	// ���ͼƬ(Image)�е�����(Face)��λ�ú���Ӧ���������ԣ��������������
	private String url1 = "http://api.eyekey.com/face/Check/checking";
	// ��������Face�����ƶȣ���ֵ�ٷ���
	private String url2 = "http://api.eyekey.com/face/Match/match_compare";
	// ����people ��face_id��
	private String url3 = "http://api.eyekey.com/People/people_create";
	// ����crowd
	private String url4 = "http://api.eyekey.com/Crowd/crowd_create";
	// ��һ��People���뵽һ��Crowd��
	private String url5 = "http://api.eyekey.com/Crowd/crowd_add";
	// ָ��һ������Face����һ��Crowd�в�ѯ�������б��������Ƶ�People
	private String url6 = "http://api.eyekey.com/face/Match/match_identify";

	private String appID = "efb84878045e4ee79994f1ed232ff17f";
	private String appKey = "6f8d0d8879d2402aadc804e30810269e";
}
