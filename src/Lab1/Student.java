package Lab1;

public class Student {
    private int NumarMatricol;
    private String Prenume;
    private String Nume;
    private String FormatieDeStudiu;
    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.NumarMatricol = numarMatricol;
        this.Prenume = prenume;
        this.Nume = nume;
        this.FormatieDeStudiu = formatieDeStudiu;
    }
    @Override
    public String toString() {
        return  "Numar_Matricol:" + NumarMatricol + " prenume:" + Prenume + " nume:" + Nume +  " formatieDeStudiu:" + FormatieDeStudiu;
    }

}
