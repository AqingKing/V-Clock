package fAPI;

public class Configuration {
	public String getUrl1() {
		return url1;
	}
	public String getUrl2() {
		return url2;
	}
	public String getAppID() {
		return appID;
	}

	public String getAppKey() {
		return appKey;
	}
    // ���ͼƬ(Image)�е�����(Face)��λ�ú���Ӧ���������ԣ��������������
	private String url1 = "http://api.eyekey.com/face/Check/checking";
	//��������Face�����ƶȣ���ֵ�ٷ���
	private String url2="http://api.eyekey.com/face/Match/match_compare";
	// ����people ��face_id��
	private String url3="http://api.eyekey.com/People/people_create";
	
	private String appID = "efb84878045e4ee79994f1ed232ff17f";
	private String appKey = "6f8d0d8879d2402aadc804e30810269e";
}
