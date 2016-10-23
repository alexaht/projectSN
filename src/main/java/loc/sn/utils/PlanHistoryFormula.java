package loc.sn.utils;

import loc.sn.model.admin.Discipline;
import loc.sn.model.plan.PlanCalc;
import loc.sn.model.plan.PlanCalcHtml;
import loc.sn.model.plan.PlanHistory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

    public static Set<PlanCalc> calculate(PlanHistory planHistory) {
        Set<PlanCalc> planCalcSet = new HashSet<PlanCalc>();
        //prescriptive session
        int planHistoryN = planHistory.getnConsult();
        if (planHistoryN > 0) {
            PlanCalc planCalc = new PlanCalc();
            planCalc.setGroupName("Н " + planHistory.getGroupTbl().getName());
            planCalc.setStudentsAmount(planHistory.getGroupTbl().getStAmount());
            planCalc.setDisciplineId(planHistory.getDiscipline().getId());
            planCalc.setConsult(calculateConsult(planHistory.getnConsult()));

            planCalcSet.add(planCalc);
        }
        // winter session
        int planHistoryZ = planHistory.getzLesson() + planHistory.getzLab() + planHistory.getzPractice() + planHistory.getzConsult() + planHistory.getzKursWork() + planHistory.getzKursWorkIngFah() + planHistory.getzKursWorkFah() + planHistory.getzControlWork() + planHistory.getzCce() + planHistory.getzExam() + planHistory.getzZalik() + planHistory.getzCpa() + planHistory.getzAtest() + planHistory.getzCcrDp() + planHistory.getzPzdp();
        if (planHistoryZ > 0) {
            PlanCalc planCalc = new PlanCalc();
            planCalc.setGroupName("З " + planHistory.getGroupTbl().getName());
            planCalc.setStudentsAmount(planHistory.getGroupTbl().getStAmount());
            planCalc.setDisciplineId(planHistory.getDiscipline().getId());
            planCalc.setLesson(calculateLesson(planHistory.getzLesson()));
            planCalc.setLab(calculateLab(planHistory.getzLab()));
            planCalc.setPractice(calculatePractice(planHistory.getzPractice()));
            planCalc.setConsult(calculateConsult(planHistory.getzConsult()));
            planCalc.setKursWork(calculateKursWork(planHistory.getzKursWork(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setKursWorkIngFah(calculateKursWorkIngFah(planHistory.getzKursWorkIngFah(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setKursWorkFah(calculateKursWorkFah(planHistory.getzKursWorkFah(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setControlWork(calculateControlWork(planHistory.getzControlWork(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setCce(calculateCce(planHistory.getzCce()));
            planCalc.setExam(calculateExam(planHistory.getzExam(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setZalik(calculateZalik(planHistory.getzZalik()));
            planCalc.setCpa(calculateCpa(planHistory.getzCpa()));
            planCalc.setAtest(calculateAtest(planHistory.getzAtest(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setCcrDp(calculateCcrDp(planHistory.getzCcrDp(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setPzDp(calculatePzDp(planHistory.getzPzdp(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setAllSum(planCalc.getLesson() + planCalc.getLab() + planCalc.getPractice() + planCalc.getConsult() + planCalc.getKursWork() + planCalc.getKursWorkIngFah() + planCalc.getKursWorkFah() + planCalc.getControlWork() + planCalc.getCce() + planCalc.getExam() + planCalc.getZalik() + planCalc.getCpa() + planCalc.getAtest() + planCalc.getCcrDp() + planCalc.getPzDp());

            planCalcSet.add(planCalc);
        }
        // summer session
        int planHistoryS = planHistory.getsLesson() + planHistory.getsLab() + planHistory.getsPractice() + planHistory.getsConsult() + planHistory.getsKursWork() + planHistory.getsKursWorkIngFah() + planHistory.getsKursWorkFah() + planHistory.getsControlWork() + planHistory.getsCce() + planHistory.getsExam() + planHistory.getsZalik() + planHistory.getsCpa() + planHistory.getsAtest() + planHistory.getsCcrDp() + planHistory.getsPzdp();
        if (planHistoryS > 0) {
            PlanCalc planCalc = new PlanCalc();
            planCalc.setGroupName("Л " + planHistory.getGroupTbl().getName());
            planCalc.setStudentsAmount(planHistory.getGroupTbl().getStAmount());
            planCalc.setDisciplineId(planHistory.getDiscipline().getId());
            planCalc.setLesson(calculateLesson(planHistory.getsLesson()));
            planCalc.setLab(calculateLab(planHistory.getsLab()));
            planCalc.setPractice(calculatePractice(planHistory.getsPractice()));
            planCalc.setConsult(calculateConsult(planHistory.getsConsult()));
            planCalc.setKursWork(calculateKursWork(planHistory.getsKursWork(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setKursWorkIngFah(calculateKursWorkIngFah(planHistory.getsKursWorkIngFah(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setKursWorkFah(calculateKursWorkFah(planHistory.getsKursWorkFah(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setControlWork(calculateControlWork(planHistory.getsControlWork(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setCce(calculateCce(planHistory.getsCce()));
            planCalc.setExam(calculateExam(planHistory.getzExam(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setZalik(calculateZalik(planHistory.getsZalik()));
            planCalc.setCpa(calculateCpa(planHistory.getsCpa()));
            planCalc.setAtest(calculateAtest(planHistory.getsAtest(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setCcrDp(calculateCcrDp(planHistory.getsCcrDp(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setPzDp(calculatePzDp(planHistory.getsPzdp(), planHistory.getGroupTbl().getStAmount()));
            planCalc.setAllSum(planCalc.getLesson() + planCalc.getLab() + planCalc.getPractice() + planCalc.getConsult() + planCalc.getKursWork() + planCalc.getKursWorkIngFah() + planCalc.getKursWorkFah() + planCalc.getControlWork() + planCalc.getCce() + planCalc.getExam() + planCalc.getZalik() + planCalc.getCpa() + planCalc.getAtest() + planCalc.getCcrDp() + planCalc.getPzDp());

            planCalcSet.add(planCalc);
        }

        return planCalcSet;
    }

    public static List<PlanCalcHtml> calcHtml(List<Discipline> disciplines, List<PlanHistory> planHistories) {
        List<PlanCalcHtml> planCalcHtmls = new LinkedList<PlanCalcHtml>();
        for (Discipline discipline : disciplines) {
            for (PlanHistory planHistory : planHistories) {
                if (discipline.getId() == planHistory.getDiscipline().getId()) {
                    //prescriptive session
                    int planHistoryN = planHistory.getnConsult();
                    if (planHistoryN > 0) {
                        PlanCalcHtml planCalcHtml = new PlanCalcHtml();
                        planCalcHtml.setHtml("<tr>" +
                                "<td>Н " + planHistory.getGroupTbl().getName() + "</td>" +
                                "<td>" + planHistory.getGroupTbl().getStAmount() + "</td>" +
                                "<td>" + calculateConsult(planHistory.getnConsult()) + "</td>" +
                                "</tr>"
                        );
                        planCalcHtmls.add(planCalcHtml);
                    }
                }
            }
        }
        return planCalcHtmls;
    }
}
