package service;

import entity.DisciplinsMark;
import entity.Term;

import java.util.ArrayList;

public class Services {
    public static Term getTermById(ArrayList<Term> terms, String id){
        for (Term term : terms) {
            if (term.getId()==Integer.parseInt(id)){
                return term;
            }
        }
        return terms.get(0);
    }
    public static double  getAverageMark(ArrayList<DisciplinsMark> dm){
        double res = 0;
        int count=0;
        for (DisciplinsMark disciplinsMark: dm){
            res+=Integer.parseInt(disciplinsMark.getMarkName()==null? "0":disciplinsMark.getMarkName());
            if (disciplinsMark.getMarkName()!=null){
                count++;
            }

        }
        if(count>0){
            return res/count;
        }
        else return 0;
    }
}
