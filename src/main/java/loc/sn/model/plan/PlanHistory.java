package loc.sn.model.plan;

import loc.sn.model.admin.Discipline;
import loc.sn.model.admin.GroupTbl;
import loc.sn.model.admin.Kafedra;
import loc.sn.model.admin.LearningYear;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by oleksiy on 23.08.16.
 */
@Entity
@Table(name = "PLAN_HISTORY")
public class PlanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   /* @NotNull
    @Column(name = "id_year")
    private int idYear;*/

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_year")
    private LearningYear learningYear;


  /*  @NotNull
    @Column(name = "id_gruppa")
    private int idGruppa;
*/

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_gruppa")
    private GroupTbl groupTbl;

/*
    @NotNull
    @Column(name = "id_kafedra")
    private int idKafedra;
*/

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_kafedra")
    private Kafedra kafedra;

/*
    @NotNull
    @Column(name = "id_discipline")
    private int idDiscipline;
*/

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_discipline")
    private Discipline discipline;

    @Column(name = "n_plan")
    private int nPlan;
    @Column(name = "n_consult")
    private int nConsult;

    @Column(name = "z_lesson")
    private int zLesson;
    @Column(name = "z_lab")
    private int zLab;
    @Column(name = "z_practice")
    private int zPractice;
    @Column(name = "z_consult")
    private int zConsult;
    @Column(name = "z_kurswork")
    private int zKursWork;
    @Column(name = "z_kurswork_ing_fah")
    private int zKursWorkIngFah;
    @Column(name = "z_kurswork_fah")
    private int zKursWorkFah;
    @Column(name = "z_controlwork")
    private int zControlWork;
    @Column(name = "z_cce")
    private int zCce;
    @Column(name = "z_exam")
    private int zExam;
    @Column(name = "z_zalik")
    private int zZalik;
    @Column(name = "z_cpa")
    private int zCpa;
    @Column(name = "z_atest")
    private int zAtest;
    @Column(name = "z_ccrdp")
    private int zCcrDp;
    @Column(name = "z_pzdp")
    private int zPzdp;

    @Column(name = "s_lesson")
    private int sLesson;
    @Column(name = "s_lab")
    private int sLab;
    @Column(name = "s_practice")
    private int sPractice;
    @Column(name = "s_consult")
    private int sConsult;
    @Column(name = "s_kurswork")
    private int sKursWork;
    @Column(name = "s_kurswork_ing_fah")
    private int sKursWorkIngFah;
    @Column(name = "s_kurswork_fah")
    private int sKursWorkFah;
    @Column(name = "s_controlwork")
    private int sControlWork;
    @Column(name = "s_cce")
    private int sCce;
    @Column(name = "s_exam")
    private int sExam;
    @Column(name = "s_zalik")
    private int sZalik;
    @Column(name = "s_cpa")
    private int sCpa;
    @Column(name = "s_atest")
    private int sAtest;
    @Column(name = "s_ccrdp")
    private int sCcrDp;
    @Column(name = "s_pzdp")
    private int sPzdp;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getnPlan() {
        return nPlan;
    }

    public void setnPlan(int nPlan) {
        this.nPlan = nPlan;
    }

    public int getnConsult() {
        return nConsult;
    }

    public void setnConsult(int nConsult) {
        this.nConsult = nConsult;
    }

    public int getzLesson() {
        return zLesson;
    }

    public void setzLesson(int zLesson) {
        this.zLesson = zLesson;
    }

    public int getzLab() {
        return zLab;
    }

    public void setzLab(int zLab) {
        this.zLab = zLab;
    }

    public int getzPractice() {
        return zPractice;
    }

    public void setzPractice(int zPractice) {
        this.zPractice = zPractice;
    }

    public int getzConsult() {
        return zConsult;
    }

    public void setzConsult(int zConsult) {
        this.zConsult = zConsult;
    }

    public int getzKursWork() {
        return zKursWork;
    }

    public void setzKursWork(int zKursWork) {
        this.zKursWork = zKursWork;
    }

    public int getzKursWorkIngFah() {
        return zKursWorkIngFah;
    }

    public void setzKursWorkIngFah(int zKursWorkIngFah) {
        this.zKursWorkIngFah = zKursWorkIngFah;
    }

    public int getzKursWorkFah() {
        return zKursWorkFah;
    }

    public void setzKursWorkFah(int zKursWorkFah) {
        this.zKursWorkFah = zKursWorkFah;
    }

    public int getzControlWork() {
        return zControlWork;
    }

    public void setzControlWork(int zControlWork) {
        this.zControlWork = zControlWork;
    }

    public int getzCce() {
        return zCce;
    }

    public void setzCce(int zCce) {
        this.zCce = zCce;
    }

    public int getzExam() {
        return zExam;
    }

    public void setzExam(int zExam) {
        this.zExam = zExam;
    }

    public int getzZalik() {
        return zZalik;
    }

    public void setzZalik(int zZalik) {
        this.zZalik = zZalik;
    }

    public int getzCpa() {
        return zCpa;
    }

    public void setzCpa(int zCpa) {
        this.zCpa = zCpa;
    }

    public int getzAtest() {
        return zAtest;
    }

    public void setzAtest(int zAtest) {
        this.zAtest = zAtest;
    }

    public int getzCcrDp() {
        return zCcrDp;
    }

    public void setzCcrDp(int zCcrDp) {
        this.zCcrDp = zCcrDp;
    }

    public int getzPzdp() {
        return zPzdp;
    }

    public void setzPzdp(int zPzdp) {
        this.zPzdp = zPzdp;
    }

    public int getsLesson() {
        return sLesson;
    }

    public void setsLesson(int sLesson) {
        this.sLesson = sLesson;
    }

    public int getsLab() {
        return sLab;
    }

    public void setsLab(int sLab) {
        this.sLab = sLab;
    }

    public int getsPractice() {
        return sPractice;
    }

    public void setsPractice(int sPractice) {
        this.sPractice = sPractice;
    }

    public int getsConsult() {
        return sConsult;
    }

    public void setsConsult(int sConsult) {
        this.sConsult = sConsult;
    }

    public int getsKursWork() {
        return sKursWork;
    }

    public void setsKursWork(int sKursWork) {
        this.sKursWork = sKursWork;
    }

    public int getsKursWorkIngFah() {
        return sKursWorkIngFah;
    }

    public void setsKursWorkIngFah(int sKursWorkIngFah) {
        this.sKursWorkIngFah = sKursWorkIngFah;
    }

    public int getsKursWorkFah() {
        return sKursWorkFah;
    }

    public void setsKursWorkFah(int sKursWorkFah) {
        this.sKursWorkFah = sKursWorkFah;
    }

    public int getsControlWork() {
        return sControlWork;
    }

    public void setsControlWork(int sControlWork) {
        this.sControlWork = sControlWork;
    }

    public int getsCce() {
        return sCce;
    }

    public void setsCce(int sCce) {
        this.sCce = sCce;
    }

    public int getsExam() {
        return sExam;
    }

    public void setsExam(int sExam) {
        this.sExam = sExam;
    }

    public int getsZalik() {
        return sZalik;
    }

    public void setsZalik(int sZalik) {
        this.sZalik = sZalik;
    }

    public int getsCpa() {
        return sCpa;
    }

    public void setsCpa(int sCpa) {
        this.sCpa = sCpa;
    }

    public int getsAtest() {
        return sAtest;
    }

    public void setsAtest(int sAtest) {
        this.sAtest = sAtest;
    }

    public int getsCcrDp() {
        return sCcrDp;
    }

    public void setsCcrDp(int sCcrDp) {
        this.sCcrDp = sCcrDp;
    }

    public int getsPzdp() {
        return sPzdp;
    }

    public void setsPzdp(int sPzdp) {
        this.sPzdp = sPzdp;
    }

    public Kafedra getKafedra() {
        return kafedra;
    }

    public void setKafedra(Kafedra kafedra) {
        this.kafedra = kafedra;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public LearningYear getLearningYear() {
        return learningYear;
    }

    public void setLearningYear(LearningYear learningYear) {
        this.learningYear = learningYear;
    }

    public GroupTbl getGroupTbl() {
        return groupTbl;
    }

    public void setGroupTbl(GroupTbl groupTbl) {
        this.groupTbl = groupTbl;
    }

    @Override
    public String toString() {
        return "PlanHistory{" +
                "id=" + id +
                ", learningYear=" + learningYear +
                ", groupTbl=" + groupTbl +
                ", kafedra=" + kafedra +
                ", discipline=" + discipline +
                ", nPlan=" + nPlan +
                ", nConsult=" + nConsult +
                ", zLesson=" + zLesson +
                ", zLab=" + zLab +
                ", zPractice=" + zPractice +
                ", zConsult=" + zConsult +
                ", zKursWork=" + zKursWork +
                ", zKursWorkIngFah=" + zKursWorkIngFah +
                ", zKursWorkFah=" + zKursWorkFah +
                ", zControlWork=" + zControlWork +
                ", zCce=" + zCce +
                ", zExam=" + zExam +
                ", zZalik=" + zZalik +
                ", zCpa=" + zCpa +
                ", zAtest=" + zAtest +
                ", zCcrDp=" + zCcrDp +
                ", zPzdp=" + zPzdp +
                ", sLesson=" + sLesson +
                ", sLab=" + sLab +
                ", sPractice=" + sPractice +
                ", sConsult=" + sConsult +
                ", sKursWork=" + sKursWork +
                ", sKursWorkIngFah=" + sKursWorkIngFah +
                ", sKursWorkFah=" + sKursWorkFah +
                ", sControlWork=" + sControlWork +
                ", sCce=" + sCce +
                ", sExam=" + sExam +
                ", sZalik=" + sZalik +
                ", sCpa=" + sCpa +
                ", sAtest=" + sAtest +
                ", sCcrDp=" + sCcrDp +
                ", sPzdp=" + sPzdp +
                '}';
    }
}
