/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author binta
 */
public class Trapesium {
     public static class Iterasi {
        public int i;
        public double x;
        public double fx;
        public int bobot;

        public Iterasi(int i, double x, double fx, int bobot) {
            this.i = i;
            this.x = x;
            this.fx = fx;
            this.bobot = bobot;
        }
    }

    // Fungsi soal
    public static double fungsi(double x, int soal) {
        switch (soal) {
            case 1: return Math.exp(5 * x);
            case 2: return Math.sqrt(x * x + 1);
            case 3: return Math.pow(5, x);
            case 4: return Math.log(x) / x;
            default: return 0;
        }
    }

    // Iterasi
    public static List<Iterasi> getIterasi(double a, double b, double h, int soal) {
        List<Iterasi> list = new ArrayList<>();
        int n = (int) Math.round((b - a) / h);

        for (int i = 0; i <= n; i++) {
            double x = a + i * h;
            double fx = fungsi(x, soal);
            int bobot = (i == 0 || i == n) ? 1 : 2;
            list.add(new Iterasi(i, x, fx, bobot));
        }
        return list;
    }

    // Integral trapesium
    public static double hitungIntegral(double a, double b, double h, int soal) {
        List<Iterasi> data = getIterasi(a, b, h, soal);
        double sum = 0;

        for (Iterasi it : data) {
            sum += it.bobot * it.fx;
        }
        return (h / 2) * sum;
    }

    // Nilai eksak
    public static double nilaiEksak(double a, double b, int soal) {
        switch (soal) {
            case 1:
                return (Math.exp(5 * b) - Math.exp(5 * a)) / 5;
            case 2:
                return (b / 2) * Math.sqrt(b * b + 1) + Math.log(b + Math.sqrt(b * b + 1)) / 2
                     - ((a / 2) * Math.sqrt(a * a + 1) + Math.log(a + Math.sqrt(a * a + 1)) / 2);
            case 3:
                return (Math.pow(5, b) - Math.pow(5, a)) / Math.log(5);
            case 4:
                return 0.5 * (Math.pow(Math.log(b), 2) - Math.pow(Math.log(a), 2));
            default:
                return 0;
        }
    }
}
