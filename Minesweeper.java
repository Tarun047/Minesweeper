import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class Minesweeper implements ActionListener{
	private Random R = new Random();
	private JButton B[]=new JButton[100];
	private int Bombs[] = new int[10];
	private int ac[] = new int[100];
	private void initBombs()
	{
		boolean state[] = new boolean[100];
		for(int i=0;i<10;i++)
		{
			int x = R.nextInt(100);
			while(state[x])
				x = R.nextInt(100);
			Bombs[i]=x;
			state[x]=true;
		}
		for(int i=0;i<10;i++)
			System.out.println(Bombs[i]);
	}
	private void initAc()
	{
		for(int i=0;i<100;i++)
		{
			try{
			ac[Bombs[i]]=-1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
			ac[Bombs[i]+1]+=1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
			ac[Bombs[i]-1]+=1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
			ac[Bombs[i]+10]+=1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
			ac[Bombs[i]-10]+=1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
			ac[Bombs[i]+10+1]+=1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
			ac[Bombs[i]+10-1]+=1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
			ac[Bombs[i]-10+1]+=1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
			try{
			ac[Bombs[i]-10-1]+=1;
			}
			catch(ArrayIndexOutOfBoundsException e){}
		}
	}
	Minesweeper()
	{
		JFrame F = new JFrame();
		F.setLayout(new GridLayout(10,10));
		F.setBackground(Color.YELLOW);
		initBombs();
		initAc();
		for(int i=0;i<100;i++)
		{
			B[i] = new JButton("");
			B[i].setActionCommand(""+ac[i]);
			B[i].addActionListener(this);
			F.add(B[i]);
		}
		F.setVisible(true);
		F.setSize(1024,768);
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e){
		JButton temp = (JButton)e.getSource();
		temp.setLabel(temp.getActionCommand());
		
	}
	public static void main(String []args)
	{
		new Minesweeper();
	}
}