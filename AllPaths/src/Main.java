import util.AF;
import util.Graph;

public class Main {

	public static void main(String[] args) {
        //�ڼ���ͼ��������(0,1)��������(0-6)���յ����(0-6)
		AF operation = new AF(new Graph(0), 3, 6);
		operation.getResult();

	}
}
