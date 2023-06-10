package Modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Emoji {
    
    private ImageView face;
    private ImageView eyes;
    private ImageView mouth;
    
    public Emoji(Image face, Image eyes, Image mouth) {
        this.face = new ImageView(face);
        this.eyes = new ImageView(eyes);
        this.mouth = new ImageView(mouth);
    }
    
    public ImageView getFace() {
        return face;
    }
    
    public void setFace(Image face) {
        this.face.setImage(face);
    }
    
    public ImageView getEyes() {
        return eyes;
    }
    
    public void setEyes(Image eyes) {
        this.eyes.setImage(eyes);
    }
    
    public ImageView getMouth() {
        return mouth;
    }
    
    public void setMouth(Image mouth) {
        this.mouth.setImage(mouth);
    }
    
}
