package GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Main.GamePanel;
import TileMap.Background;

public class HelpState extends GameState{

private Background bg;
	
	
	private String options ="Back";
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public HelpState(GameStateManager gsm) {
		
		this.gsm = gsm;
		
		try {
			
			bg = new Background("/Backgrounds/menubg.gif", 1);
			bg.setVector(-0.1, 0);
			
			titleColor = new Color(128, 0, 0);
			titleFont = new Font(
					"Algerian",
					Font.PLAIN,
					30);
			
			font = new Font("Arial", Font.PLAIN, 12);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void init() {}
	
	public void update() {
		bg.update();
	}
	
	public void draw(Graphics2D g) {
		
		// draw bg
		bg.draw(g);
		
		// draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		
		g.drawString("HELP", 120, 30);
		
		
		// draw menu options
		g.setFont(font);
	
			g.setColor(Color.RED);
			g.drawString("<- stanga, -> dreapta\n",85,55);
			g.drawString("W saritura, W+E zbor ",85,65);
			g.drawString("F flacara, R atac cu sabia ",85,75);
				g.drawString(options, GamePanel.WIDTH/2-30, GamePanel.HEIGHT - 20);
		
	}
	
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER){
			gsm.setState(GameStateManager.MENUSTATE);
		}
		
	}
	public void keyReleased(int k) {}
	
}
