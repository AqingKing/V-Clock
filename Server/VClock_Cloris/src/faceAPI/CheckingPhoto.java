package faceAPI;

import net.sf.json.JSONObject;

public class CheckingPhoto {
	public CheckingPhoto() {
		rf = new RecognizeFace();
	}

	/*
	 * �������:������Ƭ���ַ������ַ��� ����ֵ��������Ƭͬ����һ���� true ������Ƭ������ͬһ���� false
	 */
	public boolean isTheSamePerson(String photoFilePath1, String photoFilePath2)
			throws Exception {
		float similarity = rf.compareOnewithAnother(photoFilePath1,
				photoFilePath2);
		if (similarity >= 80)
			return true;
		else
			return false;

	}

	/*
	 * �����������Ƭ�Ĵ洢λ�� ����ֵ������Ƭ����ͼ���ҵ�һ��ͬ����һ���˵���Ƭ person_name �������ҵ� null
	 */
	public String doesThePersonExist(String photoFilePath) throws Exception {
		String name = "";
		String face_id = rf.computeFaceID(photoFilePath);
		JSONObject similarPeople = rf.identifyPeopleInCrowd(face_id);
		name = similarPeople.getString("person_name");
		float similarity = Float.parseFloat(similarPeople
				.getString("similarity"));
		if (similarity >= 80)
			return name;
		else
			return null;
	}

	private RecognizeFace rf;
	// public static void main(String[] args) throws Exception {
	// String imgFilePath1 = "D:\\1.jpg";
	// String imgFilePath2 = "D:\\2.jpg";
	// CheckingPhoto cp=new CheckingPhoto();
	// System.out.println(cp.doesThePersonExist(imgFilePath1));
	//
	// }
}
