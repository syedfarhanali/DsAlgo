package algoexpert.recursion;

import java.util.*;


/**
 *   INCOMPLETE
 */
public class LowestCommonManager {

    public static void main(String[] args) {

        OrgChart h = new OrgChart('H');
        OrgChart i = new OrgChart('I');
        OrgChart e = new OrgChart('E');
        OrgChart f = new OrgChart('F');
        OrgChart g = new OrgChart('G');

        OrgChart d = new OrgChart('D', new ArrayList<>(Arrays.asList(new OrgChart[]{h,i})));
        OrgChart c = new OrgChart('C',new ArrayList<>(Arrays.asList(new OrgChart[]{f,g})));

        OrgChart b = new OrgChart('B',new ArrayList<>(Arrays.asList(new OrgChart[]{d,e})));
        OrgChart a = new OrgChart('A',new ArrayList<>(Arrays.asList(new OrgChart[]{b,c})));

        getLowestCommonManager(a,e,i);
    }


    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        return null;
    }

    public static List<Object> getLowestCommonManagerHelper(OrgChart orgChart, OrgChart reportOne, OrgChart reportTwo){

        int count = 0;
        if(orgChart.directReports.size()==0){
            List<Object> result =  new ArrayList<>();
            result.add(0);
            result.add(orgChart);
            return result;
        }else {

            if(orgChart.name == reportOne.name || orgChart.name == reportTwo.name){
                count=1;
            }
            for(int i=0 ; i < orgChart.directReports.size() ;i++){
                List<Object> tempResult = getLowestCommonManagerHelper(orgChart.directReports.get(i),reportOne,reportOne);
                count = count + (Integer)tempResult.get(0);
            }
        }
        if(count == 2){
            Map result =  new HashMap<>();
            result.put(2,orgChart);

        }
        return null;
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }
        OrgChart(char name, List<OrgChart> directReports) {
            this.name = name;
            this.directReports = directReports;
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }

}