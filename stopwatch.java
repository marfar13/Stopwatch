package Stopwatch;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class stopwatch implements ActionListener
{
	JFrame frame= new JFrame();
	JButton sbutton = new JButton("START");
	JButton rbutton = new JButton("RESET");
	JLabel Tlabel = new JLabel();
	int Time=0;
	int sec=0;
	int min=0;
	int ho=0;
	boolean start=false;
	String sec_= String.format("%02d", sec);
	String min_= String.format("%02d", min);
	String ho_= String.format("%02d", ho);
	
	Timer timer= new Timer(1000, new ActionListener() 
	{
		
		public void actionPerformed(ActionEvent e)
		{
			Time+=1000;
			ho=(Time/3600000);
			min=(Time/60000)%60;
			sec=(Time/1000)%60;
			
			sec_= String.format("%02d", sec);
			min_= String.format("%02d", min);
			ho_= String.format("%02d", ho);
			
			Tlabel.setText(ho_+":"+min_+":"+sec);
		}
		
		
	});
	
	stopwatch()
	{
		Tlabel.setText(ho_+":"+ min_+":"+ sec_);
		Tlabel.setBounds(100, 100, 200, 100);
		Tlabel.setBorder(BorderFactory.createBevelBorder(1));
		Tlabel.setOpaque(true);
		Tlabel.setHorizontalAlignment(JTextField.CENTER);
		
		sbutton.setBounds(100, 200, 100, 50);
		sbutton.setFocusable(false);
		sbutton.addActionListener(this);
		
		rbutton.setBounds(200, 200, 100, 50);
		rbutton.setFocusable(false);
		rbutton.addActionListener(this);
		
		frame.add(sbutton);
		frame.add(rbutton);
		frame.add(Tlabel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		 if(e.getSource()==sbutton)
		 {
			   
			   if(start==false) 
			   {
			    start=true;
			    sbutton.setText("STOP");
			    start();
			   }
			   else 
			   {
			    start=false;
			    sbutton.setText("START");
			    stop();
			   }
			   
			  }
			  if(e.getSource()==rbutton)
			  {
			   start=false;
			   sbutton.setText("START");
			   reset();
			  }
		
	}

	
	void start()
	{
		 timer.start();
	}
	
	
	void stop()
	{
		timer.stop();
	}
	
	void reset()
	{
		 timer.stop();
		  Time=0;
		  sec =0;
		  min=0;
		  ho=0;
		  sec_ = String.format("%02d", sec);
		  min_= String.format("%02d", min);
		  ho_ = String.format("%02d", ho);       
		  Tlabel.setText(ho_+":"+min_+":"+sec_);
	}
}
