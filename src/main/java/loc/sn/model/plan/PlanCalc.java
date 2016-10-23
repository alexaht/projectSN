package loc.sn.model.plan;

import javax.persistence.*;


@Entity
@Table(name = "PLAN_HISTORY_CALC")
public class PlanCalc {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "groupName")
    private String groupName;

    @Column(name = "discipline_id")
    private int disciplineId;

    @Column(name = "studAmount")
    private int studentsAmount;

    @Column(name = "lesson")
    private double lesson;

    @Column(name = "lab")
    private double lab;

    @Column(name = "practice")
    private double practice;

    @Column(name = "consult")
    private double consult;

    @Column(name = "kursWork")
    private double kursWork;

    @Column(name = "kursWorkIngFah")
    private double kursWorkIngFah;

    @Column(name = "KursWorkFah")
    private double kursWorkFah;

    @Column(name = "controlWork")
    private double controlWork;

    @Column(name = "cce")
    private double cce;

    @Column(name = "exam")
    private double exam;

    @Column(name = "zalik")
    private double zalik;

    @Column(name = "cpa")
    private double cpa;

    @Column(name = "atest")
    private double atest;

    @Column(name = "ccrDp")
    private double ccrDp;

    @Column(name = "pzDp")
    private double pzDp;

    @Column(name = "allSum")
    private double allSum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getStudentsAmount() {
        return studentsAmount;
    }

    public void setStudentsAmount(int studentsAmount) {
        this.studentsAmount = studentsAmount;
    }

    public double getLesson() {
        return lesson;
    }

    public void setLesson(double lesson) {
        this.lesson = lesson;
    }

    public double getLab() {
        return lab;
    }

    public void setLab(double lab) {
        this.lab = lab;
    }

    public double getPractice() {
        return practice;
    }

    public void setPractice(double practice) {
        this.practice = practice;
    }

    public double getConsult() {
        return consult;
    }

    public void setConsult(double consult) {
        this.consult = consult;
    }

    public double getKursWork() {
        return kursWork;
    }

    public void setKursWork(double kursWork) {
        this.kursWork = kursWork;
    }

    public double getKursWorkIngFah() {
        return kursWorkIngFah;
    }

    public void setKursWorkIngFah(double kursWorkIngFah) {
        this.kursWorkIngFah = kursWorkIngFah;
    }

    public double getKursWorkFah() {
        return kursWorkFah;
    }

    public void setKursWorkFah(double kursWorkFah) {
        this.kursWorkFah = kursWorkFah;
    }

    public double getControlWork() {
        return controlWork;
    }

    public void setControlWork(double controlWork) {
        this.controlWork = controlWork;
    }

    public double getCce() {
        return cce;
    }

    public void setCce(double cce) {
        this.cce = cce;
    }

    public double getExam() {
        return exam;
    }

    public void setExam(double exam) {
        this.exam = exam;
    }

    public double getZalik() {
        return zalik;
    }

    public void setZalik(double zalik) {
        this.zalik = zalik;
    }


    public double getCpa() {
        return cpa;
    }

    public void setCpa(double cpa) {
        this.cpa = cpa;
    }

    public double getAtest() {
        return atest;
    }

    public void setAtest(double atest) {
        this.atest = atest;
    }

    public double getCcrDp() {
        return ccrDp;
    }

    public void setCcrDp(double ccrDp) {
        this.ccrDp = ccrDp;
    }

    public double getPzDp() {
        return pzDp;
    }

    public void setPzDp(double pzDp) {
        this.pzDp = pzDp;
    }

    public double getAllSum() {
        return allSum;
    }

    public void setAllSum(double allSum) {
        this.allSum = allSum;
    }

    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }
}
