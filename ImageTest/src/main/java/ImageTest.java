import javax.swing.*;
import java.awt.*;

/**
 * Created by ScorpionOrange on 2016/1/7.
 */
public class ImageTest {
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame=new ImageFrame();
                frame.setTitle("ImageTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * A frame with an image component
 */
class ImageFrame extends JFrame{
    public ImageFrame(){
        add(new ImageComponent());
        pack();
    }
}

/**
 * A component that displays a tiled image
 */
class ImageComponent extends JComponent{

    private static final int DEFAULT_WIDTH=960;
    private static final int DEFAULT_HEIGHT=480;

    private Image image;

    public ImageComponent(){
        image=new ImageIcon("C:\\Users\\scorp\\Desktop\\DMR.jpg").getImage();
        //image=new ImageIcon("C:\\Users\\scorp\\Desktop\\img0_1024x768.jpg").getImage();
    }

    public void paintComponent(Graphics g){
        if (image==null) return;

        int imageWidth=image.getWidth(this);
        int imageHeight=image.getHeight(this);


        //draw the image in the upper-left corner
        g.drawImage(image,0,0,null);


        //tile the image across the component
        for (int i=0;i*imageWidth<=getWidth();i++) {
            for (int j = 0; j * imageHeight <= getHeight(); j++) {
                if (i + j > 0) {
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
                }
            }
        }

    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
