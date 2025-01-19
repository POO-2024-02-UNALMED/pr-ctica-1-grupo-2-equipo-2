package modelo;

import java.util.ArrayList;

public enum Esquina {
    CLL1_CRR1("CLL1_CR1", -8, 8),
    CLL1_CRR2("CLL1_CR2", -8, 7),
    CLL1_CRR3("CLL1_CR3", -8, 6),
    CLL1_CRR4("CLL1_CR4", -8, 5),
    CLL1_CRR5("CLL1_CR5", -8, 4),
    CLL1_CRR6("CLL1_CR6", -8, 3),
    CLL1_CRR7("CLL1_CR7", -8, 2),
    CLL1_CRR8("CLL1_CR8", -8, 1),
    CLL1_CRR9("CLL1_CR9", -8, 0),
    CLL1_CRR10("CLL1_CR10", -8, -1),
    CLL1_CRR11("CLL1_CR11", -8, -2),
    CLL1_CRR12("CLL1_CR12", -8, -3),
    CLL1_CRR13("CLL1_CR13", -8, -4),
    CLL1_CRR14("CLL1_CR14", -8, -5),
    CLL1_CRR15("CLL1_CR15", -8, -6),
    CLL1_CRR16("CLL1_CR16", -8, -7),
    CLL1_CRR17("CLL1_CR17", -8, -8),
    CLL2_CRR1("CLL2_CR1", -7, 8),
    CLL2_CRR2("CLL2_CR2", -7, 7),
    CLL2_CRR3("CLL2_CR3", -7, 6),
    CLL2_CRR4("CLL2_CR4", -7, 5),
    CLL2_CRR5("CLL2_CR5", -7, 4),
    CLL2_CRR6("CLL2_CR6", -7, 3),
    CLL2_CRR7("CLL2_CR7", -7, 2),
    CLL2_CRR8("CLL2_CR8", -7, 1),
    CLL2_CRR9("CLL2_CR9", -7, 0),
    CLL2_CRR10("CLL2_CR10", -7, -1),
    CLL2_CRR11("CLL2_CR11", -7, -2),
    CLL2_CRR12("CLL2_CR12", -7, -3),
    CLL2_CRR13("CLL2_CR13", -7, -4),
    CLL2_CRR14("CLL2_CR14", -7, -5),
    CLL2_CRR15("CLL2_CR15", -7, -6),
    CLL2_CRR16("CLL2_CR16", -7, -7),
    CLL2_CRR17("CLL2_CR17", -7, -8),
    CLL3_CRR1("CLL3_CR1", -6, 8),
    CLL3_CRR2("CLL3_CR2", -6, 7),
    CLL3_CRR3("CLL3_CR3", -6, 6),
    CLL3_CRR4("CLL3_CR4", -6, 5),
    CLL3_CRR5("CLL3_CR5", -6, 4),
    CLL3_CRR6("CLL3_CR6", -6, 3),
    CLL3_CRR7("CLL3_CR7", -6, 2),
    CLL3_CRR8("CLL3_CR8", -6, 1),
    CLL3_CRR9("CLL3_CR9", -6, 0),
    CLL3_CRR10("CLL3_CR10", -6, -1),
    CLL3_CRR11("CLL3_CR11", -6, -2),
    CLL3_CRR12("CLL3_CR12", -6, -3),
    CLL3_CRR13("CLL3_CR13", -6, -4),
    CLL3_CRR14("CLL3_CR14", -6, -5),
    CLL3_CRR15("CLL3_CR15", -6, -6),
    CLL3_CRR16("CLL3_CR16", -6, -7),
    CLL3_CRR17("CLL3_CR17", -6, -8),
    CLL4_CRR1("CLL4_CR1", -5, 8),
    CLL4_CRR2("CLL4_CR2", -5, 7),
    CLL4_CRR3("CLL4_CR3", -5, 6),
    CLL4_CRR4("CLL4_CR4", -5, 5),
    CLL4_CRR5("CLL4_CR5", -5, 4),
    CLL4_CRR6("CLL4_CR6", -5, 3),
    CLL4_CRR7("CLL4_CR7", -5, 2),
    CLL4_CRR8("CLL4_CR8", -5, 1),
    CLL4_CRR9("CLL4_CR9", -5, 0),
    CLL4_CRR10("CLL4_CR10", -5, -1),
    CLL4_CRR11("CLL4_CR11", -5, -2),
    CLL4_CRR12("CLL4_CR12", -5, -3),
    CLL4_CRR13("CLL4_CR13", -5, -4),
    CLL4_CRR14("CLL4_CR14", -5, -5),
    CLL4_CRR15("CLL4_CR15", -5, -6),
    CLL4_CRR16("CLL4_CR16", -5, -7),
    CLL4_CRR17("CLL4_CR17", -5, -8),
    CLL5_CRR1("CLL5_CR1", -4, 8),
    CLL5_CRR2("CLL5_CR2", -4, 7),
    CLL5_CRR3("CLL5_CR3", -4, 6),
    CLL5_CRR4("CLL5_CR4", -4, 5),
    CLL5_CRR5("CLL5_CR5", -4, 4),
    CLL5_CRR6("CLL5_CR6", -4, 3),
    CLL5_CRR7("CLL5_CR7", -4, 2),
    CLL5_CRR8("CLL5_CR8", -4, 1),
    CLL5_CRR9("CLL5_CR9", -4, 0),
    CLL5_CRR10("CLL5_CR10", -4, -1),
    CLL5_CRR11("CLL5_CR11", -4, -2),
    CLL5_CRR12("CLL5_CR12", -4, -3),
    CLL5_CRR13("CLL5_CR13", -4, -4),
    CLL5_CRR14("CLL5_CR14", -4, -5),
    CLL5_CRR15("CLL5_CR15", -4, -6),
    CLL5_CRR16("CLL5_CR16", -4, -7),
    CLL5_CRR17("CLL5_CR17", -4, -8),
    CLL6_CRR1("CLL6_CR1", -3, 8),
    CLL6_CRR2("CLL6_CR2", -3, 7),
    CLL6_CRR3("CLL6_CR3", -3, 6),
    CLL6_CRR4("CLL6_CR4", -3, 5),
    CLL6_CRR5("CLL6_CR5", -3, 4),
    CLL6_CRR6("CLL6_CR6", -3, 3),
    CLL6_CRR7("CLL6_CR7", -3, 2),
    CLL6_CRR8("CLL6_CR8", -3, 1),
    CLL6_CRR9("CLL6_CR9", -3, 0),
    CLL6_CRR10("CLL6_CR10", -3, -1),
    CLL6_CRR11("CLL6_CR11", -3, -2),
    CLL6_CRR12("CLL6_CR12", -3, -3),
    CLL6_CRR13("CLL6_CR13", -3, -4),
    CLL6_CRR14("CLL6_CR14", -3, -5),
    CLL6_CRR15("CLL6_CR15", -3, -6),
    CLL6_CRR16("CLL6_CR16", -3, -7),
    CLL6_CRR17("CLL6_CR17", -3, -8),
    CLL7_CRR1("CLL7_CR1", -2, 8),
    CLL7_CRR2("CLL7_CR2", -2, 7),
    CLL7_CRR3("CLL7_CR3", -2, 6),
    CLL7_CRR4("CLL7_CR4", -2, 5),
    CLL7_CRR5("CLL7_CR5", -2, 4),
    CLL7_CRR6("CLL7_CR6", -2, 3),
    CLL7_CRR7("CLL7_CR7", -2, 2),
    CLL7_CRR8("CLL7_CR8", -2, 1),
    CLL7_CRR9("CLL7_CR9", -2, 0),
    CLL7_CRR10("CLL7_CR10", -2, -1),
    CLL7_CRR11("CLL7_CR11", -2, -2),
    CLL7_CRR12("CLL7_CR12", -2, -3),
    CLL7_CRR13("CLL7_CR13", -2, -4),
    CLL7_CRR14("CLL7_CR14", -2, -5),
    CLL7_CRR15("CLL7_CR15", -2, -6),
    CLL7_CRR16("CLL7_CR16", -2, -7),
    CLL7_CRR17("CLL7_CR17", -2, -8),
    CLL8_CRR1("CLL8_CR1", -1, 8),
    CLL8_CRR2("CLL8_CR2", -1, 7),
    CLL8_CRR3("CLL8_CR3", -1, 6),
    CLL8_CRR4("CLL8_CR4", -1, 5),
    CLL8_CRR5("CLL8_CR5", -1, 4),
    CLL8_CRR6("CLL8_CR6", -1, 3),
    CLL8_CRR7("CLL8_CR7", -1, 2),
    CLL8_CRR8("CLL8_CR8", -1, 1),
    CLL8_CRR9("CLL8_CR9", -1, 0),
    CLL8_CRR10("CLL8_CR10", -1, -1),
    CLL8_CRR11("CLL8_CR11", -1, -2),
    CLL8_CRR12("CLL8_CR12", -1, -3),
    CLL8_CRR13("CLL8_CR13", -1, -4),
    CLL8_CRR14("CLL8_CR14", -1, -5),
    CLL8_CRR15("CLL8_CR15", -1, -6),
    CLL8_CRR16("CLL8_CR16", -1, -7),
    CLL8_CRR17("CLL8_CR17", -1, -8),
    CLL9_CRR2("CLL9_CR2", 0, 7),
    CLL9_CRR3("CLL9_CR3", 0, 6),
    CLL9_CRR4("CLL9_CR4", 0, 5),
    CLL9_CRR5("CLL9_CR5", 0, 4),
    CLL9_CRR6("CLL9_CR6", 0, 3),
    CLL9_CRR7("CLL9_CR7", 0, 2),
    CLL9_CRR8("CLL9_CR8", 0, 1),
    CLL9_CRR10("CLL9_CR10", 0, -1),
    CLL9_CRR11("CLL9_CR11", 0, -2),
    CLL9_CRR12("CLL9_CR12", 0, -3),
    CLL9_CRR13("CLL9_CR13", 0, -4),
    CLL9_CRR14("CLL9_CR14", 0, -5),
    CLL9_CRR15("CLL9_CR15", 0, -6),
    CLL9_CRR16("CLL9_CR16", 0, -7),
    CLL10_CRR2("CLL10_CR2", 0, 7),
    CLL10_CRR3("CLL10_CR3", 0, 6),
    CLL10_CRR4("CLL10_CR4", 0, 5),
    CLL10_CRR5("CLL10_CR5", 0, 4),
    CLL10_CRR6("CLL10_CR6", 0, 3),
    CLL10_CRR7("CLL10_CR7", 0, 2),
    CLL10_CRR8("CLL10_CR8", 0, 1),
    CLL10_CRR10("CLL10_CR10", 0, -1),
    CLL10_CRR11("CLL10_CR11", 0, -2),
    CLL10_CRR12("CLL10_CR12", 0, -3),
    CLL10_CRR13("CLL10_CR13", 0, -4),
    CLL10_CRR14("CLL10_CR14", 0, -5),
    CLL10_CRR15("CLL10_CR15", 0, -6),
    CLL10_CRR16("CLL10_CR16", 0, -7),
    CLL11_CRR1("CLL11_CR1", 1, 8),
    CLL11_CRR2("CLL11_CR2", 1, 7),
    CLL11_CRR3("CLL11_CR3", 1, 6),
    CLL11_CRR4("CLL11_CR4", 1, 5),
    CLL11_CRR5("CLL11_CR5", 1, 4),
    CLL11_CRR6("CLL11_CR6", 1, 3),
    CLL11_CRR7("CLL11_CR7", 1, 2),
    CLL11_CRR8("CLL11_CR8", 1, 1),
    CLL11_CRR9("CLL11_CR9", 1, 0),
    CLL11_CRR10("CLL11_CR10", 1, -1),
    CLL11_CRR11("CLL11_CR11", 1, -2),
    CLL11_CRR12("CLL11_CR12", 1, -3),
    CLL11_CRR13("CLL11_CR13", 1, -4),
    CLL11_CRR14("CLL11_CR14", 1, -5),
    CLL11_CRR15("CLL11_CR15", 1, -6),
    CLL11_CRR16("CLL11_CR16", 1, -7),
    CLL11_CRR17("CLL11_CR17", 1, -8),
    CLL12_CRR1("CLL12_CR1", 2, 8),
    CLL12_CRR2("CLL12_CR2", 2, 7),
    CLL12_CRR3("CLL12_CR3", 2, 6),
    CLL12_CRR4("CLL12_CR4", 2, 5),
    CLL12_CRR5("CLL12_CR5", 2, 4),
    CLL12_CRR6("CLL12_CR6", 2, 3),
    CLL12_CRR7("CLL12_CR7", 2, 2),
    CLL12_CRR8("CLL12_CR8", 2, 1),
    CLL12_CRR9("CLL12_CR9", 2, 0),
    CLL12_CRR10("CLL12_CR10", 2, -1),
    CLL12_CRR11("CLL12_CR11", 2, -2),
    CLL12_CRR12("CLL12_CR12", 2, -3),
    CLL12_CRR13("CLL12_CR13", 2, -4),
    CLL12_CRR14("CLL12_CR14", 2, -5),
    CLL12_CRR15("CLL12_CR15", 2, -6),
    CLL12_CRR16("CLL12_CR16", 2, -7),
    CLL12_CRR17("CLL12_CR17", 2, -8),
    CLL13_CRR1("CLL13_CR1", 3, 8),
    CLL13_CRR2("CLL13_CR2", 3, 7),
    CLL13_CRR3("CLL13_CR3", 3, 6),
    CLL13_CRR4("CLL13_CR4", 3, 5),
    CLL13_CRR5("CLL13_CR5", 3, 4),
    CLL13_CRR6("CLL13_CR6", 3, 3),
    CLL13_CRR7("CLL13_CR7", 3, 2),
    CLL13_CRR8("CLL13_CR8", 3, 1),
    CLL13_CRR9("CLL13_CR9", 3, 0),
    CLL13_CRR10("CLL13_CR10", 3, -1),
    CLL13_CRR11("CLL13_CR11", 3, -2),
    CLL13_CRR12("CLL13_CR12", 3, -3),
    CLL13_CRR13("CLL13_CR13", 3, -4),
    CLL13_CRR14("CLL13_CR14", 3, -5),
    CLL13_CRR15("CLL13_CR15", 3, -6),
    CLL13_CRR16("CLL13_CR16", 3, -7),
    CLL13_CRR17("CLL13_CR17", 3, -8),
    CLL14_CRR1("CLL14_CR1", 4, 8),
    CLL14_CRR2("CLL14_CR2", 4, 7),
    CLL14_CRR3("CLL14_CR3", 4, 6),
    CLL14_CRR4("CLL14_CR4", 4, 5),
    CLL14_CRR5("CLL14_CR5", 4, 4),
    CLL14_CRR6("CLL14_CR6", 4, 3),
    CLL14_CRR7("CLL14_CR7", 4, 2),
    CLL14_CRR8("CLL14_CR8", 4, 1),
    CLL14_CRR9("CLL14_CR9", 4, 0),
    CLL14_CRR10("CLL14_CR10", 4, -1),
    CLL14_CRR11("CLL14_CR11", 4, -2),
    CLL14_CRR12("CLL14_CR12", 4, -3),
    CLL14_CRR13("CLL14_CR13", 4, -4),
    CLL14_CRR14("CLL14_CR14", 4, -5),
    CLL14_CRR15("CLL14_CR15", 4, -6),
    CLL14_CRR16("CLL14_CR16", 4, -7),
    CLL14_CRR17("CLL14_CR17", 4, -8),
    CLL15_CRR1("CLL15_CR1", 5, 8),
    CLL15_CRR2("CLL15_CR2", 5, 7),
    CLL15_CRR3("CLL15_CR3", 5, 6),
    CLL15_CRR4("CLL15_CR4", 5, 5),
    CLL15_CRR5("CLL15_CR5", 5, 4),
    CLL15_CRR6("CLL15_CR6", 5, 3),
    CLL15_CRR7("CLL15_CR7", 5, 2),
    CLL15_CRR8("CLL15_CR8", 5, 1),
    CLL15_CRR9("CLL15_CR9", 5, 0),
    CLL15_CRR10("CLL15_CR10", 5, -1),
    CLL15_CRR11("CLL15_CR11", 5, -2),
    CLL15_CRR12("CLL15_CR12", 5, -3),
    CLL15_CRR13("CLL15_CR13", 5, -4),
    CLL15_CRR14("CLL15_CR14", 5, -5),
    CLL15_CRR15("CLL15_CR15", 5, -6),
    CLL15_CRR16("CLL15_CR16", 5, -7),
    CLL15_CRR17("CLL15_CR17", 5, -8),
    CLL16_CRR1("CLL16_CR1", 6, 8),
    CLL16_CRR2("CLL16_CR2", 6, 7),
    CLL16_CRR3("CLL16_CR3", 6, 6),
    CLL16_CRR4("CLL16_CR4", 6, 5),
    CLL16_CRR5("CLL16_CR5", 6, 4),
    CLL16_CRR6("CLL16_CR6", 6, 3),
    CLL16_CRR7("CLL16_CR7", 6, 2),
    CLL16_CRR8("CLL16_CR8", 6, 1),
    CLL16_CRR9("CLL16_CR9", 6, 0),
    CLL16_CRR10("CLL16_CR10", 6, -1),
    CLL16_CRR11("CLL16_CR11", 6, -2),
    CLL16_CRR12("CLL16_CR12", 6, -3),
    CLL16_CRR13("CLL16_CR13", 6, -4),
    CLL16_CRR14("CLL16_CR14", 6, -5),
    CLL16_CRR15("CLL16_CR15", 6, -6),
    CLL16_CRR16("CLL16_CR16", 6, -7),
    CLL16_CRR17("CLL16_CR17", 6, -8),
    CLL17_CRR1("CLL17_CR1", 7, 8),
    CLL17_CRR2("CLL17_CR2", 7, 7),
    CLL17_CRR3("CLL17_CR3", 7, 6),
    CLL17_CRR4("CLL17_CR4", 7, 5),
    CLL17_CRR5("CLL17_CR5", 7, 4),
    CLL17_CRR6("CLL17_CR6", 7, 3),
    CLL17_CRR7("CLL17_CR7", 7, 2),
    CLL17_CRR8("CLL17_CR8", 7, 1),
    CLL17_CRR9("CLL17_CR9", 7, 0),
    CLL17_CRR10("CLL17_CR10", 7, -1),
    CLL17_CRR11("CLL17_CR11", 7, -2),
    CLL17_CRR12("CLL17_CR12", 7, -3),
    CLL17_CRR13("CLL17_CR13", 7, -4),
    CLL17_CRR14("CLL17_CR14", 7, -5),
    CLL17_CRR15("CLL17_CR15", 7, -6),
    CLL17_CRR16("CLL17_CR16", 7, -7),
    CLL17_CRR17("CLL17_CR17", 7, -8),
    CLL18_CRR1("CLL18_CR1", 8, 8),
    CLL18_CRR2("CLL18_CR2", 8, 7),
    CLL18_CRR3("CLL18_CR3", 8, 6),
    CLL18_CRR4("CLL18_CR4", 8, 5),
    CLL18_CRR5("CLL18_CR5", 8, 4),
    CLL18_CRR6("CLL18_CR6", 8, 3),
    CLL18_CRR7("CLL18_CR7", 8, 2),
    CLL18_CRR8("CLL18_CR8", 8, 1),
    CLL18_CRR9("CLL18_CR9", 8, 0),
    CLL18_CRR10("CLL18_CR10", 8, -1),
    CLL18_CRR11("CLL18_CR11", 8, -2),
    CLL18_CRR12("CLL18_CR12", 8, -3),
    CLL18_CRR13("CLL18_CR13", 8, -4),
    CLL18_CRR14("CLL18_CR14", 8, -5),
    CLL18_CRR15("CLL18_CR15", 8, -6),
    CLL18_CRR16("CLL18_CR16", 8, -7),
    CLL18_CRR17("CLL18_CR17", 8, -8);



    Esquina(String direccion, int x, int y){
        this.direccion = direccion;
        this.coordenadas[0] = x;
        this.coordenadas[1] = y;
    }
    private final int[] coordenadas = new int[2];
    private String direccion;

    public static Esquina fromDireccion(String direccion) {
        for(Esquina esquina: values()) {
            if (direccion.equals(esquina.direccion)) {
                return esquina;
            }
        }
        System.out.println("Esa dirección no está disponible en nuestra zona");
        return null;
    }
    public static Esquina fromCoo(int x, int y) {
        for(Esquina esquina: values()) {
            int x1 = esquina.coordenadas[0];
            int y1 = esquina.coordenadas[1];
            if (x == x1) {
                if (y == y1) {
                    return esquina;
                }
            }
        }
        System.out.println("Esa dirección no está disponible en nuestra zona");
        return null;
    }

    public static Esquina fromCoo(int[] coordenadas) {
        for(Esquina esquina: values()) {
            int x1 = esquina.coordenadas[0];
            int y1 = esquina.coordenadas[1];
            if (coordenadas[0] == x1) {
                if (coordenadas[1] == y1) {
                    return esquina;
                }
            }
        }
        System.out.println("Esa dirección no está disponible en nuestra zona");
        return null;
    }

    public static ArrayList<Esquina> determinarZona(int[] x, int[] y) {
        ArrayList<Esquina> esquinas = new ArrayList<Esquina>();
        for (Esquina punto: values()) {
            if (punto.coordenadas[0] >= x[0] && punto.coordenadas[0] <= x[1]) {
                if (punto.coordenadas[1] >= y[0] && punto.coordenadas[1] <= y[1]) {
                    if (x[1] == 0 && punto.direccion.contains("CLL10")) {continue;}
                    if (x[0] == 0 && punto.direccion.contains("CLL9")) {continue;}
                    esquinas.add(punto);
                }
            }
        }
        return esquinas;
    }

    public String toString() {
        return this.direccion;
    }
}




