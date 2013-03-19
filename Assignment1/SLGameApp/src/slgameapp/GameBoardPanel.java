/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package slgameapp;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Random;
import sun.java2d.loops.DrawLine;

/**
 *
 * @author Ankit
 */
public class GameBoardPanel extends javax.swing.JPanel {

    /**
     * Creates new form GameBoardPanel
     */
    public int boardsize = 8;
    int sqsize = 60;
    int p1pos = 0, p2pos = 0, p3pos = 0;
    Random randomNumber = new Random();
    ArrayList<SLNumbers> snakes, ladders;
    ArrayList<Color> snakescol, ladderscol;
//    public GameBoardPanel() {
//        initComponents();
//
//    }

    public GameBoardPanel(int nosSnake, int nosLadder, int size, ArrayList<SLNumbers> snake, ArrayList<SLNumbers> ladder)
    {
        snakescol = new ArrayList();
        ladderscol = new ArrayList();
        for (int i = 0; i < nosSnake; i++)
        {
            snakescol.add(new Color(randomNumber.nextInt(256), randomNumber.nextInt(256), randomNumber.nextInt(256), 75));
        }
        for (int i = 0; i < nosSnake; i++)
        {
            ladderscol.add(new Color(randomNumber.nextInt(256), randomNumber.nextInt(256), randomNumber.nextInt(256)));
        }
        boardsize = size;
        snakes = snake;
        ladders = ladder;
    }

    public void drawCurrBoard(int player1, int player2, int player3)
    {

        p1pos = player1;
        p2pos = player2;
        p3pos = player3;
        repaint();
    }

    public void addSnakes(Graphics2D g)
    {
        Point2D head = new Point2D(), tail = new Point2D();
        int x, y;

        for (int i = 0; i < snakes.size(); i++)
        {
            y = (snakes.get(i).initial - 1) / boardsize;
            x = (snakes.get(i).initial - 1) % boardsize;
            if ((boardsize - y) % 2 == 1)
            {
                x = boardsize - x - 1;
            }
            head.x = sqsize * x + sqsize / 2;
            head.y = sqsize * (boardsize - y - 1) + sqsize / 2;
            y = (snakes.get(i).finl - 1) / boardsize;
            x = (snakes.get(i).finl - 1) % boardsize;
            if ((boardsize - y) % 2 == 1)
            {
                x = boardsize - x - 1;
            }
            tail.x = sqsize * x + sqsize / 2;
            tail.y = sqsize * (boardsize - y - 1) + sqsize / 2;
            drawSnake(g, head, tail, sqsize, snakescol.get(i));
        }
    }

    public void addLadders(Graphics2D g)
    {
        Point2D top = new Point2D(), foot = new Point2D();
        int x, y;
        for (int i = 0; i < ladders.size(); i++)
        {
            y = (ladders.get(i).initial - 1) / boardsize;
            x = (ladders.get(i).initial - 1) % boardsize;
            if ((boardsize - y) % 2 == 1)
            {
                x = boardsize - x - 1;
            }
            top.x = sqsize * x + sqsize / 2;
            top.y = sqsize * (boardsize - y - 1) + sqsize / 2;
            y = (ladders.get(i).finl - 1) / boardsize;
            x = (ladders.get(i).finl - 1) % boardsize;
            if ((boardsize - y) % 2 == 1)
            {
                x = boardsize - x - 1;
            }
            foot.x = sqsize * x + sqsize / 2;
            foot.y = sqsize * (boardsize - y - 1) + sqsize / 2;
            drawLadder(g, top, foot, sqsize, ladderscol.get(i));
        }

    }

    private void addPlayerPos(Graphics2D drawArea)
    {
        int j;
        int i;
        if (p1pos > 0)
        {
            j = (p1pos - 1) / boardsize;
            i = (p1pos - 1) % boardsize;;
            if ((boardsize - j) % 2 == 1)
            {
                i = boardsize - i - 1;
            }
            drawArea.setColor(new Color(0, 0, 255, 150));
            drawArea.fillRect(sqsize * (i), sqsize * (boardsize - j - 1), sqsize, sqsize);
        }
        if (p2pos > 0)
        {
            j = (p2pos - 1) / boardsize;
            i = (p2pos - 1) % boardsize;;
            if ((boardsize - j) % 2 == 1)
            {
                i = boardsize - i - 1;
            }
            drawArea.setColor(new Color(0, 255, 0, 150));
            drawArea.fillRect(sqsize * (i), sqsize * (boardsize - j - 1), sqsize, sqsize);
            // drawArea.setColor(Color.BLACK);
        }
        if (p3pos > 0)
        {
            j = (p3pos - 1) / boardsize;
            i = (p3pos - 1) % boardsize;
            if ((boardsize - j) % 2 == 1)
            {
                i = boardsize - i - 1;
            }
            drawArea.setColor(new Color(255, 0, 0, 150));
            drawArea.fillRect(sqsize * (i), sqsize * (boardsize - j - 1), sqsize, sqsize);

        }
        drawArea.setColor(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D drawArea = (Graphics2D) g;
        int num = boardsize * boardsize;
        for (int j = 0; j < boardsize; j++)
        {
            for (int i = 0; i < boardsize; i++)
            {
                drawArea.drawRect(sqsize * i, sqsize * j, sqsize, sqsize);
                if (j % 2 == 0)
                {
                    drawArea.drawString("" + num, sqsize * i + sqsize / 2, sqsize * j + sqsize / 2);

                }

                if (j % 2 == 1)
                {
                    drawArea.drawString("" + num, sqsize * (boardsize - i - 1) + sqsize / 2, sqsize * j + sqsize / 2);

                }
                num--;
            }
        }

        addLadders(drawArea);
        addSnakes(drawArea);
        addPlayerPos(drawArea);
        // drawSnake(drawArea, init, finl, sqsize, new Color(255,0,0,50));
        //  drawArea.drawLine(sqsize*2+10, sqsize*2+20, sqsize*6+10, sqsize*6+20);
        //  drawArea.drawLine(sqsize*2+30, sqsize*2+20, sqsize*6+30, sqsize*6+20);
//       Point2D inter = init.add(finl);
//       snake.moveTo(init.x,init.y);
//       inter.half();
//       snake.curveTo(init.x, init.y, inter.x-10,inter.y-10, finl.x,finl.y);
//       snake.closePath();
//
//       drawArea.fill(snake);
        // drawLadder(drawArea, finl, init, sqsize, Color.yellow);

    }

    private void drawLadder(Graphics2D arena, Point2D foot, Point2D top, int sqsize, Color ladderColor)
    {
        sqsize /= 6;
        int ofset = 10;
        arena.setColor(ladderColor);
        if (foot.x > top.x)
        {
            arena.drawLine((int) foot.x - sqsize, (int) foot.y + sqsize, (int) top.x - sqsize, (int) top.y + sqsize);
            arena.drawLine((int) foot.x + sqsize, (int) foot.y - sqsize, (int) top.x + sqsize, (int) top.y - sqsize);
            int curry = (int) foot.y - ofset;
            int currx;
            while (curry > top.y)
            {
                currx = getx(foot, top, curry);
                arena.drawLine(currx - sqsize, curry + sqsize, currx + sqsize, curry - sqsize);
                curry -= ofset;

            }
        }
        else
        {
            arena.drawLine((int) foot.x - sqsize, (int) foot.y - sqsize, (int) top.x - sqsize, (int) top.y - sqsize);
            arena.drawLine((int) foot.x + sqsize, (int) foot.y + sqsize, (int) top.x + sqsize, (int) top.y + sqsize);
            int curry = (int) foot.y - ofset;
            int currx;
            while (curry > top.y)
            {
                currx = getx(foot, top, curry);
                arena.drawLine(currx - sqsize, curry - sqsize, currx + sqsize, curry + sqsize);
                curry -= ofset;

            }
        }
    }

    private int getx(Point2D foot, Point2D top, float curry)
    {
        return (int) ((foot.x - top.x) / (foot.y - top.y) * (curry - foot.y) + foot.x);
    }

    private void drawSnake(Graphics2D arena, Point2D head, Point2D tail, int sqsize, Color snakeColor)
    {
        Path2D.Float snake = new Path2D.Float();
        int width = sqsize / 8;
        sqsize /= 4;
        Point2D mid = head.average(tail);
        Point2D midhead = head.average(mid);
        Point2D midtail = tail.average(mid);

        int offset = 20;
        if (head.x < tail.x)
        {

            snake.moveTo(head.x - width, head.y + width);
            snake.quadTo(midhead.x - width - offset, midhead.y + width + offset, mid.x - width, mid.y + width);
            snake.quadTo(midtail.x - width + offset, midtail.y + width - offset, tail.x - width, tail.y + width);
            snake.lineTo(tail.x + sqsize, tail.y + sqsize);
            snake.lineTo(tail.x + width, tail.y - width);
            snake.quadTo(midtail.x + width + offset, midtail.y - width - offset, mid.x + width, mid.y - width);
            snake.quadTo(midhead.x + width - offset, midhead.y - width + offset, head.x + width, head.y - width);
            snake.quadTo(head.x - 2 * sqsize, head.y - 2 * sqsize, head.x - width, head.y + width);
        }
        else
        {
            snake.moveTo(head.x - width, head.y - width);
            snake.quadTo(midhead.x - width - offset, midhead.y - width - offset, mid.x - width, mid.y - width);
            snake.quadTo(midtail.x - width + offset, midtail.y - width + offset, tail.x - width, tail.y - width);
            snake.lineTo(tail.x - sqsize, tail.y + sqsize);
            snake.lineTo(tail.x + width, tail.y + width);
            snake.quadTo(midtail.x + width + offset, midtail.y + width + offset, mid.x + width, mid.y + width);
            snake.quadTo(midhead.x + width - offset, midhead.y + width - offset, head.x + width, head.y + width);
            snake.quadTo(head.x + 2 * sqsize, head.y - 2 * sqsize, head.x - width, head.y - width);
            snake.closePath();
        }
        arena.setColor(snakeColor);
        arena.fill(snake);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

class Point2D {

    public float x, y;

    public Point2D()
    {
    }

    public Point2D(float xcord, float ycord)
    {
        x = xcord;
        y = ycord;
    }

    public Point2D(Point2D d)
    {
        x = d.x;
        y = d.y;
    }

    public Point2D add(Point2D p2)
    {
        return new Point2D(x + p2.x, y + p2.y);
    }

    public Point2D average(Point2D p2)
    {
        return new Point2D((x + p2.x) / 2, (y + p2.y) / 2);
    }

    public void half()
    {
        x /= 2;
        y /= 2;
    }
}