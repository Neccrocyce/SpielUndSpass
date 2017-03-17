package screen;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * Opens a Window displaying the information for the players
 * Set the numberOfPlayers first before creating an instance of this class
 * @author Bernie
 *
 */
public class MainFrame {
	//width and height of window without border
	private int width;
	private int height;
	/**
	 * number of players per team
	 */
	private static int numOfPlayers;
	
	private static MainFrame instance = null;
	
	private JFrame frame;
	private JPanel backPanel, gamePanel, team1Panel, team2Panel;

	
	private MainFrame() {
		initialize();
	}
	
	public static MainFrame getInstance () {
		if (instance == null) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						instance = new MainFrame();
						instance.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		return instance;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Color mainBackgroundColor = Color.LIGHT_GRAY;
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 450);
		frame.setBackground(mainBackgroundColor);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addComponentListener(new ComponentListener() {			
			@Override
			public void componentShown(ComponentEvent e) {}			
			@Override
			public void componentResized(ComponentEvent e) {
				resizeWindow();				
			}
			@Override
			public void componentMoved(ComponentEvent e) {}		
			@Override
			public void componentHidden(ComponentEvent e) {}
		});
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		width = frame.getContentPane().getWidth();
		height = frame.getContentPane().getHeight();
		
		width = 784;	//delete
		height = 411;	//delete
		
		backPanel = new JPanel();
		backPanel.setLayout(null);
		backPanel.setBounds(0, 0, width, height);
		frame.getContentPane().add(backPanel);
		
		
		//set GamePanel
		gamePanel = new JPanel();
		gamePanel.setLayout(null);
		gamePanel.setBounds(width / 4, 0, width / 2, height);
		gamePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backPanel.add(gamePanel);
		
		//set GamePanel-Titel, -Text, -Notes
		createPanel(gamePanel, true, 0, 0, gamePanel.getWidth(), height / 5);
//		createPanel(gamePanel, true, 0, gamePanel.getComponent(0).getHeight(), gamePanel.getWidth(), (height - height / 5) * (numOfPlayers - 1) / (numOfPlayers + 2));
//		createPanel(gamePanel, true, 0, )
		
		//setTeam1Panel
		team1Panel = new JPanel();
		team1Panel.setBounds(0, 0, width / 4, height);
		team1Panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backPanel.add(team1Panel);
		
		//setTeam2Panel
		team2Panel = new JPanel();
		team2Panel.setBounds(3 * (width / 4), 0, width / 4, height);
		team2Panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		backPanel.add(team2Panel);
		
		//setTeamsPanels
		JPanel tmpPanel = team1Panel;
		for (int i = 0; i < 2; i++) {
			createPanel(tmpPanel, true, 0, 0, tmpPanel.getWidth(), tmpPanel.getHeight() / 5);
			
			
			tmpPanel = team2Panel;
		}
				
	}
	
	private void createPanel (JPanel parent, boolean border, int x, int y, int width, int height) {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(x, y, width, height);
		if (border) {
			panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		}
		parent.add(panel);
	}
	
	public static void setNumOfPlayers(int numOfPlayers) {
		MainFrame.numOfPlayers = (numOfPlayers % 2) == 0 ? numOfPlayers / 2 : numOfPlayers / 2 + 1;
	}
	
	private void resizeWindow() {
		// TODO Auto-generated method stub
	}

}
