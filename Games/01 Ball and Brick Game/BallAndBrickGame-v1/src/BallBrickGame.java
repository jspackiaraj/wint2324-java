import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BallBrickGame extends JFrame {

    private GamePanel panel;

    public BallBrickGame() {
        panel = new GamePanel();
        add(panel);
        setTitle("Ball and Brick Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BallBrickGame();
    }
}

class GamePanel extends JPanel implements ActionListener {
    private Timer timer;
    private Rectangle ball;
    private Rectangle paddle;
    private Rectangle[] bricks;
    private int ballXDir = -1;
    private int ballYDir = -2;
    private final int DELAY = 10;

    public GamePanel() {
        initGame();
        addKeyListener(new TAdapter());
        setFocusable(true);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initGame() {
        ball = new Rectangle(120, 350, 10, 10);
        paddle = new Rectangle(100, 400, 100, 10);
        initBricks();
    }

    private void initBricks() {
        bricks = new Rectangle[21];
        for (int i = 0, y = 50; i < bricks.length; i++) {
            bricks[i] = new Rectangle((i % 7) * 70 + 5, y, 50, 20);
            if ((i + 1) % 7 == 0) y += 30;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(ball.x, ball.y, ball.width, ball.height);
        g.setColor(Color.BLUE);
        g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
        g.setColor(Color.RED);
        for (Rectangle brick : bricks) {
            g.fillRect(brick.x, brick.y, brick.width, brick.height);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveBall();
        checkCollision();
        repaint();
    }

    private void moveBall() {
        ball.x += ballXDir;
        ball.y += ballYDir;

        if (ball.x < 0 || ball.x > getWidth() - ball.width) {
            ballXDir = -ballXDir;
        }
        if (ball.y < 0 || ball.y > getHeight() - ball.height) {
            ballYDir = -ballYDir;
        }
    }

    private void checkCollision() {
        if (ball.intersects(paddle)) {
            ballYDir = -ballYDir;
        }

        for (int i = 0; i < bricks.length; i++) {
            if (ball.intersects(bricks[i])) {
                ballYDir = -ballYDir;
                bricks[i] = new Rectangle();
            }
        }
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && paddle.x > 0) {
                paddle.x -= 20;
            }
            if (key == KeyEvent.VK_RIGHT && paddle.x < getWidth() - paddle.width) {
                paddle.x += 20;
            }
        }
    }
}
