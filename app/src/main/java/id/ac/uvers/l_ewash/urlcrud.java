package id.ac.uvers.l_ewash;

import android.net.Uri;

public class urlcrud {

    public static final String tandaBaca = "@#&=*+-_.,:!?()/~'%";

    public static String insertLUser (String userlaundry,String password,String namalaundry, String nohp, String alamatlaundry, String jambuka, String jamtutup, int selfdelivery, int kurirdelivery ){
        return Uri.encode("https://ewash22.000webhostapp.com/databaseewash/simpanlaundry.php?userlaundry="+userlaundry+"&password="+password+"&namalaundry="+namalaundry+"&nohp="+nohp+"&alamatlaundry="+alamatlaundry+"&jambuka="+jambuka+"&jamtutup="+jamtutup+"&selfdelivery="+selfdelivery+"&kurirdelivery="+kurirdelivery, tandaBaca);
    }

    public static String selectLUser (String userlaundry,String password){
        return Uri.encode("https://ewash22.000webhostapp.com/databaseewash/selectuserlaundry.php?userlaundry="+userlaundry+"&password="+password, tandaBaca);
    }

    public static String selectLaundryData(){
        return Uri.encode("https://ewash22.000webhostapp.com/databaseewash/selectlaundry.php?");
    }

    public static String insertLharga (String namalaundry,String baju_n,String baju_e, String boneka_n, String boneka_e, String bedcover_n, String bedcover_e, String selimutb_n, String selimutb_e, String selimutk_n, String selimutk_e, String gorden_n, String gorden_e, String setrika_n, String setrika_e){
        return Uri.encode("https://ewash22.000webhostapp.com/databaseewash/daftarharga.php?namalaundry="+namalaundry+"&baju_n="+baju_n+"&baju_e="+baju_e+"&boneka_n="+boneka_n+"&boneka_e="+boneka_e+"&bedcover_n="+bedcover_n+"&bedcover_e="+bedcover_e+"&selimutb_n="+selimutb_n+"&selimutb_e="+selimutb_e+"&selimutk_n="+selimutk_n+"&selimutk_e="+selimutk_e+"&gorden_n="+gorden_n+"&gorden_e="+gorden_e+"&setrika_n="+setrika_n+"&setrika_e="+setrika_e, tandaBaca);
    }

}
