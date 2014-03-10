import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.io.*;

class homework4Part1{
	public static void main(String[] args){
		System.out.println("請選擇 : \t1)開始遊戲 2)結束遊戲 : ");
		Scanner keyInt = new Scanner(System.in);
		int option1 = keyInt.nextInt();
		//start a new Blackjack Game
		
		while(option1 != 2){
			if(option1 == 2)
				break;
			
			Cards C = new Cards(1);
			Players player = new Players("Sean");
			Players maker = new Players("Maker");
			//construct Cards , Play , Maker
			
			for(int i=0;i<2;i++){//new 2cards
				player.Hit(C.Licensing());
				maker.Hit(C.Licensing());
			}
			player.Show();
			player.ShowPoint();
			
			while(true){
				System.out.println("1)Hit(叫牌) 2)Stay(停止叫牌) : ");
				int option2 = keyInt.nextInt();
				
				if(option2 ==2)
					break;
					
				player.Hit(C.Licensing());						
				player.Show();
				player.ShowPoint();
			
				//player point judge
				if(player.Point() == 21){
					System.out.println("Blackjack!");
					break;
				}
				if(player.Point() >21){
					System.out.println("Busted!");
					break;
				}
			}
			
			//maker Licensing to self
			System.out.println("====================");
			maker.Show();
			maker.ShowPoint();
			while(true){
				if(maker.Point() >= 17)
					break;
				else{
					maker.Hit(C.Licensing());
					maker.Show();
					maker.ShowPoint();
				}	
			}
		
			
			//compare player and maker points
			System.out.println("====================");
			System.out.println(player.nameRecall() + ":" + player.Point());
			System.out.println(maker.nameRecall() + ":" + maker.Point() + "\n");
			if(player.Point() > 21)
				System.out.println(player.nameRecall() + " Lose!");
			else if (maker.Point() >21){
				System.out.println(player.nameRecall() + " Win!");
			}
			else if(maker.Point() == player.Point()){
				System.out.println("Stalemate!");
			}
			else if(maker.Point() > player.Point()){
				System.out.println(player.nameRecall() + " Lose!");
			}
			else{
				System.out.println(player.nameRecall() + " win!");
			}

			//keyin option1
			System.out.println("請選擇 : \t1)繼續遊戲 2)結束遊戲 : ");
			option1 = keyInt.nextInt();
			player.removeAll();
			maker.removeAll();
		}
	}
}





