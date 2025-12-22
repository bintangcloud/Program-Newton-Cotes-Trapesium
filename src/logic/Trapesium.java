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

        public Iterasi(int i, double x, double fx) {
            this.i = i;
            this.x = x;
            this.fx = fx;
        }
    }

    // Fungsi soal
    public static double fungsi(double x, int soal) {
        switch (soal) {
            case 1: return Math.exp(5 * x);
            case 2: return Math.sqrt(x * x + 1);
            case 3: return Math.pow(5, x);
            case 4: 
            if (x <= 0) {
                return 0; 
            }
            return Math.log(x) / x;
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
            list.add(new Iterasi(i, x, fx));
        }
        return list;
    }

    // Integral trapesium
    public static double hitungIntegral(double a, double b, double h, int soal) {
       List<Iterasi> data = getIterasi(a, b, h, soal);
        int n = data.size() - 1;

        double hasil = 0;

        // f0 + fn
        hasil += (h / 2) * (data.get(0).fx + data.get(n).fx);

        // sum tengah
        for (int i = 1; i < n; i++) {
            hasil += h * data.get(i).fx;
        }

        return hasil;
    }

    // Nilai eksak
    public static double nilaiEksak(double a, double b, int soal) {
    switch (soal) {
        case 1:
            return (Math.exp(5 * b) - Math.exp(5 * a)) / 5.0;

        case 2:
            return (
                (b * Math.sqrt(b*b + 1)) / 2.0
                + 0.5 * Math.log(Math.abs(Math.sqrt(b*b + 1) + b))
            ) - (
                (a * Math.sqrt(a*a + 1)) / 2.0
                + 0.5 * Math.log(Math.abs(Math.sqrt(a*a + 1) + a))
            );

        case 3:
            return (Math.pow(5, b) / Math.log(5))
                 - (Math.pow(5, a) / Math.log(5));

        case 4:
            double termB = (b <= 0) ? 0 : Math.pow(Math.log(b), 2);
            double termA = (a <= 0) ? 0 : Math.pow(Math.log(a), 2);
            return 0.5 * (termB - termA);
        default:
            return 0;
    }
}
}
