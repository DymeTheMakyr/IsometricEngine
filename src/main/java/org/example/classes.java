package org.example;

import org.ejml.All.*;
import org.ejml.data.FMatrix4x4;
import org.ejml.simple.SimpleMatrix;

public class classes {
    public static class vec3{
        public double x;
        public double y;
        public double z;

        public vec3(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public vec3 subtract(vec3 in){
            return new vec3(this.x - in.x, this.y - in.y, this.z - in.z);
        }

        public double mag(){
            final double result = Math.sqrt(this.x*this.x + this.y*this.y + this.z*this.z);
            return result;
        }

        public void mult(double factor){
            this.x *= factor;
            this.y *= factor;
            this.z *= factor;
        }
    }

    public static class vec2{
        double x;
        double y;
        long ix;
        long iy;

        public vec2(double x, double y) {
            this.x = x;
            this.y = y;
            this.ix = Math.round(x);
            this.iy = Math.round(y);
        }

        public vec2 mult(double factor){
            this.x *= factor;
            this.y *= factor;
            return this;
        }

        public vec2 multC(double factor){
            return new vec2(this.x * factor, this.y * factor);
        }

        public vec2 add(vec2 vec){
            this.x += vec.x;
            this.y += vec.y;
            return this;
        }

        public vec2 addC(vec2 vec){
            return new vec2(this.x + vec.x, this.y + vec.y);
        }
    }

    public static class Object{
        public vec3 pos;
        public vec3[] points;
    }
    public static class Camera{
        public vec3 pos;
        public vec2 screenSize = new vec2(400,300);
        public double screenFactor = 10;

        public vec2 xVec;
        public vec2 yVec;
        public vec2 zVec;

        public vec2 o;
        
        public Camera(vec2 screenSize, double screenFactor, vec3 p){
            this.screenSize = screenSize;
            this.screenFactor = screenFactor;
            this.pos = p;
            this.xVec = new vec2(12*screenFactor,5*screenFactor);
            this.yVec = new vec2(0, -13*screenFactor);
            this.zVec = new vec2(-12*screenFactor,5*screenFactor);
            this.o = screenSize.multC(0.5);
        }

        public vec2 worldToScreen(vec3 vec){
            vec2 result = this.xVec.multC(vec.x).add(this.yVec.multC(vec.y)).add(this.zVec.multC(vec.z));
            return result;
        }
    }
}

