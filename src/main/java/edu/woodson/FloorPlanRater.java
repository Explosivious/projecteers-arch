
import java.util.*;

class FloorPlanRater { //written by John J.

   int Area,B1,R1,K1,H1,L1,S1,A1;
   int numB,numR,numH,numL,numS,numK, BArea,RArea,HArea,LArea,SArea,KArea;
   Apartment ori;
   public FloorPlanRater( Apartment ort){
   
      Area=ort.getArea();numB=ort.getNumB();numR=ort.getNumR();numH=ort.getNumH();numL=ort.getNumL();numS=ort.getNumS();numK=ort.getNumK(); BArea=ort.getBedroomArea(); RArea=ort.getRestroomArea();HArea=ort.getHallwayArea();LArea=ort.getLivingroomArea();SArea=ort.getStorageArea();KArea=ort.getKitchinArea();
      ori=new Apartment(Area,numB,numR,numH,numL,numS,numK, BArea,RArea,HArea,LArea,SArea,KArea);
   }
   
   
   //Apartment constructor is probably wrong, I'll change it accordingly later.
   
   public ArrayList<Apartment> rank(ArrayList<Apartment> L2){
   
      ArrayList<Integer> ranking = new ArrayList(L2.size()); 
      ArrayList<Integer> spotNum = new ArrayList(L2.size());
      
      for(int x = 0; x<L2.size(); x++){
         ranking.add(1);
      }
      
      //Bedroom, restroom, kitchin. hallway, Livingroom, Storage,
   
      for(int x = 0; x<L2.size(); x++){
         if(L2.get(x).getNumB()==ori.getNumB())
            ranking.set(x,ranking.get(x)+1);
         else if(L2.get(x).getNumB()-1==ori.getNumB()||L2.get(x).getNumB()+1==ori.getNumB())
            ranking.set(x,ranking.get(x)-2);
         else
            ranking.set(x,ranking.get(x)-3);
         
         if(L2.get(x).getNumR()==ori.getNumR())
            ranking.set(x,ranking.get(x)+1);
         else if(L2.get(x).getNumR()-1==ori.getNumR()||L2.get(x).getNumR()+1==ori.getNumR())
            ranking.set(x,ranking.get(x)-1);
         else
            ranking.set(x,ranking.get(x)-1);
            
         if(L2.get(x).getNumK()==ori.getNumK())
            ranking.set(x,ranking.get(x)+1);
         else if(L2.get(x).getNumK()-1==ori.getNumK()||L2.get(x).getNumK()+1==ori.getNumK())
            ranking.set(x,ranking.get(x)-1);
         else
            ranking.set(x,ranking.get(x)-3);
            
         if(L2.get(x).getNumH()==ori.getNumH())
            ranking.set(x,ranking.get(x)+1);
         else if(L2.get(x).getNumH()-1==ori.getNumH()||L2.get(x).getNumH()+1==ori.getNumH())
            ranking.set(x,ranking.get(x)-1);
         else
            ranking.set(x,ranking.get(x)-2);
            
         if(L2.get(x).getNumL()==ori.getNumL())
            ranking.set(x,ranking.get(x)+1);
         else if(L2.get(x).getNumL()-1==ori.getNumL()||L2.get(x).getNumL()+1==ori.getNumL())
            ranking.set(x,ranking.get(x)-1);
         else
            ranking.set(x,ranking.get(x)-2);
         
         if(L2.get(x).getNumS()==ori.getNumS())
            ranking.set(x,ranking.get(x)+1);
         else if(L2.get(x).getNumS()-1==ori.getNumS()||L2.get(x).getNumS()+1==ori.getNumS())
            ranking.set(x,ranking.get(x));
         else
            ranking.set(x,ranking.get(x)-1);
            //rating by area now
         
         if(Math.abs(L2.get(x).getArea()-ori.getArea())<=(int)(ori.getArea()*.1))
            ranking.set(x,ranking.get(x)+5);
         else if(Math.abs(L2.get(x).getArea()-ori.getArea())<=(int)(ori.getArea()*.15))
            ranking.set(x,ranking.get(x)+4);
         else if(Math.abs(L2.get(x).getArea()-ori.getArea())<=(int)(ori.getArea()*.2))
            ranking.set(x,ranking.get(x)+3);
         else if(Math.abs(L2.get(x).getArea()-ori.getArea())<=(int)(ori.getArea()*.25))
            ranking.set(x,ranking.get(x)+2);
         else if(Math.abs(L2.get(x).getArea()-ori.getArea())<=(int)(ori.getArea()*.3))
            ranking.set(x,ranking.get(x)+1);
         else if(Math.abs(L2.get(x).getArea()-ori.getArea())>=(int)(ori.getArea()*.35))
            ranking.set(x,ranking.get(x)-1);
         else if(Math.abs(L2.get(x).getArea()-ori.getArea())>=(int)(ori.getArea()*.45))
            ranking.set(x,ranking.get(x)-4);
         else if(Math.abs(L2.get(x).getArea()-ori.getArea())>=(int)(ori.getArea()*.55))
            ranking.set(x,ranking.get(x)-6);
      
            //rating by room percentage now
            //bedroom
         int L2Bp, L2Rp, L2Kp, L2Sp, L2Lp, L2Hp =0;;
         
         L2Bp = L2.get(x).getBedroomArea()/L2.get(x).getArea();
         L2Rp = L2.get(x).getRestroomArea()/L2.get(x).getArea();
         L2Kp = L2.get(x).getKitchinArea()/L2.get(x).getArea();
         L2Lp = L2.get(x).getLivingroomArea()/L2.get(x).getArea();
         L2Hp = L2.get(x).getHallwayArea()/L2.get(x).getArea();
         L2Sp = L2.get(x).getStorageArea()/L2.get(x).getArea();
              //OriginalBathroomPercentage
         int OBp = ori.getBedroomArea()/L2.get(x).getArea();
         int ORp = ori.getRestroomArea()/L2.get(x).getArea();
         int OKp = ori.getKitchinArea()/L2.get(x).getArea();
         int OLp = ori.getLivingroomArea()/L2.get(x).getArea();
         int OHp = ori.getHallwayArea()/L2.get(x).getArea();
         int OSp = ori.getStorageArea()/L2.get(x).getArea();
         
         if(Math.abs(OBp-L2Bp)<= (int)(ori.getBedroomArea()*.1))
            ranking.set(x, ranking.get(x)+1);
         else if(Math.abs(OBp-L2Bp)<= (int)(ori.getBedroomArea()*.2))
            ranking.set(x, ranking.get(x));
         else if(Math.abs(OBp-L2Bp)<= (int)(ori.getBedroomArea()*.4))
            ranking.set(x, ranking.get(x)-1);
         else if(Math.abs(OBp-L2Bp)> (int)(ori.getBedroomArea()*.4))
            ranking.set(x, ranking.get(x)-3);
            
         if(Math.abs(ORp-L2Rp)<= (int)(ori.getRestroomArea()*.1))
            ranking.set(x, ranking.get(x)+1);
         else if(Math.abs(ORp-L2Rp)<= (int)(ori.getRestroomArea()*.2))
            ranking.set(x, ranking.get(x));
         else if(Math.abs(ORp-L2Rp)<= (int)(ori.getRestroomArea()*.4))
            ranking.set(x, ranking.get(x)-1);
         else if(Math.abs(ORp-L2Rp)> (int)(ori.getRestroomArea()*.4))
            ranking.set(x, ranking.get(x)-3);
            
         if(Math.abs(OKp-L2Kp)<= (int)(ori.getKitchinArea()*.1))
            ranking.set(x, ranking.get(x)+1);
         else if(Math.abs(OKp-L2Kp)<= (int)(ori.getKitchinArea()*.2))
            ranking.set(x, ranking.get(x));
         else if(Math.abs(OKp-L2Kp)<= (int)(ori.getKitchinArea()*.4))
            ranking.set(x, ranking.get(x)-1);
         else if(Math.abs(OKp-L2Kp)> (int)(ori.getKitchinArea()*.4))
            ranking.set(x, ranking.get(x)-3);
            
         if(Math.abs(OLp-L2Lp)<= (int)(ori.getLivingroomArea()*.1))
            ranking.set(x, ranking.get(x)+1);
         else if(Math.abs(OLp-L2Lp)<= (int)(ori.getLivingroomArea()*.2))
            ranking.set(x, ranking.get(x));
         else if(Math.abs(OLp-L2Lp)<= (int)(ori.getLivingroomArea()*.4))
            ranking.set(x, ranking.get(x)-1);
         else if(Math.abs(OLp-L2Lp)> (int)(ori.getLivingroomArea()*.4))
            ranking.set(x, ranking.get(x)-3);
         
         if(Math.abs(OHp-L2Hp)<= (int)(ori.getHallwayArea()*.1))
            ranking.set(x, ranking.get(x)+1);
         else if(Math.abs(OHp-L2Hp)<= (int)(ori.getHallwayArea()*.2))
            ranking.set(x, ranking.get(x));
         else if(Math.abs(OHp-L2Hp)<= (int)(ori.getHallwayArea()*.4))
            ranking.set(x, ranking.get(x)-1);
         else if(Math.abs(OHp-L2Hp)> (int)(ori.getHallwayArea()*.4))
            ranking.set(x, ranking.get(x)-3);
         
         if(Math.abs(OSp-L2Sp)<= (int)(ori.getStorageArea()*.1))
            ranking.set(x, ranking.get(x)+1);
         else if(Math.abs(OSp-L2Sp)<= (int)(ori.getStorageArea()*.2))
            ranking.set(x, ranking.get(x));
         else if(Math.abs(OSp-L2Sp)<= (int)(ori.getStorageArea()*.4))
            ranking.set(x, ranking.get(x)-1);
         else if(Math.abs(OSp-L2Sp)> (int)(ori.getStorageArea()*.4))
            ranking.set(x, ranking.get(x)-3);
       }  
         ArrayList<Integer> ranking2 = new ArrayList(ranking.size());
         for(int u=0; u<ranking.size();u++){
            ranking2.add(u,ranking.get(u));
         }
         
         
      for(int v=0; v<L2.size() ;v++){
         spotNum.add(v,v);
      }
      

         
         int u;
      for(int y=0;y<ranking2.size();y++){
         for(int z=0;z<ranking2.size()-1;z++){
            if(ranking2.get(z) < ranking2.get(z+1)){
               int n = ranking2.get(z);
               ranking2.set(z,ranking2.get(z+1));
               ranking2.set(z+1,n);
               int by = spotNum.get(z);
               spotNum.set(z,spotNum.get(z+1));
               spotNum.set(z+1,by);
            }
         }
      }

         for(int m =0; m<spotNum.size();m++){
            ranking.set(spotNum.get(m),m);
         }
         
      
      ArrayList result = new ArrayList(L2.size()+ranking.size());
      int cv =0;
      int dv=0;
      for(int x=0; x<L2.size()+ranking.size();x++)
      {
         if(x%2==0){
            result.add(L2.get(cv));
            cv++;
         }
         else{
            result.add(ranking.get(dv));
            dv++;
         }
      }
      
      return result;
   }
   
   
   
}








