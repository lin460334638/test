package test7;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class MyClient extends JFrame{
	private BufferedReader reader;
	private PrintWriter writer;
	Socket socket;
	private JTextArea ta = new JTextArea();
	private JTextField tf = new JTextField();
	Container cc;
	
	public MyClient(String title){
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane();
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		scrollPane.setViewportView(ta);
		cc.add(tf,"South");
		tf.addActionListener(new ActionListener(){
			//���¼�
			public void actionPerformed(ActionEvent e){
				//���ı����е���Ϣд����
				writer.println(tf.getText());
				//���ı����е���Ϣ��ʾ���ı�����
				ta.append(tf.getText()+'\n');
				ta.setSelectionEnd(ta.getText().length());
				tf.setText("");
			}

		});
	}
	private void connect(){
		ta.append("��������\n");
		try{
			socket = new Socket("192.168.199.185",8770);
			
			writer = new  PrintWriter(socket.getOutputStream(),true);
		
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ta.append("�������\n");
			getTcpMessage();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void getTcpMessage(){
		try{
			while(true){
				//��ÿͻ�����Ϣ
				ta.append("������:"+reader.readLine()+'\n');
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(reader!=null){
				reader.close();
			}
			if(socket!=null){
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		MyClient client = new MyClient("���������������");
		client.setSize(400,400);
		client.setVisible(true);
		client.connect();
	}

}
