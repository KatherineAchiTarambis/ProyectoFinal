package org.yourorghere;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import javax.media.opengl.GL;

public class Dodecaedro {

    GL gl;
    float x, y, z;
    float l, a, e;
    float rx, ry, rz;
    float r, g, b;
    int slices, stacks;


    public Dodecaedro(GL gl, float x, float y, float z, float l, float a, float e, float rx, float ry, float rz, float r, float g, float b, int slices, int stacks) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.l = l;
        this.a = a;
        this.e = e;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
        this.slices = slices;
        this.stacks = stacks;
    }

    public void dibujardodecaedro() {
        GLUT glut = new GLUT();
        gl.glPushMatrix();
        gl.glColor3f(this.r, this.g, this.b);
        gl.glTranslatef(this.x, this.y, this.z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
//        gl.glTranslatef(this.x, this.y, this.z);
        gl.glScalef(this.l, this.a, this.e);
       //gl.glEnable(gl.GL_LIGHT0);
       //gl.glEnable(gl.GL_LIGHTING);
        gl.glColor3f(0.1f,0.5f,1);
        glut.glutSolidDodecahedron();
//        GLUquadric esfera = glu.gluNewQuadric();
//        glu.gluQuadricDrawStyle(esfera, GLU.GLU_FILL);
//        glu.gluSphere(esfera, 1, slices, stacks);
        //this.rx = rx + 0.8f;
//        this.ry = ry + 0.9f;
        //this.rz = rz + 0.8f;
        gl.glEnd();
        gl.glPopMatrix();

    }
}
