
package keyboard;



public class renderer {
	
	public static int width = Main.WIDTH, height = Main.HEIGHT;
	public static int[] pixels = new int[width * height];
	
	public static void renderBackground() {
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				pixels[x + y * width] = 0xAFFF6FF;
				
				if(x % 100 < 3 || x % 100 > 97 || y % 100 < 3 || y % 100 > 97) {
					pixels[x + y * width] = 0x910047;        //0xffcccccc
				}
			}    //0xffcaff
		}
	}
	
	public static void renderSprite(sprite sprite, int xp, int yp) {
		if(xp < -sprite.width || xp > width || yp < -sprite.height || yp > height) return;
		
		for(int y = 0; y < sprite.height; y++) {
			int yy = y + yp;
			if(yy < 0 || yy > height) continue;
			for(int x = 0; x < sprite.width; x++) {
				int xx = x + xp;
				if(xx < 0 || xx > width) continue;
				int col = sprite.pixels[x + y * sprite.width];    //0xffff5800
				if(col == 0xffff00ff) continue;   //0xffff00ff
				else pixels[xx + yy * width] = col;
			}
		}
		
	}
	
}

    

