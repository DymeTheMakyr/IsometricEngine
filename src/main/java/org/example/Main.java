package org.example;

import org.example.classes.*;

import javax.swing.*;

import java.awt.*;
import java.awt.Graphics.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.lang.Thread;
import java.util.ArrayList;

public class Main extends Frame {

    public static Camera cam;

    public Main(){
        setVisible(true);
        setSize((int)cam.screenSize.x, (int)cam.screenSize.y);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        System.out.println("Should Paint");
        vec2 p1 = cam.worldToScreen(new vec3(1,0,0));
        vec2 p2 = cam.worldToScreen(new vec3(0,1,0));
        vec2 p3 = cam.worldToScreen(new vec3(0,0,1));

        System.out.println((int)cam.o.x + " " + (int)cam.o.y);
        System.out.println((int)p1.x + " " + (int)p1.y);
        System.out.println((cam.o.x+p1.x) + " " + (cam.o.y+p1.y));

        g.setColor(Color.red);
        g.drawLine((int)cam.o.x, (int)cam.o.y, (int)(cam.o.x+p1.x), (int)(cam.o.y + p1.y));
        g.setColor(Color.YELLOW);
        g.drawLine((int)cam.o.x, (int)cam.o.y, (int)(cam.o.x+p2.x), (int)(cam.o.y + p2.y));
        g.setColor(Color.blue);
        g.drawLine((int)cam.o.x, (int)cam.o.y, (int)(cam.o.x+p3.x), (int)(cam.o.y+p3.y));
        System.out.println("drawn");
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        cam = new Camera(new vec2(400,300), 2, new vec3(0,0,0));


        vec3 temp = new vec3(0,0,2);
        vec2 temp2 = cam.worldToScreen(temp);

        System.out.println(temp.x + " " + temp.y + " " + temp.z);
        System.out.println(temp2.x + " " + temp2.y);

        new Main();
    }
}