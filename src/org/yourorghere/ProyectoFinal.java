package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.nio.file.Files.size;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import com.sun.opengl.util.GLUT;
import java.awt.event.KeyEvent;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class ProyectoFinal extends JFrame implements KeyListener {

    //////////////FIJO//////////////////////////////////////
    Cubo cam;
    Cuadrado suelo;
    public ArrayList<Bloques> bloques1 = new ArrayList<Bloques>();
    public ArrayList<Bloques> bloques2 = new ArrayList<Bloques>();
    public ArrayList<Bloques> bloques3 = new ArrayList<Bloques>();
    public ArrayList<Bloques> bloques4 = new ArrayList<Bloques>();
    public ArrayList<Bloques> bloques5 = new ArrayList<Bloques>();
    public ArrayList<Bloques> bloques6 = new ArrayList<Bloques>();
    public ArrayList<Cesped> c1 = new ArrayList<Cesped>();
    public ArrayList<Cesped> c2 = new ArrayList<Cesped>();
    public ArrayList<Cesped> c3 = new ArrayList<Cesped>();
    public ArrayList<Cesped> c4 = new ArrayList<Cesped>();
    public ArrayList<Cesped> c5 = new ArrayList<Cesped>();
    public ArrayList<Cesped> c6 = new ArrayList<Cesped>();
    public ArrayList<Cesped> c7 = new ArrayList<Cesped>();
    public ArrayList<Cesped> c9 = new ArrayList<Cesped>();
    public ArrayList<Cesped> c10 = new ArrayList<Cesped>();
    public ArrayList<Casa> casa1 = new ArrayList<Casa>();
    public ArrayList<Casa> casa2 = new ArrayList<Casa>();
    public ArrayList<Casa> casa3 = new ArrayList<Casa>();
    public ArrayList<Casa> casa4 = new ArrayList<Casa>();
    public ArrayList<Casa> casa5 = new ArrayList<Casa>();
    public ArrayList<Casa> casa6 = new ArrayList<Casa>();
    public ArrayList<Casa> casa7 = new ArrayList<Casa>();
    public ArrayList<Casa> casa8 = new ArrayList<Casa>();
    CanchaFutbol cancha;
    CanchaVolley cancha2;
    Casa bl1, bl2, bl3, bl4, bl5, bl6, bl7, bl8;
    Bloques b, b2, b3, b4, b5, b6;
    Gradas grada1,grada2;
    Cesped h1, h2, h3, h4, h5, h6, h7, h8, h9, h10;
    Malla malla;
    Bancas banca1,banca2,banca3,bancam;
    Bolitas bol1;

    ////////////////////////////////////////////////////////////////
    ArbolPir arbol1;
    ArbolEsferamult arbol2;
    ArbolEsfera arbol3;
    ArbolCubo arbol4;

    public static int ncam = 1;
    float rotar, angulo;
    float x = 0;
    float y = 0;
    float z = -10;

    public ProyectoFinal() {
        setTitle("Proyecto Final");
        setSize(700, 700);
        setLocation(10, 40);

        // Intancia de clase GraphicListener
        GraphicListener listener = new GraphicListener();
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);
        Animator animator = new Animator(canvas);
        animator.start();

        addKeyListener(this); // Para que canvas reconozca las pulsaciones del teclado

    }

    public static void main(String[] args) {

        ProyectoFinal frame = new ProyectoFinal();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public class GraphicListener implements GLEventListener {

        public void init(GLAutoDrawable drawable) {
            GL gl = drawable.getGL();
            System.err.println("INIT GL IS: " + gl.getClass().getName());
            gl.setSwapInterval(1);
            gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            gl.glShadeModel(GL.GL_SMOOTH);
            gl.glEnable(GL.GL_DEPTH_TEST);
            //*********************************************************************************
            ///////////////////CAMARA/////////////////////////
            cam = new Cubo(gl, 0, 0, 0, 100, 100, 100, 0, 0, 0);

            ///////////////////PISO//////////////////////////////////////
            suelo = new Cuadrado(gl, 0, -20, 5, 55f, 55f, 90, 0, 0, 0.6f, 0.6f, 0.5f, 0.6f, 0.6f, 0.5f);

            ///////////////////////////////////Bloques////////////////////////////////////////////
            for (int i = -3; i < 1; i++) {
                bloques1.add(new Bloques(gl, -40, -18.9f, 40 + 6 * i, 6, 6, 6, 0, 90, 0));
            }
            for (int i = -3; i < 1; i++) {
                bloques3.add(new Bloques(gl, -40, -18.9f, 6 * i, 6, 6, 6, 0, 90, 0));
            }
            for (int i = -3; i < 1; i++) {
                bloques2.add(new Bloques(gl, -30 - 6 * i, -18.9f, 45, 6, 6, 6, 0, 00, 0));
            }
            for (int i = -3; i < 1; i++) {
                bloques4.add(new Bloques(gl, 10 - 6 * i, -18.9f, 45, 6, 6, 6, 0, 00, 0));
            }
            for (int i = -3; i < 1; i++) {
                bloques5.add(new Bloques(gl, 35, -18.9f, 40 + 6 * i, 6, 6, 6, 0, 90, 0));
            }
            for (int i = -3; i < 1; i++) {
                bloques6.add(new Bloques(gl, 35, -18.9f, 6 * i, 6, 6, 6, 0, 90, 0));
            }
            /////////////////////////CANCHAS////////////////////////////////
            cancha = new CanchaFutbol(gl, 38, -19.8f, -39, 11, 11, 11, 0, 90, 0, 1, 1, 1);

            cancha2 = new CanchaVolley(gl, 23, -19.8f, -40, 8, 8, 8, 0, 0, 0, 1, 1, 1);

            //////////////////////////GRADERIO///////////////////////////////    
            grada1 = new Gradas(gl, 38, -19.8f, -30.5f, 16, 2, 6, 0, 0, 0, 1, 1, 1);
            grada2 = new Gradas(gl, 15, -19.8f, -39.5f, 11, 2, 6, 0, 270, 0, 1, 1, 1);

            //////////////////////CESPED//////////////////////////////////////
            for (int i = 0; i < 5; i++) {
                c1.add(new Cesped(gl, -45, -19.8f, 15 * i - 19, 15, 3, 10, 0, 90, 0, 1, 1, 1));
            }
            for (int i = 0; i < 5; i++) {
                c2.add(new Cesped(gl, 45, -19.8f, 15 * i - 19, 15, 3, 10, 0, 90, 0, 1, 1, 1));
            }
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < 2; j++) {
                    c3.add(new Cesped(gl, 10 * j - 30.5f, -19.8f, 15 * i + 26.5f, 15, 3, 10, 0, 90, 0, 1, 1, 1));
                }
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c4.add(new Cesped(gl, 10 * j - 30.5f, -19.8f, 15 * i - 19.5f, 15, 3, 10, 0, 90, 0, 1, 1, 1));
                }
            }
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < 2; j++) {
                    c5.add(new Cesped(gl, 10 * j + 19.5f, -19.8f, 15 * i + 26.5f, 15, 3, 10, 0, 90, 0, 1, 1, 1));
                }
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    c6.add(new Cesped(gl, 10 * j + 19.5f, -19.8f, 15 * i - 19.5f, 15, 3, 10, 0, 90, 0, 1, 1, 1));
                }
            }
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < 3; j++) {
                    c7.add(new Cesped(gl, 10 * j + 19.5f, -19.8f, 15 * i + 12f, 15, 3, 10, 0, 90, 0, 1, 1, 1));
                }
            }
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < 2; j++) {
                    c9.add(new Cesped(gl, -14 * j - 29.5f, -19.8f, 15 * i - 26f, 10, 3, 10, 0, 00, 0, 1, 1, 1));
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    c10.add(new Cesped(gl, -11 * j - 31.3f, -19.8f, 10 * i - 40f, 15, 3, 10, 0, 00, 0, 1, 1, 1));
                }
            }
            h8 = new Cesped(gl, 29.5f, -19.8f, 3f, 30, 3, 5, 0, 0, 0, 1, 1, 1);

            //////////////////////CASAS///////////////////////
            for (int i = 0; i < 5; i++) {
                casa1.add(new Casa(gl, 13, -18.5f, 19 + 3.2f * i, 5, 5, 5, 0, 90, 0));
            }
            for (int i = 0; i < 5; i++) {
                casa2.add(new Casa(gl, 10.5f, -18.5f, 19 + 3.2f * i, 5, 5, 5, 0, -90, 0));
            }
            for (int i = 0; i < 5; i++) {
                casa3.add(new Casa(gl, -13f, -18.5f, 19 + 3.2f * i, 5, 5, 5, 0, 90, 0));
            }
            for (int i = 0; i < 5; i++) {
                casa4.add(new Casa(gl, -15.5f, -18.5f, 19 + 3.2f * i, 5, 5, 5, 0, -90, 0));
            }
            for (int i = 0; i < 9; i++) {
                casa5.add(new Casa(gl, 13, -18.5f, -24.5f + 3.2f * i, 5, 5, 5, 0, 90, 0));
            }
            for (int i = 0; i < 9; i++) {
                casa6.add(new Casa(gl, 10.5f, -18.5f, -24.5f + 3.2f * i, 5, 5, 5, 0, -90, 0));
            }
            for (int i = 0; i < 9; i++) {
                casa7.add(new Casa(gl, -13, -18.5f, -24.5f + 3.2f * i, 5, 5, 5, 0, 90, 0));
            }
            for (int i = 0; i < 9; i++) {
                casa8.add(new Casa(gl, -15.5f, -18.5f, -24.5f + 3.2f * i, 5, 5, 5, 0, -90, 0));
            }
            //////////////////////////////ARBOLES////////////////////////////////
            arbol1 = new ArbolPir(gl, 24, -18.5f, 8, 8, 8, 8, 0, 0, 0);
            arbol2 = new ArbolEsferamult(gl, -28, -18.5f, 28, 12, 12, 12, 0, 0, 0);

            /////////////////////////////////////////////////////////////////
            banca1=new Bancas(gl, -23, -19.8f, -5, 2.5f, 2.5f, 2.5f, 0, 270, 0, 1, 1, 1);
            banca2=new Bancas(gl, -23, -19.8f, -21, 2.5f, 2.5f, 2.5f, 0, 270, 0, 1, 1, 1);
            banca3=new Bancas(gl, -34, -19.8f, -13, 2.5f, 2.5f, 2.5f, 0, 90, 0, 1, 1, 1);
            bancam=new Bancas(gl, -21, -19.8f, 0, 3, 3, 3, 0, 0, 0, 1, 1, 1);
            
            ///////////////////////////////////////////////////////////////////
            bol1 = new Bolitas(gl, 0, 0, 0, 3, 3, 3, 0, 90, 0, 1, 1, 1);
            
            ///////////////////////////////////////////////////////////////////
            malla = new Malla(gl, 0, 0, 0, 30, 30, 30, 0, 90, 0, 1, 1, 1);

            arbol3 = new ArbolEsfera(gl, 0, -12, 40, 55, 55, 55, 0, 0, 0);
            arbol4 = new ArbolCubo(gl, 0, -10, -40, 55, 55, 55, 0, 0, 0);
            //            arbol3 = new Arbol(gl, -20, 0, -5, 40, 40, 40, 0, 0, 0);
            //*********************************************************************
        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
            GL gl = drawable.getGL();
            GLU glu = new GLU();
            GLUT glut = new GLUT();

            if (height <= 0) { // avoid a divide by zero error!

                height = 1;
            }
            final float h = (float) width / (float) height;
            gl.glViewport(0, 0, width, height);
            gl.glMatrixMode(GL.GL_PROJECTION);
            gl.glLoadIdentity();
            glu.gluPerspective(60, h, 1.0, 110.0);
            gl.glMatrixMode(GL.GL_MODELVIEW);
            gl.glLoadIdentity();
        }

        public void display(GLAutoDrawable drawable) {
            GL gl = drawable.getGL();
            gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
            gl.glLoadIdentity();
            GLU glu = new GLU();
            //glu.gluLookAt(0, 5, -74, 0, 5, -70, 0, 1, 0);
//            if (ncam == 1) {
//                glu.gluLookAt(cam.x + 100, cam.y - 18, cam.z, suelo.x, suelo.y, suelo.z, 0, 1, 0);
//            }
            if (ncam == 1) {
                //glu.gluLookAt(cam.x +120f, cam.y +30f, cam.z+5, suelo.x, suelo.y, suelo.z, 0, 1, 0);
                glu.gluLookAt(cam.x + 100, cam.y - 18, cam.z, suelo.x, suelo.y, suelo.z, 0, 1, 0);
            }
//            if (ncam == 2) {
//                 //glu.gluLookAt(cam.x + 100, cam.y - 18, cam.z, suelo.x, suelo.y, suelo.z, 0, 1, 0);
//                //glu.gluLookAt(cam.x + 100, cam.y - 18, cam.z, suelo.x, suelo.y, suelo.z, 0, 1, 0);
//                glu.gluLookAt(cam.x + 50, cam.y + 90, cam.z - 50, x, y, z, 0, 1, 0);
//            }
            if (ncam == 2) {
                glu.gluLookAt(x, cam.y + 75, z, 0, -20, 5, 0, 1, 0);
            }

            gl.glPushMatrix();
            /////////////////   BLOQUES   ///////////////////////
            for (Bloques b : bloques1) {
                b.dibuja();
            }
            for (Bloques b2 : bloques2) {
                b2.dibuja();
            }
            for (Bloques b3 : bloques3) {
                b3.dibuja();
            }
            for (Bloques b4 : bloques4) {
                b4.dibuja();
            }
            for (Bloques b5 : bloques5) {
                b5.dibuja();
            }
            for (Bloques b6 : bloques6) {
                b6.dibuja();
            }
            //////////////////////////////////////////////////////////////////////////////////
            suelo.dibuja();

            //////////////////////////////////////////////////////////////////////////////////
            cancha.dibujarcancha();
            cancha2.dibujarcancha();

            ///////////////////////////////////////////////////////////////////////////////////
            grada1.dibuja();
            grada2.dibuja();

            ////////////////////////////////////////////////////////////////////////////////////
            for (Cesped h1 : c1) {
                h1.dibujarcesped();
            }
            for (Cesped h2 : c2) {
                h2.dibujarcesped();
            }
            for (Cesped h3 : c3) {
                h3.dibujarcesped();
            }
            for (Cesped h4 : c4) {
                h4.dibujarcesped();
            }
            for (Cesped h5 : c5) {
                h5.dibujarcesped();
            }
            for (Cesped h6 : c6) {
                h6.dibujarcesped();
            }
            for (Cesped h7 : c7) {
                h7.dibujarcesped();
            }
            for (Cesped h9 : c9) {
                h9.dibujarcesped();
            }
            for (Cesped h10 : c10) {
                h10.dibujarcesped();
            }

            h8.dibujarcesped();

            /////////////////////CASAS/////////////////////////
            for (Casa bl1 : casa1) {
                bl1.dibuja();
            }
            for (Casa bl2 : casa2) {
                bl2.dibuja();
            }
            for (Casa bl3 : casa3) {
                bl3.dibuja();
            }
            for (Casa bl4 : casa4) {
                bl4.dibuja();
            }
            for (Casa bl5 : casa5) {
                bl5.dibuja();
            }
            for (Casa bl6 : casa6) {
                bl6.dibuja();
            }
            for (Casa bl7 : casa7) {
                bl7.dibuja();
            }
            for (Casa bl8 : casa8) {
                bl8.dibuja();
            }

            ///////////////////////////////////////////////////////////////////
            banca1.dibujarbancas();
            banca2.dibujarbancas();
            banca3.dibujarbancas();
            bancam.dibujarbancasmesa();
            
            ///////////////////////////////////////////////////////////////////
            bol1.dibujarbolita();
            
            ///////////////////////////////////////////////////////////////////
//                malla.dibujarmalla();
            arbol1.dibujararbol();
            arbol2.dibujararbol();
//            arbol3.dibujararbol();
//            arbol4.dibujararbol();

//            arbol3.dibujararbol();
            gl.glPopMatrix();

            gl.glFlush();
        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '1') {
            ProyectoFinal.ncam = 1;
        }

        if (e.getKeyChar() == '2') {
            ProyectoFinal.ncam = 2;
        }
        if (e.getKeyChar() == '3') {
            ProyectoFinal.ncam = 3;
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cam.x += 0.5;
            System.out.println("Valor en la traslacion de X: " + cam.x);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cam.x -= 0.5;
            cam.setX(cam.getX());
            System.out.println("Valor en la traslacion de X: " + cam.x);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            cam.y += 0.5;
            cam.setY(cam.getY());
            System.out.println("Valor en la traslacion de Y: " + cam.y);
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            cam.y -= 0.5;
            cam.setY(cam.getY());
            System.out.println("Valor en la traslacion de Y: " + cam.y);
        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            cam.z += 0.5;
            cam.setZ(cam.getZ());
            System.out.println("Valor en la traslacion de Z: " + cam.z);
        }

        if (e.getKeyCode() == KeyEvent.VK_Z) {
            cam.z -= 0.5;
            cam.setZ(cam.getZ());
            System.out.println("Valor en la traslacion de Z: " + cam.z);
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
