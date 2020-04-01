package controller;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDectector {
	private CascadeClassifier face_cascade;

	// Create a constructor method
	public FaceDectector() {
		//System.load("F:\\DOCUMENT\\TRÍ TUỆ NHÂN TẠO-HK2-2019\\Project_AI_Quang\\opencv\\build\\java\\x64\\opencv_java410.dll");
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		face_cascade = new CascadeClassifier(
				"F:\\DOCUMENT\\TRÍ TUỆ NHÂN TẠO-HK2-2019\\Project_AI_Quang\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
		if (face_cascade.empty()) {
			System.out.println("--(!)Error loading(!)--");
			return;
		} else {
			System.out.println(face_cascade);
		}
	}

	public Mat detectFace(Mat inputframe) {
		Mat mRgba = new Mat();
		Mat mGrey = new Mat();
		MatOfRect faces = new MatOfRect();
		inputframe.copyTo(mRgba);
		inputframe.copyTo(mGrey);
		Imgproc.cvtColor(mRgba, mGrey, Imgproc.COLOR_BGR2GRAY);
		Imgproc.equalizeHist(mGrey, mGrey);
		face_cascade.detectMultiScale(mGrey, faces);
		for (Rect rect : faces.toArray()) {
			Imgproc.rectangle(mRgba, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 255, 0));

		}
		return mRgba;
	}

	public Mat Cut(Mat input) {
		Mat mRgba = new Mat();
		Mat mGrey = new Mat();
		Mat m_Cut = new Mat();
		MatOfRect faces = new MatOfRect();
		input.copyTo(mRgba);
		input.copyTo(mGrey);
		Imgproc.cvtColor(mRgba, mGrey, Imgproc.COLOR_BGR2GRAY);
		Imgproc.equalizeHist(mGrey, mGrey);
		face_cascade.detectMultiScale(mGrey, faces);
		Rect cut = null;
		Mat m_CutNew = new Mat();
		for (Rect rect : faces.toArray()) {
			Imgproc.rectangle(mRgba, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 255, 0));
			cut = new Rect(rect.x, rect.y, rect.width, rect.height);
			m_Cut = new Mat(mRgba, cut);
			Imgproc.cvtColor(m_Cut, m_CutNew, Imgproc.COLOR_RGB2GRAY);
		}
		return m_CutNew;
	}

}
