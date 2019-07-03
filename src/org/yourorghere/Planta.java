package org.yourorghere;

import javax.media.opengl.GL;

public class Planta {

    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;
    Cilindro tallo;
    

    public Planta(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz, float r, float g, float b) {
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
        this.tallo=new Cilindro(gl, 0.45f, 0f, 0, 0.03f, 0.03f, 1.2f, -90, 0, 0, 1f, 1f, 1f, 10, 10, 0.3f, 0.3f);

    }
}
