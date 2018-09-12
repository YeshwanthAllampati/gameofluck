import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.Random;
/*
<applet code="Opening1.java" width=100 height=100>
</applet>
*/
public class Opening1 extends Applet implements ActionListener,MouseListener
{
	int x,y,key,dec=99,ct=0,val;
	int trkx[]=new int[100];
	int trky[]=new int[100];
	String end,score;
	Label l;
	AudioClip p,f;
	Random rand;
	Button b1,b2,b3;
	TextField t;
	String help;
	public void init()
	{
		rand=new Random();
		l=new Label("THE GAME OF LUCK",Label.CENTER);
		end="GAME OVER!";
		p=getAudioClip(getDocumentBase(),"Pass.au");
		f=getAudioClip(getDocumentBase(),"Fail.au");
		add(l);
		b1=new Button("PLAY");
		b2=new Button("RULES");
		b3=new Button("EXIT");
		t=new TextField("HELP");
		add(b1);
		add(b2);
		add(b3);
		t.setEditable(false);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		addMouseListener(this);
		help="The Game has changed Buddy!!";
		
		
		
		
	}
 	public void actionPerformed(ActionEvent Ae)
	{
		
		if(Ae.getActionCommand()=="PLAY")
		{
			val=1;
			ct=0;
			dec=9;
			
			
		}
		
		if(Ae.getActionCommand()=="HELP")
		{
			val=2;
			System.out.println(val);
			repaint();
			
		}
		if(Ae.getActionCommand()=="EXIT")
		{
			val=3;
			repaint();
			
		}
	
	}
	public void mouseClicked(MouseEvent Me)
	{
		if(ct!=-1&&val==1)
		{
		trkx[ct]=Me.getX();
		trky[ct]=Me.getY();
		key=rand.nextInt(1000);
		dec=trkx[ct]+key;
        boolean flag = false;
        for(int i = 2; i <= dec/2; ++i)
        {
            if(dec % i == 0)
            {
                flag = true;
                break;
            }
        }

        if (!flag)
		{
            dec=0;
			
			
		}	
			
        else
		{
            dec=1;
		}	
		System.out.println(dec);
		repaint();
		}
	}
	public void mousePressed(MouseEvent Me)
	{
	}
	public void mouseEntered(MouseEvent Me)
	{
	}
	public void mouseExited(MouseEvent Me)
	{
	}
	public void mouseDragged(MouseEvent Me)
	{
		
	}	
	public void mouseReleased(MouseEvent Me)
	{
		
	}
	public void paint(Graphics g)
	{
		if(val==2)
		{
			System.out.println("help");
			add(t);
		}
		if(val==3)
			System.exit(0);
		if(val==1)
		{
		if(dec==1)
		{
			p.play();
			g.setColor(Color.green);
			ct++;
			for(int  i=0;i<ct;i++)
				g.fillOval(trkx[i],trky[i],10,10);
		}
		else if(dec==0)
		{	
			
			f.play();
			g.setColor(Color.red);
			ct++;
			for(int i=0;i<ct;i++)
				g.fillOval(trkx[i],trky[i],10,10);
			try
			{
			Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			g.clearRect(0,30,1350,700);
			g.drawString(end,700,325);
			g.drawString("Your Score is", 700,400);
			g.drawString(String.valueOf(ct-1), 740,440);
			try
			{
			Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
			g.clearRect(0,20,1350,700);
			ct=-1;
			val=3;;
			
			
		}
		}
		if(val==4)
			g.drawString("Thanks for Playing!", 700,400);
	}
	public void destroy()
	{
		val=4;
		repaint();
		try
			{
			Thread.sleep(1000);
			}
			catch(InterruptedException e)
			{
				System.out.println(e);
			}
		
	}
	
}
	
		

