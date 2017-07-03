package faceAPI;

import net.sf.json.JSONObject;

public class AddtoCrowd {
	public AddtoCrowd() {
		rf = new RecognizeFace();
	}
	public boolean add(String photoFilePath,String personName) throws Exception{
		String face_id=rf.computeFaceID(photoFilePath);
		String result=rf.createOnePeople(face_id, personName);
		//System.out.println(result);
		JSONObject object=JSONObject.fromObject(result);
		int done=object.getInt("added_crowd");
		if(1==done)
			return true;
		else
			return false;
	}
	private RecognizeFace rf;
//	 public static void main(String[] args) throws Exception {
//		 String imgFilePath = "D:\\3.jpg";
//		 AddtoCrowd atc=new AddtoCrowd();
//		 System.out.println(atc.add(imgFilePath, "h1"));
//		
//	}
}