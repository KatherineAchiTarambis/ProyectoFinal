package org.yourorghere;

import javax.media.opengl.GL;

public class CanchaFutbol {

    GL gl;
    float x, y, z;
    float w, h, d;
    float rx, ry, rz;
    float r, g, b;

    Cubo cesped;
    CuadradoLineas lineaaf, lineat, linea1, cuad1, cuad2, cp1, cp2;
    Circulo circ,semcir1,semcir2;
    Cilindro poste1,poste2,poste3,poste4,pa1,pa2;

    public CanchaFutbol(GL gl, float x, float y, float z, float w, float h, float d, float rx, float ry, float rz, float r, float g, float b) {
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
        this.cesped = new Cubo(gl, 0, 0, 0, 0.5f, 0f, 1f, 0, 0, 0, 0f, 0.4f, 0f, 0f, 0.4f, 0f);
        this.lineaaf = new CuadradoLineas(gl, 0f, 0f, 0f, 0.5f, 1, 90, 0, 0, 0, 0, 0);
        this.lineat = new CuadradoLineas(gl, 0f, 0f, 0f, 0.45f, 0.95f, 90, 0, 0, 1, 1, 1);
        this.linea1 = new CuadradoLineas(gl, 0f, 0f, 0.475f, 0.45f, 0.475f, 90, 0, 0, 1, 1, 1);
        this.cuad1 = new CuadradoLineas(gl, 0f, 0f, 0.78f, 0.35f, 0.17f, 90, 0, 0, 1, 1, 1);
        this.cuad2 = new CuadradoLineas(gl, 0f, 0f, -0.78f, 0.35f, 0.17f, 90, 0, 0, 1, 1, 1);
        this.cp1 = new CuadradoLineas(gl, 0f, 0f, 0.9f, 0.17f, 0.05f, 90, 0, 0, 1, 1, 1);
        this.cp2 = new CuadradoLineas(gl, 0f, 0f, -0.9f, 0.17f, 0.05f, 90, 0, 0, 1, 1, 1);
        this.circ=new Circulo(gl, 0, 0, 0, 0.4f, 0.4f, 90, 0, 0, 1, 1, 1);
        this.semcir1=new Circulo(gl, 0, 0, 0.6f, 0.4f, 0.4f, 270, 0, 0, 1, 1, 1);
        this.semcir2=new Circulo(gl, 0, 0, -0.6f, 0.4f, 0.4f, 90, 0, 0, 1, 1, 1);
        this.poste1=new Cilindro(gl, 0.16f, 0f, 0.95f, 0.03f, 0.03f, 0.6f, -90, 0, 0, 1f, 1f, 1f, 10, 10, 0.3f, 0.3f);
        this.poste2=new Cilindro(gl, -0.16f, 0f, 0.95f, 0.03f, 0.03f, 0.6f, -90, 0, 0, 1f, 1f, 1f, 10, 10, 0.3f, 0.3f);
        this.poste3=new Cilindro(gl, 0.16f, 0f, -0.95f, 0.03f, 0.03f, 0.6f, -90, 0, 0, 1f, 1f, 1f, 10, 10, 0.3f, 0.3f);
        this.poste4=new Cilindro(gl, -0.16f, 0f, -0.95f, 0.03f, 0.03f, 0.6f, -90, 0, 0, 1f, 1f, 1f, 10, 10, 0.3f, 0.3f);
        this.pa1=new Cilindro(gl, -0.16f, 0.18f, -0.95f, 0.03f, 0.03f, 1.1f, 0, 90, 0, 1f, 1f, 1f, 10, 10, 0.3f, 0.3f);
        this.pa2=new Cilindro(gl, 0.16f, 0.18f, 0.95f, 0.03f, 0.03f, 1.1f, 0, -90, 0, 1f, 1f, 1f, 10, 10, 0.3f, 0.3f);

    }

    public void dibujarcancha() {
        gl.glPushMatrix();
        gl.glTranslatef(x, y, z);
        gl.glRotatef(this.rx, 1, 0, 0);
        gl.glRotatef(this.ry, 0, 1, 0);
        gl.glRotatef(this.rz, 0, 0, 1);
        gl.glScalef(w, h, d);
        this.cesped.dibuja();
        this.lineaaf.dibujarcuadradolineas();
        this.lineat.dibujarcuadradolineas();
        this.linea1.dibujarcuadradolineas();
        this.cuad1.dibujarcuadradolineas();
        this.cuad2.dibujarcuadradolineas();
        this.cp1.dibujarcuadradolineas();
        this.cp2.dibujarcuadradolineas();
        this.circ.dibujarcirculo();
        this.semcir1.dibujarsemicirculo();
        this.semcir2.dibujarsemicirculo();
        this.poste1.dibujarcilindro();
        this.poste2.dibujarcilindro();
        this.poste3.dibujarcilindro();
        this.poste4.dibujarcilindro();
        this.pa1.dibujarcilindro();
        this.pa2.dibujarcilindro();
        

//        this.rx = rx + 0.8f;
        //this.ry = ry + 0.8f;
////        this.rz = rz + 0.8f;
//        do {
//            this.h = h + 0.01f;
//            //this.w = w + 0.01f;
//        } while (h < 10);
        gl.glPopMatrix();
    }

}
