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

    public String getPrenume() {
        return Prenume;
    }

    public String getNume() {
        return Nume;
    }

    public String getFormatieDeStudiu() {
        return FormatieDeStudiu;
    }
    public int getNumarMatricol() {
        return NumarMatricol;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Student s = (Student) o;

        return Prenume.equals(s.Prenume) && Nume.equals(s.Nume) && FormatieDeStudiu.equals(s.FormatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Prenume.hashCode() + Nume.hashCode() + FormatieDeStudiu.hashCode();
    }

    @Override
    public String toString() {
        return  "Numar_Matricol:" + NumarMatricol + " prenume:" + Prenume + " nume:" + Nume +  " formatieDeStudiu:" + FormatieDeStudiu;
    }


}
