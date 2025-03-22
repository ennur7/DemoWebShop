package Utility;

public class Myfunc {
    public static void Bekle(int saniye){
        try{
            Thread.sleep(saniye*1000);
        }catch (InterruptedException e){
            throw  new RuntimeException(e);
        }
    }
    public static int RandomSayiVer(int min, int max)
    {
        return  (int)(Math.random()* (max-min) )+ min;
    }

    public static int RandomSayiVer(int max)
    {
        return  (int)(Math.random()* max);
    }

}
