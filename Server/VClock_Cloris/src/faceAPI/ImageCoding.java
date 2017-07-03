package faceAPI;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

public class ImageCoding {
	// ���ַ���תΪͼƬ(ͼƬ�ֽ����У���Ӧ����ͼƬ�洢��Ϣ������/λ�ã�)
	public boolean generateImg(String imgStr, String imgFilePath)
			throws Exception {
		if (imgStr == null)
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// ����
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				// �����쳣����
				if (b[i] < 0)
					b[i] += 256;
			}
			// ����jpegͼƬ
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	// ��ͼƬ�ļ�ת��Ϊ�ֽ������ַ��������������Base64���봦�� (ͼƬ�洢λ��)
	public String GetImageStr(String imgFilePath) {
		InputStream in = null;
		byte[] data = null;
		// ��ȡͼƬ�ֽ�����
		try {
			in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���ֽ�����Base64����
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// ����Base64��������ֽ������ַ���
	}
}
