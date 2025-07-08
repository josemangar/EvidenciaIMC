package model;

public class Calculadora {
    public static double calcularIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    public static String determinarCategoria(double imc) {
        if (imc < 18.5) return "Bajo peso";
        if (imc < 24.9) return "Normal";
        if (imc < 29.9) return "Sobrepeso";
        return "Obesidad";
    }
}
