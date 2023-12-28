import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Missile {
    private Image image;
    private ImageView imageView;
    private double size_x = 100;
    private double size_y = 100;

    // construct the class
    public Missile(double x, double y) {
        this.image = new Image("file:../assets/missile.webp", size_x, size_y, true, true);
        this.imageView = new ImageView(image);
        this.imageView.setX(x - size_x / 2);
        this.imageView.setY(y - size_y / 2);
    }

    // basic methods to return values
    public double x() { return imageView.getX(); }
    public double y() { return imageView.getY(); }
    public Rectangle2D boundingBox() { return new Rectangle2D(this.x(), this.y(), size_x, size_y); }

    // move the airplane
    public void moveLeft() {
        if (imageView.getX() > 100) { imageView.setX(imageView.getX() - 125); }
    }

    public void moveRight() {
        if (imageView.getX() < 600) { imageView.setX(imageView.getX() + 125); }
    }

    // draw the airplane according to its position
    public void draw(GraphicsContext gc) { gc.drawImage(image, this.x(), this.y()); }

    // to provide x position for the bullets
    public double bulletX() { return this.x() + this.size_x / 2; }
    public double bulletX1(int n) { return 100 + 125 * n  + this.size_x / 2; }

}
