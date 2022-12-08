
package keyboard;
 

import java.awt.Dimension;
import java.util.Random;
import javax.swing.*;




public class GameObject  {
  



	public double x, y;
	public int width, height;
	public sprite sprite;
	public int value, speed = 10;
	public boolean moving = false, remove = false, hasMoved = false;
            JFrame f;
         
	
	Random rand = new Random();
	
	public GameObject(double x, double y) {
		this.x = x;
		this.y = y;
		this.value = (rand.nextBoolean() ? 3 : 9);
		createSprite();
		this.width = sprite.width;
		this.height = sprite.height;
	}
	
        
        
        
	public void createSprite() {
		if(this.value == 3) {
			this.sprite = new sprite(100, 100, 0xFDECC3);
		}else if(this.value == 9) {
			this.sprite = new sprite(100, 100, 0xccfefe);
		}else if(this.value == 27) {
			this.sprite = new sprite(100, 100, 0xccfecc);
		}else if(this.value == 81) {
			this.sprite = new sprite(100, 100, 0xe5ccfe);
		}else if(this.value == 243) {
			this.sprite = new sprite(100, 100, 0xf33);
		}else if(this.value == 729) {
			this.sprite = new sprite(100, 100, 0xf2bbb1);
		}else if(this.value == 2187) {
			this.sprite = new sprite(100, 100, 0xb3dde4);
		}else if(this.value == 6561) {
			this.sprite = new sprite(100, 100, 0xECC750);
		}else if(this.value == 19683) {
			this.sprite = new sprite(100, 100, 0xE5BF2D);
		}else if(this.value == 59049) {
			this.sprite = new sprite(100, 100, 0xE2B913);
		}else if(this.value == 177147) {
			this.sprite = new sprite(100, 100, 0xEDC22E);
		}else if(this.value == 531441) {
			this.sprite = new sprite(100, 100, 0x5DDB92);
		}else if(this.value == 1594323) {
			this.sprite = new sprite(100, 100, 0xEC4D58);
		}
	}
 

	public boolean canMove() {
          
                    
                    
                if(x < 0 || x + width > Main.WIDTH || y < 0 || y + height > Main.HEIGHT) {
                 
			return false;
		}
		for(int i = 0; i < Game.objects.size(); i++) {
			GameObject o = Game.objects.get(i);
			if(this == o) continue;
			if(x + width > o.x && x < o.x + o.width && y + height > o.y && y < o.y + o.height && value != o.value) {
				return false;
			}
		}
		return true;
	}
	
	public void update() {
		if(Game.moving) {
			if(!hasMoved) {
				hasMoved = true;
			}
			if(canMove()) {
				moving = true;
			}
			
			if(moving) {
				if(Game.dir == 0) x -= speed;
				if(Game.dir == 1) x += speed;
				if(Game.dir == 2) y -= speed;
				if(Game.dir == 3) y += speed;
			}
			if(!canMove()) {
				moving = false;
                               
				x = Math.round(x / 100) * 100;
				y = Math.round(y / 100) * 100;
			}
		}
	
	}
	
	public void render() {
		renderer.renderSprite(sprite, (int) x, (int) y);
	}
}

    
