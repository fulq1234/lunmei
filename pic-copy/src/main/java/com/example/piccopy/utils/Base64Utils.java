package com.example.piccopy.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.thymeleaf.util.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class Base64Utils {
    public static String sedPath = "";//static后面的地址static\images\convert
   /* public static void main(String[] args) throws Exception {
        String path = Base64Utils.class.getResource("").getPath();
        System.out.println(path);
        //在线图片地址
        String url = "http://bpic.588ku.com//element_origin_min_pic/17/03/03/7bf4480888f35addcf2ce942701c728a.jpg";

        //本地图片地址
        //String url = "data:image/gif;base64,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";
        String str = Base64Utils.downloadFiles(url,"F:\\images\\");
        System.out.println(str);
    }*/

   public static String KEBeforeSet(String html){
       if(html == null){
           return "";
       }
       Document doc = Jsoup.parse(html);
       for(Element element :doc.select("img")){
           String src = element.attr("src");
           String str = Base64Utils.downloadFiles(src);
           if(str == null || str.equals("")){
               continue;
           }
           element.attr("src",str);
       }
       return doc.toString();
   }

    /**
     * 下载文件到本地
     * @param str
     * @return
     */
    public static String downloadFiles(String str){
        //下载地址是项目目录F:\workspace2\lunmei\pic-copy\target\classes\static\images\convert
        String downLoadpath = Base64Utils.getConvertPath();
        File ff = new File(downLoadpath);
        if(!ff.exists()){//文件不存在的话，就创建
            ff.mkdirs();
        }
        //downLoadpath = "F:\\workspace2\\lunmei\\pic-copy\\target\\classes\\static\\images\\convert\\";
        String returnStr = "";
        if(str != null && !str.equals("")){
            if(str.contains(";base64,") && str.contains("data:image/")){//base64字符串
                returnStr = Base64Utils.downLoadBase64(str,downLoadpath);
            }else if(str.indexOf("http") == 0){//在线图片
                returnStr = Base64Utils.downLoadOnline(str,downLoadpath);
            }
        }
        return returnStr;
    }

    /**
     * 文件下载的保存位置
     * @return
     */
    public  static String getConvertPath(){
        //下载地址是项目目录F:\workspace2\lunmei\pic-copy\target\classes\static\images\convert
        String downLoadpath = Base64Utils.class.getResource("").getPath();//原始地址
        if(downLoadpath == null || downLoadpath.equals("") || downLoadpath.length()<=1 || !downLoadpath.contains("classes")){
            return "";
        }
        String sepstr = "/";
        if(downLoadpath != null && downLoadpath.contains("\\")){
            sepstr = "\\\\";
        }
        if (downLoadpath.substring(0, 1).equals(sepstr)) {//如果第一个字符是分隔符，就去掉
            downLoadpath = downLoadpath.substring(1,downLoadpath.length());
        }

        String prePath0 = downLoadpath.substring(0,downLoadpath.indexOf("classes") + 7);

        if(!prePath0.substring(prePath0.length() - 1,prePath0.length()) .equals(sepstr)){//最后一个字符，如果最后一个字符不是分隔符，就在字符串最后添加一个分隔符
            prePath0 = prePath0 + sepstr;
        }
        String downLoadPath = prePath0 + "static" + sepstr + "images" + sepstr + "convert" + sepstr;
        sedPath = "images/convert/";
        String[] arr1 = downLoadPath.split(sepstr);
        downLoadPath = StringUtils.join(arr1,File.separator) + File.separator;

       return downLoadPath;
    }
    /**
     * base64图片保存到本地
     * @param base64str：base64字符串
     * @param downloadpath：本地保存图片的路径
     * @return：保存到本地文件的地址
     */
    public static String downLoadBase64(String base64str,String downloadpath){
        //本地图片地址
       // String originalStr = "data:image/gif;base64,R0lGODlhzABoAPcAALU0mP/7wpbUUoPHSLfel8PDw//dANthfP/XWvLU598blf/QEcxlsv/WRP/mlL+McP/ZMN87oumt08stl9vxsJ7Ua9Zur9qLxf/uvv/ghYvNTP///+xBYvu+Rc5SgOO5Jv/rQ//0WvFtgfBiY+RGqKXYd//wMPFrtP/eINXvpfn99O/35/aQMf/st8ktl/u9N+Y2md/w0cwzmabeWve+x//catun0vBard1rkcTlpb7ndP/95v/3e//3mvzEUOMhlfrm88tXq6s4mfR+Pf/0zv/hM9VxuO+si7HiX+80o+8zjv/MM/BKq//3hf/wA/eRwOF/o//2a9FMovFcptRaqfJyuvWdauw/m//sWf/0S//WStBDn+SEV97xyf/tdavags0ygdjvvvF5hPahy/768u7M5c7tmv/93/R5c//3pe9Cpu341/7jovit0c/puf/MZrzmg5LPT57EPf3GOukzhuYalf/MKZ/bV70ymNJUpv/xHtllsva4Xv/mAO0hlNGAv8Uvl/V9tdhfoNxwZvFaj71AnvFsr//01vzW6OY4oumSyvGan/aDbP/81v/ph6vfW843kqjeY/735f7PQvbG5Ljlaf/yOs47nfKDh//0UvA4jO+d0N7xwM/sq+RVrv/2v//xEbK1ZK3edMU9nv/zQv3x+OyXSORkte81mNVirP/WUe9Lp5zXVMPoldlQn/7LJP3bdv/UOvWQzP/xmfBRlP/4tef21e212v/PPPN/xPi22/Fui+xihfeumO86pOwZlOL0yt6Avtjwr//pEJfSYe4nk8bqh//+7/Bjr/vO4vRymP/+9/be7vNru+iMZu273P/3c//RVf/tKeajzvu+b96Yy7Pdjfej1e5EfdQek9JCi9RBnfb2sslCi/V/m//1Y/zFROhPpv//zP7jmu/54O1Rj7flYf/cKNl6tP/3jMXqd//33vzb7v/preyde6/efblQpfCMyf/mM6vgZLE2mPJYev/3r43MVP/LGv/wxP/XY/TX6//uZu9Sq+Epm/u7OiH5BAAHAP8ALAAAAADMAGgAAAj/ADcIHEiwoMGDCBMqXMiwocOHECNKnPiwgMWLGDNq3Mixo8ePIEOKHEmypMmTIAUWoMiypcuXMBM+i0lTpc2aOHPqdClBgpGZCksFy1Nt58GVG5AaXcq06QYgeKKO2pewlAUpefIAcZr0JtevYFuWiSqVqsFSe6RgzQO0KVKlYePKZTgWD6C7l6YZVLRFbdaiTt/OHUzYYLWodxNT2SowwZa+a1MBYbxUcOHLgy8gTgxowqVSAvc89ps1FWimljGrBstgc+IJE4JtuHVp9No8st16Xc2baWu7nGFPKJWnNuSsuAPv7s0852/OnWErumScdB4Lpysvb84d5vPgsGVQ/7eNPJVe1Nu7q6f4/XX48cdLS0bfdb19ljZc3xUuvvrtVKmYZVRq9xX4EFTAuTdBf+TJJ+BOBBoo4UKHQccffNYByAx9cNknyYQG7VNGGaeVEgRng1zoX3kW6FbffWS0A6JApdgADz0A5PjHVvuMktgg2ry3YmmUuNihehg4AOI+FxQihBA45qhjKc9w5oyQDeYhgXIv2geLPhOW8eSYUUqJxyjPSJCYM2JAAgmGWFnwoHZdqreOKqqsI2Ep8IwJpZQAkIUHAwy44MIBB7gjAxTVUSHBPtMEY0EwWw6YXnMOaKFFBnv+4WeZOXrgQTecQcImDoII8hg60+xBxasAWv/QVk4RDtZOO2QgRIamWsTyoYTPOPmnmVF5MAgX2rhgKg6YXLJIlgCmYsEFltZJmAOq1MAGEb8K1EIDDcQSC6cTPvMkqGQlxgUXzvDxBqpQQCutBRZsqFOtg5FRA6+91pABEWyEK+4SRIAYBD2gBjrIwpC4MEgs2R4xjhTy0kuvvTjhOxgR4AosLsQDL7GED7lKaAPCgJLlgSksvwAxNUcIMmQesVqcwL2XDubAJB+L7PPPL7AxYSmFoCvoIKYszIcMDMZHc6zo3IyztYXt2vPPPr/wQjTRaKEPLOO0QwQRGHR3csqCjuKCNkEuCGd5UEtNa86DtRDyEnPkPcckc2j/zevHeXdwiHp/ABpoEBekomB/tWU4L70SZEeTxoXVgHXeW2v9girgDtx32etVQygD1Tzzh4VCXhJMMP89js7rc1N9mSST+Ny31tF00IE+nceC9wtvSAiEEfpF5/Z4z9ySyqtUPG5B5LEfqZoksOBi/Rw++JABBhlo6vkc/wxe4AWBFq9i4wkAUQ2sFp8XPXdE6KMFz77PUTYbeKoyCd/RgH5f4eVL0H72wDTqbGMbUqDChphRDYtVamrSm50+OPezN+gjA9FAAAL4Na5usWQFnVDBUqpBLAF25gIFvMQB1YIOsFCOMBnAEy7ssIRJgINrsMgf5zwWixa8BA4V6IJR/+BRQgvRhjoreqCRmIMBPNVOZNjDYcd65zuRkYslnLhDHEogwpygzYQTKAMB32YarrxQLpLYYK/qNweuea9jV/PZFSkyDy3eo4s1+aKFNjBG/7jqFmakm1y6t0Y79M2Na/xYHPE2hwyUbCJmeAQrNGANLxaRM1TgY9PUsoGeBFJ2c8GfwET2ghzucGCTyIDAspWBcbhyHNuiCDDMMYNJrgAneuQMtfo4mtx85YxgaaIqrIeLrw3OiT3zwVLMgIQZCCAMC8GjQ3KZGKooomnQc6Egv9JEfTigBb8SH+d61kimcKISd+iEQjoRg4gQMUfpSsweBDIN8QRjC6nA2C+36f8UIjhATwXx4QbYcDVwPNIoKqAAJxISBg20EyIMuCQgLmGWMshANsxIxkQQgYiWAJMw+RAIGRpgO/81RQU5uGVBbCGAODz0IUGQUiEuwIBRBKEakttCGQTS0YggYgou+ehggieQDEARFnEJAzQHkkVWCOCl08xRIeZUEMpolCCUIEE2FECCfsRjE5QI6xgMoYkieZSfc5EEOMKJN4PKJQZLVcE8ZnAHVtgiIn9IRRmompAxEEQC2diqAhRQh8L6oRjFUIISAvESocrlEOUUCDiCNhg3QJMTSHiEZieiCCUypA0DeUZgB0tYwyJWsYxtLFrlQoQXuHUDb1BmWMhhi9r/bsANtqAAEpoJjIlQIgKSWwhon+KP0Za2DodN7GJj4ti4tANvAg0bV8iRAmNotq5xiIM1rJECcyDBDBQBQjZIwNeDDNcTxi0scg+r2OHCpLlh0YfIoiEQoX3FFsy8bks1MIA7VGKhLNGqAqrQU4U8YQObCKw/1LvexNKiwO9dLU48eBBJ2IGGS/DhQbmiAmHM9Q4tJYY13OCSBG+1DmqQBYQL8oRS+MMfiViwYZMbiOCqFpRMOQQscIWQDFxYZKooTG1toVICSJMgBGiIi0n7i1/4ARUncK9AgPCEU0RAxjMuxhWkPDkJ44QMPgBeLAkirlf4TKCqUYE6C0KOClTA/yGKEGyWlXDggSDCEBEYrHr9cNhVrLjLOG7KIaDYtzdkoAVEEJcdPobUhIgPLCEciApa0dI1M2TJx2WvEq66AUqEQ88z7geXM+blnIzDdpp7A7heoUiCkGFs3PMBmr+CUoFwIhJ1FYBKG7IJ0po2sandQBviQexit4Ey1YogWFRRRUKDyw77m0QDxvFEveVNRktZQyV2C4d3WKOdSV7BXOn6joiQANR8TqwmBvKEP3NJ2V/JBy4UKTJwLQGOWJOjU1TATLoKQANfgGsKMvuISJAjIpQANXKVe1VDIHufgeYKLKgoLlXcm+I/Q8C+OWEMEGdXAxqogDV0sFskHFwinv9A92n9ugGgygW+O1mHGr0HsR1S/GMUzskazFCJ6zo1DvwdwADMUQlhiDAMUG1Iwkub7uUiIthhgblOJOEAcFhdCwgAlz4mgXWbf8ykO1kDMMygA5+31Bo5sIYwBkKOeyS9IbkYbJP9oAYlIEPYdY6L1HEyjttpDhw1cEA7VDFBPE1RSWBZAQU60Ykw4DHJGyAHMRw6kSrsuRhTuMIGnjDqT8K7KZKwHCP93oF1HAIX0cgfr2owGE4IY9dJJkckBPBUilh+vahAxQaQ4e53z4UMAbubyHwADh/AAhav8AHXll+DDYNFBTqYARzamdJK+PuuFNGFL9I9hTZMwcaeD4v/JPLhgKzfvHZae8McXjFZ14KDDfYoDDCQAOISdKIV172DS0rRhlUUAxVPYAiDsXcssQ5E0A4xZHhUhDk+sH6vgDlakw+zMAvxNxfq8Ah2xAoEZ2kugQhjEAgstwGlAARys0S/R34zhwvWBg5L8ApmZm2NdgbpkA7HEBfk0HOTxAreBQc4MQW6MBCK4ArbUIJ08nlcYYBEYHHWNgdLsACX80jHAA09EBcdNg+sMAPmkAINcWRs13gxEAN3lQxTwA4CIQERcIaKEH7T8zN6Ewv4sGjNBnYBAA1nIBfA8A5rMBC7ZhAqYA23cAuUoQLWJUkCUAK3JAtTcAvx4AlneIan/6CGmEEE+XZvF6ZIsYB4BHEMPFALcsFOArECX4AQKlABGmBljegKgnAADxAKorBUGxAO/tCIshgBDwchpbYUwjcJRDAJdgBHsaBxB2EPFVgQjYAFw4gTX7gBo6gBCNEKcVABmxABkAAGsxgBuUAjKReL1RgBgGSCqmGJsTAOGyBv/NIrOScQtcCJBeEIRVAEBZMTMZADKiAK/5Zd9jcQcMAKrFACHgAGYAAJ23gNG3AN/qAA23iGm+B702OJ5EIGqtAC+UBIWjBrBfEJn0AQjQAC7QgCzgcTrSAKICYAogBVwkBXd3CS/pgIKqmSjUgCpVAFg3WQEZCQ3ngZHNM52P9WVKy3AZIQQ3NkEAHQCAJhD+0oD0Y5C8T4CWngEldYS5FwZHCgWdf1ADCwklapktdwAgqgjdvIaUW4Gt8CLu84EC2gCt2SDwjQkQNhD8vQCEb5lvKAlGQwC1gAlxe5EOSgDpl1B5EwYpE3A4A5A2vmiubgXc00Ax5wlVd5CjCpmCt5ApB4GZlSAzknCaogjgMhCY92EMvwCbMAl0e5A1nwliZQmuKwhQPnbyGHWZklCiJkDaEoEIXpXY9gBo6pmD9wm4lAhgqJGQjgAGpZA2CyEI3AAyAgDyDgBU0Al6P5CVhQmtBpAjwAEcBgfSCmAXEwmwdnDRqQAwOhDuagA2b/cEu6qZL+AAMwZpW8gJUCoQu5cALwGQ+6AH5nFXFcgQH2hRDtoAVjaRDpcJygiQUAigXG2QPRCZ1CCRHkAAe1BHRIYAwrMI/ZRWIbEAYANhD9UJ4j8APhoJJXkAjlUA6JcI26kKGOeQrySZ8RQYA4AVAJIQlagIkGYQ+g+ZbPiQU9wA8hcKClmQUUsQJDVknAEAk/d3DkwIECsQlJsKRMupLl8As/oAaJcAVokAhVegPs0AzluZJVEGH2qRrdo5Y7kA41Kg/SQAo9IIWlmQ5ZEJ0BQBEqsAZyWgKcYJK0p4w8eBDxwKR8mgTY8AtMagVXUA4ioAabIKVbCgN0EA8G/1GHK3qLc4EBE6kQdXmg0mAC0FALaRACc2gJnmoJ6dAINSgRKoBfkiSVdVVuZtAKOVACJeCdBAEEudCnSfALI7CkV8AIV2AFfLqliaAEdFAPNEAQ9kAKx9gQLBoXqgCMCAENPFqaPFCDaZAGnkoKWXCt1xqqP9pzqNoKcJBr1rCHBFEKulAFS+oHv1APuioCukMLfequvbqSisoIWJAJNaiJTuAEw/CoX6oaDtAA/VkQO0AKz2oCPXAMPcAD2JoFIdCw3/CwSzkR20ZwrJB/2DdlzZCxGtsMmyALTNBkSVAOfOADsTAJInAFV0AIjIAG8EqrS2oFIZAFoHoGepCvTv/QB6PqEMkqfg3wkwVxDOIgDrUADZlQrWiappmQCSHwsEwLDdCQDg1BDkqlUuRQmLs1AxpwB48wDyc3EKUgC2oQtr4wtmTrZLhqBXgiAowgAoTgsn3aC1EQs5YgDd9gszd7lzoLqYMxcec4EOIQBaQQuIGbtA27tEz7DU4LDTzADcuwEJ0wD7QHdCVgC2swmzrACnEwA5XQtQXBDmH7uWHLZ2TrC7tADZiwC77gtn16DU0QtzIrDTVrs30AtRWht3ORDw0gowWRBoKbBUmrtIfbulEQBTxQvD1QC2+WECrAoCdJeyA3ANYQngslDKywuQlRBauQvdq7fagAusrgDav/gAmjO7p8qgY/2AOuO7exm6+zCxE7GxcbpJYbcAyF27DEO7zD2wRpULxN0AScSA4aQKEHgX8+Jwo50AVuQACiIGlIkIcJIQv90A/auwqoUAxqMMG9kL3eALocnGKcVgvpKw2gYLd94Kh526+r0Q6xgAXqeBDpgL9RIA5OW7zFGwBnUAsBsAMC4YzJaxCzVHJmcHK3RA6VJBA7txAeGMER7H+ooMT9sAiGkL1TkL0d/LkCuQHLsAOb+rojzAP5Op1EYMIL8b5hsQP4gA/QoBBACw1pcAY80L9wfKwqMHtxIK4CwXNm4MCfWAGlaml5zBDscAOCfAO+gAqrkAtj4MRK/zzBjKy9zQAECeu0MuupTZAJTpAJPKAHfdAHRXCsR2G7c8EPKLAA8pCzB9EIb3oGcNwDrPymBEEB/ibABKHHBNFQX9AFa7YCxuAQ/CfI3asLujDITlwFirzEjZwBPJC+rdsE+ToMm9wHBhDNIOCin4zCmEGj8rAACzCFArEMjXsQMsjKrJygBCEMmsUKsrwQOfBvFbBUf6xkJ4AMq2C+QHACg3zPsiDMxezEhAALcUsKlhAFtXAGafoNILDJ0RzN1GwQZGwU9uAFFJgrXlCao4wFGzCHUcDNjWoP03oMZ/DNr0xwF8sQ+Qh0d6XLD0EJbdAGTIAML4kMMB3TMJ0L+f98z/fsxLRACDUQAgAtDTxwBm4cAJnwzAZQBKZczUZYGPzQjkWABWTAD9C5AA0Qt4gbsQbRCDtwDHhrEJW7WxDRCg2qTu88ELb1wEygC2MQzzIt04gg0zY9yLQQ12LA05agB3bNA9/gzETtyQwNyk3xCUXwljzgrBS9ACDwsDzA1xfdEMZgDq7YEJhVS9awBurwrQacdj18EEDQ0qUAn7sgAiJgCPA52uwQD2t92shACKpdAz2QBXowwuz7zJyMrH7NFEQQ2IJtAt/gqQtwDojLA+RcEC2sEJyghQWhAm9HEJF0B6JAcmYXB7RsEJtw1rpgCJ8N2qI92ifADuyg3aj/LdNA8A0m8Nqx3Qfy4AU0SNvWHBdE8JYgwKaYaglZcA4LQKBNgBDHMNwJkXQodQ/pfNxlVwkTm3+PfRYRXApjsAvXLQLKUAUO7uBkSAnaPeFPoAuU0FG8O96gYAI3K9tIqd5JTRjtbZRegN6kMLCZAAILAAFNoNHE6MpMxQlERhAvtQI5oEXEwBCYpQ7csAG24AY50AphMNIGcQ1MIJB8IAZKvuSBEAgPfhrscA1PUAWyYFZhRRBNIN6vTQqaLNslDOL2wQ9GCQKNkAaoDA1LCwH44AXBTRADzWYkV0vvQGIUWqe5VuAH0Qk6kAKioI8tpV1uIE1FXQRe0AIH3gN9/2AFS67o3tDkgaALOyCqDxEAGk4K0ODlfbDVCdHQOkEGacAPWQDV0FCDAdADITCDdsCsBbEM6QDSknaB13nLcYqqkdAQDAqYdRUJeL4Bs5DQBsACHOBXPLDJ7oAJHTAMVuANbZAPlay0afwQ9jDepBAAmK7pCMHpOSHmRhmdWUDVius7ASsQZS6KsP5vGmALJNdMBqcC1WUMxgAH3fYOkTbHUvkIcMCFA1EECc0BHFAEGzDsffAP7jAMBJ8BAG2tS+viCiGMApEGafwNXm7tSN0d2CwP0WkJpJAJiN0EXmAHO1kQPXCa5I6BciAH72C1rYBH53SYTqUB/k0Bd7Bbj+awdgqh77/OAUPQB8X7zMPgBKBg1yYwuA/b5gehxcVbC43rqAnrBdH84WNc2zuh7RYPnQj/2+nQA+ISsDvQBK5+EGP3AaJQAWZAAXbcBZHQTNjFX5EwA0hgvWq87xywAH0wDF7sBBwOCj9vAhgPvNAg8btLw4ndCIIP0rPAD06vENhOExX/lpbwDdf6Dfvbv7PgCEvwk9PKEIcQDcrECfjeCf7tYf4GdAPwCOqA7xUZzcCe885KCvkKDT6vB6VZ9d+g3z9rD/lNwy3eA2kw0EDNryjx+8Af/MI//MRf/CIxI8if/BsQEAA7";
        if(base64str != null && base64str.contains(";base64,") && base64str.contains("data:image/")){
            String str = base64str.substring(base64str.indexOf(";base64,") + 8,base64str.length());
            String last = base64str.substring(base64str.indexOf("data:image/") + 11,base64str.indexOf(";base64,"));
            String newFile = System.currentTimeMillis() + (int)(1+Math.random()*(10-1+1)) + "." + last;
            String path = downloadpath + newFile;
            Base64Utils.Base64ToImage(str,path);
            return sedPath + newFile;
        }
        return "";
    }

    /**
     * 下载在线文件到本地
     * @param url:在线文件的url地址
     * @param downloadpath：本地保存图片的路径
     * @return：保存到本地文件的地址
     */
    public static String downLoadOnline(String url,String downloadpath){
        //在线图片地址
        //String string = "http://bpic.588ku.com//element_origin_min_pic/17/03/03/7bf4480888f35addcf2ce942701c728a.jpg";
        String ste = Base64Utils.ImageToBase64ByOnline(url);
        String last = "jpg";
        if(url != null && url.contains(".")){
            last = url.substring(url.lastIndexOf(".") + 1,url.length());
            last = last.toLowerCase();
            if(!last.equals("bmp") && !last.equals("jpg") && !last.equals("jpeg") && !last.equals("png") && !last.equals("gif")){
                last = "jpg";
            }
            String newFile = System.currentTimeMillis() + (int)(1+Math.random()*(10-1+1)) + "." + last;
            String path = downloadpath + newFile;
            Base64Utils.Base64ToImage(ste, path);
            return sedPath + newFile;
        }
        return "";
    }

    /**
     * 本地图片转换成base64字符串
     * @param imgFile	图片本地路径
     * @return
     *
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:40:46
     */
   /* public static String ImageToBase64ByLocal(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理


        InputStream in = null;
        byte[] data = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);

            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }*/



    /**
     * 在线图片转换成base64字符串
     *
     * @param imgURL	图片线上路径
     * @return
     *
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:43:18
     */
    public static String ImageToBase64ByOnline(String imgURL) {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(imgURL);
            byte[] by = new byte[1024];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 关闭流
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data.toByteArray());
    }


    /**
     * base64字符串转换成图片
     * @param imgStr		base64字符串
     * @param imgFilePath	图片存放路径
     * @return
     *
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:42:17
     */
    public static boolean Base64ToImage(String imgStr,String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片

        if (imgStr == null) // 图像数据为空
            return false;

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }

            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
