package CompanyTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ali2
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }
    private static boolean rule1(UnilateralLine x, UnilateralLine y)
    {
       return x.tType.equals(y.tType) && x.sCen.equals(y.eCen) && x.eCen.equals(y.sCen);
    }

    private static boolean rule1(UnilateralLine x, UnilateralLine y, UnilateralLine z)
    {
        return x.tType.equals(y.tType) && x.sCen.equals(y.eCen) && x.eCen.equals(y.sCen);
    }

    private static boolean rule2(UnilateralLine x, UnilateralLine y, UnilateralLine z)
    {
        if ((x.tType.equals(y.tType) && x.tType.equals(z.tType)))
        {
            return  (x.eCen.equals(y.sCen) && y.eCen.equals(z.sCen) && z.eCen.equals(x.sCen)) ||
                    (x.eCen.equals(z.sCen) && z.eCen.equals(y.sCen) && y.eCen.equals(x.sCen)) ||
                    (y.eCen.equals(x.sCen) && x.eCen.equals(z.sCen) && z.eCen.equals(y.sCen));
        }
        return false;
    }

    private static boolean rule3(UnilateralLine x, UnilateralLine y, UnilateralLine z)
    {
        if ((x.tType.equals(y.tType) && x.tType.equals(z.tType)))
        {
            return  (x.eCen.equals(y.sCen) && z.eCen.equals(x.sCen) && y.sPro.equals(z.sPro)) ||
                    (x.eCen.equals(z.sCen) && y.eCen.equals(x.sCen) && y.sPro.equals(z.sPro)) ||
                    (y.eCen.equals(x.sCen) && z.eCen.equals(y.sCen) && x.sPro.equals(z.sPro)) ||
                    (y.eCen.equals(z.sCen) && x.eCen.equals(y.sCen) && x.sPro.equals(z.sPro)) ||
                    (z.eCen.equals(x.sCen) && y.eCen.equals(z.sCen) && x.sPro.equals(y.sPro)) ||
                    (z.eCen.equals(y.sCen) && y.eCen.equals(y.sCen) && x.sPro.equals(y.sPro));
        }
        return false;
    }

    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<>();
        for (UnilateralLine x :lineList)
        {
            cir2: for (UnilateralLine y :lineList)
            {
                if (x == y)
                    continue;
                if (rule1(x, y))
                {
                    result.add("rule1: " + x.id + y.id);
                    continue;
                }
                for (UnilateralLine z :lineList)
                {
                    if (z == x || z== y)
                        continue;
                    if (rule1(x, y, z))
                    {
                        result.add("rule1: " + x.id + y.id + z.id);
                        break cir2;
                    }
                    if (rule2(x, y, z))
                    {
                        result.add("rule2: " + x.id + y.id + z.id);
                        break cir2;
                    }
                    if (rule3(x, y, z))
                    {
                        result.add("rule3: " + x.id + y.id + z.id);
                        break cir2;
                    }
                }
            }
        }
        return result;
    }
    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型
        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro,String tType) {
            this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
        public String getId() {return id;}
        public void setId(String id) {this.id = id;}
        public String getSCen() {return sCen;}
        public void setSCen(String ePro) {this.ePro = ePro;}
        public String getSPro() {return sPro;}
        public void setSPro(String sPro) {this.sPro = sPro;}
        public String getECen() {return eCen;}
        public void setECen(String eCen) {this.eCen = eCen;}
        public String getEPro() {return ePro;}
        public void setEPro(String ePro) {this.ePro = ePro;}
        public String getTType() {return tType;}
        public void setTType(String tType) {this.tType = tType;}
    }
}
