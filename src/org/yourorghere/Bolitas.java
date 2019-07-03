
package org.yourorghere;

import javax.media.opengl.GL;

public class Bolitas {
    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;
    Dona dona;
    

    public Bolitas(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz, float r, float g, float b) {
        this.gl = gl;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.h = h;
        this.d = d;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
        this.r = r;
        this.g = g;
        this.b = b;
        this.dona=new Dona(gl, 0, 0, 0, 0.4f, 0.4f, 0.4f, 90, 0, -10, 0.5f, 0.3f, 0f, 10, 10, 1.5f,5);
    }
    public void dibujarbolita() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(w, h, d);
        this.dona.dibujardona();

        gl.glPopMatrix();
    }
}
