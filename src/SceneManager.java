import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class SceneManager implements ActionListener {
	
	private static SceneManager instance;
	
	public Scene currentScene;
	
	
	private JFrame frame;
	private TravelDropDown dropDownTravel;
	private JButton travelButton;
	
	private JLabel travelInfo;
	
	private SceneManager() 
	{	
		frame = new JFrame();
		frame.setTitle("Simple example");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		
		travelButton = new JButton("Travel");
		travelButton.addActionListener(this);
	}
	
	public static SceneManager getInstance() {
		if(instance == null)
			instance = new SceneManager();
		
		return instance;
	}
	
	public void update() {
		
		travelInfo = new JLabel("You are currently at " + currentScene.scene_name);
		travelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		
		dropDownTravel = new TravelDropDown(currentScene.getChildrenNames());
		dropDownTravel.setOpaque(true);
		frame.setContentPane(dropDownTravel);
		
		dropDownTravel.add(travelInfo, BorderLayout.CENTER);
		dropDownTravel.add(travelButton, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == travelButton) {
			String destName = (String)dropDownTravel.travelDDown.getSelectedItem();
			currentScene = currentScene.getScene(destName);
			this.update();
		}
	}
	
}

class TravelDropDown extends JPanel {
	
	public JComboBox travelDDown;
	
	public TravelDropDown(String[] travelDestinations) {
		super (new BorderLayout());
		
		travelDDown = new JComboBox(travelDestinations);
		add(travelDDown, BorderLayout.PAGE_START);
	}
}