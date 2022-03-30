package league;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends Frame implements ActionListener{
	
	Label l1, l2, l3;
	TextField t1, t2, t3;
	Button b1, b2;
	
	public UI() 
	{
		l1 = new Label("Summoner Name:");
		l2 = new Label("Summoner ID:");
		l3 = new Label("Summoner Profile ID:");
		t1 = new TextField(10);
		t2 = new TextField(15);
		t3 = new TextField(10);
		b1 = new Button("Search");
		b2 = new Button("Exit");
		add(l1);
		add(t1);
		add(b1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(b2);
		setSize(400,400);
		setTitle("LOL Stats");
		setLayout(new FlowLayout());
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent action)
	{
		String inp = "";
		
		try {
			inp = t1.getText();
		}
		catch(Exception e)
		{
			System.out.println("Invalid");
		}
		
		if(action.getSource()==b1)
		{
			Summ s = new Summ(inp);
			t2.setText(s.id);
			t3.setText(s.profileIconId);
		}
		
		if(action.getSource()==b2)
		{
			CloseFrame();
		}
		
	}
	
	public void CloseFrame()
	{
		super.dispose();
	}
	
	public static void main(String[] args)
	{
		UI u = new UI();
		u.setVisible(true);
		u.setLocation(300,300);
	}

}
