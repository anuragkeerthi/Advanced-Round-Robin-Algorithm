
public class cpu 
{ 
   public void sjf(Object[][] td)
   {
        Object[][] t;
        t=td;
        int n=0,k;
        int pos,temp,total=0;
      float avwt=0,avtat=0;
        int[] bt = new int[10];
        for (int i = 0; i < 1; i++)
        {    for(int j=0;j<t.length;j++)
        {
            bt[j]=Integer.parseInt(String.valueOf(t[j][i]));
            System.out.print(bt[j]+" ");
            n++;
             System.out.print("Number of Processors: "+n);
        }
        }
            for(int i=0;i<n;i++)
    {
        pos=i;
        for(int j=i+1;j<n;j++)
        {
            if(bt[j]<bt[pos])
                pos=j;
        }
 
        temp=bt[i];
        bt[i]=bt[pos];
        bt[pos]=temp;
    }
    int[] wt=new int[10];
   //calculate waiting time
    for( int i=1;i<n;i++)
    {
        wt[i]=0;
        for(int j=0;j<i;j++)
            wt[i]+=bt[j];
 
        total+=wt[i];
    }
    avwt=(float)total/n;      //average waiting time
     total=0;
    //avwt=(int)((float)total/n);      //average waiting time
    
    int[] tat=new int[10];
    for( int i=0;i<n;i++)
    {
        tat[i]=bt[i]+wt[i];     //calculate turnaround time
        total+=tat[i];
    }
      avtat=(float)total/n;     //average turnaround time
    //System.out.println("Average waiting time="+avwt);
  //  System.out.println("Average Turnaround Time="+avtat);

             String s=String.valueOf(avwt);
             ex.jTextField4.setText(s);  
             s=String.valueOf(avtat);
             ex.jTextField5.setText(s);
               
       
   }
   public void priority(Object[][] x,Object[][] y)
   {
        Object[][] t1;
        t1=x;
        Object[][] t2;
        t2=y;
        int[] pr = new int[10];
        int n=0,k=1;
        int[] bt = new int[10];
        for (int i = 0; i < 1; i++)
        {    for(int j=0;j<t1.length;j++)
        {
            bt[j]=Integer.parseInt(String.valueOf(t1[j][i]));
            System.out.print(bt[j]+" ");
            n++;  // to get number of processors
            System.out.print("Number of Processors: "+n);
       
        }
        }
        for (int i = 0; i < 1; i++)
        {    for(int j=0;j<t2.length;j++)
        {
            pr[j]=Integer.parseInt(String.valueOf(t2[j][k]));
         System.out.print(pr[j]+" ");
        }
        }
        
//           int[] p=new int[20];//contains process number
         int pos,temp,total = 0;
       //int avwt=0,n,k,avtat=0;//Declaration of variables
       float avwt=0,avtat=0;
        //sorting burst time, priority and process number in ascending order using selection sort
    for(int i=0;i<n;i++)
    {
        pos=i;
        for(int j=i+1;j<n;j++)
        {
            if(pr[j]<pr[pos])
                pos=j;
        }
 
        temp=pr[i];
        pr[i]=pr[pos];
        pr[pos]=temp;
 
        temp=bt[i];
        bt[i]=bt[pos];
        bt[pos]=temp;
 
  /*      temp=p[i];
        p[i]=p[pos];
        p[pos]=temp;
          */
    }
    int[] wt=new int[10]; 
    //calculate waiting time
    for(int i=1;i<n;i++)
    {
        wt[i]=0;
        for(int j=0;j<i;j++)
            wt[i]+=bt[j];
 
        total+=wt[i];
    }
    avwt=(float)total/n;      //average waiting time
    total=0;
    int[] tat=new int[10];
    for(int i=0;i<n;i++)
    {
        tat[i]=bt[i]+wt[i];     //calculate turnaround time
        total+=tat[i];
    }
    avtat=(float)total/n;     //average turnaround time
    System.out.println("Average waiting time="+avwt);
    System.out.println("Average Turnaround Time="+avtat);
           String s=String.valueOf(avwt);
             ex.jTextField4.setText(s);  
             s=String.valueOf(avtat);
             ex.jTextField5.setText(s);
   }
   public void rr(Object[][] td)
   {
       Object[][] t;
        t=td;
         int n=0;
        int[] bt = new int[10];
        for (int i = 0; i < 1; i++)
        {    for(int j=0;j<t.length;j++)
        {
            bt[j]=Integer.parseInt(String.valueOf(t[j][i]));
            System.out.print(bt[j]+" ");
            n++;
       
        }
        System.out.println("\n No of Processors: "+n);
        }
        int temp;
        for(int i=0;i<=n-1;i++)
       {
          for(int j=i+1;j<n;j++)
         {
          if(bt[i]>bt[j])
          {
            temp=bt[i];
            bt[i]=bt[j];
            bt[j]=temp;
          }
         }
        }
        temp=0;
       int[] m=new int[3];
        double tq=bt[0];
     for(int i=0;i<n;i++)
      System.out.println(bt[i]);  
    int mean=0,median=0,mode=0;
    for(int i=0;i<n;i++)
     mean+=bt[i];
    mean/=n;
    System.out.println("Mean:"+mean);
    if(n%2 != 0)
       median =bt[(n+1)/2 - 1];
    else
      median = bt[((n/2)+(n/2+1))/2  - 1]; 
      System.out.println("Median:"+median); 
	 
if(mean >= median )
{
    m[0] = mean ;
    m[1] = median ;
}
else
{
     m[1] = mean ;
    m[0] = median ;
}
		  
		 tq = Math.ceil(Math.sqrt((m[0]*bt[n-1])+(m[1]*bt[0])));
	        System.out.println("Time quantum="+tq);
             
                
                
                temp=0;
             int cb[]=new int[10];
             int[] wt=new int[10];
             int[] tat=new int[10];
             int i,j,k,sum=0;

             for( k=0;k<n;k++)
                 cb[k]=bt[k];
             int min=bt[0];
             System.out.println("Min burst time:"+min);
             int max=bt[n-1];
             System.out.println("Max burst time:"+max);
             
do
{
for(i=0;i<n;i++)
{
if(cb[i]>tq)
{
cb[i]-=tq;
for(j=0;j<n;j++)
{
if((j!=i)&&(cb[j]!=0))
wt[j]+=tq;
}
}
else
{
for(j=0;j<n;j++)
{
if((j!=i)&&(cb[j]!=0))
wt[j]+=cb[i];
}
cb[i]=0;
}
}
sum=0;
for(k=0;k<n;k++)
sum=sum+cb[k];
}
while(sum!=0);
for(i=0;i<n;i++)
tat[i]=wt[i]+bt[i];


             int att=0,awt=0;
             for(i=0;i<n;i++)
             {
                 
                 att+=tat[i];
                 awt+=wt[i];
             }
             awt=awt/n;
             att=att/n;
             System.out.println("Average waiting time="+awt);
          System.out.println("Average Turnaround Time="+att);
         
          String s=String.valueOf(awt);
             ex.jTextField4.setText(s);  
             s=String.valueOf(att);
             ex.jTextField5.setText(s);
             
   }
   
   

    public void fcfs(Object[][] td) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object[][] t;
        t=td;
         int n=0,k;
        int[] bt = new int[10];
        for (int i = 0; i < 1; i++)
        {    for(int j=0;j<t.length;j++)
        {
            bt[j]=Integer.parseInt(String.valueOf(t[j][i]));
            System.out.print(bt[j]+" ");
            n++;
       
        }
        System.out.println("\n No of Processors: "+n);
        }
        
             int[] wt=new int[10];
          for(int i=1;i<n;i++)
       {
        wt[i]=0;
        //tat[i]=0;
        for(int j=0;j<i;j++)
            wt[i]+=bt[j];
       }
    
    int[] tat=new int[10];
    for(int i=1;i<n;i++)
          tat[i]=0;
          float avwt=0,avtat=0;
          for(k=0;k<n;k++)
          {
             tat[k]=bt[k]+wt[k]; //calculating Turnaround time
              avwt+=wt[k];
              avtat+=tat[k];
          }
          avwt=avwt/k;
          avtat=avtat/k;
          System.out.println("Average waiting time="+avwt);
          System.out.println("Average Turnaround Time="+avtat);
         
          String s=String.valueOf(avwt);
             ex.jTextField4.setText(s);  
             s=String.valueOf(avtat);
             ex.jTextField5.setText(s);
       }
    }
  

