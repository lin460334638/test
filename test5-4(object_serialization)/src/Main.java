/*��Student��ʾѧ�������԰���{studentID, name, sex} (ѧ�ţ��������Ա�)��ʹ�����л���������Student��ѧ����Ϣ���ļ�list.txt���룬������ѧ���������С�ע�⣬�����������Ա������֯��String���ͣ���ѧ�ſ�����StringҲ������Long��
ʹ��ObjectOutputStream���Ѿ������ѧ����Ϣд�����ļ���student.bin���С�
ʹ��ObjectInputStream����student.bin���еĶ�����Ϣ���������ʾ�ڿ���̨�С�
*/
public class Main {

	public static void main(String[] args) {
		Student s=new Student();
		s.readfile();
		s.sort();
		s.output();
		s.input();
	}

}
