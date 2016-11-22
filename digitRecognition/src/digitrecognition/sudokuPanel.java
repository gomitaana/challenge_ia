package digitrecognition;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author gomit
 */
public class sudokuPanel extends JPanel implements MouseMotionListener, MouseListener{

    public sudokuPanel() {
        initComponents();
    }
    
    private void initComponents() {
        num1 = new javax.swing.JButton();
        num2 = new javax.swing.JButton();
        num3 = new javax.swing.JButton();
        num4 = new javax.swing.JButton();
        num5 = new javax.swing.JButton();
        num6 = new javax.swing.JButton();
        num7 = new javax.swing.JButton();
        num8 = new javax.swing.JButton();
        num9 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(100, 100));
        setPreferredSize(new java.awt.Dimension(100, 100));
        setLayout(new java.awt.GridLayout(3, 3));

        num1.setMaximumSize(new java.awt.Dimension(33, 33));
        num1.setText("0");
        num1.setMinimumSize(new java.awt.Dimension(33, 33));
        num1.setBorder(new LineBorder(Color.BLACK));

        num2.setMinimumSize(new java.awt.Dimension(33, 33));
        num2.setText("0");
        num2.setBorder(new LineBorder(Color.BLACK));
        
        num3.setMinimumSize(new java.awt.Dimension(33, 33));
        num3.setText("0");
        num3.setBorder(new LineBorder(Color.BLACK));
        
        num4.setMinimumSize(new java.awt.Dimension(33, 33));
        num4.setText("0");
        num4.setBorder(new LineBorder(Color.BLACK));
        
        num5.setMinimumSize(new java.awt.Dimension(33, 33));
        num5.setText("0");
        num5.setBorder(new LineBorder(Color.BLACK));

        num6.setMinimumSize(new java.awt.Dimension(33, 33));
        num6.setText("0");
        num6.setBorder(new LineBorder(Color.BLACK));
        
        num7.setMinimumSize(new java.awt.Dimension(33, 33));
        num7.setText("0");
        num7.setBorder(new LineBorder(Color.BLACK));
        
        num8.setMinimumSize(new java.awt.Dimension(33, 33));
        num8.setText("0");
        num8.setBorder(new LineBorder(Color.BLACK));
        
        num9.setMinimumSize(new java.awt.Dimension(33, 33));
        num9.setText("0");
        num9.setBorder(new LineBorder(Color.BLACK));
       
        add(num1);
        add(num2);
        add(num3);
        add(num4);
        add(num5);
        add(num6);
        add(num7);
        add(num8);
        add(num9);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private javax.swing.JButton num1;
    private javax.swing.JButton num2;
    private javax.swing.JButton num3;
    private javax.swing.JButton num4;
    private javax.swing.JButton num5;
    private javax.swing.JButton num6;
    private javax.swing.JButton num7;
    private javax.swing.JButton num8;
    private javax.swing.JButton num9;
}
