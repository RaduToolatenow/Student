package Lab1;

public class Student {
    private int numarMatricol;
    private String Prenume= " ";
    private String Nume;
    private String FormatieDeStudiu;
    private double nota;

    public Student(int numarMatricol, String prenume, String nume, String formatieDeStudiu) {
        this.numarMatricol = numarMatricol;
        this.Prenume = prenume;
        this.Nume = nume;
        this.FormatieDeStudiu = formatieDeStudiu;
    }
public Student(int numarMatricol){

        this.numarMatricol = numarMatricol;
}
    public Student(){

        this.numarMatricol = 0;
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

        return numarMatricol;
    }

    //pentru nota
    public void setNota(double nota) {

        this.nota = nota;
    }

    public  double getNota() {

        return nota;
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
        return  "Numar_Matricol:" + numarMatricol + " prenume:" + Prenume + " nume:" + Nume +  " formatieDeStudiu:" + FormatieDeStudiu+ " nota:"+nota;
    }


}
