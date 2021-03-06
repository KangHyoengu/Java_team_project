package admin;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class QuantityChk {
	
	String orderCnt;

	
	boolean QuanChk(String orderCnt) {
		
			try {
				
				if(orderCnt.equals("")) {
					 throw new Exception("입력 값이 없습니다    ");
				}
				if(Pattern.matches("^[a-zA-Z]*$", orderCnt)) {
					 throw new Exception("숫자만 입력해 주세요    ");
				}
				if(Pattern.matches(" ^[가-힣]*$", orderCnt)) {
					 throw new Exception("숫자만 입력해 주세요    ");
				}
				if(Pattern.matches("[ !@#$%^&*(),.?\":{}|<>]", orderCnt)) {
					throw new Exception("숫자만 입력해 주세요    ");
				}
				
			} catch (Exception e) {
				
				JFrame warn = new JFrame();
				warn.setBounds(200,200,300,150);
				warn.setLayout(null);
				
				JLabel message = new JLabel(e.getMessage(),SwingConstants.CENTER);
				message.setBounds(0,20,300,30);
				warn.add(message);
				
				JButton close = new JButton("확인");
				close.setBounds(100,60,80,40);
				warn.add(close);
				close.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						warn.dispose();
						
					}
				});
				
				
				warn.setVisible(true);
				return true;
			}
			
		return false;
		
	}

}
