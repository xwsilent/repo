public class BowlingGame {

    public int[] getscore(String temp){
        if(temp.length()==1){
            if(temp.equals("X"))
                return new int[]{10,-1,2};
            else
                return new int[]{Integer.valueOf(temp),-1,0};
        }
        else{
            int[] res=new int[3];
            for(int i=0;i<2;i++){
                if(temp.charAt(i)=='X'){
                    res[i]=10;
                    res[2]=2;
                }
                else if(temp.charAt(i)=='/'){
                    res[i]=10-res[0];
                    res[2]=1;
                }
                else if(temp.charAt(i)=='-'){
                    res[i]=0;
                    res[i]=0;
                }
                else{
                    res[i]=temp.charAt(i)-48;
                    res[2]=0;
                }

            }
            return res;
        }

    }
    public int getBowlingScore(String bowlingCode) {

        int ballnum=0;
        String[] str=bowlingCode.split("\\|");

        int ertran1=0,ertran2=0;
        int nexttime=0;
        if(str.length==12)
        {
            ertran1=getscore(str[11])[0];
            ertran2=getscore(str[11])[1];
        }
        for(int i=9;i>=0;i--){
            String temp=str[i];
            if(temp.equals(""))
                continue;
            int[] res=getscore(temp);
            //test
            //System.out.println(ertran1+","+ertran2+"  "+i+": "+res[0]+","+res[1]+","+res[2]);
            nexttime=res[2];
            int currentball=res[1]==-1?0:res[1];
            currentball+=res[0];
            if(nexttime!=0)
                currentball+=ertran1;
            if(nexttime==2)
                currentball+=ertran2;
            ballnum+=currentball;
            if(temp.length()==2){
                ertran1=res[0];
                ertran2=res[1];
            }

            else if(temp.length()==1){
                ertran2=ertran1;
                ertran1=10;
            }
            //System.out.println(currentball);
        }
        return ballnum;
    }
}
