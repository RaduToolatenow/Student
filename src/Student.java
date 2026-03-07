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
        return "Student{" +
                "numarMatricol:" + NumarMatricol + " prenume:" + Prenume + " nume:" + Nume +  " formatieDeStudiu:" + FormatieDeStudiu  + '}';
    }

}
