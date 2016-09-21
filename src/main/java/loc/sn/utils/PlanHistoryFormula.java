package loc.sn.utils;

import loc.sn.model.plan.PlanCalc;
import loc.sn.model.plan.PlanHistory;

/**
 * Created by oleksiy on 20.09.16.
 */
public class PlanHistoryFormula {

    public static double calculateLesson(int lesson) {
        return lesson;
    }

    public static double calculateLab(int lab) {
        return lab;
    }

    public static double calculatePractice(int practice) {
        return practice;
    }

    public static double calculateConsult(int consult) {
        return consult;
    }

    public static double calculateKursWork(int kursWork, int studAmount) {
        return (kursWork * studAmount * 0.33);
    }

    public static double calculateKursWorkIngFah(int kursWorkIngFag, int studAmount) {
        return (kursWorkIngFag * studAmount * 3);
    }

    public static double calculateKursWorkFah(int kursWorkFah, int studAmount) {
        return (kursWorkFah * studAmount * 4);
    }

    public static double calculateControlWork(int controlWork, int studAmount) {
        return (controlWork * studAmount * 0.33);
    }

    public static double calculateCce(int cce) {
        return (cce * 2);
    }

    public static double calculateExam(int exam, int studAmount) {
        return (exam * studAmount * 0.33);
    }

    public static double calculateZalik(int zalik) {
        return (zalik * 2);
    }

    public static double calculateCpa(int cpa) {
        return (cpa * 4);
    }

    public static double calculateAtest(int atest, int studAmount) {
        return (atest * studAmount * 2);
    }

    public static double calculateCcrDp(int ccrDp, int studAmount) {
        return (ccrDp * studAmount);
    }

    public static double calculatePzDp(int pzDp, int studAmount) {
        return (pzDp * studAmount);
    }

    public static PlanCalc calculate(PlanHistory planHistory) {
        PlanCalc planCalc = new PlanCalc();
        System.out.println(planHistory);
        return null;
    }
}
